package app.kawamura.kawachi.memo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.kawamura.kawachi.memo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater).apply { setContentView(this.root) }

    var data=
    }
}