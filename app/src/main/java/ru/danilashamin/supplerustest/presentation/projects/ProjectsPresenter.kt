package ru.danilashamin.supplerustest.presentation.projects

import com.arellomobile.mvp.InjectViewState
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.danilashamin.supplerustest.App
import ru.danilashamin.supplerustest.api.Api
import ru.danilashamin.supplerustest.api.keys.ProjectIDByCityRequestKeys
import ru.danilashamin.supplerustest.api.request.Request
import ru.danilashamin.supplerustest.base.PresenterBase
import ru.danilashamin.supplerustest.model.Project
import ru.danilashamin.supplerustest.ui.screens.projects.ProjectsView
import ru.danilashamin.supplerustest.utils.MessageService
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class ProjectsPresenter : PresenterBase<ProjectsView>() {
    @Inject
    lateinit var router: Router

    @Inject
    lateinit var api: Api

    @Inject
    lateinit var messageService: MessageService

    init {
        App.instance.appComponent.inject(this)
    }

    override fun onFirstViewAttach() {
        disposeOnDestroy(
            api.getProjectIDByCity(Request(ProjectIDByCityRequestKeys("SPB")))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { viewState.showLoading() }
                .doOnComplete { viewState.hideLoading() }
                .subscribe({
                    viewState.setProjects(it.body)
                }, {
                    it.printStackTrace()
                    viewState.showMessage(messageService.getErrorOnRequestMessage())
                })
        )
    }

    fun onProjectClicked(project: Project) {

    }
}