package com.wakeupgetapp.prettyshoppinglist.data.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.wakeupgetapp.prettyshoppinglist.data.local.ShoppingListDatabase
import com.wakeupgetapp.prettyshoppinglist.data.local.dao.ShoppingListDao
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    private val databaseName = "pslDatabase.db"


    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): ShoppingListDatabase {
        return Room.databaseBuilder(context, ShoppingListDatabase::class.java, databaseName)
            .build()
    }

    @Provides
    @Singleton
    fun providesShoppingListDao(database: ShoppingListDatabase): ShoppingListDao {
        return database.shoppingListDao()
    }
}