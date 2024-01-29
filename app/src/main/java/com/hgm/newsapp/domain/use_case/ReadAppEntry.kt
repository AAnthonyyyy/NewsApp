package com.hgm.newsapp.domain.use_case

import com.hgm.newsapp.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

/**
 * @author：HGM
 * @created：2024/1/29 0029
 * @description：
 **/
class ReadAppEntry(
      private val localUserManager: LocalUserManager
) {
       operator fun invoke(): Flow<Boolean> {
            return localUserManager.readAppEntry()
      }
}