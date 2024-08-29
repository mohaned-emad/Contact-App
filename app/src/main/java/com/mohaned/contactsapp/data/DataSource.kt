package com.mohaned.contactsapp.data

import com.mohaned.contactsapp.R
import com.mohaned.contactsapp.model.Contact

class DataSource {
    fun getContacts() : List<Contact> {
        val contacts = mutableListOf<Contact>()

        contacts.add(Contact("Auntie", "+201012345678", R.drawable.auntie))
        contacts.add(Contact("Brother", "+201087654321", R.drawable.brother))
        contacts.add(Contact("Daughter", "+201012345678", R.drawable.daughter))
        contacts.add(Contact("Friend 1", "+201012345678", R.drawable.friend_1))
        contacts.add(Contact("Friend 2", "+201012345678", R.drawable.friend_2))
        contacts.add(Contact("Grandfather", "+201012345678", R.drawable.grandfather))
        contacts.add(Contact("Granny", "+201012345678", R.drawable.granny))
        contacts.add(Contact("Mother", "+201012345678", R.drawable.neigbour))
        contacts.add(Contact("Sister", "+201012345678", R.drawable.sister))
        contacts.add(Contact("Son", "+201012345678", R.drawable.son))
        contacts.add(Contact("Uncle", "+201012345678", R.drawable.uncle))

        return contacts
    }
}