package com.wakeupgetapp.prettyshoppinglist.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.wakeupgetapp.prettyshoppinglist.data.local.dao.ShoppingListDao
import com.wakeupgetapp.prettyshoppinglist.data.local.model.ShoppingListEntity
import com.wakeupgetapp.prettyshoppinglist.data.local.model.ShoppingListEntryEntity
import com.wakeupgetapp.prettyshoppinglist.data.local.model.ShoppingListWithEntries

@Database(entities = [ShoppingListEntity::class, ShoppingListEntryEntity::class], version = 1)
abstract class ShoppingListDatabase : RoomDatabase() {
    abstract fun shoppingListDao(): ShoppingListDao
}