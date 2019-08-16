package ru.danilashamin.supplerustest.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.danilashamin.supplerustest.App
import ru.danilashamin.supplerustest.R
import ru.danilashamin.supplerustest.api.Api
import ru.danilashamin.supplerustest.api.keys.GetPositionsRequestKeys
import ru.danilashamin.supplerustest.api.keys.ProjectIDByCityRequestKeys
import ru.danilashamin.supplerustest.api.request.Request
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var api: Api

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        App.instance.appComponent.inject(this)

        val d = api.getProjectIDByCity(Request(ProjectIDByCityRequestKeys("SPB")))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .flatMap {
                api.getPositions(Request(GetPositionsRequestKeys(it.body[0].projectId)))
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
            }
            .flatMap {
                api.getImage(Request("1", it.body[0].content.imageId))
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
            }
            .subscribe({ response ->
                response.body
            }, { error ->
                error.printStackTrace()
            })
    }
}
