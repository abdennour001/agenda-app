package com.example.agenda_app

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.agenda_app.models.Session
import kotlinx.android.synthetic.*

class Adapter(val context: Context, val data: List<Session>):BaseAdapter() {

    override fun getItem(position: Int): Any {
        return data[position]
    }

    override fun getItemId(position: Int): Long {
        return data[position].id
    }

    override fun getCount(): Int {
        return data.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var view = convertView
        val holder:ViewHolder
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.session_list_item,parent,false)
            val sessionTitle = view.findViewById(R.id.session_title) as TextView
            val sessionTeacher = view.findViewById(R.id.session_teacher) as TextView
            val sessionDuration = view.findViewById(R.id.session_duration) as TextView
            val sessionDate = view.findViewById(R.id.session_date) as TextView
            val sessionImage = view?.findViewById(R.id.session_image) as ImageView
            holder = ViewHolder(sessionTitle,sessionTeacher,sessionDuration, sessionDate, sessionImage)
            view.tag = holder
        }
        else {
            holder = view.tag as ViewHolder
        }
        holder.sessionTitle.text = data[position].title
        // to change
        holder.sessionTeacher.text = data[position].teacher
        holder.sessionDuration.text = data[position].duration
        holder.sessionDate.text = data[position].date
        holder.sessionImage.setImageResource(data[position].image)
        return view
    }

    private class ViewHolder(val sessionTitle: TextView,val sessionTeacher: TextView, val sessionDuration: TextView, val sessionDate: TextView, val sessionImage: ImageView)

}