package com.github.gunin_igor75.bdnetworkpatterntask

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.github.gunin_igor75.bdnetworkpatterntask.app.Repositories
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val apiDao = Repositories.database.getFlowerShopDao()
        lifecycleScope.launch {
            apiDao.getFlowers()

        }
    }
}