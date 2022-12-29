package com.example.form_validation.screens.registration.components.registration_form

import android.util.Patterns

data class FormFieldValidationResult(

    val isValid: Boolean,
    val validationErrorMessage: String?= null

)

class EmailValidator {

    fun validate(email: String): FormFieldValidationResult {

        return if(email.isBlank( ))
            FormFieldValidationResult(
                isValid = false,
                validationErrorMessage = "email cannot be empty"
            )

        else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches( ))
            FormFieldValidationResult(
                isValid = false,
                validationErrorMessage = "email is invalid"
            )

        else FormFieldValidationResult(isValid = true)
    }
}