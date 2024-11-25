package com.github.gunin_igor75.bdnetworkpatterntask.example1_2.data.local.repository

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.github.gunin_igor75.bdnetworkpatterntask.example1_2.data.local.db.FlowerShopDao
import com.github.gunin_igor75.bdnetworkpatterntask.example1_2.data.local.db.FlowerShopDatabase
import com.github.gunin_igor75.bdnetworkpatterntask.example1_2.data.local.entity.BouquetDb
import com.github.gunin_igor75.bdnetworkpatterntask.example1_2.data.local.entity.BouquetFlowerDb
import com.github.gunin_igor75.bdnetworkpatterntask.example1_2.data.local.entity.FlowerDb
import com.github.gunin_igor75.bdnetworkpatterntask.example1_2.data.local.entity.WarehouseDb
import kotlinx.coroutines.test.runTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FlowerShopRepositoryImplTest {

    private lateinit var db: FlowerShopDatabase

    private lateinit var apiDao: FlowerShopDao

    private val repository: FlowerShopRepository by lazy {
        FlowerShopRepositoryImpl(apiDao)
    }

    @Before
    fun createDb() {
        db = Room.inMemoryDatabaseBuilder(
            InstrumentationRegistry.getInstrumentation().targetContext,
            FlowerShopDatabase::class.java
        ).build()
        apiDao = db.getFlowerShopDao()
    }

    @After
    fun closeDb() {
        db.close()
    }

    @Test
    fun `проверка_метода_buyBouquet_покупка_букета_проверка_баланса_позитивно`() = runTest {
        createData()
        val bouquetId = 1
        val amountBouquet = 2

        val isGoodBay = repository.buyBouquet(bouquetId, amountBouquet)

        val actualAmountFlowerRose = apiDao.getAmountFlower(1)
        assertThat(actualAmountFlowerRose).isEqualTo(4)
        assertThat(isGoodBay).isTrue()
    }

    @Test
    fun `проверка_метода_buyBouquet_покупка_букетов_проверка_баланса_негативно`() = runTest {
        createData()
        val bouquetId = 1
        val amountBouquet = 6

        val isGoodBay = repository.buyBouquet(bouquetId, amountBouquet)

        assertThat(isGoodBay).isFalse()
    }


    private suspend fun createData() {
        insertFlowers()
        insertBouquet()
        insertBouquetFlower()
        insertWarehouse()
    }

    private suspend fun insertFlowers() {
        val rose = FlowerDb(0, "rose", "russia")
        val tulip = FlowerDb(0, "tulip", "russia")
        val lily = FlowerDb(0, "lily", "russia")
        val carnation = FlowerDb(0, "carnation", "russia")
        val orchid = FlowerDb(0, "orchid", null)
        val daisy = FlowerDb(0, "daisy", null)
        val aster = FlowerDb(0, "aster", "russia")
        val gladiolus = FlowerDb(0, "gladiolus", "russia")
        val dahlia = FlowerDb(0, "dahlia", "russia")
        val violet = FlowerDb(0, "violet", null)
        apiDao.insertFlower(
            rose,
            tulip,
            lily,
            carnation,
            orchid,
            daisy,
            aster,
            gladiolus,
            dahlia,
            violet
        )
    }

    private suspend fun insertBouquet() {
        val bouquetFirst = BouquetDb(0, "bouquetFirst", "sparkly", "wicker")
        val bouquetSecond = BouquetDb(0, "bouquetSecond", "sparkly", "wicker")
        val bouquetThree = BouquetDb(0, "bouquetThree", null, null)
        apiDao.insertBouquet(bouquetFirst, bouquetSecond, bouquetThree)
    }

    private suspend fun insertBouquetFlower() {
        val bfFirst1 = BouquetFlowerDb(1, 1, 3)
        val bfFirst2 = BouquetFlowerDb(1, 2, 2)
        val bfFirst3 = BouquetFlowerDb(1, 3, 2)
        val bfSecond1 = BouquetFlowerDb(2, 4, 2)
        val bfSecond2 = BouquetFlowerDb(1, 7, 1)
        val bfThree = BouquetFlowerDb(3, 9, 3)
        apiDao.insertBouquetFlower(bfFirst1, bfFirst2, bfFirst3, bfSecond1, bfSecond2, bfThree)
    }

    private suspend fun insertWarehouse() {
        val flowerRose = WarehouseDb(0, 1, 10)
        val flowerTulip = WarehouseDb(0, 2, 10)
        val flowerLily = WarehouseDb(0, 3, 10)
        val flowerCarnation = WarehouseDb(0, 4, 10)
        val flowerOrchid = WarehouseDb(0, 5, 10)
        val flowerDaisy = WarehouseDb(0, 6, 10)
        val flowerAster = WarehouseDb(0, 7, 10)
        val flowerGladiolus = WarehouseDb(0, 8, 10)
        val flowerDahlia = WarehouseDb(0, 9, 10)
        val flowerViolet = WarehouseDb(0, 10, 10)
        apiDao.insertWarehouse(
            flowerRose,
            flowerTulip,
            flowerLily,
            flowerCarnation,
            flowerOrchid,
            flowerDaisy,
            flowerAster,
            flowerGladiolus,
            flowerDahlia,
            flowerViolet
        )
    }
}