package com.example.appkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private lateinit var textInputPassword: TextInputLayout
    private lateinit var textInputEditText: TextInputEditText
    private lateinit var confirmButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        textInputPassword = findViewById(R.id.ttl_password)
        textInputEditText = findViewById(R.id.edt_input)
        confirmButton = findViewById(R.id.btn_confirm)

        confirmButton.setOnClickListener {
            if (textInputEditText.text.toString().isBlank()) {
                textInputPassword.error = "Empty field"
            }
        }

        textInputEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(
                s: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                if (s.toString().length > 12) {
                    textInputPassword.error = "Exceeded the length"
                }else{
                    textInputPassword.isErrorEnabled = false
                }
            }

        })
    }
}