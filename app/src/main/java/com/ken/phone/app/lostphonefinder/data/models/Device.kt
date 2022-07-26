package com.ken.phone.app.lostphonefinder.data.models

import androidx.annotation.Keep
import java.io.Serializable

@Keep
data class Device(
    val deviceNick: String? = "",
    val deviceId: String = "",
    val ownerUuID: String = "",
    val fcmToken: String = ""
): Serializable
