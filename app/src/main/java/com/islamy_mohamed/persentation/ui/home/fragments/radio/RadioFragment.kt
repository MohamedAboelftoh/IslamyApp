package com.islamy_mohamed.persentation.ui.home.fragments.radio

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.islamy_mohamed.databinding.FragmentRadioBinding
import com.islamy_mohamed.data.model.RadiosItem
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RadioFragment : Fragment() {
    private var _viewBinding: FragmentRadioBinding? = null
    private val viewBinding get() = _viewBinding!!
    private val radioViewModel: RadioViewModel by viewModels()
    private var radios: List<RadiosItem?>? = null
    private lateinit var intentService: Intent
    private var currentlyPlaying = false
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentRadioBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        intentService = Intent(requireContext(), RadioService::class.java)

        togglePlayingVisibility(false)

        radioViewModel.getRadios()

        subscribeToLiveData()

        viewBinding.start.setOnClickListener {
            requireActivity().startForegroundService(intentService)
//            if(!radios.isNullOrEmpty()) {
//                if (currentlyPlaying) requireActivity().stopService(intentService)
//                else requireActivity().startForegroundService(intentService)
//                currentlyPlaying = !currentlyPlaying
//            }
        }
        viewBinding.pause.setOnClickListener {
            requireActivity().stopService(intentService)
        }
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _viewBinding = null
    }
    private fun togglePlayingVisibility(playing: Boolean) {
        viewBinding.start.isVisible = playing
        viewBinding.pause.isVisible = playing
        viewBinding.loadingProgressbar.isVisible = !playing
    }
    private fun subscribeToLiveData() {
        radioViewModel.radios.observe(viewLifecycleOwner) {
            radios = it
            if(!radios.isNullOrEmpty()){
                Toast.makeText(requireContext(), "Radios Loaded", Toast.LENGTH_LONG).show()
                togglePlayingVisibility(true)
            }
        }
        radioViewModel.errorMessages.observe(viewLifecycleOwner) { error ->
            if (error.isNotEmpty()) {
                Toast.makeText(requireContext(), error, Toast.LENGTH_LONG).show()
                togglePlayingVisibility(true)
            }
        }
    }
}