package ru.danilashamin.supplerustest.ui.project

import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import ru.danilashamin.supplerustest.R
import ru.danilashamin.supplerustest.base.FragmentBase
import ru.danilashamin.supplerustest.model.Project
import ru.danilashamin.supplerustest.presentation.project.ProjectPresenter
import ru.danilashamin.supplerustest.utils.Constants.PROJECT_KEY

class ProjectFragment : FragmentBase(), ProjectView {
    companion object {
        fun newInstance(project: Project): ProjectFragment {
            val fragment = ProjectFragment()
            val args = Bundle()
            args.putSerializable(PROJECT_KEY, project)
            fragment.arguments = args
            return fragment
        }
    }

    @InjectPresenter
    lateinit var presenter: ProjectPresenter

    override fun provideLayoutRes(): Int = R.layout.fragment_project


    @ProvidePresenter
    fun providePresenter():ProjectPresenter{
        val project = arguments?.getSerializable(PROJECT_KEY) as Project
        return ProjectPresenter(project)
    }

}