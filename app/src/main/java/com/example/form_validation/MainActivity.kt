package com.example.form_validation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.form_validation.screens.registration.RegistrationScreenView

class MainActivity : ComponentActivity( ) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            RegistrationScreenView( )
        }
    }
}