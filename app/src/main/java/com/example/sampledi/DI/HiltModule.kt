package com.example.sampledi.DI

import com.example.sampledi.Dummy.Car
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object HiltModule {

    @Provides
    fun provideCar():Car{
        return Car()
    }

}