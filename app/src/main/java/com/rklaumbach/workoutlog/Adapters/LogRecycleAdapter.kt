package com.rklaumbach.workoutlog.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.rklaumbach.workoutlog.Model.LogEntry

class LogRecycleAdapter(val context: Context, val entries :List<LogEntry>) : RecyclerView.Adapter<LogRecycleAdapter.Holder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Holder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(p0: Holder, p1: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {



    }

}