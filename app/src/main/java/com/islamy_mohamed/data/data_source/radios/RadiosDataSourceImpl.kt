package com.islamy_mohamed.data.data_source.radios

import com.islamy_mohamed.data.api.WebService
import com.islamy_mohamed.data.model.RadiosItem
import javax.inject.Inject

class RadiosDataSourceImpl @Inject constructor(
    private val webService: WebService
) : RadiosDataSource {
    override suspend fun getRadios(): List<RadiosItem?>? {
        return webService.getRadio().radios
    }
}