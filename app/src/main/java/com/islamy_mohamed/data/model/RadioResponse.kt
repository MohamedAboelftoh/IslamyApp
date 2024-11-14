package com.islamy_mohamed.data.model

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
data class RadioResponse(

	@field:SerializedName("radios")
	val radios: List<RadiosItem?>? = null
) : Parcelable