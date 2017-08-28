package com.struzzwebsolutions.budgeting

import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import org.w3c.dom.Text


class ExpenseFragment : Fragment() {
    var mExpense: Expense? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mExpense = Expense()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //return super.onCreateView(inflater, container, savedInstanceState)
        val v: View = inflater!!.inflate(R.layout.activity_add_expense, container, false)

        val mExpNameField: EditText = v.findViewById(R.id.et_expense_name)
        //var watcher = TextWatcher()
        mExpNameField.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                //This space intentionally left blank
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                mExpense!!.expenseName = s.toString()
            }

            override fun afterTextChanged(s: Editable) {
                //This one too
            }
        })

        return v
    }
}

