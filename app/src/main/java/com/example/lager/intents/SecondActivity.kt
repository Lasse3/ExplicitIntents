package com.example.lager.intents

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        if(intent.extras.containsKey("toast")){
            val toast = intent.getStringExtra("toast")
            Toast.makeText(this,toast,Toast.LENGTH_SHORT).show()
        }
        second_button.setOnClickListener{
            val ALL_IS_WELL = true

            if (ALL_IS_WELL) {
                val intentReturn = Intent()
                val text = name.text.toString()
                intentReturn.putExtra("name", text)
                setResult(Activity.RESULT_OK,intentReturn)
            } else{
                setResult(Activity.RESULT_CANCELED)
            }
            finish()
        }
    }
}