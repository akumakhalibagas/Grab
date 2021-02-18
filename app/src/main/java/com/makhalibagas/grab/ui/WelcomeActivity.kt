package com.makhalibagas.grab.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.makhalibagas.grab.R
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        etNomer.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                if (s!!.isNotEmpty()){
                    tvContinue.visibility = View.VISIBLE
                    iv_grab.visibility = View.VISIBLE
                    tvContinue.setOnClickListener {
                        val intent = Intent(applicationContext, VerifActivity::class.java)
                        val nomor = etNomer.text.toString()
                        intent.putExtra("nomor", nomor)
                        startActivity(intent)

                    }
                }else{
                    tvContinue.visibility = View.GONE
                    iv_grab.visibility = View.GONE
                }
            }

        })
    }
}