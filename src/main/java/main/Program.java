package main;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import models.*;

public class Program {

    public static void main(String[] args) {
        Animal a;
        Validator v = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Animal>> violations;

        a = new Tiger.Builder().addName("").addAge(0).addWeight(-3.1)
                .addColor("White").addCategory("longHaired")
                .addEatenEmployees(-1).Build();

        violations = v.validate(a);
        System.out.println("Invalid object:");

        if (violations != null)
            for(ConstraintViolation cv : violations)
                System.out.println(cv.getPropertyPath().toString().toUpperCase() + " | " + cv.getMessage());

        a = new Tiger.Builder().addName("Fluffy").addAge(3).addWeight(90.7)
                .addColor("Red").addCategory("shortHaired")
                .addEatenEmployees(1).Build();

        violations = v.validate(a);
        System.out.println("Valid object:");
        if (violations != null)
            for(ConstraintViolation cv : violations)
                System.out.println(cv.getPropertyPath().toString().toUpperCase() + " | " + cv.getMessage());
    }

}
