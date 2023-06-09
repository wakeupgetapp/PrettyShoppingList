package com.wakeupgetapp.prettyshoppinglist.data.local.model


import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.wakeupgetapp.prettyshoppinglist.data.model.ShoppingListEntryState

@Entity(
    tableName = "shoppingListEntry",
    foreignKeys = [
        ForeignKey(
            entity = ShoppingListCategoryEntity::class,
            parentColumns = ["id"],
            childColumns = ["shoppingListCategoryId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class ShoppingListEntryEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val name: String = "",
    val state: ShoppingListEntryState = ShoppingListEntryState.INITIAL,
    val shoppingListCategoryId: Long = 0L
)