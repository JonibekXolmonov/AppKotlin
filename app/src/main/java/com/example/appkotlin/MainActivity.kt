package com.example.appkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.TextView
import android.widget.TextView.OnEditorActionListener
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        editText = findViewById(R.id.edt_edit_text)
        textView = findViewById(R.id.tv_text_view)
        textChangedListener()
        onKeyListener()
    }

    //this function detects whether enter button of keyboard is pressed!
    private fun onKeyListener() {
        editText.setOnEditorActionListener(OnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                Toast.makeText(applicationContext, "Enter pressed", Toast.LENGTH_SHORT).show()
            }
            false
        })
    }

    private fun textChangedListener() {
        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {
                textView.text = s.toString()
            }
        })
    }
}