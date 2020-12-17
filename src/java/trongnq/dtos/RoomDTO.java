/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trongnq.dtos;

import trongnq.daos.RoomDAO;

/**
 *
 * @author Quoc
 */
public class RoomDTO  {

    private String roomID;
    private int roomTypeID;
    private int roomStatus;

    public RoomDTO() {
    }

    public RoomDTO(String roomID, int roomTypeID, int roomStatus) {
        this.roomID = roomID;
        this.roomTypeID = roomTypeID;
        this.roomStatus = roomStatus;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public int getRoomTypeID() {
        return roomTypeID;
    }

    public void setRoomTypeID(int roomTypeID) {
        this.roomTypeID = roomTypeID;
    }

    public int getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(int roomStatus) {
        this.roomStatus = roomStatus;
    }

    public String getRoomTypeName() throws Exception {
        RoomDAO roomDAO = new RoomDAO();
        return roomDAO.getRoomTypeByRoomID(roomID);
    }

    public double getRoomPrice() throws Exception {
        RoomDAO roomDAO = new RoomDAO();
        return roomDAO.getRoomPriceByRoomTypeID(roomTypeID);
    }

    @Override
    public String toString() {
        return "RoomDTO{" + "roomID=" + roomID + ", roomTypeID=" + roomTypeID + ", roomStatus=" + roomStatus + '}';

    }

}
