package com.hgm.newsapp.presentation.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.hgm.newsapp.presentation.onboarding.components.OnBoardingPage


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(

) {
      Column(
            modifier = Modifier.fillMaxSize()
      ) {
            // 引导页的状态
            val pageState = rememberPagerState(initialPage = 0) {
                  pages.size
            }

            // 按钮状态
            val buttonState = remember {
                  derivedStateOf {
                        when (pageState.currentPage) {
                              0 -> listOf("", "Next")
                              1 -> listOf("Back", "Next")
                              2 -> listOf("Back", "Get Started")
                              else -> listOf()
                        }
                  }
            }

            HorizontalPager(state = pageState) {index->
                  OnBoardingPage(page = pages[index])
            }
      }
}