package com.hgm.newsapp.di

import android.app.Application
import androidx.room.Insert
import com.hgm.newsapp.data.manager.LocalUserManagerImpl
import com.hgm.newsapp.domain.manager.LocalUserManager
import com.hgm.newsapp.domain.use_case.AppEntryUseCase
import com.hgm.newsapp.domain.use_case.ReadAppEntry
import com.hgm.newsapp.domain.use_case.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @author：HGM
 * @created：2024/1/29 0029
 * @description：
 **/
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

      @Provides
      @Singleton
      fun provideLocalUserManager(application: Application): LocalUserManager =
            LocalUserManagerImpl(application)


      @Provides
      @Singleton
      fun provideAppEntryUseCase(localUserManager: LocalUserManager): AppEntryUseCase = AppEntryUseCase(
            saveAppEntry = SaveAppEntry(localUserManager),
            readAppEntry = ReadAppEntry(localUserManager)
      )
}