package com.wakeupgetapp.prettyshoppinglist.data.local.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

data class ShoppingListCategoryWithEntries(
    @Embedded val shoppingListCategoryEntity: ShoppingListCategoryEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "shoppingListCategoryId"
    )
    val shoppingListEntries: List<ShoppingListEntryEntity>
)

