package com.example.noteapp.presenaasion.ui.adapter

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import com.example.noteapp.databinding.NoteItemBinding
import com.example.noteapp.note_item_Fragment
import com.example.noteapp.presenaasion.data.models.NotesModel

class NoteAdapter : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    private var noteList = mutableListOf<NotesModel>()

    fun setNoteList(noteList: MutableList<NotesModel>) {
        this.noteList = noteList
    }

    class NoteViewHolder(private val binding: NoteItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(notesModel: NotesModel) {
            binding.tvNote.text = notesModel.note
            binding.tvTitleNote.text = notesModel.title
            binding.tvData.text = notesModel.data
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            NoteItemBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun getItemCount(): Int {
        return noteList.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.onBind(noteList[position])
    }
}