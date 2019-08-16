package ru.danilashamin.supplerustest.ui.custom

import android.content.res.Resources
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import ru.danilashamin.supplerustest.App
import ru.danilashamin.supplerustest.R
import javax.inject.Inject

class MarginItemDecoration : RecyclerView.ItemDecoration() {

    @Inject
    lateinit var resources: Resources

    private val margin: Int

    init {
        App.instance.appComponent.inject(this)
        margin = resources.getDimension(R.dimen._16dp).toInt()
    }

    override fun getItemOffsets(
        outRect: Rect, view: View,
        parent: RecyclerView, state: RecyclerView.State
    ) {
        with(outRect) {
            left = margin
            right = margin
            if (parent.getChildAdapterPosition(view) != parent.childCount) {
                bottom = margin
            }
        }
    }
}