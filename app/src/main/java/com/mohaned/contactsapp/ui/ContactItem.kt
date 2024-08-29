package com.mohaned.contactsapp.ui

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mohaned.contactsapp.R
import com.mohaned.contactsapp.model.Contact

@Composable
fun ContactItem(
    contact: Contact,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .background(Color.LightGray)
            .wrapContentSize()
            .clickable {
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:${contact.phoneNumber}")
            }
            context.startActivity(intent)
        }
    ) {
        Image(
            painter = painterResource(id = contact.image),
            contentDescription = contact.name,
        )
        Text(
            text = contact.name,
            fontWeight = FontWeight.SemiBold,
            modifier = modifier.padding(vertical = 2.dp)
        )
        SelectionContainer {
            Text(
                text = contact.phoneNumber,
                modifier = modifier.padding(bottom = 4.dp),
                textAlign = TextAlign.Center,

            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ContactItemPreview() {
    val contact = Contact("Friend 1", "+201012345678", R.drawable.friend_1)
    ContactItem(contact)
}