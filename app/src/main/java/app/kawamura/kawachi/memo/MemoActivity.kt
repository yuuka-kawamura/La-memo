package app.kawamura.kawachi.memo

import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import app.kawamura.kawachi.memo.databinding.ActivityMemoBinding

class MemoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMemoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMemoBinding.inflate(layoutInflater).apply { setContentView(this.root) }

        var editText=binding.memoEdittext.text.toString()

        binding.checkButton.setOnClickListener {

            val toMainActivity = Intent(this, MainActivity::class.java)
            toMainActivity.putExtra("Text", editText)

            startActivity(toMainActivity)
        }
    }
}