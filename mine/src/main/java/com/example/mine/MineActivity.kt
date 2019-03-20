package com.example.mine

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_mine.*

class MineActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mine)

        var userId: Int? = intent.getIntExtra("id", 0)

        desTextView.text = "MineActivity id为: $userId"
    }
}
