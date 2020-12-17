/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trongnq.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import trongnq.define.Define;
import trongnq.dtos.RoomDTO;
import trongnq.utils.DBUtilities;

/**
 *
 * @author Quoc
 */
public class RoomDAO {

    private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;

    private void closeConnection() throws Exception {
        if (rs != null) {
            rs.close();
        }
        if (preStm != null) {
            preStm.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    public String getRoomTypeByRoomID(String roomID) throws Exception {
        String roomTypeName = "";
        String sql = "SELECT [room_type].[roomtypename]"
                + " FROM [room_type]"
                + " WHERE [room_type].[roomtypeid] = ?";
        try {
            conn = DBUtilities.makeConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, roomID);
            rs = preStm.executeQuery();
            if (rs.next()) {
                roomTypeName = rs.getString("roomtypename");
            }
        } finally {
            closeConnection();
        }
        return roomTypeName;
    }

    public ArrayList<RoomDTO> displayAllRoom() throws Exception {
        ArrayList<RoomDTO> roomInfoList = new ArrayList<>();
        String sql = "SELECT [room].[roomid], [room].[roomtypeid], [room].[roomstatus] FROM [room]";
        try {
            conn = DBUtilities.makeConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            while (rs.next()) {
                String roomID = rs.getString("roomid");
                int roomTypeID = rs.getInt("roomtypeid");
                int roomStatus = rs.getInt("roomstatus");
                RoomDTO roomInfo = new RoomDTO(roomID, roomTypeID, roomStatus);
                roomInfoList.add(roomInfo);
            }
        } finally {
            closeConnection();
        }
        return roomInfoList;
    }

    public ArrayList<RoomDTO> searchRoomBySearchValues(String checkInDate, String checkOutDate) throws Exception {
        ArrayList<RoomDTO> roomInfoList = new ArrayList<>();
        String sql = "SELECT [room].[roomID]"
                + "FROM  [room]"
                + "INNER JOIN [booking_detail] ON [room].[roomID] = [booking_detail].[roomID]";
        try {
            conn = DBUtilities.makeConnection();
            preStm = conn.prepareStatement(sql);
//            //1. user search by Check In Date
//            if (!checkInDate.equals("") && checkOutDate.equals("")) {
//
//            }
//            //2. user search by Check Out Date
//            if (checkInDate.equals("") && !checkOutDate.equals("")) {
//
//            }
//            //3. user search by both check in and check out date
//            if (!checkInDate.equals("") && !checkOutDate.equals("")) {
//
//            }
            //4. user search all
            if (checkInDate.equals("") && checkOutDate.equals("")) {
                sql += "AND [booking_detail].[checkInDate] <= ? "
                        + "AND [booking_detail].[checkOutDate] <= ?";
                preStm.setString(1, checkInDate);
                preStm.setString(2, checkOutDate);
            }
            rs = preStm.executeQuery();
            while (rs.next()) {
                String roomID = rs.getString("roomid");
                int roomTypeID = rs.getInt("roomtypeid");
                int roomStatus = rs.getInt("roomstatus");
                RoomDTO roomInfo = new RoomDTO(roomID, roomTypeID, roomStatus);
                roomInfoList.add(roomInfo);
            }
        } finally {
            closeConnection();
        }
        return roomInfoList;
    }

    public double getRoomPriceByRoomTypeID(int roomTypeID) throws Exception {
        double roomPrice = 0;
        String sql = "SELECT [room_type].[roomtypeprice]"
                + " FROM [room_type]"
                + " WHERE [room_type].[roomtypeid] = ?";
        try {
            conn = DBUtilities.makeConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, roomTypeID);
            rs = preStm.executeQuery();
            if (rs.next()) {
                roomPrice = rs.getFloat("roomtypeprice");
            }
        } finally {
            closeConnection();
        }
        return roomPrice;
    }
}
