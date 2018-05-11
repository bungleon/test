package com.test.controller;

import com.test.model.request.SessionRequest;

import java.io.UnsupportedEncodingException;
import java.security.spec.*;
import java.util.Base64;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpSession;
import java.security.*;

@RestController
public class RSAController {

    @RequestMapping(value = "/rsakeygenerator", method = RequestMethod.POST)
    public String keyGenerator(@RequestBody SessionRequest sessionRequest, HttpSession session) throws NoSuchProviderException, NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = null;
        try {
            keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG", "SUN");
        // 1024, 2048, 4096, 8192, 16384, ....  bit
        //16384 üretmesi uzun sürüyor
        keyPairGenerator.initialize(8192,random);
        KeyPair keyPair = keyPairGenerator.genKeyPair();
        byte[] publicKey = keyPair.getPublic().getEncoded();
        byte[] privateKey = keyPair.getPrivate().getEncoded();
        session.setAttribute("privateKey",privateKey);
        session.setAttribute("publicKey",publicKey);



        return "Public Key = "+new String(publicKey)
                +"\nPrivate Key = "+new String(privateKey);
    }

    @RequestMapping(value = "/rsaencription", method = RequestMethod.POST)
    public String encriptRSA(@RequestBody String data, HttpSession session) throws BadPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeySpecException {
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        }
        byte[] key=(byte[]) session.getAttribute("publicKey");
        PublicKey publicKey = KeyFactory.getInstance("RSA")
                .generatePublic(new X509EncodedKeySpec(key));
        if(key!=null) {
            try {
                cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            } catch (InvalidKeyException e) {
                e.printStackTrace();
            }
        }
        byte[] sifreliMetin = cipher.doFinal(data.getBytes());
        return new String(Base64.getEncoder().encode(sifreliMetin));
    }

    @RequestMapping(value = "/rsadecription", method = RequestMethod.POST)
    public String decriptRSA(@RequestBody String data, HttpSession session) throws BadPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeySpecException {
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        }
        //Key publicKey=(Key) session.getAttribute("publicKey");
        byte[] key=(byte[])session.getAttribute("privateKey");
        PrivateKey privateKey = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(key));
        if(privateKey!=null) {
            try {
                //cipher.init(Cipher.ENCRYPT_MODE, publicKey);
                cipher.init(Cipher.DECRYPT_MODE, privateKey);
            } catch (InvalidKeyException e) {
                e.printStackTrace();
            }
        }
        byte[] desifreliMetin=desifreliMetin = cipher.doFinal(Base64.getDecoder().decode(data.getBytes()));

        return new String(desifreliMetin);
    }

    @RequestMapping(value = "/rsaencriptionbig", method = RequestMethod.POST)
    public String encriptRSABig(@RequestBody String data, HttpSession session) throws BadPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeySpecException, UnsupportedEncodingException {
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        }
        byte[] key=(byte[]) session.getAttribute("publicKey");
        PublicKey publicKey = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(key));
        if(key!=null) {
            try {
                cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            } catch (InvalidKeyException e) {
                e.printStackTrace();
            }
        }
        byte[] encrypted = blockCipher(data.getBytes("UTF-8"),Cipher.ENCRYPT_MODE,cipher);
        return new String(Base64.getEncoder().encode(encrypted));
    }

    @RequestMapping(value = "/rsadecriptionbig", method = RequestMethod.POST)
    public String decriptRSABig(@RequestBody String data, HttpSession session) throws BadPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeySpecException, UnsupportedEncodingException {
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        }
        //Key publicKey=(Key) session.getAttribute("publicKey");
        byte[] key=(byte[])session.getAttribute("privateKey");
        PrivateKey privateKey = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(key));
        if(privateKey!=null) {
            try {
                //cipher.init(Cipher.ENCRYPT_MODE, publicKey);
                cipher.init(Cipher.DECRYPT_MODE, privateKey);
            } catch (InvalidKeyException e) {
                e.printStackTrace();
            }
        }
        byte[] decripted = blockCipher(Base64.getDecoder().decode(data.getBytes()),Cipher.DECRYPT_MODE,cipher);

        return new String(decripted);
    }

    private byte[] blockCipher(byte[] bytes, int mode,Cipher cipher ) throws IllegalBlockSizeException, BadPaddingException{
        byte[] scrambled = new byte[0];
        byte[] toReturn = new byte[0];
        // if we encrypt we use 100 byte long blocks. Decryption requires 128 byte long blocks (because of RSA)
        //1024/8-11
        //int length = (mode == Cipher.ENCRYPT_MODE)? 117 : 128;
        //2048/8-11
        //int length = (mode == Cipher.ENCRYPT_MODE)? 245 : 256;
        //4096/8-11
        //int length = (mode == Cipher.ENCRYPT_MODE)? 501 : 512;
        //8192/8-11
        int length = (mode == Cipher.ENCRYPT_MODE)? 1013 : 1024;
        //16384/8-11
        //int length = (mode == Cipher.ENCRYPT_MODE)? 2037 : 2048;
        // another buffer. this one will hold the bytes that have to be modified in this step
        byte[] buffer = new byte[length];

        for (int i=0; i< bytes.length; i++){

            // if we filled our buffer array we have our block ready for de- or encryption
            if ((i > 0) && (i % length == 0)){
                //execute the operation
                scrambled = cipher.doFinal(buffer);
                // add the result to our total result.
                toReturn = append(toReturn,scrambled);
                // here we calculate the length of the next buffer required
                int newlength = length;

                // if newlength would be longer than remaining bytes in the bytes array we shorten it.
                if (i + length > bytes.length) {
                    newlength = bytes.length - i;
                }
                // clean the buffer array
                buffer = new byte[newlength];
            }
            // copy byte into our buffer.
            buffer[i%length] = bytes[i];
        }

        // this step is needed if we had a trailing buffer. should only happen when encrypting.
        // example: we encrypt 110 bytes. 100 bytes per run means we "forgot" the last 10 bytes. they are in the buffer array
        scrambled = cipher.doFinal(buffer);

        // final step before we can return the modified data.
        toReturn = append(toReturn,scrambled);

        return toReturn;
    }

    private byte[] append(byte[] prefix, byte[] suffix){
        byte[] toReturn = new byte[prefix.length + suffix.length];
        for (int i=0; i< prefix.length; i++){
            toReturn[i] = prefix[i];
        }
        for (int i=0; i< suffix.length; i++){
            toReturn[i+prefix.length] = suffix[i];
        }
        return toReturn;
    }


}
