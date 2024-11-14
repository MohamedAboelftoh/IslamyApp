package com.islamy_mohamed.domain.useCase

import com.islamy_mohamed.data.model.RadiosItem
import com.islamy_mohamed.domain.repo.RadiosRepo
import javax.inject.Inject

class RadiosUseCase @Inject constructor (
    private val radiosRepo: RadiosRepo
){
    suspend fun execute(): List<RadiosItem?>?{
        return radiosRepo.getRadios()
    }
}