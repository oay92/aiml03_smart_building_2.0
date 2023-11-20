package com.aiml03.project.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aiml03.project.model.bean.ResidentDetails;

public class SearchByDAO {

	private Connection conn;
	
	public SearchByDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public List<ResidentDetails> searchByBuildingAndUnit(String buildingNo, String unitNo) throws SQLException {

        final String SQL = "SELECT * FROM aiml03.person WHERE building_num = ? AND unit_num = ? AND enabled = 1";
        System.out.println(SQL);

        PreparedStatement preState = conn.prepareStatement(SQL);
        preState.setString(1, buildingNo);
        preState.setInt(2, Integer.parseInt(unitNo));

        ResultSet rs = preState.executeQuery();

        // Assuming ResidentDetails has setters, you need to populate it with data from the ResultSet.
        
        List<ResidentDetails> rList = new ArrayList<>();
        
        while (rs.next()) {
            ResidentDetails r = new ResidentDetails();
            // Set other attributes here
        	int pID = rs.getInt("pID");
        	String name = rs.getString("name");
        	String email = rs.getString("email");
        	String phoneNo = rs.getString("phone");
        	String photo = rs.getString("photo");
//        	String licensePlate = rs.getString("licensePlate");
//        	String faceStamp = rs.getString("faceStamp");
//        	String licenseStamp = rs.getString("licenseStamp");
        	r.setpID(pID);
			r.setEmail(email);
			r.setPhoneNo(phoneNo);
			r.setName(name);
			r.setPhoto(photo);

			rList.add(r);
        }
        rs.close();
        preState.close();

        return rList;
    }
        

//	public List<ResidentDetails> findResidents() throws SQLException {
		
//		List<ResidentDetails> rList = new ArrayList<>();

//		while (rs.next()) {
//			ResidentDetails r = new ResidentDetails();
//			r.setResident(rs.getString(r));
//
//			// When the loop reaches this point, 'm' still holds the previous resident
//			// state.
//			if (r != null) {
//				rList.add(r);
//			}
			 //Set other resident attributes here
//			
//			r.setEmail(rs.getString("email"));
//			r.setPhoneNo(rs.getString("Phone No."));
//			r.setName(rs.getString("Name"));
//			r.setBuildingNo(rs.getString("Building No."));
//			r.setUnitNo(rs.getString("Unit No."));
//			residentList.add(resident);
//			r.setPhoto(rs.getString("Photo"));
//			r.setLevel(rs.getString("level"));
//		}
//
//		return rList;
//	}
}