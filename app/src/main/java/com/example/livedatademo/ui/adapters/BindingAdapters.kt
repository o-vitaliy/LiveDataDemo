package com.example.livedatademo.ui.adapters

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import com.xwray.groupie.databinding.BindableItem

@BindingAdapter("isGone")
fun bindIsGone(view: View, isGone: Boolean) {
    view.visibility = if (isGone) {
        View.GONE
    } else {
        View.VISIBLE
    }
}

@BindingAdapter("rc_items")
fun bindItems(recyclerView: RecyclerView, items: List<BindableItem<*>>?) {
    val adapter = recyclerView.adapter as? GroupAdapter<ViewHolder>
            ?: GroupAdapter<ViewHolder>().apply {
                recyclerView.adapter = this
            }
    items?.let {
        adapter.update(it)
    }
}