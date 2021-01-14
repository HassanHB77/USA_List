package com.hassan.android.usastate

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.hassan.android.usastate.databinding.FragmentListBinding
import com.hassan.android.usastate.recyclerview.ItemAdaptor


class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)

        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(requireContext(), 1)
            adapter = ItemAdaptor(getMainResponse(requireActivity()).objects, requireActivity())
        }

        return binding.root
    }

}