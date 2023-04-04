package com.wakeupgetapp.prettyshoppinglist.data.local.model

import androidx.room.Embedded
import androidx.room.Relation

data class ShoppingListWithCategories(
    @Embedded val shoppingList: ShoppingListEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "shoppingListId"
    )
    val shoppingListCategories: List<ShoppingListCategoryEntity>
)
