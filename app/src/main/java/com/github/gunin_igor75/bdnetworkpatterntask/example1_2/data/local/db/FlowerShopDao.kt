package com.github.gunin_igor75.bdnetworkpatterntask.example1_2.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.github.gunin_igor75.bdnetworkpatterntask.example1_2.data.local.entity.BouquetDb
import com.github.gunin_igor75.bdnetworkpatterntask.example1_2.data.local.entity.BouquetFlowerDb
import com.github.gunin_igor75.bdnetworkpatterntask.example1_2.data.local.entity.FlowerBalanceTuple
import com.github.gunin_igor75.bdnetworkpatterntask.example1_2.data.local.entity.FlowerDb
import com.github.gunin_igor75.bdnetworkpatterntask.example1_2.data.local.entity.WarehouseDb

@Dao
interface FlowerShopDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFlower(vararg flower: FlowerDb)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBouquet(vararg bouquet: BouquetDb)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBouquetFlower(vararg bouquetFlower: BouquetFlowerDb)

    @Query(
        "SELECT warehouse.id, " +
                "(warehouse.amount - bouquet_flower.amount_flower *:amountBouquet) as remainder " +
                "FROM bouquet_flower " +
                "INNER JOIN flowers " +
                "ON bouquet_flower.flower_id = flowers.id " +
                "INNER JOIN warehouse " +
                "ON flowers.id = warehouse.flower_id " +
                "WHERE bouquet_flower.bouquet_id =:bouquetId "
    )
    suspend fun getBalance(bouquetId: Int, amountBouquet: Int): List<FlowerBalanceTuple>

    @Update
    suspend fun updateFlowerCount(warehouseDb: List<WarehouseDb>)
}