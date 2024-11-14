package com.islamy_mohamed.domain.repo

import com.islamy_mohamed.data.model.RadiosItem

interface RadiosRepo {
    suspend fun getRadios(): List<RadiosItem?>?

}