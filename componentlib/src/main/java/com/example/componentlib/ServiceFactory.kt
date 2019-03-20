package com.example.componentlib

import com.example.componentlib.impl.EmptyLoginService
import com.example.componentlib.impl.EmptyMineService
import com.example.componentlib.service.ILoginService
import com.example.componentlib.service.IMineService

/**
 * Copyright (c), 2018-2019, CHAINCE
 * @author: lixin
 * Date: 2019/3/20
 * Description:
 */
class ServiceFactory private constructor(){

    companion object {
        private var ourInstance: ServiceFactory? = null
            get() {
                if (field == null) {
                    field = ServiceFactory()
                }
                return field
            }
        fun getInstance(): ServiceFactory {
            return ourInstance!!
        }
    }

    var mLoginService: ILoginService? = null
        get() {
            if (field == null) {
                field = EmptyLoginService()
            }
            return field
        }
    var mMineService: IMineService? = null
        get() {
            if (field == null) {
                field = EmptyMineService()
            }
            return field
        }

}