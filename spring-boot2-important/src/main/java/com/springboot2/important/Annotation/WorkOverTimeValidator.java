package com.springboot2.important.Annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class WorkOverTimeValidator implements ConstraintValidator<WorkOverTime,Integer>{

    private WorkOverTime work;

    private int max;

    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {

        if(integer == null){

            return true;
        }

        return integer < max;
    }

    @Override
    public void initialize(WorkOverTime work) {

        this.work = work;
        max = work.max();
    }
}
