package com.example.tablepalv1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*

class Remove_Employees : AppCompatActivity() {

    private lateinit var database: FirebaseDatabase
    private lateinit var employeesRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_remove_employees)

        // Initialize Firebase Database
        database = FirebaseDatabase.getInstance()
        employeesRef = database.getReference("Employee") // Assuming "Employee" is the node containing employee data

        // Email of the employee to be removed
        val emailToRemove = "Joe@gmail.com" // Example email to be removed

        // Query to find the employee with the specified email
        val query: Query = employeesRef.orderByChild("email").equalTo(emailToRemove)

        // Add a ValueEventListener to retrieve the data matching the query
        query.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (employeeSnapshot in dataSnapshot.children) {
                    // Get the key of the employee to be removed
                    val key = employeeSnapshot.key
                    if (key != null) {
                        // Remove the employee from the database
                        employeesRef.child(key).removeValue()
                        // Inform the user about the successful removal
                        // You can show a Toast or update UI accordingly
                    }
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Handle errors, if any, while querying the database
            }
        })
    }
}
