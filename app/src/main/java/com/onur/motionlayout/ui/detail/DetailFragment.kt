package com.onur.motionlayout.ui.detail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.onur.motionlayout.databinding.FragmentDetailBinding
import com.pluvia.material.chameleoncards.ui.list.ListViewModel

class DetailFragment : Fragment(), MotionLayout.TransitionListener {
    private var _binding: FragmentDetailBinding? = null
    private val vm: ListViewModel by activityViewModels()
    private var flag = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        flag = false
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        _binding!!.detailMotionLayout.addTransitionListener(this)
        vm.setOnEventItemClicked(true)

        requireActivity().onBackPressedDispatcher
            .addCallback(viewLifecycleOwner) {
                _binding!!.detailMotionLayout.transitionToStart()
                _binding!!.constraintLayout2.transitionToStart()
                flag = true
            }
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("motionProgress", _binding!!.detailMotionLayout.progress.toString())
        _binding!!.detailMotionLayout.transitionToEnd()
        _binding!!.constraintLayout2.transitionToEnd()
    }

    override fun onTransitionStarted(motionLayout: MotionLayout?, startId: Int, endId: Int) {
        Log.d("tag","onTransitionStarted")
    }

    override fun onTransitionChange(
        motionLayout: MotionLayout?,
        startId: Int,
        endId: Int,
        progress: Float
    ) {
        Log.d("tag","onTransitionChange")
    }

    override fun onTransitionCompleted(motionLayout: MotionLayout?, currentId: Int) {
        if (flag){
            findNavController().navigateUp()
        }
    }

    override fun onTransitionTrigger(
        motionLayout: MotionLayout?,
        triggerId: Int,
        positive: Boolean,
        progress: Float
    ) {
        Log.d("tag","onTransitionTrigger")
    }
}