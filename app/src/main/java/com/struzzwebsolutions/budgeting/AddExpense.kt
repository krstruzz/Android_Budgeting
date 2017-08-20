package com.struzzwebsolutions.budgeting

import android.content.ContentValues
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast


/**
 * Created by keith on 8/19/17.
 */

class AddExpense : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_expense)
    }

    fun buAdd(view: View) {
        var dbManager = DBManager(this)
        var values = ContentValues()
        values.put(dbManager.colExpName,etExpName.text.toString())
        values.put(dbManager.colExpCost,etExpCost)
        values.put(dbManager.colExpDate,etExpDate)

        val ID = dbManager.Insert(values)
        if(ID>0){
            Toast.makeText(this,"expense is added",Toast.LENGTH_LONG).show()
            finish()
        }else {
            Toast.makeText(this,"cannot add expense",Toast.LENGTH_LONG).show()
        }
    }
}