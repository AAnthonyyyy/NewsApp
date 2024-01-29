package com.hgm.newsapp.core.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.hgm.newsapp.presentation.onboarding.OnBoardingScreen
import com.hgm.newsapp.presentation.onboarding.OnBoardingViewModel

/**
 * @author：HGM
 * @created：2024/1/29 0029
 * @description：
 **/
@Composable
fun NavGraph(
      startDestination: String
) {
      val navController = rememberNavController()

      NavHost(navController = navController, startDestination = startDestination) {
            navigation(
                  route = Route.AppStartNavigation.route,
                  startDestination = Route.OnBoardingScreen.route
            ) {
                  composable(route = Route.OnBoardingScreen.route) {
                        val viewModel: OnBoardingViewModel = hiltViewModel()
                        OnBoardingScreen(onEvent = viewModel::onEvent)
                  }
            }

            navigation(
                  route = Route.NewsNavigation.route,
                  startDestination = Route.NewsNavigatorScreen.route
            ) {
                  composable(route = Route.NewsNavigatorScreen.route){
                        //NewsNavigator()
                  }
            }
      }
}