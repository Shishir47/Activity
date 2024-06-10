package com.shishir.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    private lateinit var prevbtn: Button
    private lateinit var viewDataA1: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        viewDataA1= findViewById(R.id.viewDataA1)
        val data= intent.extras
        data?.let{
            val msg1= data.getString(Constants.INTENT_MESSAGE_KEY)
            val msg2= data.getString(Constants.INTENT_MESSAGE2_KEY)
            val num= data.getDouble(Constants.INTENT_NUMBER)
            viewDataA1.text= (msg1+"\n"+msg2+"\n"+num)
        }
        prevbtn= findViewById(R.id.goToPrev)
        prevbtn.setOnClickListener{
            Intent(this@MainActivity2, MainActivity::class.java).also{
                startActivity(it)
            }
        }
    }
}