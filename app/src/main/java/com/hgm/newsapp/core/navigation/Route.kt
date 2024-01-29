package com.hgm.newsapp.core.navigation

/**
 * @author：HGM
 * @created：2024/1/29 0029
 * @description：
 **/
sealed class Route(
      val route: String
) {
      object AppStartNavigation : Route(route = "appStartNavigation")
      object NewsNavigation : Route(route = "newsNavigation")

      // ----------------------------------------------------------------------

      object OnBoardingScreen : Route(route = "onBoardingScreen")
      object HomeScreen : Route(route = "homeScreen")
      object SearchScreen : Route(route = "searchScreen")
      object BookmarkScreen : Route(route = "bookmarkScreen")
      object DetailsScreen : Route(route = "detailsScreen")
      object NewsNavigatorScreen : Route(route = "newsNavigatorScreen")

}
