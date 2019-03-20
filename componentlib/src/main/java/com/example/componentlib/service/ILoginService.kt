package com.example.componentlib.service

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager

/**
 * Copyright (c), 2018-2019, CHAINCE
 * @author: lixin
 * Date: 2019/3/20
 * Description:
 */
interface ILoginService {
    fun launch(context: Context)
    fun showUserInfoFragment(fragmentManager: FragmentManager, viewId: Int, bundle: Bundle) : Fragment?
}