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
        listExpenses.add(Expense(1,"First Expense", Date(8/15/2017),75.65))
        listExpenses.add(Expense(2,"Second Expense", Date(8/16/2017),1005.65))
        listExpenses.add(Expense(3,"Third Expense", Date(9/15/2017),5.65))

        var myExpensesAdapter = MyExpensesAdapter(listExpenses)
        lvExpenses.adapter = myExpensesAdapter
    }

    inner class MyExpensesAdapter:BaseAdapter {

        var listExpensesAdapter = ArrayList<Expense>()
        constructor(listExpensesAdapter:ArrayList<Expense>):super() {
            this.listExpensesAdapter = listExpensesAdapter

        }
        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var myView = layoutInflater.inflate(R.layout.activity_expense,null)
            var myExpense = listExpensesAdapter[p0]
            myView.tvExpName.text = myExpense.expenseName
            myView.tvExpDate.text = myExpense.expenseDate.toString()
            myView.tvExpCost.text = myExpense.expenseCost.toString()

            return myView

        }

        override fun getItem(p0: Int): Any {
            return listExpensesAdapter[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getCount(): Int {
            return listExpensesAdapter.size
        }

    }
}