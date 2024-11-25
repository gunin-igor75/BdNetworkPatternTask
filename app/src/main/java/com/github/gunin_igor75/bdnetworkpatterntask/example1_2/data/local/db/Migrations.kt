package com.github.gunin_igor75.bdnetworkpatterntask.example1_2.data.local.db

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val MIGRATION_1_2 = object : Migration(1, 2) {

    override fun migrate(db: SupportSQLiteDatabase) {
        db.execSQL("ALTER TABLE bouquets ADD COLUMN 'craft_paper' TEXT")
        db.execSQL("ALTER TABLE bouquets ADD COLUMN 'basket' TEXT")
        db.execSQL("ALTER TABLE flowers ADD COLUMN 'country_origin' TEXT")
    }
}
