package com.mahammadjafarzade.flights.searchList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.constraintlayout.solver.state.State.Constraint
import androidx.constraintlayout.widget.ConstraintSet
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.mahammadjafarzade.common.base.BaseFragment
import com.mahammadjafarzade.common.flowstate.Status
import com.mahammadjafarzade.common.toDetail
import com.mahammadjafarzade.flights.R
import com.mahammadjafarzade.flights.databinding.FragmentSearchListBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SearchListFragment : BaseFragment<FragmentSearchListBinding>(FragmentSearchListBinding::inflate) {
    val viewModel : SearchListViewModel by viewModels()
    private lateinit var adapter : SearchListAdapter
    override fun mViewModel(): SearchListViewModel {
        return viewModel
    }

    fun addButton(){
        val button = Button(context)
        val buttonId = 1
        button.id = buttonId
        button.text = "Button"
        context?.let {
            button.setBackgroundColor(it.getColor(android.R.color.holo_red_dark))
        }
        binding.root.addView(button)

        val set = ConstraintSet()
        set.clone(binding.root)

        set.constrainDefaultWidth(button.id, 200)
        set.constrainDefaultHeight(button.id, 200)

        set.connect(button.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START, 50)
        set.connect(button.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, 50)
        set.connect(button.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END, 50)


//        val button2 = Button(context)
//        val button2Id = 2
//        button2.id = button2Id
//        button2.text = "Button 2"
//        context?.let {
//            button.setBackgroundColor(it.getColor(android.R.color.holo_red_dark))
//        }
//        binding.root.addView(button2)
//
//        set.connect(button2.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START, 50)
//        set.connect(button2.id, ConstraintSet.TOP, buttonId, ConstraintSet.BOTTOM, 50)
//        set.connect(button2.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END, 50)
        set.applyTo(binding.root)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecylerAdapter()

        lifecycleScope.launch {
            viewModel.getFlights()
        }

        viewModel.data.observe(viewLifecycleOwner) {
            adapter.setData(it?.flights ?: listOf())
        }
        addButton()
    }
    private fun initRecylerAdapter(){
        adapter = SearchListAdapter{
            findNavController().toDetail(it.eunid)
        }
        binding.recylerView.layoutManager = LinearLayoutManager(context)
        binding.recylerView.adapter = adapter
    }
}