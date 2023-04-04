package com.wakeupgetapp.prettyshoppinglist.data.local.model

import androidx.room.Embedded
import androidx.room.Relation

data class ShoppingListWithCategoriesAndEntries(
    @Embedded val shoppingList: ShoppingListEntity,
    @Relation(
        entity = ShoppingListCategoryEntity::class,
        parentColumn = "id",
        entityColumn = "shoppingListId"
    )
    val shoppingListCategories: List<ShoppingListCategoryWithEntries>
)
