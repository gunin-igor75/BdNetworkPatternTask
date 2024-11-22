package com.github.gunin_igor75.bdnetworkpatterntask.example1_2.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

@Entity(
    tableName = "bouquet_flower",
    foreignKeys = [
        ForeignKey(
            entity = BouquetDb::class,
            parentColumns = ["id"],
            childColumns = ["bouquet_id"]
        ),
        ForeignKey(
            entity = FlowerDb::class,
            parentColumns = ["id"],
            childColumns = ["flower_id"]
        )
    ],
    primaryKeys = ["bouquet_id", "flower_id"],
    indices = [
        Index("flower_id")
    ]
)
data class BouquetFlowerDb(
    @ColumnInfo("bouquet_id")
    val bouquetId: Int,
    @ColumnInfo("flower_id")
    val flowerId: Int,
    @ColumnInfo("amount_flower")
    val amountFlower: Int,
)
