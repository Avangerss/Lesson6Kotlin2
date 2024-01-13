package com.example.noteapp.presenaasion.ui.fragments.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.noteapp.databinding.FragmentHomeBinding
import com.example.noteapp.presenaasion.data.models.NotesModel
import com.example.noteapp.presenaasion.ui.adapter.NoteAdapter

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val noteAdapter = NoteAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding  = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initialize()
    }

    private fun initialize() {
        noteAdapter.setNoteList(
            mutableListOf(
                NotesModel("Title", "Note", "Data \n time"),
                NotesModel("Title", "Note", "Data \n time"),
                NotesModel("Title", "Note", "Data \n time")
            )
        )
        binding.rvNotes.adapter = noteAdapter
    }
}