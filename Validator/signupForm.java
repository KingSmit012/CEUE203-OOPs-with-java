package Validator;

public class signupForm {
    @NotBlank
    @MaxLenght(20)
    private String userName;

    @NotBlank
    @MaxLenght(30)
    private String email;

    @NotBlank
    @MaxLenght(15)
    private String password;

    public signupForm(String userName , String email , String password){
        this.userName = userName;
        this.email = email;
        this.password = password;
    }
}