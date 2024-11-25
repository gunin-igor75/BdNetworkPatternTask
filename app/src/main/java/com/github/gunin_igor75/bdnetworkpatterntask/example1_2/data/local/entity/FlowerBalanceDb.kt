package com.github.gunin_igor75.bdnetworkpatterntask.example1_2.data.local.entity

import androidx.room.ColumnInfo

data class FlowerBalanceTuple(
    @ColumnInfo("id")
    val id: Int,
    @ColumnInfo("remainder")
    val remainder: Int
)
