package com.wah.commons.utils;

import com.wah.commons.security.exception.EncodeException;

import java.io.InputStream;
import java.security.MessageDigest;

public class MD5Utils{

    private static final String ALGORITHM = "MD5";

    public static byte[] digest(byte[] bytes) throws EncodeException{
        AssertUtils.notEmpty(bytes, "字节数组不能为空");

        try{
            MessageDigest digest = MessageDigest.getInstance(ALGORITHM);

            return digest.digest(bytes);
        }catch(Exception e){
            throw new EncodeException(e.getMessage(), e);
        }
    }

    public static byte[] encode(InputStream input) throws EncodeException{
        AssertUtils.notNull(input, "输入流不能为空");

        try{
            MessageDigest digest = MessageDigest.getInstance(ALGORITHM);
            byte[]        buffer = new byte[8192];
            int           length = 0;

            while((length = input.read(buffer)) != -1){
                digest.update(buffer, 0, length);
            }

            return digest.digest();
        }catch(Exception e){
            throw new EncodeException(e.getMessage(), e);
        }
    }
}
