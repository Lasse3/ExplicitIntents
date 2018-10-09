package com.example.lager.intents

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val CODE_SECOND_ACTIVITY = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        main_button.setOnClickListener{
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("toast", "Welcome to the second intent")
            startActivityForResult(intent,CODE_SECOND_ACTIVITY)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode==CODE_SECOND_ACTIVITY){
            if (resultCode==Activity.RESULT_OK){
                if(data != null) {
                    val toast = data.getStringExtra("name")
                    Toast.makeText(this, toast, Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
}
