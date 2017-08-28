package com.struzzwebsolutions.budgeting

import java.util.*

class Expense() {
    var expID: UUID = UUID.randomUUID()
    var expenseName: String? = null
    var expenseDate: Date? = null
    var expenseCost: Double? = null

    constructor(expenseName: String, expenseDate: Date, expenseCost: Double) : this() {}

    override fun toString(): String = "[$expenseDate] $expenseName: $expenseCost"

    fun addExpenseToDB(expense: Expense) {

    }
}