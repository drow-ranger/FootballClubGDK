package com.deofibrianico.mako.footballclubgdk

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.deofibrianico.mako.footballclubgdk.R.array.club_image
import com.deofibrianico.mako.footballclubgdk.R.array.club_name
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var items: MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()

        club_list.layoutManager = LinearLayoutManager(this)
        club_list.adapter = RecyclerViewAdapter(this, items)
    }


    private fun initData() {
        val name = resources.getStringArray(club_name)
        val image = resources.obtainTypedArray(club_image)
        items.clear()
        for (i in name.indices) {
            items.add(Item(name[i],
                    image.getResourceId(i, 0)))
        }

        //Recycle the typed array
        image.recycle()
    }
}
