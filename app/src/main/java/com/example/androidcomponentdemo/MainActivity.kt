package com.example.androidcomponentdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.componentlib.ServiceFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loginBtn.setOnClickListener {
            ServiceFactory.getInstance().mLoginService?.launch(this)
        }

        mineBtn.setOnClickListener {
            ServiceFactory.getInstance().mMineService?.launch(this, 1)
        }

        fragmentBtn.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("des", "描述内容")
            ServiceFactory.getInstance().mLoginService?.showUserInfoFragment(supportFragmentManager, R.id.container, bundle)
        }
    }
}
