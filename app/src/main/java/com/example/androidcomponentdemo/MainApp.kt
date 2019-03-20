package com.example.androidcomponentdemo

import android.app.Application
import com.example.componentlib.AppConfig
import com.example.componentlib.IAppComponent

/**
 * Copyright (c), 2018-2019, CHAINCE
 * @author: lixin
 * Date: 2019/3/20
 * Description:
 */
class MainApp: Application(), IAppComponent {

    override fun onCreate() {
        super.onCreate()
        initialize(this)
    }

    override fun initialize(application: Application) {
        for (component in AppConfig.COMPONENTS) {
            try {
                val clazz = Class.forName(component)
                val `object` = clazz.newInstance()
                if (`object` is IAppComponent) {
                    `object`.initialize(this)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}