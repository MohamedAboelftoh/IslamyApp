package com.islamy_mohamed.data.repo.radios

import com.islamy_mohamed.data.data_source.radios.RadiosDataSource
import com.islamy_mohamed.data.model.RadiosItem
import com.islamy_mohamed.domain.repo.RadiosRepo
import javax.inject.Inject

class RadiosRepoImpl @Inject constructor(
    private val radiosDataSource: RadiosDataSource
) : RadiosRepo {
    override suspend fun getRadios(): List<RadiosItem?>? {
        return radiosDataSource.getRadios()
    }
}