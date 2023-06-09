package com.example.mehmet_can_gunduz_hw7.adapter

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.mehmet_can_gunduz_hw7.R
import com.example.mehmet_can_gunduz_hw7.models.Note

class ListCustomAdapter(private val context: Activity,private val list: MutableList<Note>) : ArrayAdapter<Note>(context,
    R.layout.list_custom_adapter,list) {

    @SuppressLint("MissingInflatedId")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val rootView = context.layoutInflater.inflate(R.layout.list_custom_adapter,null,true)
        val txt_lTitle = rootView.findViewById<TextView>(R.id.txt_ltitle)

        val note = list.get(position)
        txt_lTitle.text = note.title
        return rootView
    }
}