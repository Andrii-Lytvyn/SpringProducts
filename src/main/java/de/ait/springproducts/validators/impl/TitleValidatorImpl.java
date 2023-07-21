package de.ait.springproducts.validators.impl;

import de.ait.springproducts.validators.TitleValidator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TitleValidatorImpl implements TitleValidator {
    private final int minLength;

    public TitleValidatorImpl(@Value("${min.title.length}") int minLength){
        this.minLength = minLength;
    }
    @Override
    public void validate(String title){
        if(title.length()<minLength){
            throw new IllegalArgumentException("Title too short, must be " + minLength + " symbols.");
        }
    }
}
