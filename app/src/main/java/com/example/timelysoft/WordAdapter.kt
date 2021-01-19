package com.example.timelysoft

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WordAdapter : RecyclerView.Adapter<WordAdapter.HistoryViewHolder>() {

    private val histories = ArrayList<Word>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_word, parent, false)
        return HistoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.bind(histories[position])
    }

    override fun getItemCount(): Int {
        return histories.size
    }

    fun update(list: List<Word>) {
        histories.clear()
        histories.addAll(list)
        notifyDataSetChanged()
    }

    inner class HistoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvWord :TextView = itemView.findViewById(R.id.tv_word)
        fun bind(order: Word) {
                tvWord.text = order.originalWord
        }
    }
}