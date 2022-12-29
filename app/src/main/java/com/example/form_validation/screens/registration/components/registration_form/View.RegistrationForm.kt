package com.example.form_validation.screens.registration.components.registration_form

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.collect

@Composable
fun RegistrationFormView( ) {

    val viewModel: RegistrationFormViewModel= viewModel<RegistrationFormViewModel>( )
        val state: RegistrationFormState= viewModel.formState

    val context= LocalContext.current

    LaunchedEffect(key1 = context) {
        viewModel.formValidationEvent.collect{ validationEvent ->

            when(validationEvent) {
                is RegistrationFormViewModel.FormValidationEvent.SuccessfulValidation -> {

                    Toast.makeText(
                        context,
                        "Registration successful",
                        Toast.LENGTH_LONG
                    ).show( )
                }
            }
        }
    }

    Column(modifier = Modifier
        .fillMaxSize( )
        .padding(16.dp), verticalArrangement = Arrangement.Center) {

        TextField(
            modifier = Modifier.fillMaxWidth( ),

            value = state.email,
            onValueChange = { viewModel.onEvent(RegistrationFormEvent.EmailChangeEvent(it)) },
            isError = state.emailValidationError != null,

            keyboardOptions = KeyboardOptions(keyboardType= KeyboardType.Email),
            placeholder = {
                Text(text = "Email Address")
            }
        )

        if(state.emailValidationError != null)
            Text(
                modifier = Modifier.align(Alignment.End),
                text = state.emailValidationError,
                color= Color.Red
            )
        
        Spacer(modifier= Modifier.height(15.dp))

        Button(onClick = { viewModel.onEvent(RegistrationFormEvent.FormSubmitEvent) }) {
            Text(text = "Submit Registration Form")
        }
    }

}

@Preview
@Composable
fun RegistrationFormPreview( ) {

    Surface( ) {
        RegistrationFormView( )
    }

}