package com.mvc.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hashing {
	
	public String generateHash(String password)
	{
		StringBuilder hash = new StringBuilder();
		try{
			MessageDigest sha = MessageDigest.getInstance("SHA-1");
			byte[] hashedBytes = sha.digest(password.getBytes());
			//for salting
			char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
					'a', 'b', 'c', 'd', 'e', 'f'};
			for(int i = 0; i < hashedBytes.length; i++)
			{
				byte b = hashedBytes[i];
				hash.append(digits[(b & 0xf0) >> 4]);
				hash.append(digits[b & 0x0f]);
			}
		}
		catch (NoSuchAlgorithmException e){
			System.out.print(e);
			
		}
		
		
		return hash.toString();
	}

}
