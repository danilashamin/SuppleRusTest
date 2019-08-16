package ru.danilashamin.supplerustest.presentation.projects

import com.arellomobile.mvp.InjectViewState
import ru.danilashamin.supplerustest.App
import ru.danilashamin.supplerustest.api.ApiService
import ru.danilashamin.supplerustest.base.PresenterBase
import ru.danilashamin.supplerustest.model.Project
import ru.danilashamin.supplerustest.ui.screens.projects.ProjectsView
import ru.danilashamin.supplerustest.utils.MessageService
import ru.danilashamin.supplerustest.utils.Screens
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class ProjectsPresenter : PresenterBase<ProjectsView>() {
    @Inject
    lateinit var router: Router

    @Inject
    lateinit var apiService: ApiService

    @Inject
    lateinit var messageService: MessageService

    init {
        App.instance.appComponent.inject(this)
    }

    override fun onFirstViewAttach() {
        disposeOnDestroy(
            apiService.getProjectIDByCity("SPB")
                .doOnSubscribe { viewState.showLoading() }
                .doOnComplete { viewState.hideLoading() }
                .subscribe({
                    viewState.setProjects(it.body)
                }, {
                    it.printStackTrace()
                    viewState.showMessage(
                        """${messageService.getErrorOnRequestMessage()}
${it.message}"""
                    )
                })
        )
    }

    fun onProjectClicked(project: Project) {
        router.navigateTo(Screens.ProjectScreen(project))
    }
}