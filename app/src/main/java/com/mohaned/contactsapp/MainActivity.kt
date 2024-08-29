package com.mohaned.contactsapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.mohaned.contactsapp.data.DataSource
import com.mohaned.contactsapp.ui.ContactsGrid
import com.mohaned.contactsapp.ui.theme.ContactsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ContactsAppTheme {
                ContactsApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactsApp(modifier: Modifier = Modifier) {
    val contacts = DataSource().getContacts()
    val context = LocalContext.current
    Scaffold (
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text(text = "Contacts App", fontWeight = FontWeight.SemiBold)},
                actions = {
                    IconButton(onClick = {
                        val homeNumber = "+0244059165"
                        val intent = Intent(Intent.ACTION_DIAL).apply {
                            data = Uri.parse("tel:${homeNumber}")
                        }
                        context.startActivity(intent)
                    }) {
                        Icon(painter = painterResource(id = R.drawable.ic_home), contentDescription = "Home")
                    }
                }
            )
        }
    ) { innerPadding ->
        ContactsGrid(contacts = contacts, modifier = modifier.padding(innerPadding))
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun ContactsDesignPreview() {
    ContactsApp()
}