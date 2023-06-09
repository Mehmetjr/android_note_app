package com.example.mehmet_can_gunduz_hw7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ShowNote : AppCompatActivity() {

    lateinit var txt_title : TextView
    lateinit var txt_detail : TextView
    lateinit var txt_date : TextView
    lateinit var btn_delete : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_note)

        txt_title = findViewById(R.id.txt_title)
        txt_detail = findViewById(R.id.txt_detail)
        txt_date = findViewById(R.id.txt_date)
        btn_delete = findViewById(R.id.btn_delete)


        val nid = intent.getIntExtra("nid",0)
        var title =  intent.getStringExtra("title")
        var detail = intent.getStringExtra("detail")
        var date = intent.getStringExtra("date")

        txt_title.text = title
        txt_detail.text = detail
        txt_date.text = date

        btn_delete.setOnClickListener {

            MainActivity.db.deleteNote(nid)

            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}