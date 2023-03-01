package com.tim.newsapplication.Fragments

import android.annotation.SuppressLint
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tim.newsapplication.MainActivity
import com.tim.newsapplication.R
import com.tim.newsapplication.databinding.FragmentThemeSettingsBinding

class ThemeSettingsFragment(val switcherPosition: Boolean) : Fragment() {

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

    @SuppressLint("ResourceAsColor")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.frThemeSettingsAppThemeSwitcher.isChecked = switcherPosition

        binding.frThemeSettingsAppThemeSwitcher.setOnCheckedChangeListener{
                _, isChecked ->
            context?.theme?.applyStyle(R.style.DarkTheme, true)
            if (isChecked){
                context?.theme?.applyStyle(R.style.DarkTheme, true).apply {  }
                (activity as MainActivity).window.statusBarColor = this.resources.getColor(R.color.black)
                (activity as MainActivity).setAppTheme("Dark")
                savedInstanceState?.putBoolean("SwitcherPosition", false)
            } else {
                context?.theme?.applyStyle(R.style.LightTheme, true).apply {  }
                (activity as MainActivity).window.statusBarColor = this.resources.getColor(R.color.suede)
                (activity as MainActivity).setAppTheme("Light")
                savedInstanceState?.putBoolean("SwitcherPosition", true)
            }
        }
    }
}