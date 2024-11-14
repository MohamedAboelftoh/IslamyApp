package com.islamy_mohamed.data.data_source.radios

import com.islamy_mohamed.data.model.RadiosItem

interface RadiosDataSource {
    suspend fun getRadios(): List<RadiosItem?>?
}