package com.example.agenda_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.session_details_fragment.*

class SessionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_session)
        val intent = intent
        val position = intent.getIntExtra("position",0)
        session_image.setImageResource(MainActivity.Sessions[position].image)
        session_title.text = MainActivity.Sessions[position].title
        session_teacher.text = MainActivity.Sessions[position].teacher
        session_date.text = MainActivity.Sessions[position].date
        session_duration.text = MainActivity.Sessions[position].duration
    }
}
