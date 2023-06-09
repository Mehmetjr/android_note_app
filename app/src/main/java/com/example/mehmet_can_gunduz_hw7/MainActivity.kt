package com.example.mehmet_can_gunduz_hw7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import com.example.mehmet_can_gunduz_hw7.adapter.ListCustomAdapter
import com.example.mehmet_can_gunduz_hw7.models.Note

class MainActivity : AppCompatActivity() {
    companion object{
        lateinit var db : DB
    }
    lateinit var listView: ListView
    lateinit var btn_add : Button
    var arr = mutableListOf<Note>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


            btn_add = findViewById(R.id.btn_add)

            btn_add.setOnClickListener {
                val intent = Intent(this,NewNote::class.java)
                startActivity(intent)
            }


    }

    override fun onStart() {

        super.onStart()
        db = DB(this)
        listView = findViewById(R.id.listView)

        arr = db.allNote().toMutableList<Note>()
        val adapter = ListCustomAdapter(this,arr)

        listView.adapter = adapter

        registerForContextMenu(listView)

        listView.setOnItemClickListener { adapterView, view, i, l ->


            val intent = Intent(this,ShowNote::class.java)
            intent.putExtra("nid",arr[i].nid)
            intent.putExtra("title", arr[i].title)
            intent.putExtra("detail",arr[i].detail)
            intent.putExtra("date", arr[i].date)
            startActivity(intent)

        }

        listView.setOnItemLongClickListener { adapterView, view, i, l ->
            val intent = Intent(this,UpdateNote::class.java)
            intent.putExtra("nid",arr[i].nid)
            intent.putExtra("title", arr[i].title)
            intent.putExtra("detail",arr[i].detail)
            intent.putExtra("date", arr[i].date)
            startActivity(intent)
            false
        }





    }

}