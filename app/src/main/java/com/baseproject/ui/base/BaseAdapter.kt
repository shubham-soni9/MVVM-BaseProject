package com.baseproject.ui.base

import androidx.recyclerview.widget.RecyclerView

/**
 * Base structure for defining Adapter
 */
abstract class BaseAdapter<T : RecyclerView.ViewHolder?, D> :
    RecyclerView.Adapter<T>() {
    abstract fun setData(data: List<D>?)
}