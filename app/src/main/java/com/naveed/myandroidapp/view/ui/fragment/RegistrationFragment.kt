package com.naveed.myandroidapp.view.ui.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.naveed.myandroidapp.R
import com.naveed.myandroidapp.databinding.FragmentRegistrationBinding
import com.naveed.myandroidapp.extension.isValidEmail
import com.naveed.myandroidapp.viewmodel.RegistrationViewModel
import kotlinx.android.synthetic.main.fragment_registration.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 *View/Fragment for Registration Screen
 */
class RegistrationFragment : Fragment() {

    private lateinit var registrationViewModel : RegistrationViewModel
    private lateinit var registrationBinder : FragmentRegistrationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        registrationBinder = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_registration,
            container,
            false
        )

        registrationViewModel = ViewModelProvider(this).get(RegistrationViewModel::class.java)
        registrationBinder.registrationViewModel = registrationViewModel

        registrationBinder.lifecycleOwner = this
        return registrationBinder.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
    }

    private fun initListener(){
        button_register.setOnClickListener {
            if(user_email_et.text.toString().isValidEmail()){
                registrationViewModel.saveUserRegistrationData()
                findNavController().navigate(R.id.action_registrationFragment2_to_recyclerviewFragment)
            }
            else{
                user_email_et.error = "Please enter a valid Email"
            }
        }
    }

    //to disable or hide actionbar[toolbar] options menu in Fragment
    override fun onStart() {
        super.onStart()
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu?.clear()
        super.onCreateOptionsMenu(menu, inflater)
    }

}
