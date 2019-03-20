package com.example.mine

import android.app.Application
import com.example.componentlib.IAppComponent
import com.example.componentlib.ServiceFactory

/**
 * Copyright (c), 2018-2019, CHAINCE
 * @author: lixin
 * Date: 2019/3/20
 * Description:
 */
class MineApp: Application(), IAppComponent {

    override fun onCreate() {
        super.onCreate()
        initialize(this)
    }

    override fun initialize(application: Application) {
        ServiceFactory.getInstance().mMineService = MineService()
    }
}