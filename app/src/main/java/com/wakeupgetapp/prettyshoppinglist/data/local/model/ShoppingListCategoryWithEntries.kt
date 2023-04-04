package com.wakeupgetapp.prettyshoppinglist.data.local.model

import androidx.room.Embedded
import androidx.room.Relation

data class ShoppingListCategoryWithEntries(
    @Embedded val shoppingListCategoryEntity: ShoppingListCategoryEntity,
    @Relation(
        parentColumn = "categoryId",
        entityColumn = "entityId"
    )
    val shoppingListEntries: List<ShoppingListEntryEntity>
)