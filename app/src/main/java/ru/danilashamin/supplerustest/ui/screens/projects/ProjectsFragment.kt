package ru.danilashamin.supplerustest.ui.screens.projects

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.fragment_projects.*
import ru.danilashamin.supplerustest.R
import ru.danilashamin.supplerustest.base.FragmentBase
import ru.danilashamin.supplerustest.model.Project
import ru.danilashamin.supplerustest.presentation.projects.ProjectsPresenter
import ru.danilashamin.supplerustest.ui.adapters.ProjectsAdapter
import ru.danilashamin.supplerustest.ui.adapters.ProjectsAdapterListener
import ru.danilashamin.supplerustest.ui.custom.MarginItemDecoration

class ProjectsFragment : FragmentBase(), ProjectsView, ProjectsAdapterListener {
    companion object {
        fun newInstance() = ProjectsFragment()
    }

    @InjectPresenter
    lateinit var presenter: ProjectsPresenter

    private val projectsAdapter = ProjectsAdapter(this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        rvProjects.layoutManager = LinearLayoutManager(context)
        rvProjects.addItemDecoration(MarginItemDecoration())
        rvProjects.adapter = projectsAdapter
    }

    override fun provideLayoutRes(): Int = R.layout.fragment_projects

    override fun setProjects(projects: List<Project>) {
        projectsAdapter.projects = projects
    }

    override fun onProjectClicked(project: Project) {
        presenter.onProjectClicked(project)
    }
}