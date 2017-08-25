package com.struzzwebsolutions.budgeting

import java.util.*

/**
 * Created by keith on 8/17/17.
 */
class Expense(var expID: Int, var expenseName: String, var expenseDate: Date, var expenseCost: Double) {

    override fun toString(): String {
        return "$expenseDate - $expenseName: $expenseCost"
    }

    fun addExpenseToDB(expense: Expense) {

    }
}