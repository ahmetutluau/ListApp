package com.ahmetutlu.listapp.view

import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.ahmetutlu.listapp.R
import com.ahmetutlu.listapp.adapter.RecyclerAdapter
import com.ahmetutlu.listapp.databinding.FragmentDetailsBinding
import com.ahmetutlu.listapp.model.ListData
import com.ahmetutlu.listapp.utils.dowloadImage
import com.ahmetutlu.listapp.utils.makePlaceHolder
import com.ahmetutlu.listapp.vm.DetailsVM
import retrofit2.http.Url
import java.net.URL

class DetailsFragment : Fragment() {
    private lateinit var binding:FragmentDetailsBinding
    private lateinit var viewModel:DetailsVM


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_details,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        arguments?.let {
            binding.chosenItem=DetailsFragmentArgs.fromBundle(it).model
            binding.image.dowloadImage(DetailsFragmentArgs.fromBundle(it).foto, makePlaceHolder(view.context))


        }

        viewModel= DetailsVM()

        subscribeIncomeData()


    }
    fun subscribeIncomeData(){
        viewModel.incomeData.observe(viewLifecycleOwner, Observer {
            binding.chosenItem=it
        })
    }


}