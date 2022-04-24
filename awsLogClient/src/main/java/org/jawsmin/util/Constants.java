package org.jawsmin.util;

public class Constants {

	public static final String REGION = "us-east-1";
	public static final String DOMAIN = "amazonaws.com";
	public static final String KEY = System.getenv("AWS_ACCESS_KEY_ID");
	public static final String SECRET = System.getenv("AWS_SECRET_ACCESS_KEY");
	public static final String SERVICE = "logs";

	public static final String URL = "https://" + SERVICE + "." + REGION + "."
			+ DOMAIN;

}
