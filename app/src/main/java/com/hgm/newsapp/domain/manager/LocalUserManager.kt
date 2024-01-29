package com.hgm.newsapp.domain.manager

import kotlinx.coroutines.flow.Flow


/**
 * @author：HGM
 * @created：2024/1/29 0029
 * @description：
 **/
interface LocalUserManager {

      suspend fun saveAppEntry()

      fun readAppEntry(): Flow<Boolean>
}