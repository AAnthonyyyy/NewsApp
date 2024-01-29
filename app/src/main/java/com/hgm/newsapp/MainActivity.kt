package com.hgm.newsapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.lifecycleScope
import com.hgm.newsapp.domain.use_case.AppEntryUseCase
import com.hgm.newsapp.presentation.onboarding.OnBoardingScreen
import com.hgm.newsapp.presentation.onboarding.OnBoardingViewModel
import com.hgm.newsapp.ui.theme.NewsAppTheme
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

      @Inject
      lateinit var appEntryUseCase: AppEntryUseCase

      override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            // 设置屏幕
            WindowCompat.setDecorFitsSystemWindows(window, false)

            // 安装启动页
            installSplashScreen()

            lifecycleScope.launch {
                  appEntryUseCase.readAppEntry().collect {
                        Log.d("Test", "--------------:$it")
                  }
            }

            setContent {
                  NewsAppTheme {
                        val viewModel: OnBoardingViewModel = hiltViewModel()

                        Surface(
                              modifier = Modifier.fillMaxSize(),
                              color = MaterialTheme.colorScheme.background
                        ) {
                              OnBoardingScreen(viewModel::onEvent)
                        }
                  }
            }
      }
}