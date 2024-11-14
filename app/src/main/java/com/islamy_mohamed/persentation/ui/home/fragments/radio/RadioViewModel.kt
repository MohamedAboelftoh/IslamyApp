package com.islamy_mohamed.persentation.ui.home.fragments.radio

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.islamy_mohamed.data.model.RadiosItem
import com.islamy_mohamed.domain.useCase.RadiosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.util.concurrent.TimeoutException
import javax.inject.Inject
@HiltViewModel
class RadioViewModel @Inject constructor(
    private val radiosUseCase: RadiosUseCase
) : ViewModel() {
    var radios = MutableLiveData<List<RadiosItem?>?>(listOf())
    var errorMessages = MutableLiveData("")
    fun getRadios(){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                radios.postValue(radiosUseCase.execute())
            }catch (e : TimeoutException){
                errorMessages.postValue("Time Out Error")
            }
            catch (e : HttpException){
                errorMessages.postValue("http Error")
            }catch (e : Exception){
                errorMessages.postValue(e.localizedMessage)
            }
        }
    }
}