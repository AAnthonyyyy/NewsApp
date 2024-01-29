package com.hgm.newsapp.presentation.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hgm.newsapp.domain.use_case.AppEntryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author：HGM
 * @created：2024/1/29 0029
 * @description：
 **/
@HiltViewModel
class OnBoardingViewModel @Inject constructor(
      private val appEntryUseCase: AppEntryUseCase
) : ViewModel() {

      fun onEvent(event:OnBoardingEvent){
            when (event) {
                  OnBoardingEvent.SaveAppEntry -> {
                        saveAppEntry()
                  }
            }
      }

      private fun saveAppEntry() {
            viewModelScope.launch {
                  appEntryUseCase.saveAppEntry()
            }
      }

}