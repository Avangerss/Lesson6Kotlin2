package com.example.mynoteshello.ui.fragments.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.mynoteshello.App
import com.example.mynoteshello.R
import com.example.mynoteshello.databinding.FragmentHomeBinding
import com.example.mynoteshello.ui.adapters.NoteAdapter

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null

    private lateinit var biding: FragmentHomeBinding

    private val noteAdapter = NoteAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        biding = FragmentHomeBinding.inflate(layoutInflater)
        return biding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigateToAddNote()
        initialize()
    }

    private fun navigateToAddNote() = with(biding) {
        btnAddNote.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_addNoteFragment)
        }
    }

    private fun initialize() = with(biding) {
        App.db?.let {
            it.noteDao().getAllNotes()
            noteAdapter.setNoteList(it.noteDao().getAllNotes() )
        }
        biding.rvNotes.adapter = noteAdapter
    }
}