package com.tim.newsapplication

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.tim.newsapplication.Fragments.AccountFragment
import com.tim.newsapplication.Fragments.HostFragment
import com.tim.newsapplication.Fragments.SavedItemsFragment
import com.tim.newsapplication.Fragments.ThemeSettingsFragment
import com.tim.newsapplication.databinding.ActivityMainBinding

open class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var toggle: ActionBarDrawerToggle
    lateinit var drawerLayout: DrawerLayout

    private val accountFragment = AccountFragment()
    private var themeSettingsFragment = ThemeSettingsFragment(false)
    private val savedItemsFragment = SavedItemsFragment()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setTheme(R.style.LightTheme)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)

        drawerLayout = binding.DrawerLayout
        val navView = binding.navigationView

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        val hostFragment = HostFragment()

        makeCurrentFragment(hostFragment, "Host Fragment")


        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {

            it.isChecked = true

            when (it.itemId) {

                R.id.host_fragment -> makeCurrentFragment(hostFragment, it.title.toString())
                R.id.nav_account -> makeCurrentFragment(accountFragment, it.title.toString())
                R.id.nav_saved_items -> makeCurrentFragment(savedItemsFragment, it.title.toString())
                R.id.nav_theme_settings -> makeCurrentFragment(
                    themeSettingsFragment,
                    it.title.toString()
                )
            }
            true
        }
    }

    private fun makeCurrentFragment(fragment: Fragment, title: String) {

        supportFragmentManager.beginTransaction().apply {

            replace(R.id.FragmentWrapper, fragment)
            commit()
        }
        drawerLayout.closeDrawers()
        setTitle(title)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    @SuppressLint("ResourceAsColor")
    fun setAppTheme(string: String) {

        if (string == "Dark") {
            supportActionBar!!.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.burgundy)))
            themeSettingsFragment = ThemeSettingsFragment(true)
            makeCurrentFragment(themeSettingsFragment, "Theme Settings")
        } else if (string == "Light") {
            supportActionBar!!.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.darkSuede)))
            themeSettingsFragment = ThemeSettingsFragment(false)
            makeCurrentFragment(themeSettingsFragment, "Theme Settings")
        }
    }
}