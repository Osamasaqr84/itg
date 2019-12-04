package com.noname.task.presentation.screens.charactersfragment

import android.content.Context
import android.support.v4.app.FragmentActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.noname.task.R
import com.noname.task.model.entities.character
import com.noname.task.model.usecases.loudImage
import kotlinx.android.synthetic.main.charcter_item.view.*

class CharcterAdapter(
    activity: FragmentActivity,
    characters: java.util.ArrayList<character>,
    charactersFragment1: CharactersFragment
) : RecyclerView.Adapter<CharcterAdapter.CustomView>() {

    private val context: Context = activity
    private var charchterData: ArrayList<character> = characters
    private val charactersFragment: CharactersFragment = charactersFragment1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomView {

        return CustomView(LayoutInflater.from(context).inflate(R.layout.charcter_item, parent, false))
    }

    override fun onBindViewHolder(holder: CustomView, position: Int) {

        holder.name.text = charchterData.get(position).name
        loudImage(context,holder.charchter_img,charchterData.get(position).thumbnail.path+"."+
                charchterData.get(position).thumbnail.extension)
//        holder.website.text = charchterData.get(position).website
//        holder.name.text = charchterData.get(position).name
//        holder.venue.text = charchterData.get(position).venue
        var listString = ""

        holder.mView.setOnClickListener(View.OnClickListener {
            charactersFragment.onItemClick(charchterData.get(position).id)
        })
    }

    override fun getItemCount(): Int {
        return charchterData.size
    }

    class CustomView(val mView: View) : RecyclerView.ViewHolder(mView) {
        val name = mView.name
        val charchter_img = mView.charchter_img

    }

}
