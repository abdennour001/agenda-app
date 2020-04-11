package com.example.agenda_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ListView
import com.example.agenda_app.models.Session
import kotlinx.android.synthetic.main.session_details_fragment.*

class MainActivity : AppCompatActivity() {

    companion object {
        internal var Sessions: List<Session> = ArrayList<Session>()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Sessions = getData()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter = Adapter(this, Sessions)
        val sessionList = this.findViewById<ListView>(R.id.session_list)
        sessionList.adapter = adapter
        sessionList.setOnItemClickListener { parent, view, position, id ->
            if (!isTwoPane()) {
                val intent = Intent(this, SessionActivity::class.java)
                intent.putExtra("position", position)
                startActivity(intent)
            } else {
                session_image.setImageResource(Sessions[position].image)
                session_title.text = Sessions[position].title
                session_teacher.text = Sessions[position].teacher
                session_date.text = Sessions[position].date
                session_duration.text = Sessions[position].duration
            }

        }
    }

    private fun isTwoPane(): Boolean {
        return findViewById<View>(R.id.fragment4) != null
    }

    private fun getData(): List<Session> {
        val sessions = mutableListOf<Session>()

        sessions.add(Session(1, "ML", R.drawable.ml, "1h 30min", "2020-04-11 08:30", "Ens BENATCHBA Karima"))
        sessions.add(Session(2, "SGBD", R.drawable.sgbd, "1h 45min", "2020-04-11 10:30", "Ens Soumia BENKRID"))
        sessions.add(Session(3, "IHM", R.drawable.ihm, "2h 30min", "2020-04-12 12:30", "Ens Bouzidi-Hassini Sabrina"))
        sessions.add(Session(4, "TDM", R.drawable.tdm, "2h 30min", "2020-04-13 11:30", "Ens Batata Sofiane"))
        sessions.add(Session(5, "Projet 2CS", R.drawable.project, "2h 30min", "2020-04-14 10:00", "Ens MOSTEFAI Amine"))

        return sessions
    }
}
