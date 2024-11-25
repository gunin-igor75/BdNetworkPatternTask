package com.github.gunin_igor75.bdnetworkpatterntask.example1_2.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "bouquets"
)
data class BouquetDb(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id")
    val id: Int,
    @ColumnInfo("name")
    val name: String,
    @ColumnInfo("craft_paper")
    val craftPaper: String?,
    @ColumnInfo("basket")
    val basket: String?
)
