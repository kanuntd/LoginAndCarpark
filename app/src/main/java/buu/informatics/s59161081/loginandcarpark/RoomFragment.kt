package buu.informatics.s59161081.loginandcarpark


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import buu.informatics.s59161081.loginandcarpark.databinding.FragmentRoomBinding

/**
 * A simple [Fragment] subclass.
 */
class RoomFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentRoomBinding>(inflater,
            R.layout.fragment_room,container,false)
        return binding.root
    }


}
