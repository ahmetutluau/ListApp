package com.ahmetutlu.listapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ahmetutlu.listapp.R
import com.ahmetutlu.listapp.adapter.RecyclerAdapter
import com.ahmetutlu.listapp.databinding.FragmentListBinding
import com.ahmetutlu.listapp.utils.extensions.showMessage
import com.ahmetutlu.listapp.vm.ListVM

class ListFragment : Fragment() {
    private lateinit var viewModel:ListVM
    private var listAdapter=RecyclerAdapter(arrayListOf())
    private lateinit var recyclerView:RecyclerView
    private lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_list,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel= ListVM()

        binding.recyclerView.layoutManager=LinearLayoutManager(context)
        binding.recyclerView.adapter=listAdapter

        //divider between items in below
        binding.recyclerView.addItemDecoration(DividerItemDecoration(context,LinearLayoutManager.VERTICAL))

        //to make liisten binding to whole viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        subscribeDatas()
        subscribeMessage()

        //we define in below when we swipe list page
        binding.swiperefreshLayout.setOnRefreshListener {
            viewModel.showProgress(true)
            viewModel.refreshData()

            binding.swiperefreshLayout.isRefreshing=false//we already have our own progress bar
        }
    }

    fun subscribeDatas(){
        viewModel.datas.observe(viewLifecycleOwner, Observer {
            it?.let {
                listAdapter.updatedList(it)
                //here we observe our livedata with func from our adapter
            }
        })
    }
    fun subscribeMessage(){
        viewModel.message.observe(viewLifecycleOwner, Observer { message->
            showMessage(message)
        })
    }





}