package com.github.gunin_igor75.bdnetworkpatterntask.example1_2.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.github.gunin_igor75.bdnetworkpatterntask.example1_2.data.local.entity.BouquetDb
import com.github.gunin_igor75.bdnetworkpatterntask.example1_2.data.local.entity.BouquetFlowerDb
import com.github.gunin_igor75.bdnetworkpatterntask.example1_2.data.local.entity.FlowerBalanceTuple
import com.github.gunin_igor75.bdnetworkpatterntask.example1_2.data.local.entity.FlowerDb
import com.github.gunin_igor75.bdnetworkpatterntask.example1_2.data.local.entity.WarehouseDb

@Dao
interface FlowerShopDao {

    @Query("SELECT * FROM flowers")
    suspend fun getFlowers(): List<FlowerDb>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFlower(vararg flower: FlowerDb)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBouquet(vararg bouquet: BouquetDb)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBouquetFlower(vararg bouquetFlower: BouquetFlowerDb)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWarehouse(vararg  warehouse: WarehouseDb)

    @Query("SELECT amount FROM warehouse WHERE flower_id =:flowerId LIMIT 1")
    suspend fun getAmountFlower(flowerId: Int): Int

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

    @Query("UPDATE warehouse SET amount =:amount WHERE id =:warehouseId")
    suspend fun updateFlowerCount(warehouseId: Int, amount: Int)
}