package com.example.appkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    private lateinit var textInputPassword: TextInputLayout
    private lateinit var editTextChangedListener: TextInputEditText
    private lateinit var confirmButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        textInputPassword = findViewById(R.id.ttl_password)
        confirmButton = findViewById(R.id.btn_confirm)
        editTextChangedListener = findViewById(R.id.edt_change_listener)

        confirmButton.setOnClickListener {
            if (editTextChangedListener.text.toString().isEmpty()){
                textInputPassword.error = "Empty field"
            }
        }
        editTextChangedListener.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (!s.isNullOrBlank()){
                    textInputPassword.isErrorEnabled = false
                }
                if(s.toString().length>12){
                    textInputPassword.error = "Very long"
                }
            }

            override fun afterTextChanged(s: Editable?) {

            }

        })
    }
}