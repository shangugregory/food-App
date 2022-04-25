package com.example.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private val bt = findViewById<Button>(R.id.button)
    private val img = arrayOf(R.drawable.beef, R.drawable.chapati ,R.drawable.beans, R.drawable.ugali, R.drawable.cabage, R.drawable.rice)
    private val text = arrayOf("Beef", "chapati", "Beans", "ugali", "Cabbage", "Rice")
    private val desc = arrayOf("non veg", "Non Veg", "non Veg", "non veg", "pure Veg", "non Veg")
    private val price = arrayOf("@Ksh. 20/=", "@ Ksh. 10/=", "@ Ksh. 10/=", "@ Ksh. 5", "@ Ksh. 5/=", "@ Ksh. 5/=")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerVew)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CustomAdapter(img, text, desc, price)


    }
    override fun onClick(v: View?) {
        when(v?.id){

        }

        var adapter = CustomAdapter(img, desc,price, price)
        adapter.setonItemClickListener(object : CustomAdapter.onItemClickListener{
            override fun onitemClick(position: Int) {
                Toast.makeText(this@MainActivity, "You clocked on item number. $position", Toast.LENGTH_SHORT).show()
            }

        })

    }
}