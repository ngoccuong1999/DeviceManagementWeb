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
public class ErrorDeviceDTO implements Serializable{
    private String idError;

    public String getIdError() {
        return idError;
    }

    public void setIdError(String idError) {
        this.idError = idError;
    }

    public ErrorDeviceDTO(String idError) {
        this.idError = idError;
    }

    public ErrorDeviceDTO() {
    }
}
