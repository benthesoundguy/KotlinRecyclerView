package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: CustomAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager
    private var dataset = mutableListOf("January", "February", "March")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewManager = LinearLayoutManager(this)
        viewAdapter = CustomAdapter(dataset)

        recyclerView = findViewById<RecyclerView>(R.id.recyclerview).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }

        val addButton: Button = findViewById(R.id.addButton)
        addButton.setOnClickListener {
            dataset.add("Item ${dataset.size + 1}")
            viewAdapter.notifyItemInserted(dataset.size - 1)
        }
    }
}