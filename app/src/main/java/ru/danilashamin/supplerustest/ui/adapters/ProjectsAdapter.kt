package ru.danilashamin.supplerustest.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.card_project_name.view.*
import ru.danilashamin.supplerustest.R
import ru.danilashamin.supplerustest.model.Project

class ProjectsAdapter(private val listener: ProjectsAdapterListener) :
    RecyclerView.Adapter<ProjectsAdapter.ProjectViewHolder>() {

    var projects: List<Project>? = null
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_project_name, parent, false)
        return ProjectViewHolder(view)
    }

    override fun getItemCount(): Int = projects?.size ?: 0

    override fun onBindViewHolder(holder: ProjectViewHolder, position: Int) {
        holder.bind(projects?.get(position))
    }

    inner class ProjectViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvProjectName = itemView.tvProjectName
        private val projectNameContainer = itemView.projectNameContainer

        fun bind(project: Project?) {
            tvProjectName.text = project?.projectName
            if (project != null) {
                projectNameContainer.setOnClickListener { listener.onProjectClicked(project) }
            }
        }
    }

}

interface ProjectsAdapterListener {
    fun onProjectClicked(project: Project)
}
