package com.example.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.util.Log
import com.example.componentlib.service.ILoginService

/**
 * Copyright (c), 2018-2019, CHAINCE
 * @author: lixin
 * Date: 2019/3/20
 * Description:
 */
class LoginService: ILoginService {

    override fun launch(context: Context) {
        val intent = Intent(context, LoginActivity::class.java)
        context.startActivity(intent)
    }

    override fun showUserInfoFragment(fragmentManager: FragmentManager, viewId: Int, bundle: Bundle): Fragment? {
        val fragment = UserInfoFragment()
        fragment.arguments = bundle
        fragmentManager.beginTransaction().add(viewId, fragment).commit()
        return fragment
    }
}