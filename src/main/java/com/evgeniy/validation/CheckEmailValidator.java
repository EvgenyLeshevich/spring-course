package com.evgeniy.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckEmailValidator implements ConstraintValidator<CheckEmail, String> {

    private String endOfEmail;

    @Override
    public void initialize(CheckEmail checkEmail) {
        // Указываем аннотации, что заданный стринг это её value
        endOfEmail = checkEmail.value();
    }

    @Override
    public boolean isValid(String enteredValue, ConstraintValidatorContext constraintValidatorContext) {
        // Проверяем заканчивается ли введённый стринг с заданных в value нашей аннотации
        return enteredValue.endsWith(endOfEmail);
    }
}
