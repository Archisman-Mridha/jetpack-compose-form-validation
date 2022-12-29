package com.example.form_validation.screens.registration

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.form_validation.screens.registration.components.registration_form.RegistrationFormView

@Composable
fun RegistrationScreenView( ) {

    Surface(modifier = Modifier.fillMaxSize( ), color = Color.White) {
        RegistrationFormView( )
    }

}