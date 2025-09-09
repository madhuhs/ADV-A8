package com.jspiders.pms.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneValidator
        implements ConstraintValidator<ValidPhone,String> {
    @Override
    public boolean isValid(String phone, ConstraintValidatorContext constraintValidatorContext) {
        boolean res = phone.matches("[0-9]");
        return res;
    }
}
