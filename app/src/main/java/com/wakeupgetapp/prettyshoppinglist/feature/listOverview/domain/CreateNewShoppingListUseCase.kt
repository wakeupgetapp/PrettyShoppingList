package com.wakeupgetapp.prettyshoppinglist.feature.listOverview.domain

import com.wakeupgetapp.prettyshoppinglist.data.model.ShoppingList
import com.wakeupgetapp.prettyshoppinglist.data.model.ShoppingListCategory
import com.wakeupgetapp.prettyshoppinglist.data.repository.ShoppingListRepository
import com.wakeupgetapp.prettyshoppinglist.util.Constants
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale
import javax.inject.Inject

class CreateNewShoppingListUseCase @Inject constructor(
    private val repository: ShoppingListRepository
): suspend (String, LocalDate) -> Long {
    override suspend fun invoke(title: String, date: LocalDate): Long {
        val mDate = DateTimeFormatter.ofPattern(Constants.DATE_FORMAT, Locale.getDefault()).format(date)
        val shoppingListId = repository.addShoppingList(ShoppingList(title = title, date = mDate))
        repository.addShoppingListCategory(ShoppingListCategory(shoppingListId = shoppingListId))
        return shoppingListId
    }
}

fun LocalDate.toDate(): Date = Date.from(this.atStartOfDay(ZoneId.systemDefault()).toInstant())
