package com.example.mehmet_can_gunduz_hw7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class UpdateNote : AppCompatActivity() {


    lateinit var edt_utitle : EditText
    lateinit var edt_udetail : EditText
    lateinit var btn_update : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_note)

        edt_utitle = findViewById(R.id.edt_utitle)
        edt_udetail = findViewById(R.id.edt_udetail)
        btn_update = findViewById(R.id.btn_update)


        val nid = intent.getIntExtra("nid",0)
        var title =  intent.getStringExtra("title")
        var detail = intent.getStringExtra("detail")


        edt_utitle.setText(title)
        edt_udetail.setText(detail)
        btn_update.setOnClickListener {

            MainActivity.db.updateNote(nid,edt_utitle.text.toString(),edt_udetail.text.toString())

            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}