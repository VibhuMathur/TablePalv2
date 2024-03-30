package com.example.tablepalv1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class adminoptions : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adminoptions)
        var mainactbtn1 = findViewById<Button>(R.id.btnAddMenuItem)
        var mainactbtn2 = findViewById<Button>(R.id.btnAddEmployee)
        var mainactbtn3 = findViewById<Button>(R.id.btnRemoveMenuItem)
        var mainactbtn4 = findViewById<Button>(R.id.btnRemoveEmployee)

        mainactbtn1.setOnClickListener {
            val intent = Intent(this,Add_Items::class.java)
            startActivity(intent)
        }

        mainactbtn2.setOnClickListener {
            val intent = Intent(this, Add_Employee::class.java)
            startActivity(intent)
        }

        mainactbtn3.setOnClickListener {
            val intent = Intent(this,Remove_Item::class.java)
            startActivity(intent)
        }

        mainactbtn4.setOnClickListener {
            val intent = Intent(this, Remove_Employees::class.java)
            startActivity(intent)
        }
    }
}