package com.example.mynoteshello.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mynoteshello.databinding.NoteItemBinding
import com.example.mynoteshello.ui.models.NotesModel

class NoteAdapter : RecyclerView.Adapter<NoteAdapter.NoteViwHolter>() {

    private var noteList = mutableListOf<NotesModel>()

    fun setNoteList(noteList: MutableList<NotesModel>) {
        this.noteList = noteList
    }
    class NoteViwHolter(private val biding: NoteItemBinding) :
        RecyclerView.ViewHolder(biding.root) {
        fun onBind(notesModel: NotesModel) {
            biding.tvNote.text = notesModel.note
            biding.tvTitleNote.text = notesModel.title
            biding.tvDateTime.text = notesModel.data
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViwHolter {
        return NoteViwHolter(
            NoteItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return noteList.size
    }

    override fun onBindViewHolder(holder: NoteViwHolter, position: Int) {
        holder.onBind(noteList[position])
    }
}