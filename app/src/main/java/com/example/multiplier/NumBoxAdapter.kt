package com.example.multiplier

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.multiplier.databinding.ItemGridBinding

class NumBoxAdapter(
    private var numBoxes: MutableList<NumBox>,
    private var listener: OnClickListener
) : RecyclerView.Adapter<NumBoxAdapter.ViewHolder>() {

    private lateinit var mContext: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        mContext = parent.context
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_grid, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val numBox = numBoxes[position]

        with(holder){
            setListener(numBox)
            binding.tvNumber.text = numBox.id.toString()
        }
    }

    override fun getItemCount(): Int = numBoxes.size


    fun add(numBox: NumBox) {
            numBoxes.add(numBox)
            numBox.establishId(numBoxes.size)
            notifyItemInserted(numBoxes.size - 1)
    }

    fun update(numBox: NumBox) {
        val index = numBoxes.indexOf(numBox)
        if (index != -1) {
            numBoxes[index].multiplyNumber()
            notifyItemChanged(index)
        }
    }


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemGridBinding.bind(view)
        fun setListener(numBox: NumBox) {
            binding.root.setOnClickListener { listener.onClick(numBox) }
        }
    }

}