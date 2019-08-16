package ru.danilashamin.supplerustest.api

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.danilashamin.supplerustest.api.keys.GetPositionsRequestKeys
import ru.danilashamin.supplerustest.api.keys.ProjectIDByCityRequestKeys
import ru.danilashamin.supplerustest.api.request.Request
import ru.danilashamin.supplerustest.api.response.Response
import ru.danilashamin.supplerustest.model.ImageInfo
import ru.danilashamin.supplerustest.model.Position
import ru.danilashamin.supplerustest.model.Project

class ApiService(private val api: Api) {
    fun getProjectIDByCity(cityCode: String): Observable<Response<List<Project>>> {
        return api.getProjectIDByCity(Request(ProjectIDByCityRequestKeys(cityCode)))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .flatMap {
                if (it.errorCode == 1) {
                    Observable.error(Exception(it.userErrorInfo))
                } else {
                    Observable.just(it)
                }
            }
    }

    fun getPositions(projectId: String): Observable<Response<List<Position>>> {
        return api.getPositions(Request(GetPositionsRequestKeys(projectId)))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .flatMap {
                if (it.errorCode == 1) {
                    Observable.error(Exception(it.userErrorInfo))
                } else {
                    Observable.just(it)
                }
            }
    }

    fun getImage(imageSize: String, objectId: String): Observable<Response<ImageInfo>> {
        return api.getImage(Request(imageSize, objectId))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .flatMap {
                if (it.errorCode == 1) {
                    Observable.error(Exception(it.userErrorInfo))
                } else {
                    Observable.just(it)
                }
            }
    }
}