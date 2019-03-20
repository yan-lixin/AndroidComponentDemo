package com.example.componentlib

import android.app.Application

/**
 * Copyright (c), 2018-2019, CHAINCE
 * @author: lixin
 * Date: 2019/3/20
 * Description:
 */
interface IAppComponent {
    fun initialize(application: Application)
}