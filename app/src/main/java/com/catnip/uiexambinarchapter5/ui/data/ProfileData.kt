package com.catnip.uiexambinarchapter5.ui.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProfileData(
    var name : String,
    var imageURL : String,
    var profession: String,
    var address : String
) : Parcelable
