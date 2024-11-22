package com.github.gunin_igor75.bdnetworkpatterntask.example1_2.data.local.repository

import com.github.gunin_igor75.bdnetworkpatterntask.example1_2.data.local.db.FlowerShopDao

class FlowerShopRepositoryImpl(
    private val apiDao: FlowerShopDao
) : FlowerShopRepository {


    override fun buyBouquet(bouquetId: Int, amount: Int): Boolean {
        return false
    }
}