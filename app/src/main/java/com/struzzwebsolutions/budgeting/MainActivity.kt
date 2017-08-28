package com.struzzwebsolutions.budgeting

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_expense.view.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    var listExpenses = ArrayList<Expense>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Add dummy exp
        listExpenses.add(Expense("First Expense", Date(8/15/2017),75.65))
        listExpenses.add(Expense("Second Expense", Date(8/16/2017),1005.65))
        listExpenses.add(Expense("Third Expense", Date(9/15/2017),5.65))

        val myExpensesAdapter = MyExpensesAdapter(listExpenses)
        lvExpenses.adapter = myExpensesAdapter
    }

    inner class MyExpensesAdapter(var listExpensesAdapter: ArrayList<Expense>) : BaseAdapter() {

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val myView = layoutInflater.inflate(R.layout.activity_add_expense,null)
            var myExpense = listExpensesAdapter[p0]
            //myView.tv_expense_name.text = myExpense.expenseName
            //myView.tv_expense_date.text = myExpense.expenseDate.toString()
            //myView.tv_expense_cost.text = myExpense.expenseCost.toString()

            return myView

        }

        override fun getItem(p0: Int): Any = listExpensesAdapter[p0]

        override fun getItemId(p0: Int): Long = p0.toLong()

        override fun getCount(): Int = listExpensesAdapter.size

    }
}