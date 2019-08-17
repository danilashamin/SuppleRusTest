package ru.danilashamin.supplerustest.ui.screens.project

import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.littlemango.stacklayoutmanager.StackLayoutManager
import kotlinx.android.synthetic.main.fragment_project.*
import ru.danilashamin.supplerustest.R
import ru.danilashamin.supplerustest.base.FragmentBase
import ru.danilashamin.supplerustest.model.Position
import ru.danilashamin.supplerustest.model.Project
import ru.danilashamin.supplerustest.presentation.project.ProjectPresenter
import ru.danilashamin.supplerustest.ui.adapters.ProjectPositionsAdapter
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

    private val positionsAdapter = ProjectPositionsAdapter()

    override fun provideLayoutRes(): Int = R.layout.fragment_project

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val layoutManager = StackLayoutManager(StackLayoutManager.ScrollOrientation.BOTTOM_TO_TOP, 3)

        layoutManager.setItemOffset(50)

        rvProjectPositions.layoutManager = layoutManager
        rvProjectPositions.adapter = positionsAdapter
    }

    override fun setPositions(positions: List<Position>) {
        positionsAdapter.positions = positions
    }

    override fun setProjectName(projectName: String) {
        tvProjectName.text = projectName
    }

    @ProvidePresenter
    fun providePresenter(): ProjectPresenter {
        val project = arguments?.getSerializable(PROJECT_KEY) as Project
        return ProjectPresenter(project)
    }

}