package buu.informatics.s59161081.loginandcarpark


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import buu.informatics.s59161081.loginandcarpark.databinding.FragmentRoomBinding

/**
 * A simple [Fragment] subclass.
 */
class RoomFragment : Fragment() {
    private val carParking0 = CarParking(0)
    private val carParking1 = CarParking(1)
    private val carParking2 = CarParking(2)
    private val carParkings = arrayOf(carParking0,carParking1,carParking2)


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentRoomBinding>(inflater,
            R.layout.fragment_room,container,false)
        setHasOptionsMenu(true)
        return binding.root
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.options_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!,
            view!!.findNavController()) || super.onOptionsItemSelected(item)
    }



}
