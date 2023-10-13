package br.com.acalappv4.application.web.components.validation

import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext


class TemporalReferenceConstraint: ConstraintValidator<ValidReference, String> {

    private companion object{
        private const val REFERENCE_REGEX = "^\\d{6}$"

        private const val START_MONTH_STRING = 0
        private const val END_MONTH_STRING = 2

        private const val START_YEAR_STRING = 4
        private const val END_YEAR_STRING = 6
    }

    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        return value?.let {
            it.isNotBlank() &&
            it.length == 6 &&
            it.matches(Regex(REFERENCE_REGEX)) &&
            it.substring(START_YEAR_STRING, END_YEAR_STRING).toInt() > 0 &&
            it.substring(START_MONTH_STRING, END_MONTH_STRING).toInt() in 1..12
        } ?: false
    }

}