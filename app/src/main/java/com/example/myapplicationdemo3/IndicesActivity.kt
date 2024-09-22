package com.example.myapplicationdemo3

import android.os.Bundle
import android.widget.GridView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplicationdemo3.models.Indices
import com.example.myapplicationdemo3.models.Portfolio
import com.example.myapplicationdemo3.utils.GridRVAdapter
import org.json.JSONObject

class IndicesActivity : AppCompatActivity() {
    lateinit var courseTime: TextView
    lateinit var courseGRV: GridView
    lateinit var courseList: List<Indices>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_indices)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        courseTime= findViewById(R.id.lastUpdateTime)
        courseGRV = findViewById(R.id.idGRV)
        courseList = ArrayList<Indices>()


        val jsonString = """
  {
    "last_update": "2024-09-18 17:30:04",
    "data": [
      {
        "symbol": "^DJI",
        "short_name": "Dow",
        "price": 41606.18,
        "change": -15.8984,
        "percent_change": -0.0382
      },
      {
        "symbol": "^GSPC",
        "short_name": "S&P 500",
        "price": 5634.58,
        "change": 1.4902,
        "percent_change": 0.0265
      },
      {
        "symbol": "^IXIC",
        "short_name": "Nasdaq",
        "price": 17628.06,
        "change": 35.9336,
        "percent_change": 0.2043
      },
      {
        "symbol": "^N225",
        "short_name": "Nikkei 225",
        "price": 36380.1,
        "change": 176.95,
        "percent_change": 0.49
      },
      {
        "symbol": "000001.SS",
        "short_name": "Shanghai",
        "price": 2717.2813,
        "change": 13.1917,
        "percent_change": 0.49
      },
      {
        "symbol": "^HSI",
        "short_name": "Hang Seng",
        "price": 17660.03,
        "change": 237.91,
        "percent_change": 1.37
      },
      {
        "symbol": "^STI",
        "short_name": "Singapore",
        "price": 3592.42,
        "change": -1,
        "percent_change": -0.0278
      }
    ]
  }
    """.trimIndent()
        val userList = ArrayList<Indices>()
        val jsonObject = JSONObject(jsonString)
        val jsonlast_update = jsonObject.getString("last_update");
        val jsonData = jsonObject.getJSONArray("data");

        courseTime.text = jsonlast_update.toString()
        for (i in 0 until jsonData.length()) {

            userList.add(
                Indices(
                    symbol = jsonData.getJSONObject(i).getString("symbol"),
                    short_name = jsonData.getJSONObject(i).getString("short_name"),
                    price = jsonData.getJSONObject(i).getDouble("price"),
                    change = jsonData.getJSONObject(i).getDouble("change"),
                    percent_change = jsonData.getJSONObject(i).getDouble("percent_change"),

                )
            )
        }
        // on below line we are initializing our course adapter
        // and passing course list and context.
        val courseAdapter = GridRVAdapter(courseList = userList, this@IndicesActivity)

        // on below line we are setting adapter to our grid view.
        courseGRV.adapter = courseAdapter
    }



    override fun onBackPressed() {
        // perform some action
        super.onBackPressed();
    }

}