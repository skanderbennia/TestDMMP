package com.example.testdmmp

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testdmmp.adapter.MyAdapter
import com.example.testdmmp.models.Planet
import com.example.testdmmp.repository.Repository
import kotlinx.android.synthetic.main.fragment_space.*


class SpaceFragment : Fragment() {

private lateinit var viewModel: MainViewModel
    private val myAdapter by lazy { MyAdapter() }

    //setupRecyclerview()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)
        viewModel.getPlanet()
        viewModel.myResponse.observe(this, Observer {response ->


            if(response.isSuccessful){
                setupRecyclerview()
                response.body()?.let { myAdapter.setData(it) }

            }else{
                Log.d("error","nothing")
            }

        })
        return inflater.inflate(R.layout.fragment_space, container, false)


    }


    private fun setupRecyclerview() {
        recycle?.adapter = myAdapter
        recycle?.layoutManager = LinearLayoutManager(requireContext())
    }

    companion object {
        fun newInstance(): SpaceFragment = SpaceFragment()
    }

}