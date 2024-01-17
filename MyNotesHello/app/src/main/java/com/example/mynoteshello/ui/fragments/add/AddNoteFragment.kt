package com.example.mynoteshello.ui.fragments.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mynoteshello.App
import com.example.mynoteshello.data.local.room.entities.Note
import com.example.mynoteshello.databinding.FragmentAddNoteBinding
import kotlin.math.log

class AddNoteFragment : Fragment() {

    private var _binding: FragmentAddNoteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addNoteToRoom()
    }

    private fun addNoteToRoom() = with(binding) {
        btnHome1.setOnClickListener {
            val title = someId.text.toString().trim()
            val note = some.text.toString().trim()

            App.db?.let {
                it.noteDao().addNote(Note(title = title, description = note))
                findNavController().navigateUp()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}