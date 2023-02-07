package com.def.roomsampleapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.def.roomsampleapp.databinding.FragmentFirstBinding
import com.def.roomsampleapp.model.Student
import com.def.roomsampleapp.viewmodel.DatasViewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: DatasViewModel
    private lateinit var adapter: StudentAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[DatasViewModel::class.java]
        // initData()
        initViewObjects()
        initObservers()
        return binding.root

    }

    fun initData(){
        viewModel.insert(Student(name = "Eren", surname = "ÇOLAK", age = "33"))
        viewModel.insert(Student(name = "Ayşe", surname = "ÇOLAK", age = "31"))
        viewModel.insert(Student(name = "Elif", surname = "ÇOLAK", age = "31"))
    }
    fun initViewObjects(){
        adapter = StudentAdapter(StudentDiff())
        binding.recyclerview.adapter = adapter
        binding.recyclerview.layoutManager = LinearLayoutManager(this.context)
    }

    fun initObservers(){
        viewModel.allStudents.observe(viewLifecycleOwner) {allStudents ->
            adapter.submitList(allStudents)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    inner class StudentDiff: DiffUtil.ItemCallback<Student>(){
        override fun areItemsTheSame(oldItem: Student, newItem: Student): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Student, newItem: Student): Boolean {
           return oldItem == newItem
        }

    }
}