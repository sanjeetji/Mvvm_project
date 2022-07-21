package com.sanjeet.solulabassignment.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.sanjeet.solulabassignment.databinding.FragmentHomeBinding
import com.sanjeet.solulabassignment.repository.HomePageRepository
import com.sanjeet.solulabassignment.service.RetrofitService
import com.sanjeet.solulabassignment.viewmodel.HomeViewModel
import com.sanjeet.solulabassignment.viewmodel.HomeViewModelFactory

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding?=null
    private val binding get() = _binding

    lateinit var viewModel: HomeViewModel
    private val retrofitService = RetrofitService.getInstance()
    private val homeItemListAdapter = HomeItemListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this, HomeViewModelFactory(HomePageRepository(retrofitService))).get(HomeViewModel::class.java)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater,container,false)

        binding?.progressbar?.visibility = View.VISIBLE
        binding?.rvItem?.apply {
            adapter = homeItemListAdapter
            layoutManager = GridLayoutManager(requireActivity(),3)
        }

        viewModel.data.observe(requireActivity(), Observer {
            binding?.progressbar?.visibility = View.GONE
            it?.data?.list?.let { it1 -> homeItemListAdapter.setItemList(it1) }
        })
        viewModel.errorMessage.observe(requireActivity(), Observer {
            binding?.progressbar?.visibility = View.GONE
            Toast.makeText(requireActivity(),it,Toast.LENGTH_SHORT).show()
        })

        viewModel.getHomePageItems()


        return binding?.root!!
    }

}