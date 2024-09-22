package com.example.myapplicationdemo3.utils

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.myapplicationdemo3.R
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import com.example.myapplicationdemo3.models.Indices


// on below line we are creating an
// adapter class for our grid view.
internal class GridRVAdapter(
    // on below line we are creating two
    // variables for course list and context
    private val courseList: List<Indices>,
    private val context: Context
) :
    BaseAdapter() {
    // in base adapter class we are creating variables
    // for layout inflater, course image view and course text view.
    private var layoutInflater: LayoutInflater? = null
    private lateinit var dowChange: TextView
    private lateinit var dowPercentage: TextView
    private lateinit var dowLabel: TextView
    private lateinit var dowValue: TextView
    private lateinit var llv1: RelativeLayout


    // below method is use to return the count of course list
    override fun getCount(): Int {
        return courseList.size
    }

    // below function is use to return the item of grid view.
    override fun getItem(position: Int): Any? {
        return null
    }

    // below function is use to return item id of grid view.
    override fun getItemId(position: Int): Long {
        return 0
    }

    // in below function we are getting individual item of grid view.
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var convertView = convertView
        // on blow line we are checking if layout inflater
        // is null, if it is null we are initializing it.
        if (layoutInflater == null) {
            layoutInflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        }
        // on the below line we are checking if convert view is null.
        // If it is null we are initializing it.
        if (convertView == null) {
            // on below line we are passing the layout file
            // which we have to inflate for each item of grid view.
            convertView = layoutInflater!!.inflate(R.layout.item_indices, null)
        }

        dowChange = convertView!!.findViewById(R.id.dowChange)
        dowPercentage = convertView!!.findViewById(R.id.dowPercentage)
        dowLabel = convertView!!.findViewById(R.id.dowLabel)
        dowValue = convertView!!.findViewById(R.id.dowValue)
        llv1 = convertView!!.findViewById(R.id.llv1)

        if (courseList.get(position).percent_change > 0) llv1.setBackgroundColor(Color.parseColor("#44FF44")) else
            llv1.setBackgroundColor(Color.parseColor("#c0392b"))


        dowChange.setText(courseList.get(position).change.toString())
        dowPercentage.setText(courseList.get(position).percent_change.toString()+ " %")
        dowLabel.setText(courseList.get(position).short_name)
        dowValue.setText(courseList.get(position).price.toString())

        return convertView
    }
}
