package com.wah.commons.utils;

import com.google.common.collect.Maps;
import com.wah.commons.security.exception.DecodeException;
import com.wah.commons.security.exception.EncodeException;
import com.wah.commons.security.exception.KeyPairGenerateException;
import com.wah.commons.security.exception.SignatureException;

import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Map;

public class RSAUtils{

    private static final String ALGORITHM = "RSA";
    private static final String SIGNATURE = "SHA1withRSA";

    private static final int KEY_LENGTH_1024 = 1024;
    private static final int KEY_LENGTH_2048 = 2048;

    private static final int MAX_1024_ENCODE_BLOCK = 117;
    private static final int MAX_1024_DECODE_BLOCK = 128;

    private static final int MAX_2048_ENCODE_BLOCK = 245;
    private static final int MAX_2048_DECODE_BLOCK = 256;

    public static final String PUBLIC_KEY  = "RSA_PUBLIC_KEY";
    public static final String PRIVATE_KEY = "RSA_PRIVATE_KEY";

    public static Map<String, Key> keyPairBy1024() throws KeyPairGenerateException{
        return keyPair(KEY_LENGTH_1024);
    }

    public static Map<String, Key> keyPairBy2048() throws KeyPairGenerateException{
        return keyPair(KEY_LENGTH_2048);
    }

    public static byte[] sign(byte[] content, byte[] privateKey) throws SignatureException{
        AssertUtils.notEmpty(content, "签名的内容信息不能为空");
        AssertUtils.notEmpty(privateKey, "私钥信息不能为空");

        try{
            PrivateKey key = generatePrivateKey(privateKey);

            Signature signature = Signature.getInstance(SIGNATURE);
            signature.initSign(key);
            signature.update(content);

            return signature.sign();
        }catch(Exception e){
            throw new SignatureException(e.getMessage(), e);
        }
    }

    public static boolean verify(byte[] content, byte[] sign, byte[] publicKey) throws SignatureException{
        AssertUtils.notEmpty(content, "验签的内容信息不能为空");
        AssertUtils.notEmpty(sign, "签名的内容信息不能为空");
        AssertUtils.notEmpty(publicKey, "公钥信息不能为空");

        try{
            PublicKey key = generatePublicKey(publicKey);

            Signature signature = Signature.getInstance(SIGNATURE);
            signature.initVerify(key);
            signature.update(content);

            return signature.verify(sign);
        }catch(Exception e){
            throw new SignatureException(e.getMessage(), e);
        }
    }

    public static byte[] encodeBy1024PublicKey(byte[] content, byte[] key) throws EncodeException{
        return encodeByPublicKey(content, key, MAX_1024_ENCODE_BLOCK);
    }

    public static byte[] encodeBy1024PrivateKey(byte[] content, byte[] key) throws EncodeException{
        return encodeByPrivateKey(content, key, MAX_1024_ENCODE_BLOCK);
    }

    public static byte[] encodeBy2048PublicKey(byte[] content, byte[] key) throws EncodeException{
        return encodeByPublicKey(content, key, MAX_2048_ENCODE_BLOCK);
    }

    public static byte[] encodeBy2048PrivateKey(byte[] content, byte[] key) throws EncodeException{
        return encodeByPrivateKey(content, key, MAX_2048_ENCODE_BLOCK);
    }

    public static byte[] decodeBy1024PublicKey(byte[] content, byte[] key) throws DecodeException{
        return decodeByPublicKey(content, key, MAX_1024_DECODE_BLOCK);
    }

    public static byte[] decodeBy1024PrivateKey(byte[] content, byte[] key) throws DecodeException{
        return decodeByPrivateKey(content, key, MAX_1024_DECODE_BLOCK);
    }

    public static byte[] decodeBy2048PublicKey(byte[] content, byte[] key) throws DecodeException{
        return decodeByPublicKey(content, key, MAX_2048_DECODE_BLOCK);
    }

    public static byte[] decodeBy2048PrivateKey(byte[] content, byte[] key) throws DecodeException{
        return decodeByPrivateKey(content, key, MAX_2048_DECODE_BLOCK);
    }

    private static PublicKey generatePublicKey(byte[] key) throws KeyPairGenerateException{
        AssertUtils.notEmpty(key, "公钥信息不能为空");

        try{
            KeyFactory         factory = KeyFactory.getInstance(ALGORITHM);
            X509EncodedKeySpec spec    = new X509EncodedKeySpec(key);

            return factory.generatePublic(spec);
        }catch(Exception e){
            throw new KeyPairGenerateException(e.getMessage(), e);
        }
    }

