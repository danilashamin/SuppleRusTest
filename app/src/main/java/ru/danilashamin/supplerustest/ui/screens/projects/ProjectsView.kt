package ru.danilashamin.supplerustest.ui.screens.projects

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import ru.danilashamin.supplerustest.base.ViewBase
import ru.danilashamin.supplerustest.model.Project

interface ProjectsView : ViewBase {
    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setProjects(projects:List<Project>)
}