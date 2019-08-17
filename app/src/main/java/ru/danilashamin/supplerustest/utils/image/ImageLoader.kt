package ru.danilashamin.supplerustest.utils.image


import android.util.Base64
import com.bumptech.glide.Priority
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.Options
import com.bumptech.glide.load.data.DataFetcher
import com.bumptech.glide.load.model.ModelLoader
import com.bumptech.glide.load.model.ModelLoaderFactory
import com.bumptech.glide.load.model.MultiModelLoaderFactory
import com.bumptech.glide.signature.ObjectKey
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import ru.danilashamin.supplerustest.App
import ru.danilashamin.supplerustest.api.ApiService
import ru.danilashamin.supplerustest.model.Position

import java.nio.ByteBuffer
import javax.inject.Inject

/**
 * Loads image for Position
 */
class ImageLoader : ModelLoader<Position, ByteBuffer> {

    companion object {
        fun factory(): Factory {
            return Factory()
        }
    }

    class Factory : ModelLoaderFactory<Position, ByteBuffer> {

        override fun build(factory: MultiModelLoaderFactory): ModelLoader<Position, ByteBuffer> {
            return ImageLoader()
        }

        override fun teardown() {
        }
    }

    override fun buildLoadData(
        position: Position,
        width: Int,
        height: Int,
        options: Options
    ): ModelLoader.LoadData<ByteBuffer> {
        return ModelLoader.LoadData(ObjectKey(position.positionId), ImageFetcher(position))
    }

    class ImageFetcher(private val position: Position) : DataFetcher<ByteBuffer> {

        @Inject
        lateinit var apiService: ApiService

        init {
            App.instance.appComponent.inject(this)
        }

        private var d: Disposable? = null

        override fun loadData(priority: Priority, callback: DataFetcher.DataCallback<in ByteBuffer>) {
            d = apiService.getImage("0", position.content.imageId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    if (it.errorCode == 1) {
                        callback.onLoadFailed(Exception(it.userErrorInfo))
                    } else {
                        val data = Base64.decode(it.body.imageData, Base64.DEFAULT)
                        val byteBuffer = ByteBuffer.wrap(data)
                        callback.onDataReady(byteBuffer)
                    }
                }, {
                    callback.onLoadFailed(Exception(it))
                })
        }

        override fun cleanup() {

        }

        override fun cancel() {
            if (d?.isDisposed == false) {
                d?.dispose()
            }
        }

        override fun getDataClass(): Class<ByteBuffer> {
            return ByteBuffer::class.java
        }

        override fun getDataSource(): DataSource {
            return DataSource.REMOTE
        }
    }

    override fun handles(position: Position): Boolean {
        return true
    }

}
