package com.example.componentlib.impl

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import com.example.componentlib.service.ILoginService

/**
 * Copyright (c), 2018-2019, CHAINCE
 * @author: lixin
 * Date: 2019/3/20
 * Description:
 */
class EmptyLoginService: ILoginService {
    override fun showUserInfoFragment(fragmentManager: FragmentManager, viewId: Int, bundle: Bundle): Fragment? {
        return null
    }

    override fun launch(context: Context) {

    }
}