package com.cg.service;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Optional;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import com.cg.bean.EmployeeMaster;
import com.cg.dao.AuthenticatorDao;
import com.cg.dao.AuthenticatorDaoImpl;


public class AuthenticatorServiceImpl implements AuthenticatorService {
	
	private static final SecureRandom RAND = new SecureRandom();
	private static final int ITERATIONS = 65536;
	private static final int KEY_LENGTH = 160; //512
	private static final String ALGORITHM = "PBKDF2WithHmacSHA512";
	private static final int SALT_LENGTH = 160; //512
	
	private AuthenticatorDao dao;
	
	public AuthenticatorServiceImpl() {
		dao = new AuthenticatorDaoImpl(); 
	}
	
	private static Optional<String> generateSalt(final int length){
		if(length < 1) {
			System.out.println("error in generateSalt : length must be > 0 ");
			return Optional.empty();
		}
		
		byte[] salt = new byte[length];
		RAND.nextBytes(salt);
		return Optional.of(Base64.getEncoder().encodeToString(salt));
	}
	
private static Optional<String> hashPassword (String password, String salt){
		
		// converting the password from string to char array
		char[] chars = password.toCharArray();
		// converting the salt from get salt to byte array
		byte[] bytes = salt.getBytes();
		// Cannot keep password int string as strings are immutable 
		
		// Method to generate the key where chars is password, bytes is salt
		PBEKeySpec spec = new PBEKeySpec(chars, bytes, ITERATIONS, KEY_LENGTH);
		
		// clearing the array as it contains password in plain text format by setting everything to null
		Arrays.fill(chars, Character.MIN_VALUE);
		
		try {
			
			SecretKeyFactory fac = SecretKeyFactory.getInstance(ALGORITHM);
			byte[] securePassword = fac.generateSecret(spec).getEncoded();
			return Optional.of(Base64.getEncoder().encodeToString(securePassword));
	
		} catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
			
			System.err.println("Exception occured in hashPassword()");
			return Optional.empty();
		
		} finally {
			
			spec.clearPassword();
		}
	}

	
	@Override
	public String authenticateUser(int employeeId, String password) {
		EmployeeMaster employee = dao.getInfo(employeeId);
		if (employee == null) {
			return "No user Found";
		} else {
			String salt = employee.getUserSalt();
			String calculatedHash = hashPassword(password, salt).get();
			if(calculatedHash.equals(employee.getPassword())) {
				return "Successful Authentication" + employee.getRole();
			} else {
				return "Unsuccessful Authentication";
			}
		}
	}

	@Override
	public boolean addUser(int employeeId, String name, String password, String role) {
		String salt = generateSalt(SALT_LENGTH).get();
		String encryptedPassword = hashPassword(password, salt).get();
		EmployeeMaster employee = new EmployeeMaster();
		employee.setEmployeeId(employeeId);
		employee.setEmployeeName(name);
		employee.setPassword(encryptedPassword);
		employee.setRole(role);
		employee.setUserSalt(salt);
		
		return dao.addUser(employee);
	}
}
