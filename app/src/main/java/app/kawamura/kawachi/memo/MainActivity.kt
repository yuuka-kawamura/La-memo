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

//reviewed by toppo 🧸: 課題プロダクトいい感じ！いいね！保存しっかりできていて良
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var pref: SharedPreferences// = getSharedPreferences("SharedPref", Context.MODE_PRIVATE)

    //🧸: 空白行が2行以上空かないように気をつけてみよう

    private var data = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(this.root) }
        pref = getSharedPreferences("SharedPref", Context.MODE_PRIVATE)

        /*data = arrayListOf(
             "a", "i"
         )*/
        //🧸: ナイス！Nullを防ぐif文が書けていていいね
        //保存内容が空の時を除く
        if (pref.getString("Key", "")!!.isNotEmpty())
            data = pref.getString("Key", "")?.split(",") as ArrayList<String>


        //🧸: 不要なコードは削除してしまおう！
        //val addtext = intent.getStringExtra("Text")

        // pref.getString("Key", "")?.split(",")?.forEach {  data }
        Log.d("debug", data.toString())
        //🧸: findViewByIdではなくviewBindingを使おう
        val list = findViewById<ListView>(R.id.list_view)
        list.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, data)

        binding.plusButton.setOnClickListener {
            val toMemoActivity = Intent(this, MemoActivity::class.java)

            startActivity(toMemoActivity)
        }
    }

}