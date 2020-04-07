/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuongdn.dtos;

import java.io.Serializable;

/**
 *
 * @author Ngoc Cuong
 */
public class ErrorObjDTO implements Serializable{
    private String passwordError, usernameError, repeatPasswordError, fullNameError, phoneNumberError;

    public ErrorObjDTO() {
    }

    public ErrorObjDTO(String passwordError, String usernameError, String repeatPasswordError, String fullNameError, String phoneNumberError) {
        this.passwordError = passwordError;
        this.usernameError = usernameError;
        this.repeatPasswordError = repeatPasswordError;
        this.fullNameError = fullNameError;
        this.phoneNumberError = phoneNumberError;
    }
    
    public String getPasswordError() {
        return passwordError;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    public String getUsernameError() {
        return usernameError;
    }

    public void setUsernameError(String usernameError) {
        this.usernameError = usernameError;
    }

    public String getRepeatPasswordError() {
        return repeatPasswordError;
    }

    public void setRepeatPasswordError(String repeatPasswordError) {
        this.repeatPasswordError = repeatPasswordError;
    }

    public String getFullNameError() {
        return fullNameError;
    }

    public void setFullNameError(String fullNameError) {
        this.fullNameError = fullNameError;
    }

    public String getPhoneNumberError() {
        return phoneNumberError;
    }

    public void setPhoneNumberError(String phoneNumberError) {
        this.phoneNumberError = phoneNumberError;
    }
    
}
