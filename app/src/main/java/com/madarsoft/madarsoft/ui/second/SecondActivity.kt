package com.madarsoft.madarsoft.ui.second

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.madarsoft.madarsoft.BaseActivity
import com.madarsoft.madarsoft.R
import com.madarsoft.madarsoft.databinding.ActivitySecondBinding
import org.koin.android.viewmodel.ext.android.viewModel

class SecondActivity(override val layoutId: Int = R.layout.activity_second) :
    BaseActivity<ActivitySecondBinding>() {

    val viewModel: SecondViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.onActivityStarted()
        initObservers()
    }

    private fun initObservers(){
        viewModel.user.observe(this){
            binding.usernameText.text = it.username
            binding.ageText.text = it.age.toString()
            binding.jobText.text = it.job
            binding.genderText.text = it.gender
        }
    }

    companion object {
        fun start(activity: Activity) {
            activity.startActivity(Intent(activity, SecondActivity::class.java))
        }
    }


}