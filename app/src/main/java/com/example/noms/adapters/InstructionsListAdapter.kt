package com.example.noms.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.noms.R
import kotlinx.android.synthetic.main.instruction_list_item.view.*

class InstructionsListAdapter (val instructions: List<String>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.instruction_list_item, parent, false)
        return InstructionListItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as InstructionListItemViewHolder).bind(instructions[position])
    }

    override fun getItemCount() = instructions.size

    class InstructionListItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(instruction: String) {
            itemView.instructionInfo.text = instruction
        }
    }
}