package com.wah.commons.utils;

public class HexUtils{

    public static String toHex(byte[] bytes){
        AssertUtils.notEmpty(bytes, "字节数组不能为空");

        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < bytes.length; i++){
            String hex = Integer.toHexString(bytes[i] & 0xFF);

            if(hex.length() == 1){
                hex = '0' + hex;
            }

            builder.append(hex);
        }

        return builder.toString();
    }

    public static byte[] toBytes(String hex){
        AssertUtils.hasText(hex, "字符串不能为空");

        int    length = hex.length() / 2;
        byte[] result = new byte[length];

        for(int i = 0; i < length; i++){
            int high = Integer.parseInt(hex.substring(i * 2, i * 2 + 1), 16);
            int low  = Integer.parseInt(hex.substring(i * 2 + 1, i * 2 + 2), 16);

            result[i] = (byte) (high * 16 + low);
        }

        return result;
    }
}
