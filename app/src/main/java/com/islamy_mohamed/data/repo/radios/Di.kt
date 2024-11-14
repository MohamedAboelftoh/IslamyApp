package com.islamy_mohamed.data.repo.radios

import com.islamy_mohamed.domain.repo.RadiosRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class Di {
    @Binds
    abstract fun provideRadiosDataSource(
        radiosRepoImpl: RadiosRepoImpl
    ): RadiosRepo
}