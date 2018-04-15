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
            data.add(ItemObject("This is the item content in the first position"))
            data.add(ItemObject("This is the item content in the second position"))
            data.add(ItemObject("This is the item content in the third position"))
            data.add(ItemObject("This is the item content in the fourth position"))
            data.add(ItemObject("This is the item content in the fifth position"))
            data.add(ItemObject("Second Header",true))
            data.add(ItemObject("This is the item content in the first position"))
            data.add(ItemObject("This is the item content in the second position"))
            data.add(ItemObject("This is the item content in the third position"))
            data.add(ItemObject("This is the item content in the fourth position"))
            data.add(ItemObject("This is the item content in the fifth position"))
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