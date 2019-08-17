package ru.danilashamin.supplerustest.utils

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.Registry
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule
import ru.danilashamin.supplerustest.model.Position
import ru.danilashamin.supplerustest.utils.image.ImageLoader
import java.nio.ByteBuffer

@GlideModule
class MyAppGlideModule : AppGlideModule() {
    override fun registerComponents(context: Context, glide: Glide, registry: Registry) {
        registry.append(Position::class.java, ByteBuffer::class.java, ImageLoader.factory())
    }
}