package com.github.gunin_igor75.bdnetworkpatterntask.example1_2.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(
    tableName = "flowers"
)
data class FlowerDb(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id")
    val id: Int,
    @ColumnInfo("name")
    val name: String,
)
