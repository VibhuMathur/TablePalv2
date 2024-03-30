package com.example.tablepalv1

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.getValue
import org.w3c.dom.Element

private lateinit var db: DatabaseReference

class emp_login : AppCompatActivity() {

        lateinit var email: EditText
        lateinit var pass: EditText
        var flg = 0
        @SuppressLint("CutPasteId")
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_emp_login)
            var emploginbtn = findViewById<Button>(R.id.buttonLogin)
            email = findViewById(R.id.editTextEmail)
            pass = findViewById(R.id.editTextPassword)
            emploginbtn.setOnClickListener {
                val semail = email.text.toString()
                val spass = pass.text.toString()
                var emp = employee()
                var arr = arrayListOf<Element>()
                db = FirebaseDatabase.getInstance().getReference("Employee")
                db.addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        var value = dataSnapshot!!.children
//                        var i =0;
                        value.forEach breaking@{
//
                            var em = it.value as HashMap<String, String>
//                            Log.d("TAG", em.)

                            if(semail=="${em["email"]}"&&spass=="${em["pass"]}"&&"Chef"=="${em["job"]}"){
                                flg = 1
                                val t = Toast.makeText(this@emp_login, "yaay chef" , Toast.LENGTH_LONG)
                                t.show()
                                val intent = Intent(this@emp_login, Chef::class.java)
                                startActivity(intent)
//                                Log.d("TAG", flg.toString())
                                return@breaking
                            }
                            else if((semail=="${em["email"]}"&&spass=="${em["pass"]}"&&"Waiter"=="${em["job"]}")){
                                flg = 2
                                val t = Toast.makeText(this@emp_login,"{$em[email]}" ,Toast.LENGTH_LONG)
                                t.show()
                                val intent = Intent(this@emp_login, Waiter::class.java)
                                startActivity(intent)
                                return@breaking
                        }

                        }

                    }

                    override fun onCancelled(error: DatabaseError) {
                        TODO("Not yet implemented")
                    }

                })
                Log.d("TAG", flg.toString())
                if ((semail == "sadmin@gmail.com") && (spass.equals("123456"))) {
                    val intent = Intent(this, adminoptions::class.java)
                    startActivity(intent)
                } else if(flg==1){
                    val intent = Intent(this, Chef::class.java)
                    startActivity(intent)

                } else if(flg==2){
                    val intent = Intent(this, Waiter::class.java)
                    startActivity(intent)
                }
                else {
                    val intent = Intent(this, emp_login::class.java)
                    startActivity(intent)
                }
            }
        }
}