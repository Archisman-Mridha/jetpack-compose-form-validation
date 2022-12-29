package com.example.form_validation.screens.registration.components.registration_form

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class RegistrationFormViewModel(

    private val emailValidator: EmailValidator= EmailValidator( )

): ViewModel( ) {

    var formState by mutableStateOf(RegistrationFormState( ))
        private set

    private val formValidationEventChannel= Channel<FormValidationEvent>( )
        val formValidationEvent= formValidationEventChannel.receiveAsFlow( )

    fun onEvent(event: RegistrationFormEvent) {
        when(event) {

            is RegistrationFormEvent.EmailChangeEvent -> {

                val emailValidationResult= emailValidator.validate(event.changedValue)

                formState= formState.copy(
                    email= event.changedValue,
                    emailValidationError= emailValidationResult.validationErrorMessage
                )
            }

            is RegistrationFormEvent.FormSubmitEvent -> handleFormSubmit( )
        }
    }

    private fun handleFormSubmit( ) {

        val formHasError= listOf<String?>(formState.emailValidationError)
            .any{ it != null }

        if(formHasError)
            formState= formState.copy(formHasError= true)

        else {
            formState= formState.copy(formHasError= false)

            viewModelScope.launch {
                formValidationEventChannel.send(FormValidationEvent.SuccessfulValidation)
            }
        }
    }

    sealed class FormValidationEvent {
        object SuccessfulValidation: FormValidationEvent( )
    }

}