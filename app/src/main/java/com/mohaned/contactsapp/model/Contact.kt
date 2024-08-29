package com.mohaned.contactsapp.model

import androidx.annotation.DrawableRes

data class Contact(
    val name: String,
    val phoneNumber: String,
    @DrawableRes val image: Int
)
