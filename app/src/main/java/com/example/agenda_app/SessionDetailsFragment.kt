package com.example.agenda_app

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.agenda_app.MainActivity.Companion.Sessions
import com.example.agenda_app.R
import kotlinx.android.synthetic.main.session_details_fragment.*



// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [DetailFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [DetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SessionDetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val position = arguments!!.getInt("position",0)
        session_image.setImageResource(Sessions[position].image)
        session_title.text = Sessions[position].title
        session_teacher.text = Sessions[position].teacher
        session_date.text = Sessions[position].date
        session_duration.text = Sessions[position].duration
        return inflater.inflate(R.layout.session_details_fragment, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }
}
