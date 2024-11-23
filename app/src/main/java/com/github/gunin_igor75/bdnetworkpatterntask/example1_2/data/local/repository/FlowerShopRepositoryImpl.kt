package com.github.gunin_igor75.bdnetworkpatterntask.example1_2.data.local.repository

import com.github.gunin_igor75.bdnetworkpatterntask.example1_2.data.local.db.FlowerShopDao

class FlowerShopRepositoryImpl(
    private val apiDao: FlowerShopDao
) : FlowerShopRepository {


    override suspend fun buyBouquet(bouquetId: Int, amount: Int): Boolean {
        val flowerBalance = apiDao.getBalance(bouquetId, amount)
        val opportunityPurchase = flowerBalance.all { it.remainder >= 0 }
        if (!opportunityPurchase) return false
        flowerBalance.forEach { apiDao.updateFlowerCount(it.id, it.remainder) }
        return true
    }
}