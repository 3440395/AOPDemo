package com.xk.aopdemo;

import com.antfortune.freeline.FreelineCore;

/**
 * Created by xuekai on 2017/6/28.
 */

public class Application extends android.app.Application {
    @Override
    public void onCreate() {
        FreelineCore.init(this);
        super.onCreate();
    }
}
