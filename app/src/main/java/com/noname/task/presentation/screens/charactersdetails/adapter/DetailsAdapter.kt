package com.noname.task.presentation.screens.charactersdetails.adapter

import android.content.Context
import android.support.v4.app.FragmentActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.noname.task.R
import com.noname.task.model.entities.ComicsResult
import com.noname.task.model.usecases.loudImage
import kotlinx.android.synthetic.main.detail_item.view.*
import kotlinx.android.synthetic.main.detail_item.view.name

class DetailsAdapter(
    activity: FragmentActivity,
    comics: ArrayList<ComicsResult>?
) :
    RecyclerView.Adapter<DetailsAdapter.CustomView>() {

    private val context: Context = activity.baseContext
    private val comicsData: List<ComicsResult> = comics!!
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomView {

        return CustomView(LayoutInflater.from(context).inflate(R.layout.detail_item, parent, false))
    }

    override fun onBindViewHolder(holder: CustomView, position: Int) {

        holder.name.text = comicsData.get(position).title
        loudImage(context,holder.img,comicsData.get(position).thumbnail.path+"."+comicsData.get(position).thumbnail.extension)

    }

    override fun getItemCount(): Int {
        return comicsData.size
    }

    inner class CustomView(val mView: View) : RecyclerView.ViewHolder(mView) {

        val itemVieww: View = mView
        val name = mView.name
        val img = mView.item_img
    }

}
