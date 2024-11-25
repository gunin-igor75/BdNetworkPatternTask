package com.github.gunin_igor75.bdnetworkpatterntask.example1_2.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "warehouse",
    foreignKeys = [
        ForeignKey(
            entity = FlowerDb::class,
            parentColumns = ["id"],
            childColumns = ["flower_id"],
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index("flower_id")
    ]
)
data class WarehouseDb(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id")
    val id: Int,
    @ColumnInfo("flower_id")
    val flowerId: Int,
    @ColumnInfo("amount")
    val amount: Int
)
