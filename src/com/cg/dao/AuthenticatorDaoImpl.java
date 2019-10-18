package com.cg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cg.bean.EmployeeMaster;

public class AuthenticatorDaoImpl implements AuthenticatorDao{

	@Override
	public boolean addUser(EmployeeMaster employee) {
		Connection conn = null;
		
		try {
			conn = JdbcUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(save);
			stmt.setInt(1, employee.getEmployeeId());
			stmt.setString(2, employee.getEmployeeName());
			stmt.setString(3, employee.getPassword());
			stmt.setString(4, employee.getRole());
			stmt.setString(5, employee.getUserSalt());
			
			int update = stmt.executeUpdate();
			
			if(update > 0)
				return true;
			else 
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public EmployeeMaster getInfo(int employeeId) {
		Connection conn = null;
		EmployeeMaster employee = null;
		
		try {
			conn = JdbcUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(get);
			stmt.setInt(1, employeeId);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				employee = new EmployeeMaster();
				employee.setEmployeeId(rs.getInt(1));
				employee.setEmployeeName(rs.getString(2));
				employee.setPassword(rs.getString(3));
				employee.setRole(rs.getString(4));
				employee.setUserSalt(rs.getString(5));
			}
			else {
				return null;
			}
			return employee;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) 
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
