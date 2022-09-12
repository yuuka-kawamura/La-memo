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

//reviewed by toppo 🧸: メモの保存画面も良い感じだね！配列周りのところだけもうちょっとトライしてみよう
class MemoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMemoBinding
    //🧸: 必要ない変数は削除しよう
    private lateinit var pref: SharedPreferences
    private var data = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMemoBinding.inflate(layoutInflater).apply { setContentView(this.root) }
        val pref: SharedPreferences = getSharedPreferences("SharedPref", Context.MODE_PRIVATE)

        if (pref.getString("Key", "")!!.isNotEmpty())
            data = pref.getString("Key", "")?.split(",") as ArrayList<String>

        binding.checkButton.setOnClickListener {
            //🧸:ここはvalで良さそう！
            //打った文字をeditTextに代入
            var editText = binding.memoEdittext.text.toString()
            //edittextが空かnullじゃない時
            //🧸: 配列の作成は完璧！
            if (editText.isNullOrEmpty().not()) {
                //dataにedittextを追加
                data += editText
            }

            Log.d("debug", data.toString())

            val editor = pref.edit()
            var memoList = ""
            //🧸: 文字列にするところで","を入れているせいで空白の要素が入ってしまっているね>< memoList = data.toString()で良いかも！
            //配列を文字列にしてデータ保存
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