package com.tim.newsapplication.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.tim.newsapplication.MainActivity
import com.tim.newsapplication.R
import com.tim.newsapplication.databinding.FragmentThemeSettingsBinding

class ThemeSettingsFragment : Fragment() {

    lateinit var binding: FragmentThemeSettingsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentThemeSettingsBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.frThemeSettingsAppThemeSwitcher.setOnCheckedChangeListener{
                _, isChecked ->
            if (isChecked){
                (activity as MainActivity).setAppTheme("Dark")
            } else {
                //MainActivity().setAppTheme("Light")
            }
        }
    }
}