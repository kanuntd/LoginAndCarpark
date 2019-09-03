package buu.informatics.s59161081.loginandcarpark


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.inflate
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import buu.informatics.s59161081.loginandcarpark.databinding.FragmentLoginBinding
import kotlinx.android.synthetic.main.fragment_login.*

/**
 * A simple [Fragment] subclass.
 */
class LoginFragment : Fragment() {
    private val username= "admin"
    private val password = "admin"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentLoginBinding>(inflater,
            R.layout.fragment_login,container,false)
        binding.noLoginText.visibility = View.GONE
        binding.loginButton.setOnClickListener { view : View ->
            if(usernameEditText.text.toString()== username && passwordEditText.text.toString() == password){
                view.findNavController().navigate(R.id.action_loginFragment_to_roomFragment)
            }else{
                binding.noLoginText.visibility =View.VISIBLE
            }
        }
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
