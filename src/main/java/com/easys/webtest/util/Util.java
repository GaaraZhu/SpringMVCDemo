package com.easys.webtest.util;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

public class Util {
	public static void main(String[] args) {
		System.out.println(encodePassword("123"));
	}

	private static Md5PasswordEncoder encoder = new Md5PasswordEncoder();

	public static String encodePassword(String password) {
		return encoder.encodePassword(password, null);
	}

}
