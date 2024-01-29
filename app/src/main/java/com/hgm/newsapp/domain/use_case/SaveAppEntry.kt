package com.hgm.newsapp.domain.use_case

import com.hgm.newsapp.domain.manager.LocalUserManager

/**
 * @author：HGM
 * @created：2024/1/29 0029
 * @description：
 **/
class SaveAppEntry(
      private val localUserManager: LocalUserManager
) {
      suspend operator fun invoke() {
            localUserManager.saveAppEntry()
      }
}