    private static PrivateKey generatePrivateKey(byte[] key) throws KeyPairGenerateException{
        AssertUtils.notEmpty(key, "私钥信息不能为空");

        try{
            KeyFactory          factory = KeyFactory.getInstance(ALGORITHM);
            PKCS8EncodedKeySpec spec    = new PKCS8EncodedKeySpec(key);

            return factory.generatePrivate(spec);
        }catch(Exception e){
            throw new KeyPairGenerateException(e.getMessage(), e);
        }
    }

    private static byte[] encodeByPublicKey(byte[] content, byte[] key, int maxBlock) throws EncodeException{
        try{
            PublicKey publicKey = generatePublicKey(key);

            return encode(content, publicKey, maxBlock);
        }catch(Exception e){
            throw new EncodeException(e.getMessage(), e);
        }
    }

    private static byte[] encodeByPrivateKey(byte[] content, byte[] key, int maxBlock) throws EncodeException{
        try{
            PrivateKey privateKey = generatePrivateKey(key);

            return encode(content, privateKey, maxBlock);
        }catch(Exception e){
            throw new EncodeException(e.getMessage(), e);
        }
    }

    private static byte[] decodeByPublicKey(byte[] content, byte[] key, int maxBlock) throws DecodeException{
        try{
            PublicKey publicKey = generatePublicKey(key);

            return decode(content, publicKey, maxBlock);
        }catch(Exception e){
            throw new DecodeException(e.getMessage(), e);
        }
    }

    private static byte[] decodeByPrivateKey(byte[] content, byte[] key, int maxBlock) throws DecodeException{
        try{
            PrivateKey privateKey = generatePrivateKey(key);

            return decode(content, privateKey, maxBlock);
        }catch(Exception e){
            throw new DecodeException(e.getMessage(), e);
        }
    }

    private static Map<String, Key> keyPair(int length) throws KeyPairGenerateException{
        try{
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(ALGORITHM);
            keyPairGenerator.initialize(length);

            KeyPair keyPair = keyPairGenerator.generateKeyPair();

            RSAPublicKey publicKey  = (RSAPublicKey) keyPair.getPublic();
            RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();

            Map<String, Key> keys = Maps.newHashMapWithExpectedSize(2);

            keys.put(PUBLIC_KEY, publicKey);
            keys.put(PRIVATE_KEY, privateKey);

            return keys;
        }catch(Exception e){
            throw new KeyPairGenerateException(e.getMessage(), e);
        }
    }

    private static byte[] encode(byte[] content, Key key, int maxBlock) throws EncodeException{
        AssertUtils.notEmpty(content, "加密内容不能为空");
        AssertUtils.notNull(key, "密钥不能为空");

        try(ByteArrayOutputStream output = new ByteArrayOutputStream()){
            Cipher cipher = Cipher.getInstance(key.getAlgorithm());
            cipher.init(Cipher.ENCRYPT_MODE, key);

            int length = content.length;
            int offset = 0;
            int i      = 0;

            //对数据分段加密
            while(length - offset > 0){
                byte[] buffer = cipher.doFinal(content, offset, length - offset > maxBlock ? maxBlock : length - offset);

                output.write(buffer, 0, buffer.length);
                i++;
                offset = i * maxBlock;
            }

            return output.toByteArray();
        }catch(Exception e){
            throw new EncodeException(e.getMessage(), e);
        }
    }

    private static byte[] decode(byte[] content, Key key, int maxBlock) throws DecodeException{
        AssertUtils.notEmpty(content, "解密内容不能为空");
        AssertUtils.notNull(key, "密钥不能为空");

        try(ByteArrayOutputStream output = new ByteArrayOutputStream()){
            Cipher cipher = Cipher.getInstance(key.getAlgorithm());
            cipher.init(Cipher.DECRYPT_MODE, key);

            int length = content.length;
            int offset = 0;
            int i      = 0;

            //对数据分段解密
            while(length - offset > 0){
                byte[] buffer = cipher.doFinal(content, offset, length - offset > maxBlock ? maxBlock : length - offset);

                output.write(buffer, 0, buffer.length);
                i++;
                offset = i * maxBlock;
            }

            return output.toByteArray();
        }catch(Exception e){
            throw new DecodeException(e.getMessage(), e);
        }
    }
}
