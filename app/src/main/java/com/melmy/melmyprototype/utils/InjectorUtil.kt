package com.melmy.melmyprototype.utils

import android.content.Context
import com.melmy.melmyprototype.data.AppDatabase
import com.melmy.melmyprototype.data.MissionRepository
import com.melmy.melmyprototype.viewmodel.HomeViewModelFactory
import com.melmy.melmyprototype.viewmodel.MissionListViewModelFactory

object InjectorUtil {

    private fun getMissionRepository(context: Context) =
            MissionRepository.getInstance(
                    AppDatabase.getInstance(context).missionDao(),
                    AppDatabase.getInstance(context).dailyMissionDao()
            )

    fun provideMissionListViewModelFactory(
            context: Context
    ): MissionListViewModelFactory {
        val missionRepository = getMissionRepository(context)
        return MissionListViewModelFactory(missionRepository)
    }

    fun provideHomeViewModelFactory(
            context: Context
    ): HomeViewModelFactory {
        val missionRepository = getMissionRepository(context)
        return HomeViewModelFactory(missionRepository)
    }
}