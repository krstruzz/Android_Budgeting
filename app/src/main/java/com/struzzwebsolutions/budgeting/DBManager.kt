package com.struzzwebsolutions.budgeting

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

/**
 * Created by keith on 8/18/17.
 */
class DBManager {

    val dbName = "MyBudgetTracker"
    val dbTable = "Budget"
    val colID = "ID"
    val colExpName = "Expense_Name"
    val colExpDate = "Expense_Date"
    val colExpCost = "Expense_Cost"
    val dbVersion = 1
    val sqlCreateTable = "CREATE TABLE IF NOT EXISTS $dbTable ($colID INTEGER PRIMARY KEY; $colExpName TEXT; $colExpDate DATE; $colExpCost DOUBLE);"
    var sqlDB:SQLiteDatabase?=null

    constructor(context: Context) {
        var db = DatabaseHelperNotes(context)
        sqlDB = db.writableDatabase

    }

    inner class DatabaseHelperNotes:SQLiteOpenHelper {
        var context:Context?=null
        constructor(context: Context):super(context,dbName, null,dbVersion) {
            this.context=context
        }
        override fun onCreate(p0: SQLiteDatabase?) {
            p0!!.execSQL(sqlCreateTable)
            Toast.makeText(this.context,"database is created",Toast.LENGTH_LONG).show()
        }

        override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
            p0!!.execSQL("DROP TABLE IF EXISTS $dbTable")
        }

    }

    fun Insert(values:ContentValues):Long {
        val ID = sqlDB!!.insert(dbTable,"",values)
        return ID
    }
}