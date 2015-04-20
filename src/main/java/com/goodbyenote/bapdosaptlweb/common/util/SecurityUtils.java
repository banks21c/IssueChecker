package com.goodbyenote.bapdosaptlweb.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.apache.log4j.Logger;

public class SecurityUtils {
	private static final Logger LOGGER = Logger.getLogger(SecurityUtils.class);
	
	/**
	 * MD5 암호화
	 * @param str-문자
	 * @return 암호화문자
	 */	
	public static String makeMD5(String str){
		
		String MD5 = null; 
		
		try{
			MessageDigest md = MessageDigest.getInstance("MD5"); 
			md.update(str.getBytes()); 
			byte byteData[] = md.digest();
			StringBuffer sb = new StringBuffer(); 
			for(int i = 0 ; i < byteData.length ; i++){
				sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
			}
			MD5 = sb.toString();
			LOGGER.debug(MD5);
			
		}catch(NoSuchAlgorithmException e){
			LOGGER.debug(e.getMessage()); 		
		}		
		
		return MD5;
	}

	/**
	 * 32자리 유일키 생성
	 * @return 문자열
	 */	
	public static String make32UniqueId(){
		return makeMD5(UUID.randomUUID().toString());
	}
	
    /**
     * 날짜를 주어진 방식으로 리턴한다. 예)201503121041.001
     * @return 
     */
    public static String getTimeFormat() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss.SSS");
        return formatter.format(new Date());
    }	
    
    /**
     * 날짜를 주어진 방식으로 리턴한다. 예)201503121041.001d3e644f05d06d882e5b92e330f1c9ce4
     * @return 
     */
    public static String getTimeFormatUnique() {
        return getTimeFormat() + make32UniqueId();
    }	    

}
