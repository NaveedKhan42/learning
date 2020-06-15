package com.naveed.myandroidapp.view.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.naveed.myandroidapp.R
import com.naveed.myandroidapp.databinding.FragmentLoginBinding
import com.naveed.myandroidapp.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.fragment_login.*


/**
 * View/Fragment for Login Screen
 */
class LoginFragment : Fragment() {

    private lateinit var loginViewModel: LoginViewModel
    private lateinit var loginBinder: FragmentLoginBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loginBinder = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_login,
            container,
            false
        )

        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        loginBinder.loginViewModel = loginViewModel
        loginBinder.lifecycleOwner = this

        return loginBinder.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
        initObservers()
    }


    private fun initListener(){

        btn_submit.setOnClickListener {
            Log.i("Info", "Sign In Button pressed")
            loginViewModel.performLogin()
        }

        btn_sign_up.setOnClickListener {
            Log.i("Info", "Sign Up Button pressed")
            findNavController().navigate(R.id.action_loginFragment_to_registrationFragment2)
        }

        btn_reset.setOnClickListener {
            Log.i("Info", "Reset Button pressed")
            et_user_name.setText("")
            et_password.setText("")
        }

    }


    private fun initObservers(){
        loginViewModel.loginResult.observe(viewLifecycleOwner, Observer {result ->
            result?.let {valid ->
                    if(valid)
                        findNavController().navigate(R.id.action_loginFragment_to_recyclerviewFragment)
                    else
                        Toast.makeText(context, "Invalid Credentials", Toast.LENGTH_LONG).show()
            }
        })
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
