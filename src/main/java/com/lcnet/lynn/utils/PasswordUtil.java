package com.lcnet.lynn.utils;

import org.apache.axis.encoding.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.security.crypto.codec.Utf8;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author hlc004
 * 密码加密解密工具
 */
public class PasswordUtil {
	
	/*private static Logger log = LoggerFactory.getLogger(PasswordUtil.class);
	
	private static final String Algorithm = "DESede"; //定义 加密算法,可用 DES,DESede,Blowfish
	
	*//**
	 * 秘钥
	 *//*
	private static final String secretKey = "com.lcnet.lynn" ;
	
	*//**
	 * 比对密码是否一致
	 * @param expected
	 * @param actual
	 * @return
	 *//*
	public static boolean equals(String expected, String actual) {
        byte[] expectedBytes = bytesUtf8(expected);
        byte[] actualBytes = bytesUtf8(actual);
        int expectedLength = expectedBytes == null ? -1 : expectedBytes.length;
        int actualLength = actualBytes == null ? -1 : actualBytes.length;
        if (expectedLength != actualLength) {
            return false;
        }

        int result = 0;
        for (int i = 0; i < expectedLength; i++) {
            result |= expectedBytes[i] ^ actualBytes[i];
        }
        return result == 0;
    }
	
	*//**
	 * 转换为UTF-8
	 * @param s
	 * @return
	 *//*
	private static byte[] bytesUtf8(String s) {
        if(s == null) {
            return null;
        }

        return Utf8.encode(s);
    }
	
	*//**
	 * 根据用户名和密码进行加密
	 * @param userName
	 * @param password
	 * @return
	 *//*
	public static String encrypt(String userName, String password) {
		String pword = null ;
		final byte[] keyBytes = hex(userName) ; 
        byte[] encoded = encryptMode(keyBytes, password.getBytes());  
        if(encoded != null) {
        	pword = Base64.encode(encoded);   
        }
        return pword ;
	}
	
	*//**
	 * 根据用户名和密码进行解密
	 * @param userName
	 * @param password
	 * @return
	 *//*
	public static String decrypt(String userName, String password) {
		
		final byte[] keyBytes = hex(userName) ;   
		byte[] encoded = Base64.decode(password) ;
	    byte[] decryptPassword = decryptMode(keyBytes, encoded);
	    if(decryptPassword != null) {
	    	return new String(decryptPassword) ;
	    }
		return null ;
	}
	
	*//**
	 * 根据秘钥对密码或用户名进行加密
	* @Title: encrypt 
	* @author hlc004
	* @Description: TODO
	* @param password
	* @return
	* @return String
	* @date 2015年7月6日 下午2:41:49 
	* @throws
	 *//*
	public static String encrypt(String password) {
		String pword = null ;
		final byte[] keyBytes = hex(secretKey) ; 
        byte[] encoded = encryptMode(keyBytes, password.getBytes());  
        if(encoded != null) {
        	pword = Base64.encode(encoded);   
        }
        return pword ;
	}
	
	*//**
	 * 根据秘钥对密码或用户名进行解密
	* @Title: decrypt 
	* @author hlc004
	* @Description: TODO
	* @param password
	* @return
	* @return String
	* @date 2015年7月6日 下午2:41:49 
	* @throws
	 *//*
	public static String decrypt(String password) {
		
		final byte[] keyBytes = hex(secretKey) ;   
		byte[] encoded = Base64.decode(password) ;
	    byte[] decryptPassword = decryptMode(keyBytes, encoded);
	    if(decryptPassword != null) {
	    	return new String(decryptPassword) ;
	    }
		return null ;
	}

	//keybyte为加密密钥，长度为24字节
    //src为被加密的数据缓冲区（源）
    public static byte[] encryptMode(byte[] keybyte, byte[] src) {
       try {
            //生成密钥
            SecretKey deskey = new SecretKeySpec(keybyte, Algorithm);

            //加密
            Cipher c1 = Cipher.getInstance(Algorithm);
            c1.init(Cipher.ENCRYPT_MODE, deskey);
            return c1.doFinal(src);
        } catch (Exception e) {
        	log.error(e.getMessage());
        	e.printStackTrace(); 
        } 
        return null;
    }
    
    //keybyte为加密密钥，长度为24字节
    //src为加密后的缓冲区
    public static byte[] decryptMode(byte[] keybyte, byte[] src) {      
    try {
            //生成密钥
            SecretKey deskey = new SecretKeySpec(keybyte, Algorithm);

            //解密
            Cipher c1 = Cipher.getInstance(Algorithm);
            c1.init(Cipher.DECRYPT_MODE, deskey);
            return c1.doFinal(src);
        } catch (Exception e) {
        	log.error(e.getMessage());
        	e.printStackTrace();
        } 
        return null;
    }
    
    //转换成十六进制字符串
    public static String byte2hex(byte[] b) {
        String hs="";
        String stmp="";

        for (int n=0;n<b.length;n++) {
            stmp=(Integer.toHexString(b[n] & 0XFF));
            if (stmp.length()==1) hs=hs+"0"+stmp;
            else hs=hs+stmp;
            if (n<b.length-1)  hs=hs+":";
        }
        return hs.toUpperCase();
    }
    
    public static byte[] hex(String username){  
        String f = DigestUtils.md5Hex(username+secretKey);  
        byte[] bkeys = new String(f).getBytes();  
        byte[] enk = new byte[24];  
        for (int i=0;i<24;i++){  
            enk[i] = bkeys[i];  
        }  
        return enk;  
    }
    
    public static void main(String[] args)
    {
    	String user1 = "Administrator";
    	String user2 = "admin";
    	String user3 = "caibocheng";
    	String user4 = "caisenmiao";
    	String user5 = "chenhuanlong";
    	String user6 = "fengminghui";
    	String user7 = "gouyubei";
    	String user8 = "guanwanyuan";
    	String user9 = "huangweisheng";
    	String user10 = "huanlanxiang";
    	String user11 = "jiangwenbo";
    	String user12 = "linquan";
    	String user13 = "liubing";
    	String user14 = "liuxiaoling";
    	String user15 = "lixichao";
    	String user16 = "qiubo";
    	String user17 = "qiuxiaohong";
    	String user18 = "tianmengyuan";
    	String user19 = "xiaohuanxiang";
    	String user20 = "xieqianhao";
    	String user111 = "yanghaiyang";
    	String user1111 = "yangjin";
    	String user11111 = "zhuyao";
    	System.out.println(encrypt(user1, "000000"));
    	System.out.println(encrypt(user2, "000000"));
    	System.out.println(encrypt(user3, "000000"));
    	System.out.println(encrypt(user4, "000000"));
    	System.out.println(encrypt(user5, "000000"));
    	System.out.println(encrypt(user6, "000000"));
    	System.out.println(encrypt(user7, "000000"));
    	System.out.println(encrypt(user8, "000000"));
    	System.out.println(encrypt(user9, "000000"));
    	System.out.println(encrypt(user10, "000000"));
    	System.out.println(encrypt(user11, "000000"));
    	System.out.println(encrypt(user12, "000000"));
    	System.out.println(encrypt(user13, "000000"));
    	System.out.println(encrypt(user14, "000000"));
    	System.out.println(encrypt(user15, "000000"));
    	System.out.println(encrypt(user16, "000000"));
    	System.out.println(encrypt(user17, "000000"));
    	System.out.println(encrypt(user18, "000000"));
    	System.out.println(encrypt(user19, "000000"));
    	System.out.println(encrypt(user20, "000000"));
    	System.out.println(encrypt(user111, "000000"));
    	System.out.println(encrypt(user1111, "000000"));
    	System.out.println(encrypt(user11111, "000000"));
        System.out.println(encrypt("xuer", "000000"));
        System.out.println(decrypt("xuer", "L7tnYAuSw2w="));
        System.out.println(encrypt("primecocn", "primecocn"));
        System.out.println(encrypt("primecocn", "root"));
        System.out.println(decrypt("primecocn", "FoC7NIg11QGVfIMTfv2IXA=="));
        System.out.println(decrypt("primecocn", "FoC7NIg11QGVfIMTfv2IXA=="));


        System.out.println(encrypt("primecocn"));
        System.out.println(encrypt("jbpm"));

		System.out.println(encrypt("lcnet"));
		System.out.println(encrypt("lcnet2015"));
		System.out.println(encrypt("xuer", "000000"));


		System.out.println(decrypt("dMx75dPkLHE="));
		System.out.println(decrypt("ux6sgat5mvAE6KfmkP1c8w=="));
		System.out.println(decrypt("dECrEm+Pnm+O5k/tl7cNRA=="));
    }*/
    
}
