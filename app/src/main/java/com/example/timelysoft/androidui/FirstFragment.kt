package com.example.timelysoft.androidui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import com.example.timelysoft.databinding.FragmentFirstBinding
import com.example.timelysoft.domain.MainUseCase

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {
    val viewModel: WordsViewModel by activityViewModels()
    private var _binding: FragmentFirstBinding? = null
    private lateinit var adapter: WordAdapter

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun initRecyclerView() {
        _binding?.recyclerView2
        adapter = WordAdapter()
        with(_binding?.recyclerView2) {
            this?.let {
                layoutManager = LinearLayoutManager(requireContext())
                setHasFixedSize(true)
                this.adapter = adapter
                viewModel.listOfWords.observe(viewLifecycleOwner, Observer {
                    (this.adapter as WordAdapter?)?.submitList(it)
                })
            }
        }


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        binding.buttonFirst.setOnClickListener {
            viewModel.saveWord(binding.textInputLayout.text.toString())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}