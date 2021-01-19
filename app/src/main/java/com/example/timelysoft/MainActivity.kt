package com.example.timelysoft

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import com.example.timelysoft.androidui.WordsViewModel
import com.example.timelysoft.databinding.ActivityMainBinding
import com.example.timelysoft.domain.MainUseCase
import com.example.timelysoft.util.ExtraParamsViewModelFactory
import com.example.timelysoft.util.ServiceLocator
import com.example.timelysoft.util.ServiceLocator.getWordsPresenter
import com.example.timelysoft.util.ServiceLocator.getWordsPresenterLiveData
import com.example.timelysoft.util.ServiceLocator.getWordsRepository

class MainActivity : AppCompatActivity() {
    val viewModel: WordsViewModel by viewModels() {
        ExtraParamsViewModelFactory(
            MainUseCase(getWordsRepository(), getWordsPresenter()),
            getWordsPresenterLiveData()
        )
    }
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}