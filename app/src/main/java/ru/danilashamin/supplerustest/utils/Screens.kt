package ru.danilashamin.supplerustest.utils

import androidx.fragment.app.Fragment
import ru.danilashamin.supplerustest.model.Project
import ru.danilashamin.supplerustest.ui.screens.project.ProjectFragment
import ru.danilashamin.supplerustest.ui.screens.projects.ProjectsFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {
    class ProjectsScreen : SupportAppScreen() {
        override fun getFragment(): Fragment = ProjectsFragment.newInstance()
    }

    class ProjectScreen(private val project: Project) : SupportAppScreen() {
        override fun getFragment(): Fragment = ProjectFragment.newInstance(project)
    }
}