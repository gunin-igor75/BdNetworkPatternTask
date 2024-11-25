package com.github.gunin_igor75.bdnetworkpatterntask.example1_2.data.local.repository

interface FlowerShopRepository {
    suspend fun buyBouquet(bouquetId: Int, amount: Int): Boolean
}