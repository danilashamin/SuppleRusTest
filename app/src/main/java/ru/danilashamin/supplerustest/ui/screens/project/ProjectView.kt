package ru.danilashamin.supplerustest.ui.screens.project

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import ru.danilashamin.supplerustest.base.ViewBase
import ru.danilashamin.supplerustest.model.Position

interface ProjectView : ViewBase {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setPositions(positions: List<Position>)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setProjectName(projectName: String)
}