package ru.danilashamin.supplerustest.presentation.project

import com.arellomobile.mvp.InjectViewState
import ru.danilashamin.supplerustest.App
import ru.danilashamin.supplerustest.api.ApiService
import ru.danilashamin.supplerustest.base.PresenterBase
import ru.danilashamin.supplerustest.model.Project
import ru.danilashamin.supplerustest.ui.screens.project.ProjectView
import ru.danilashamin.supplerustest.utils.MessageService
import javax.inject.Inject

@InjectViewState
class ProjectPresenter(private val project: Project) : PresenterBase<ProjectView>() {
    @Inject
    lateinit var apiService: ApiService
    @Inject
    lateinit var messageService: MessageService

    init {
        App.instance.appComponent.inject(this)
    }

    override fun onFirstViewAttach() {
        disposeOnDestroy(apiService.getPositions(project.projectId)
            .doOnSubscribe { viewState.showLoading() }
            .doOnComplete { viewState.hideLoading() }
            .subscribe({
                viewState.setPositions(it.body)
            }, {
                it.printStackTrace()
                viewState.showMessage(
                    """${messageService.getErrorOnRequestMessage()}
${it.message}"""
                )
            })
        )
    }
}