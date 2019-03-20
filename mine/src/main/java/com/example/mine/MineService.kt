package com.example.mine

import android.content.Context
import android.content.Intent
import com.example.componentlib.service.IMineService

/**
 * Copyright (c), 2018-2019, CHAINCE
 * @author: lixin
 * Date: 2019/3/20
 * Description:
 */
class MineService: IMineService {
    override fun launch(context: Context, userId: Int) {
        val intent = Intent(context, MineActivity::class.java)
        intent.putExtra("id", userId)
        context.startActivity(intent)

    }
}