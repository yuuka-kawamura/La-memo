package app.kawamura.kawachi.memo

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import app.kawamura.kawachi.memo.databinding.ActivityMemoBinding

class MemoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMemoBinding
    private lateinit var pref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMemoBinding.inflate(layoutInflater).apply { setContentView(this.root) }
        val pref: SharedPreferences = getSharedPreferences("SharedPref", Context.MODE_PRIVATE)
       //var data = ArrayList<String>()

       var data= pref.getString("Key","")

        binding.checkButton.setOnClickListener {
            //打った文字をeditTextに代入
            var editText = binding.memoEdittext.text.toString()
            //edittextが空かnullじゃない時
            if (editText.isNullOrEmpty().not()) {
                //dataにedittextを追加
               // data.add(editText)
                data+=editText
            }

            Log.d("debug", data.toString())

            val editor = pref.edit()
            var memoList = ""
            if (data != null) {
                for (word in data) {

                        memoList += "$word,"
                }
            }
            Log.d("debug", memoList)
            editor.putString("Key", memoList)
            editor.apply()

            val toMainActivity = Intent(this, MainActivity::class.java)

            startActivity(toMainActivity)
        }
    }
}