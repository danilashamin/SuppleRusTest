package ru.danilashamin.supplerustest.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.card_project.view.*
import ru.danilashamin.supplerustest.R
import ru.danilashamin.supplerustest.model.Position
import ru.danilashamin.supplerustest.utils.GlideApp

class ProjectPositionsAdapter : RecyclerView.Adapter<ProjectPositionsAdapter.PositionViewHolder>() {

    var positions: List<Position>? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PositionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_project, parent, false)
        return PositionViewHolder(view)
    }

    override fun getItemCount(): Int = positions?.size ?: 0

    override fun onBindViewHolder(holder: PositionViewHolder, position: Int) {
        val pos = positions?.get(position)
        holder.bind(pos)
    }

    class PositionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val ivPositionImage = itemView.ivPositionImage
        private val tvPositionName = itemView.tvPositionName
        private val tvPositionDescription = itemView.tvPositionDescription

        fun bind(position: Position?) {
            GlideApp.with(ivPositionImage)
                .load(position)
                .into(ivPositionImage)

            tvPositionName.text = position?.content?.title

            val description = position?.content?.description

            if (description?.isEmpty() == true || description?.equals(" ") == true) {
                tvPositionDescription.visibility = View.GONE
            } else {
                tvPositionDescription.text = description
            }
        }
    }
}