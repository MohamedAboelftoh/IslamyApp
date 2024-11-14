package com.islamy_mohamed.data.data_source.radios

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class Di {
    @Binds
    abstract fun provideRadiosDataSource(
        radiosDataSourceImpl: RadiosDataSourceImpl
    ):RadiosDataSource
}