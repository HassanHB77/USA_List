package com.hassan.android.usastate

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.hassan.android.usastate.databinding.FragmentListBinding
import com.hassan.android.usastate.recyclerview.ItemAdaptor


class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    private val viewModel: ListViewModel by lazy {
        ViewModelProvider(this).get(ListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)

        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(requireContext(), 1)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.loadPeople(requireActivity())

        viewModel.listOfPeopleLiveData.observe(viewLifecycleOwner, {
            binding.recyclerView.adapter = ItemAdaptor(it, requireActivity())
        })
    }
}