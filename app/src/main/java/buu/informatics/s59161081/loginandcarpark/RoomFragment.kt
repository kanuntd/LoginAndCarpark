package buu.informatics.s59161081.loginandcarpark


import android.annotation.SuppressLint
import android.graphics.Color
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
    private lateinit var binding: FragmentRoomBinding
    private val carParking0 = CarParking(1)
    private val carParking1 = CarParking(2)
    private val carParking2 = CarParking(3)
    private val carParkings = arrayOf(carParking0, carParking1, carParking2)
    private var currentIndex = 0


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate<FragmentRoomBinding>(inflater,
            R.layout.fragment_room,container,false)

        binding.apply {
            this.carParking = carParkings?.get(0)
            roomButton1.setOnClickListener { view ->
                clickRoom(view)
            }
            roomButton2.setOnClickListener { view ->
                clickRoom(view)
            }
            roomButton3.setOnClickListener { view ->
                clickRoom(view)
            }
            updateButton.setOnClickListener{view ->
                updateRoom(view)
            }

        }
        setHasOptionsMenu(true)
        return binding.root
    }
    private fun getCarIdFormView(view:View):Int {
        when(view.id) {
            R.id.roomButton1 -> return 0
            R.id.roomButton2 -> return 1
            R.id.roomButton3 -> return 2
        }
        return -1
    }
    private fun clickRoom(view: View){
        binding.apply {
            currentIndex = getCarIdFormView(view)
            this.carParking = carParkings?.get(currentIndex)
            invalidateAll()
        }
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.options_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!,
            view!!.findNavController()) || super.onOptionsItemSelected(item)
    }

    private fun updateRoom(view: View){
        val carPark = carParkings?.get(currentIndex)
        carPark.status = false
        binding.apply {
            if(currentIndex==0){
                roomButton1.setText(R.string.busy)
                roomButton1.setBackgroundColor(Color.parseColor("#CCAAAA"))
            }else if(currentIndex==1){
                roomButton2.setText(R.string.busy)
                roomButton2.setBackgroundColor(Color.parseColor("#CCAAAA"))
            }else{
                roomButton3.setText(R.string.busy)
                roomButton3.setBackgroundColor(Color.parseColor("#CCAAAA"))
            }
            invalidateAll()
        }

    }




}
