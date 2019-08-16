package ru.danilashamin.supplerustest.api

import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST
import ru.danilashamin.supplerustest.api.keys.GetPositionsRequestKeys
import ru.danilashamin.supplerustest.api.keys.ProjectIDByCityRequestKeys
import ru.danilashamin.supplerustest.api.request.Request
import ru.danilashamin.supplerustest.api.response.Response
import ru.danilashamin.supplerustest.model.ImageInfo
import ru.danilashamin.supplerustest.model.PositionInfo
import ru.danilashamin.supplerustest.model.ProjectInfo

interface Api {
    @POST("GetProjectIDbyCity")
    fun getProjectIDByCity(@Body projectIDByCityRequest: Request<ProjectIDByCityRequestKeys>): Observable<Response<List<ProjectInfo>>>

    @POST("GetPositions")
    fun getPositions(@Body getPositionsRequest: Request<GetPositionsRequestKeys>): Observable<Response<List<PositionInfo>>>

    @POST("GetImage")
    fun getImage(@Body getImageRequest: Request<String>): Observable<Response<ImageInfo>>
}