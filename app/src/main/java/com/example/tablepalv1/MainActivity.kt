package com.example.tablepalv1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.database


private lateinit var db:DatabaseReference
data class user
(
    var name: String ?= null,
    var msg: String ?= null
)

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        db = FirebaseDatabase.getInstance().getReference("vibhu")
        db.child("message").setValue("Hello")
        val t = Toast.makeText(this, "yaay", Toast.LENGTH_LONG)
        t.show()

        var mainactbtn1 = findViewById<Button>(R.id.btnEmployee)
        var mainactbtn2 = findViewById<Button>(R.id.btnCustomer)

        mainactbtn1.setOnClickListener {
            val intent = Intent(this,emp_login::class.java)
            startActivity(intent)
        }

        mainactbtn2.setOnClickListener {
            val intent = Intent(this, menu_choice::class.java)
            startActivity(intent)
        }
    }
}
