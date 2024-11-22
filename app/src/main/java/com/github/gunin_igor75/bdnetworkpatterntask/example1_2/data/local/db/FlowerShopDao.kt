package com.github.gunin_igor75.bdnetworkpatterntask.example1_2.data.local.db

import androidx.room.Dao
import androidx.room.Query
import com.github.gunin_igor75.bdnetworkpatterntask.example1_2.data.local.entity.BouquetFlowerDb
import com.github.gunin_igor75.bdnetworkpatterntask.example1_2.data.local.entity.FlowerDb

@Dao
interface FlowerShopDao {

    @Query("SELECT * FROM flowers")
    suspend fun getFlowers(): List<FlowerDb>

    @Query("SELECT * FROM bouquet_flower WHERE bouquet_id =:bouquetId")
    suspend fun getBouquetAndFlowerById(bouquetId: Int): BouquetFlowerDb

    @Query(
        "WITH temps  as (SELECT flower_id as id, amount_flower as amount FROM bouquet_flower " +
                "WHERE bouquet_id =:bouquetId)" +
                "SELECT (warehouse.amount - temps.amount *:amountBouquet) as count_flower FROM warehouse, temps " +
                "WHERE temps.id = warehouse.flower_id"
    )
    suspend fun getBalance(bouquetId: Int, amountBouquet: Int): List<Int>

    @Query("SELECT * FROM bouquet_flower" +
        ""

    )
    suspend fun getBalance1(bouquetId: Int, amountBouquet: Int): List<Int>
}