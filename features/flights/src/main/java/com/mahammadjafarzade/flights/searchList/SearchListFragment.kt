package com.mahammadjafarzade.flights.searchList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.mahammadjafarzade.common.base.BaseFragment
import com.mahammadjafarzade.common.flowstate.Status
import com.mahammadjafarzade.flights.databinding.FragmentSearchListBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SearchListFragment : BaseFragment<FragmentSearchListBinding, SearchListViewModel>(FragmentSearchListBinding::inflate) {
    val viewModel : SearchListViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
           lifecycleScope.launch {
               viewModel.getFlights()
           }
        viewModel.data.observe(viewLifecycleOwner){
        }
    }

    override fun mViewModel(): SearchListViewModel {
        return viewModel
    }

}