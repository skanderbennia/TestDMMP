package com.example.testdmmp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.testdmmp.NavActivity
import com.example.testdmmp.databinding.FragmentHomeBinding
import com.example.testdmmp.databinding.FragmentQuizBinding
import kotlinx.android.synthetic.main.fragment_home.*
// TODO: Rename parameter arguments, choose names that match


/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /*val activity = NavActivity()
        val myDataFromActivity = activity?.getMyData()
        email_value.text = myDataFromActivity
       /* if(arguments != null ){
            val email_valeur = this.arguments?.getString("params")
            email_value.text = email_valeur
        }*/*/
        val binding = DataBindingUtil.inflate<FragmentHomeBinding>(
            inflater, R.layout.fragment_home, container, false)
        binding.emailValue.text = "skander@gmail.com"
        return binding.root

    }
    companion object {
        fun newInstance(): HomeFragment = HomeFragment()
    }
}