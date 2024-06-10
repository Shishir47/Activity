package com.shishir.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var nxtBtn: Button
    private lateinit var sendNxtAct: EditText
    private lateinit var intReturn: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        Toast.makeText(this@MainActivity, "On Created is Called", Toast.LENGTH_SHORT).show()
        this.nxtBtn= findViewById(R.id.goToNxt)
        this.sendNxtAct= findViewById(R.id.sendNxtAct)
        intReturn= findViewById(R.id.intReturn)
        val getResult=
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
                if(it.resultCode==Constants.RETURN_RESULT){
                    val message= it.data!!.getStringExtra(Constants.INTENT_MESSAGE2_KEY)
                    intReturn.text= message
                }
            }
        nxtBtn.setOnClickListener{
            val intent= Intent(this@MainActivity, MainActivity2::class.java)
            intent.putExtra(Constants.INTENT_MESSAGE_KEY,sendNxtAct.text.toString())
            intent.putExtra(Constants.INTENT_MESSAGE2_KEY, "Another Message from First Activity")
            intent.putExtra(Constants.INTENT_NUMBER, 123.24)
            getResult.launch(intent)
        }

    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this@MainActivity,"On Start is called", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this@MainActivity,"On Resume is called", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this@MainActivity,"On Pause is called", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this@MainActivity,"On Stop is called", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this@MainActivity,"On Destroy is called", Toast.LENGTH_SHORT).show()
    }
}