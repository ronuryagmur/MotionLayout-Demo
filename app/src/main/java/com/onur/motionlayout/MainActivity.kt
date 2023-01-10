package com.onur.motionlayout

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.onur.motionlayout.databinding.ActivityMainBinding
import com.pluvia.material.chameleoncards.ui.list.ListViewModel

class MainActivity : AppCompatActivity() {
    private val vm: ListViewModel by viewModels()
    private var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        vm.onEventItemClicked.observe(this, Observer {
            if (it){
                binding!!.clMain.transitionToEnd()
            } else {
                binding!!.clMain.transitionToStart()
            }
        })
    }

    override fun onBackPressed() {
        if (binding != null){
            binding!!.clMain.transitionToStart()
        }
        return super.onBackPressed()
    }
}