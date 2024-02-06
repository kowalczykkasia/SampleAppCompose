package com.kasia.sample.app.storage.models

import com.google.gson.annotations.SerializedName

data class Media(
    @SerializedName("m") val url: String
)