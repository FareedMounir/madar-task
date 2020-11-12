package com.madarsoft.madarsoft.ui.splash

import android.os.Bundle
import com.madarsoft.madarsoft.BaseActivity
import com.madarsoft.madarsoft.R
import com.madarsoft.madarsoft.databinding.ActivitySplashBinding
import com.madarsoft.madarsoft.ui.first.FirstActivity

class SplashActivity(override val layoutId: Int = R.layout.activity_splash) :
    BaseActivity<ActivitySplashBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        FirstActivity.start(this)
    }

}