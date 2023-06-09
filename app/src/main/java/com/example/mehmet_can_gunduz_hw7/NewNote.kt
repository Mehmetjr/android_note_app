package com.example.mehmet_can_gunduz_hw7

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.util.*

class NewNote : AppCompatActivity() {
    lateinit var edt_title : EditText
    lateinit var edt_detail : EditText
    lateinit var btn_date : Button
    lateinit var btn_save : Button
    var selectDate = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_note)
        edt_title = findViewById(R.id.edt_title)
        edt_detail = findViewById(R.id.edt_detail)
        btn_date = findViewById(R.id.btn_date)
        btn_save = findViewById(R.id.btn_save)


        val calender = Calendar.getInstance()
        btn_date.setOnClickListener(View.OnClickListener {
            val datePickerDialog = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { datePicker, i, i2, i3 ->

                    var ay = "${i2 + 1}" //if (i2+1 < 10) "0${i2+1}" else "${i2+1}
                    if (i2+1<10){
                        ay ="0${i2 + 1}"
                    }
                    selectDate = "$i3.$ay.$i"
                },
                calender.get(Calendar.YEAR),
                calender.get(Calendar.MONTH),
                calender.get(Calendar.DAY_OF_MONTH),
            )
            datePickerDialog.show()
        })

        btn_save.setOnClickListener{
            if (selectDate != ""){
                var status = MainActivity.db.addNote(edt_title.text.toString(),edt_detail.text.toString(),selectDate)
                Log.d("status",status.toString())

                selectDate = ""
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
                finish()
            }else{
                Toast.makeText(this,"Select Date", Toast.LENGTH_LONG).show()

            }

        }
    }
}