package com.struzzwebsolutions.budgeting

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager

/**
 * Created by keith on 8/27/17.
 */
class ExpenseActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_add_expense)

        val fm: FragmentManager = supportFragmentManager
        var fragment: Fragment = fm.findFragmentById(R.id.fragment_container)

        if (fragment == null) {
            fragment = ExpenseFragment()
            fm.beginTransaction().add(R.id.fragment_container, fragment).commit()
        }
    }
}