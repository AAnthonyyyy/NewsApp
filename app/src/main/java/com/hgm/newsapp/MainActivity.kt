package com.hgm.newsapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.lifecycleScope
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.hgm.newsapp.core.navigation.NavGraph
import com.hgm.newsapp.domain.use_case.AppEntryUseCase
import com.hgm.newsapp.presentation.onboarding.OnBoardingScreen
import com.hgm.newsapp.presentation.onboarding.OnBoardingViewModel
import com.hgm.newsapp.core.ui.theme.NewsAppTheme
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

      val viewModel by viewModels<MainViewModel>()

      override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            // 设置屏幕
            WindowCompat.setDecorFitsSystemWindows(window, false)
            // 安装启动页
            installSplashScreen().apply {
                  viewModel.splashCondition
            }
            setContent {
                  NewsAppTheme {
                        val isDarkTheme = isSystemInDarkTheme()
                        val systemController = rememberSystemUiController()

                        SideEffect {
                              systemController.setSystemBarsColor(
                                    color = Color.Transparent,
                                    darkIcons =!isDarkTheme
                              )
                        }

                        Surface(
                              modifier = Modifier.fillMaxSize(),
                              color = MaterialTheme.colorScheme.background
                        ) {
                              NavGraph(startDestination = viewModel.startDestination)
                        }
                  }
            }
      }
}