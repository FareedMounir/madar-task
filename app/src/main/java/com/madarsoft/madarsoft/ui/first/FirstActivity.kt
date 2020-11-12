package com.madarsoft.madarsoft.ui.first

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.madarsoft.madarsoft.BaseActivity
import com.madarsoft.madarsoft.R
import com.madarsoft.madarsoft.databinding.ActivityFirstBinding
import com.madarsoft.madarsoft.ui.second.SecondActivity
import com.madarsoft.madarsoft.utils.handleTextChange
import org.koin.android.viewmodel.ext.android.viewModel

class FirstActivity(override val layoutId: Int = R.layout.activity_first) :
    BaseActivity<ActivityFirstBinding>() {

    private val viewModel: FirstViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initListeners()
        initObservers()
    }

    private fun initListeners() {
        binding.usernameEdit.handleTextChange {
            val username = it.toString().trim()
            viewModel.setUsername(username)
        }

        binding.ageEdit.handleTextChange {
            val age = it.toString().trim()
            viewModel.setAge(age)
        }

        binding.jobEdit.handleTextChange {
            val jopTitle = it.toString().trim()
            viewModel.setJobTitle(jopTitle)
        }

        binding.genderGroup.setOnCheckedChangeListener { _, checkedId ->
            val gender = if (checkedId == R.id.male_radio) {
                "Male"
            } else {
                "Female"
            }

            viewModel.setGender(gender)
        }

        binding.submitButton.setOnClickListener {
            viewModel.onSubmitButtonClicked()
        }
    }

    private fun initObservers() {
        viewModel.openSecond.observe(this) {
            SecondActivity.start(this)
        }

        viewModel.submitButtonEnabled.observe(this) {
            binding.submitButton.isEnabled = it
        }

        viewModel.ageError.observe(this){
            binding.ageInput.error = getString(R.string.age_not_valid)
        }
    }

    companion object {
        fun start(activity: Activity) {
            activity.startActivity(Intent(activity, FirstActivity::class.java))
        }
    }

}