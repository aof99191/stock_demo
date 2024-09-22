package com.example.myapplicationdemo3.utils

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplicationdemo3.R
import com.example.myapplicationdemo3.models.Portfolio

class UserAdapter(private val userList: List<Portfolio>) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_portfolio, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserAdapter.UserViewHolder, position: Int) {
        val user = userList[position]
        holder.bind(user)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        private val logoImgView : ImageView =itemView.findViewById(R.id.stockLogo)
        private val stockNameTextView : TextView =itemView.findViewById(R.id.stockName)
        private val investmentStatusTextView : TextView =itemView.findViewById(R.id.investmentStatus)
        private val stockValueTextView : TextView =itemView.findViewById(R.id.stockValue)
        private val stockChangeTextView : TextView =itemView.findViewById(R.id.stockChange)
//        private val stockPointTextView : TextView =itemView.findViewById(R.id.stockPoint)


        fun bind(user: Portfolio)
        {
            Glide.with(itemView.context).load(user.image_plan).centerCrop().into(logoImgView)
            stockNameTextView.text = user.title
            investmentStatusTextView.text = user.description
            stockValueTextView.text = user.all.toString()
            stockChangeTextView.text = " ( "+ user.change.toString() +" ) "
           if (user.change > 0) stockChangeTextView.setTextColor(Color.parseColor("#44FF44")) else
               stockChangeTextView.setTextColor(Color.parseColor("#c0392b"))
//            stockPointTextView.text = user.pending_point.toString()



        }

    }

}