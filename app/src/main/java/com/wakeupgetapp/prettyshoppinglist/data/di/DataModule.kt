package com.wakeupgetapp.prettyshoppinglist.data.di

import android.content.Context
import androidx.room.Room
import com.wakeupgetapp.prettyshoppinglist.data.local.ShoppingListDatabase
import com.wakeupgetapp.prettyshoppinglist.data.local.dao.ShoppingListDao
import com.wakeupgetapp.prettyshoppinglist.data.local.datasource.ShoppingListDataSource
import com.wakeupgetapp.prettyshoppinglist.data.local.datasource.ShoppingListDataSourceImpl
import com.wakeupgetapp.prettyshoppinglist.data.repository.ShoppingListRepository
import com.wakeupgetapp.prettyshoppinglist.data.repository.ShoppingListRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindsShoppingListRepository(
        shoppingListRepository: ShoppingListRepositoryImpl
    ): ShoppingListRepository

    @Binds
    fun bindsShoppingListDataSource(
        shoppingListDataSource: ShoppingListDataSourceImpl
    ): ShoppingListDataSource


//    @Provides
//    fun provideShoppingListDatabase(@ApplicationContext context: Context): ShoppingListDatabase {
//        return Room.databaseBuilder(
//            context,
//            ShoppingListDatabase::class.java,
//            "shopping_list_database"
//        ).build()
//    }



}