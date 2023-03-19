package com.wakeupgetapp.prettyshoppinglist.data.local.model

import androidx.room.Embedded
import androidx.room.Relation

data class ShoppingListWithEntries(
    @Embedded val shoppingList: ShoppingListEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "shoppingListId"
    )
    val entriesList: List<ShoppingListEntryEntity>
)