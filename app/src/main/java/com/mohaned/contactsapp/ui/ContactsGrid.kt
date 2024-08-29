package com.mohaned.contactsapp.ui

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mohaned.contactsapp.data.DataSource
import com.mohaned.contactsapp.model.Contact

@Composable
fun ContactsGrid(contacts : List<Contact>, modifier: Modifier = Modifier) {
    var configuration = LocalConfiguration.current

    val columns = when(configuration.orientation){
        Configuration.ORIENTATION_LANDSCAPE -> 5
        else -> 3
    }

    LazyVerticalGrid(
        columns = GridCells.Fixed(columns),
        //contentPadding = PaddingValues(2.dp),
        modifier = modifier
            //.padding(top = 8.dp)
            .wrapContentSize()
    ) {
        items(contacts) { contact ->
            ContactItem(contact)
        }
    }
}

@Preview(showSystemUi = false, showBackground = true)
@Composable
private fun ContactsGridPreview() {
    val contacts = DataSource().getContacts()
    ContactsGrid(contacts)
}