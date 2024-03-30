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

data class item
    (
    var Name: String ?= null,
    var Desc: String ?= null,
    var Price: String ?= null,
    var Time: String ?= null
)

class Add_Items : AppCompatActivity() {
    lateinit var cemail: EditText
    lateinit var cpass: EditText
    lateinit var cjob: EditText
    lateinit var cName: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_items)
        var submitbtn = findViewById<Button>(R.id.buttonSubmit)
        cemail = findViewById(R.id.editTextName)
        cpass = findViewById(R.id.editTextDescription)
        cjob = findViewById(R.id.editTextPrice)
        cName = findViewById(R.id.editTextPreparationTime)
        val i = item()
        submitbtn.setOnClickListener {
            i.Name = cemail.text.toString()
            i.Desc = cpass.text.toString()
            i.Price = cjob.text.toString()
            i.Time = cName.text.toString()
            db = FirebaseDatabase.getInstance().getReference("Item")
            key = db.child("Item").push().key!!
            db.child(key!!).setValue(i)
            val intent = Intent(this, Add_Items::class.java)
            startActivity(intent)
            val t = Toast.makeText(this, "Item Added", Toast.LENGTH_LONG)
            t.show()
        }
    }
}