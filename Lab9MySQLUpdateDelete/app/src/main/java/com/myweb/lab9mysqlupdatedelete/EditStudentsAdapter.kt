package com.myweb.lab9mysqlupdatedelete

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.edit_delete_item_layout.view.*

class EditStudentsAdapter (val item:List<Student>,val context: Context): RecyclerView.Adapter<EditStudentsAdapter.ViewHolder>(){
    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val tvID = view.tvID
        val tvName = view.tvName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewItem = LayoutInflater.from(parent.context).inflate(R.layout.edit_delete_item_layout,parent,false)
        val myHolder = ViewHolder(viewItem)

        viewItem.setOnClickListener(){
            val pos = myHolder.adapterPosition
            val context:Context = parent.context
            val student = item[pos]
            val intent = Intent(context,EditDeleteActivity::class.java)
            intent.putExtra("mId",student.std_id)
            intent.putExtra("mName",student.std_name)
            intent.putExtra("mAge",student.std_age.toString())
            context.startActivity(intent)
        }
        return myHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvID.text = item[position].std_id
        holder.tvName.text = item[position].std_name
    }
    override fun getItemCount(): Int {
        return item.size
    }
}