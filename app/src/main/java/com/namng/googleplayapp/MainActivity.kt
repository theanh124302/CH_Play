package com.namng.googleplayapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.namng.googleplayapp.apps.AppAdapter
import com.namng.googleplayapp.apps.AppModel
import com.namng.googleplayapp.category.CategoryAdapter
import com.namng.googleplayapp.category.CategoryModel
import com.namng.googleplayapp.listapps.ListAdapter
import com.namng.googleplayapp.listapps.ListModel

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val category_names = arrayOf(
            "For you",
            "Top charts",
            "Orther devices",
            "Children",
            "Type",
            "Charge"
        )
        val app_names = arrayOf(
            "Lol",
            "Liên quân",
            "AS",
            "Intelji",
            "Youtube",
            "Be"
        )
        val numberStars = arrayOf(
            "5.0", "5.0", "5.0", "5.0", "5.0", "4.0"
        )

        val listapps_names = arrayOf(
            "Hot",
            "The Anh App",
            "Popular app",
            "Oke app",
            "The Anh"
        )

        val categories = arrayListOf<CategoryModel>()
        repeat(6){
            val index = it
            categories.add(CategoryModel(category_names[index]))
        }

        val categoryAdapter = CategoryAdapter(categories, object : CategoryAdapter.ItemClickListener {
            override fun ItemClick(position: Int) {
            }
        })

        val categoryRecyclerView = findViewById<RecyclerView>(R.id.category_recycler_view)
        categoryRecyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        categoryRecyclerView.adapter = categoryAdapter

        val apps = arrayListOf<AppModel>()
        repeat(6){
            val index1 = it%3 + 1
            val index2 = it/3 + 1
            apps.add(AppModel(app_names[it], resources.getIdentifier("icon_$index2$index1", "drawable", packageName),numberStars[it]))
        }

        val appAdapter = AppAdapter(apps, object : AppAdapter.ItemClickListener{
            override fun ItemClick(position: Int){
            }
        })

        val listapps = arrayListOf<ListModel>()
        repeat(5){
            listapps.add(ListModel(listapps_names[it],appAdapter))
        }

        val listAdapter = ListAdapter(this, listapps, object : ListAdapter.ItemClickListener{
            override  fun ItemClick(position: Int){
            }
        })

        val listAppRecyclerView = findViewById<RecyclerView>(R.id.listapp_recycler_view)
        listAppRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        listAppRecyclerView.adapter = listAdapter
    }


}