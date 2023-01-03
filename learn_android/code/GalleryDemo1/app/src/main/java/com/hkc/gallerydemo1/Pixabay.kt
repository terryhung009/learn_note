package com.hkc.gallerydemo1

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class Pixabay (
    val total:Int,
    val totalHits:Int,
    val hits:Array<PhotoItem>,

)
@Parcelize data class PhotoItem(
    @SerializedName("webformatURL")val previewURL:String,
    @SerializedName("id")val PhotoId:Int,
    @SerializedName("largeImageURL")val fullURL:String,



    ):Parcelable

