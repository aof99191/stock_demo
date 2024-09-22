package com.example.myapplicationdemo3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationdemo3.models.Portfolio
import com.example.myapplicationdemo3.utils.UserAdapter
import org.json.JSONArray

class PortfolioActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        enableEdgeToEdge()
        setContentView(R.layout.activity_portfolio)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val button_indces = findViewById<ImageButton>(R.id.closeIcon)
        button_indces.setOnClickListener {
            onBackPressed()
        }

        val userList = mutableListOf<Portfolio>()
        val jsonString = """
    [
    {
      "plan_id": "4",
      "title": "Meta",
      "enable": 1,
      "order": 40000,
      "description": "เป็นส่วนหนึ่งของกิจการ Meta",
      "image_plan_bg": "https://storage.radarspoint.com/radars-point-images/plan/background/Head_Meta.jpg",
      "image_plan": "https://storage.radarspoint.com/radars-point-images/plan/Meta.jpg",
      "withdrawable_point": 110.9,
      "pending_point": 0,
      "cost": 47.348,
      "change": 63.55,
      "all": 110.9
    },
    {
      "plan_id": "2",
      "title": "Apple",
      "enable": 1,
      "order": 20000,
      "description": "เป็นส่วนหนึ่งของกิจการ Apple",
      "image_plan_bg": "https://storage.radarspoint.com/radars-point-images/plan/background/Head_Apple.jpg",
      "image_plan": "https://storage.radarspoint.com/radars-point-images/plan/apple.jpg",
      "withdrawable_point": 88.56,
      "pending_point": 0.6000000000000001,
      "cost": 91.172,
      "change": -2.61,
      "all": 89.16
    },
    {
      "plan_id": "27",
      "title": "OR",
      "enable": 1,
      "order": 50000,
      "description": "เป็นส่วนหนึ่งของกิจการ OR",
      "image_plan_bg": "https://storage.radarspoint.com/radars-point-images/plan/background/Head_OR.jpg",
      "image_plan": "https://storage.radarspoint.com/radars-point-images/plan/OR.jpg",
      "withdrawable_point": 9.39,
      "pending_point": 18,
      "cost": 16.35,
      "change": -6.96,
      "all": 27.39
    },
    {
      "plan_id": "6",
      "title": "Netflix",
      "enable": 1,
      "order": 60000,
      "description": "เป็นส่วนหนึ่งของกิจการ Netflix",
      "image_plan_bg": "https://storage.radarspoint.com/radars-point-images/plan/background/Head_Netflix.jpg",
      "image_plan": "https://storage.radarspoint.com/radars-point-images/plan/netflix.jpg",
      "withdrawable_point": 11.4,
      "pending_point": 0,
      "cost": 8.04,
      "change": 3.36,
      "all": 11.4
    },
    {
      "plan_id": "29",
      "title": "TIDLOR",
      "enable": 1,
      "order": 40000,
      "description": "เลือกแผนลงทุนหุ้น TIDLOR",
      "image_plan_bg": "https://storage.radarspoint.com/radars-point-images/plan/background/Head_TIDLOR.jpg",
      "image_plan": "https://storage.radarspoint.com/radars-point-images/plan/TIDLOR.jpg",
      "withdrawable_point": 0.14,
      "pending_point": 0,
      "cost": 0.32,
      "change": -0.18,
      "all": 0.14
    },
    {
      "plan_id": "18",
      "title": "Xiaomi",
      "enable": 1,
      "order": 61000,
      "description": "เป็นส่วนหนึ่งของกิจการ Xiaomi",
      "image_plan_bg": "https://storage.radarspoint.com/radars-point-images/plan/background/Head_Xiaomi.jpg",
      "image_plan": "https://storage.radarspoint.com/radars-point-images/plan/Xiaomi.jpg",
      "withdrawable_point": 0.1,
      "pending_point": 0,
      "cost": 0.13,
      "change": -0.03,
      "all": 0.1
    },
    {
      "plan_id": "33",
      "title": "3.3 Bonus Point",
      "enable": 0,
      "order": 998,
      "description": "รับ Bonus Point เพิ่ม 33 %",
      "image_plan_bg": "https://storage.radarspoint.com/radars-point-images/plan/background/Head_33_BonusPoint.jpg",
      "image_plan": "https://storage.radarspoint.com/radars-point-images/plan/33_BonusPoint.jpg",
      "withdrawable_point": 0.08,
      "pending_point": 0,
      "cost": 0.06,
      "change": 0.02,
      "all": 0.08
    },
    {
      "plan_id": "28",
      "title": "Coinbase",
      "enable": 1,
      "order": 40000,
      "description": "เป็นส่วนหนึ่งของกิจการ Coinbase",
      "image_plan_bg": "https://storage.radarspoint.com/radars-point-images/plan/background/Head_coinbase.jpg",
      "image_plan": "https://storage.radarspoint.com/radars-point-images/plan/coinbase.jpg",
      "withdrawable_point": 0.08,
      "pending_point": 0,
      "cost": 0.06,
      "change": 0.02,
      "all": 0.08
    },
    {
      "plan_id": "12",
      "title": "AOT",
      "enable": 1,
      "order": 120000,
      "description": "เป็นส่วนหนึ่งของกิจการ AOT",
      "image_plan_bg": "https://storage.radarspoint.com/radars-point-images/plan/background/Head_AOT.png",
      "image_plan": "https://storage.radarspoint.com/radars-point-images/plan/AOT.jpg",
      "withdrawable_point": 0.04,
      "pending_point": 0,
      "cost": 0.04,
      "change": 0,
      "all": 0.04
    },
    {
      "plan_id": "21",
      "title": "Alibaba",
      "enable": 1,
      "order": 63000,
      "description": "เป็นส่วนหนึ่งของกิจการ Alibaba",
      "image_plan_bg": "https://storage.radarspoint.com/radars-point-images/plan/background/Head_Alibaba.jpg",
      "image_plan": "https://storage.radarspoint.com/radars-point-images/plan/Alibaba.jpg",
      "withdrawable_point": 0.01,
      "pending_point": 0,
      "cost": 0.03,
      "change": -0.02,
      "all": 0.01
    },
    {
      "plan_id": "20",
      "title": "Ping An",
      "enable": 1,
      "order": 64000,
      "description": "เป็นส่วนหนึ่งของกิจการ Ping An",
      "image_plan_bg": "https://storage.radarspoint.com/radars-point-images/plan/background/Head_PingAn.jpg",
      "image_plan": "https://storage.radarspoint.com/radars-point-images/plan/PingAn.jpg",
      "withdrawable_point": 0.01,
      "pending_point": 0,
      "cost": 0.02,
      "change": -0.01,
      "all": 0.01
    }
  ]
    """.trimIndent()

        val jsonObject = JSONArray(jsonString)
        for (i in 0 until jsonObject.length()) {

//            val respObj = jsonObject.getJSONObject(i)
//            val lngName = respObj.getString("languageName")
//            val lngImg = respObj.getString("languageImg")

            userList.add(
                Portfolio(
                planid = jsonObject.getJSONObject(i).getString("plan_id"),
                title = jsonObject.getJSONObject(i).getString("title"),
                enable = jsonObject.getJSONObject(i).getInt("enable"),
                order = jsonObject.getJSONObject(i).getInt("order"),
                description = jsonObject.getJSONObject(i).getString("description"),
                image_plan_bg = jsonObject.getJSONObject(i).getString("image_plan_bg"),
                image_plan = jsonObject.getJSONObject(i).getString("image_plan"),
                withdrawable_point = jsonObject.getJSONObject(i).getDouble("withdrawable_point"),
                pending_point = jsonObject.getJSONObject(i).getDouble("pending_point"),
                cost = jsonObject.getJSONObject(i).getDouble("cost"),
                change = jsonObject.getJSONObject(i).getDouble("change"),
                all = jsonObject.getJSONObject(i).getDouble("all")
            )
            )
        }
        showUserList(userList)
    }
    override fun onBackPressed() {
        // perform some action
        super.onBackPressed();
    }
    private fun showUserList(userList: List<Portfolio>) {
        // Use the userList to populate the RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = UserAdapter(userList)
    }
}