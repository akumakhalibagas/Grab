package com.makhalibagas.grab.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import com.makhalibagas.grab.R
import kotlinx.android.synthetic.main.activity_verif.*

class VerifActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verif)


        val nomor = intent.getStringExtra("nomor")
        tvNomor.text = "+62 $nomor"
        etCode.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (etCode.text.toString() == "123456"){
                    startActivity(Intent(Intent(applicationContext, MainActivity::class.java)))
                }
            }
        })
    }
}