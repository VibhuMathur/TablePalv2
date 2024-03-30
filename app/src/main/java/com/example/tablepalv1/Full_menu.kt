package com.example.tablepalv1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.Firebase
import com.google.firebase.database.database
import com.google.firebase.database.getValue

data class  Item(val desc: String, val name: String, val price: Int, val time:Int){
    constructor(): this("","",0,0);
}

class ItemAdapter: RecyclerView.Adapter<ItemAdapter.ViewHolder>(){
    val items = mutableListOf<Item>()
    init {
        val ref = Firebase.database("https://tablepalv1-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("Item")
        ref.get().addOnSuccessListener {
            val values = it!!.getValue<List<Item>>()
            if(values!=null){
                this.items.addAll(values)
                notifyDataSetChanged()
            }
            else Log.d("aaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "Data add error lmao")
        }.addOnFailureListener {
            Log.d("aaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "Data recive error lmao")
        }
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val txt1:TextView
        val txt2:TextView
        val btn:Button
        init{
            txt1 = view.findViewById(R.id.item_name)
            txt2 = view.findViewById(R.id.item_cost)
            btn = view.findViewById(R.id.item_add)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txt1.text = this.items[position].name
        holder.txt2.text = "$${this.items[position].price}"
        holder.btn.setOnClickListener {
            Toast.makeText(holder.itemView.context, "added!!", Toast.LENGTH_LONG).show()
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

class Full_menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_menu)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = ItemAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}