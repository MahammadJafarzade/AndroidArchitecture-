package com.mahammadjafarzade.flights.searchList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.mahammadjafarzade.flights.databinding.FragmentSearchListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchListFragment : Fragment() {
    lateinit var binding : FragmentSearchListBinding
    val viewModel : SearchListViewModel by viewModels()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSearchListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btn.setOnClickListener {
            viewModel.getFlights()
        }
        viewModel.data.observe(viewLifecycleOwner) {
        }
    }
}