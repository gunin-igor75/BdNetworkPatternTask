package com.github.gunin_igor75.bdnetworkpatterntask.example1_2.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.github.gunin_igor75.bdnetworkpatterntask.example1_2.data.local.entity.BouquetDb
import com.github.gunin_igor75.bdnetworkpatterntask.example1_2.data.local.entity.BouquetFlowerDb
import com.github.gunin_igor75.bdnetworkpatterntask.example1_2.data.local.entity.FlowerDb
import com.github.gunin_igor75.bdnetworkpatterntask.example1_2.data.local.entity.WarehouseDb

@Database(
    entities = [
        FlowerDb::class,
        BouquetDb::class,
        BouquetFlowerDb::class,
        WarehouseDb::class
    ],
    version = 1
)
abstract class FlowerShopDatabase : RoomDatabase() {

    abstract fun getFlowerShopDao(): FlowerShopDao

    companion object {
        private const val DB_NAME = "flower_db"
        private var _database: FlowerShopDatabase? = null

        fun init(context: Context): FlowerShopDatabase {
            _database?.let { return it }
            val instance = Room.databaseBuilder(
                context,
                FlowerShopDatabase::class.java,
                DB_NAME
            ).createFromAsset("initial_database.db")
                .build()
            _database = instance
            return instance
        }
    }
}