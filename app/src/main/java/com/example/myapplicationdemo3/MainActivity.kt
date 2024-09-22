package com.example.myapplicationdemo3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationdemo3.models.Portfolio
import com.example.myapplicationdemo3.utils.UserAdapter
import org.json.JSONArray

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        enableEdgeToEdge()
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        val button_indces = findViewById<Button>(R.id.button_indces)
        button_indces.setOnClickListener {
            val intent = Intent(this, IndicesActivity::class.java)
            startActivity(intent)
        }

        val button_port = findViewById<Button>(R.id.button_port)
        button_port.setOnClickListener {
            val intent = Intent(this, PortfolioActivity::class.java)
            startActivity(intent)
        }
    }

}
