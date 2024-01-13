package com.example.mynoteshello.ui.fragments.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mynoteshello.databinding.FragmentHomeBinding
import com.example.mynoteshello.ui.models.NotesModel
import com.example.mynoteshello.ui.adapters.NoteAdapter

class HomeFragment : Fragment() {

    private lateinit var biding: FragmentHomeBinding

    private val noteAdapter = NoteAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        biding = FragmentHomeBinding.inflate(layoutInflater)
        return biding.root
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
        biding.rvNotes.adapter = noteAdapter
    }
}