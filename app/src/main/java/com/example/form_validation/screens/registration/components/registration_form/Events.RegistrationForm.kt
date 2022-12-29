package com.example.form_validation.screens.registration.components.registration_form

sealed class RegistrationFormEvent {

    data class EmailChangeEvent(val changedValue: String): RegistrationFormEvent( )

    object FormSubmitEvent: RegistrationFormEvent( )

}