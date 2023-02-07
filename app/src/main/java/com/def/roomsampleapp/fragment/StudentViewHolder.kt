package com.def.roomsampleapp.fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.def.roomsampleapp.R

class StudentViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private var studentItemView: TextView

    init {
        studentItemView = view.findViewById(R.id.textView)
    }

    companion object {
        fun create(parent: ViewGroup): StudentViewHolder {
            val view: View = LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_item, parent, false)
            return StudentViewHolder(view)
        }
    }

    fun bind(text: String) {
        studentItemView.setText(text)
    }

}