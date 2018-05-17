package com.test.cryptography;

import org.springframework.util.StreamUtils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Base64;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class ResolveKey {

	private String key = "75b217cb14126724f72f59499cc6cbf6";

	private byte[] iv = DatatypeConverter.parseHexBinary("0F6F132E35C2CDF905469CEAA84B73CC");

	public String encrypt(String str) throws Exception {
		return Base64.getMimeEncoder().encodeToString(compress(Base64.getMimeEncoder().encodeToString(getCipher(1).doFinal(str.getBytes("UTF-8")))));
	}

	public String decrypt(String str) throws Exception {
		return new String(getCipher(2).doFinal(Base64.getMimeDecoder().decode(decompress(Base64.getMimeDecoder().decode(str)).getBytes("UTF-8"))));
	}

	private Cipher getCipher(int cryptMode) throws Exception {
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		Key secretKeySpec = new SecretKeySpec(this.key.getBytes("UTF-8"), "AES");
		AlgorithmParameterSpec ivParameterSpec = new IvParameterSpec(this.iv);
		cipher.init(cryptMode, secretKeySpec, ivParameterSpec);
		return cipher;
	}

	public String decompress(byte[] data) {
		try {
			GZIPInputStream gzipInputStream = new GZIPInputStream(new ByteArrayInputStream(data));
			return StreamUtils.copyToString(gzipInputStream, Charset.forName("UTF-8"));
		} catch (Exception e) {

		}
		return "";
	}

	public byte[] compress(String str) {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(str.length());
		byte[] bArr;
		try {
			GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
			gZIPOutputStream.write(str.getBytes());
			gZIPOutputStream.close();
			bArr = byteArrayOutputStream.toByteArray();
			byteArrayOutputStream.close();
		} catch (IOException e) {
			return null;
		}
		return bArr;
	}
}



