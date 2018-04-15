package com.example.vinu.rviewheaderdemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import java.util.*

class MainActivity : AppCompatActivity() {
    private var addHeaderRecyclerView: RecyclerView? = null
    private val dataSource: List<ItemObject>
        get() {
            val data = ArrayList<ItemObject>()
            data.add(ItemObject("First Header",true))
            data.add(ItemObject("First position"))
            data.add(ItemObject("Second position"))
            data.add(ItemObject("Third position"))
            data.add(ItemObject("Fourth position"))

            data.add(ItemObject("Second Header",true))
            data.add(ItemObject("First position"))
            data.add(ItemObject("Second position"))
            data.add(ItemObject("Third position"))
            data.add(ItemObject("Fourth position"))

            return data
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addHeaderRecyclerView = findViewById(R.id.add_header)
        val linearLayoutManager = LinearLayoutManager(this@MainActivity)
        addHeaderRecyclerView!!.layoutManager = linearLayoutManager
        addHeaderRecyclerView!!.setHasFixedSize(true)
        val customAdapter = CustomRecyclerViewAdapter(dataSource)
        addHeaderRecyclerView!!.adapter = customAdapter
    }
}
class ItemObject(val contents: String,val header:Boolean) {
    constructor(contents: String) : this(contents,false)
}