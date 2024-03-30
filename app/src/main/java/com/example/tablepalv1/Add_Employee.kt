package com.example.tablepalv1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

private lateinit var db: DatabaseReference
private var key: String ?=null

data class employee
    (
    var email: String ?= null,
    var job: String ?= null,
    var Name: String ?= null,
    var pass: String ?= null
)

class Add_Employee : AppCompatActivity() {

    lateinit var cemail: EditText
    lateinit var cpass: EditText
    lateinit var cjob: EditText
    lateinit var cName: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_employee)
        var submitbtn = findViewById<Button>(R.id.buttonSubmit)
        cemail = findViewById(R.id.editTextEmail)
        cpass = findViewById(R.id.editTextPassword)
        cjob = findViewById(R.id.profession)
        cName = findViewById(R.id.Name)
        val emp = employee()
        submitbtn.setOnClickListener {
            emp.email = cemail.text.toString()
            emp.pass = cpass.text.toString()
            emp.job = cjob.text.toString()
            emp.Name = cName.text.toString()
            db = FirebaseDatabase.getInstance().getReference("Employee")
            key = db.child("employee").push().key!!
            db.child(key!!).setValue(emp)
            val intent = Intent(this, Add_Employee::class.java)
            startActivity(intent)
            val t = Toast.makeText(this, "Employee Added", Toast.LENGTH_LONG)
            t.show()
        }
    }
}