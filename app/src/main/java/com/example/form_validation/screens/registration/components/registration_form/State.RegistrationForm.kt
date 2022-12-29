package com.example.form_validation.screens.registration.components.registration_form

data class RegistrationFormState(

    val email: String= "",
    val emailValidationError: String?= null,

    val formHasError: Boolean= false

)