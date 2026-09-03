package Validator;

import javax.xml.validation.Validator;

public class ValidatorDemo {

    public static void main(String[] args) {

        signupForm form1 = new signupForm(
                "",
                "thisisaverylongemailaddress@example.com",
                "123"
        );

        signupForm form2 = new signupForm(
            "King", 
            "King@gmail.com", 
            "123"
        );

        System.out.println("For Form - 1 :");
        String errorsForF1 = validator.validate(form1);
        
        if (errorsForF1.isEmpty()) {
            System.out.println("Form is valid");
        } else {
            System.out.println("Validation errors:");
            System.out.println(errorsForF1);
        }
        
        System.out.println("For Form - 2 :");
        String errorsFroF2 = validator.validate(form2);

        if(errorsFroF2.isEmpty()){
            System.out.println("Form is valid");
        }else{
            System.out.println("Invalid Form");
            System.out.println(errorsFroF2);
        }
    }
}