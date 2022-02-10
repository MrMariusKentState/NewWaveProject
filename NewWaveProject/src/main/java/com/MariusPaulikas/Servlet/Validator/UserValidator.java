package com.MariusPaulikas.Servlet.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.MariusPaulikas.Servlet.Models.User;
import com.MariusPaulikas.Servlet.Repositories.UserRepository;



@Component
public class UserValidator implements Validator {

	
@Autowired
private UserRepository userrepository;


public boolean supports(Class<?> clazz) {
    return User.class.equals(clazz);
}


public void validate(Object target, Errors errors) {
    User user = (User) target;
    
//    if (!user.getConfirmpassword().equals(user.getPassword())) {
//        // 3
//        errors.rejectValue("confirmpassword", "Match", "Your Password and Password Confirmation must match.");
//    } 
    
    if(userrepository.existsByEmail(user.getEmail())) {
    	errors.rejectValue("email", "emailerror", "This email already exists.  Please enter a different email.");
    }
}



}
