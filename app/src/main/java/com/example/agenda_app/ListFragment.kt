package com.example.agenda_app

import android.content.Context
import android.graphics.ColorSpace
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import com.example.agenda_app.MainActivity.Companion.Sessions
import com.example.agenda_app.models.Session
import kotlinx.android.synthetic.main.fragment_list.*
import kotlinx.android.synthetic.main.session_details_fragment.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [ListFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [ListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Sessions = MainActivity.Sessions
        val adapter = Adapter(activity!!, Sessions)
        session_list.adapter = adapter
        session_list.setOnItemClickListener { parent, view, position, id ->
            session_image.setImageResource(Sessions[position].image)
            session_title.text = Sessions[position].title
            session_teacher.text = Sessions[position].teacher
            session_date.text = Sessions[position].date
            session_duration.text = Sessions[position].duration
        }
    }
}
