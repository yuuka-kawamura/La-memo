package app.kawamura.kawachi.memo

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import app.kawamura.kawachi.memo.databinding.ActivityMainBinding
import java.lang.reflect.Array.set

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val pref: SharedPreferences = getSharedPreferences("SharedPref", Context.MODE_PRIVATE)

    //private lateinit var data:list
    var data = listOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(this.root) }


        data = arrayListOf(
            "a", "i"
        )

       memodata=pref.getStringSet("Key",null)
        if(memodata!==null)
            data.add(memodata)
        val list = findViewById<ListView>(R.id.list_view)
        list.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, data)
        var addtext = intent.getStringExtra("Text")
        if (addtext !== null)
            data.add(addtext.toString())

        binding.plusButton.setOnClickListener {
            val toMemoActivity = Intent(this, MemoActivity::class.java)
            startActivity(toMemoActivity)
        }
    }

    override fun onStop() {
        super.onStop()
        val editor = pref.edit()
        editor.putStringSet("Key", data)
        editor.apply()
    }
}