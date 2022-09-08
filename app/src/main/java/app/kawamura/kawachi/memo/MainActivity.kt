package app.kawamura.kawachi.memo

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import app.kawamura.kawachi.memo.databinding.ActivityMainBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var pref: SharedPreferences// = getSharedPreferences("SharedPref", Context.MODE_PRIVATE)


    private var data = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(this.root) }
        pref = getSharedPreferences("SharedPref", Context.MODE_PRIVATE)

        /* data = arrayListOf(
              "a", "i"
          )*/
        // data.isNullOrEmpty().not()= pref.getString("Key","")?.split(",") as ArrayList<String>


        //val addtext = intent.getStringExtra("Text")

        pref.getString("Key", "")?.split(",")?.forEach { data }
        Log.d("debug", data.toString())
        val list = findViewById<ListView>(R.id.list_view)
        list.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, data)

        binding.plusButton.setOnClickListener {
            val toMemoActivity = Intent(this, MemoActivity::class.java)
            startActivity(toMemoActivity)
        }
    }

}