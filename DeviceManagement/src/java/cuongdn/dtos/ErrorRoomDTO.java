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
public class ErrorRoomDTO implements Serializable{
    private String roomIdError;

    public ErrorRoomDTO() {
    }

    public ErrorRoomDTO(String roomIdError) {
        this.roomIdError = roomIdError;
    }

    public String getRoomIdError() {
        return roomIdError;
    }

    public void setRoomIdError(String roomIdError) {
        this.roomIdError = roomIdError;
    }
    
    
}
