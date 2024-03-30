package com.example.tablepalv1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class menu_choice : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_choice)

        var mainactbtn1 = findViewById<Button>(R.id.btnQuickOrder)
        var mainactbtn2 = findViewById<Button>(R.id.btnFullMenu)

        mainactbtn1.setOnClickListener {
            val intent = Intent(this,quick_order::class.java)
            startActivity(intent)
        }

        mainactbtn2.setOnClickListener {
            val intent = Intent(this,Full_menu::class.java)
            startActivity(intent)
        }
    }
}