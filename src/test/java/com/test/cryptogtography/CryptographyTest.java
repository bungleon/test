package com.test.cryptogtography;

import com.test.cryptography.ResolveKey;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.postgresql.util.Base64;

@RunWith(MockitoJUnitRunner.class)
public class CryptographyTest {
	ResolveKey resolveKey = new ResolveKey();
	@Test
	public void solveLoginRequest() throws Exception {
		String value ="H4sIAAAAAAAAAAXBycJCQAAA4LtXcUCyHf6DGiNksmXplp2xa1BP/3+fgABwFpw7OugDnz3sNCVq\n" +
				"4B/lmzaagdWYskvLVQR40CLIMSQYcAZOHLbuBdRWTTKbQuOSKq3ju0ztsDbpdW7gRvZ19e6vi02z\n" +
				"NUqVzI2HSgAir9sXrfjokRrPs3qp4gh3GXO5geD9FPIsqJ/MW9mJdf3lVGEojyHDHeeZcgLjXdIy\n" +
				"P0zMii+wl47lYGyL6QC9/r0sSXCcxh43rx9IHJxxiTe+4snKzO6vrVHTUHRPKuAyIXp1bmqKn1D8\n" +
				"CSRCWacyLu2AYlZp8/UdTP9hycag1EP+hMkU04I2lD3MuzVo5b4tyzGLaSr/cNecRUeGptPk33YT\n" +
				"+bUXsd0TDypAL4v51OI1WPS4kK4efZqRgt2wTfMIi99Zi2icPx4rkbzSyXYqdJeQKYC8ChFsAiX6\n" +
				"AVmCBkqeBldeOX5kfsAWxhgu7jW6efvZPKQUkbLsc/KwKtoY6wRti8uwezFR/k1eJ91nHWe3+PVN\n" +
				"1KG0xMTJUttt4bYoURJJOqf2u+3qqhnlPGqF8RmHfAd7iU3MLw2PN0m+GWEv1BEK3H3Tz3Fn0dz5\n" +
				"mDIOIKi2e3YyLT4163BVjMD28LHUPaPWosafpYtsTSnn+ew9niv374/6B4+T901gAgAA\n";

		String firstValue=resolveKey.decrypt(value);
		System.out.println(firstValue);
	}

	@Test
	public void solveLoginResponse() throws Exception {
		String value ="H4sIAAAAAAAEAAXB2aJCQAAA0A/qQYzEI9lu1iLbW4xtxhjESF9/zxGKryCmrSG75RABF0HifUPX/VXO8Fdxn7qBQmDGFx/ps80OuYaniueLQTldZu4hvVWKapU1p7RafW3S/DCBG3YwNJx5KRW8eV8woreKzfObLIx5n2oPhXEYy8FtypWDPEyZnJg8mEjkHu1rQnmRgHA2hoQMYbdiaBrnXCjvN+Xajh80mxaFNNdRJz2yR8buPfC8lu48l8qsZorbfLIlrl5qDigHjXA9RG7uNnWx+A3kdhCJLS8jaR8j6ZnYzw3gnJ6GCENf2UUts6TjsRa3fSPivoJ4jH9PYuvXu8HFSUZsb6epnsZqqFyneRbiYqE+6mGrOzHuLyCyUqXMVqs/94WWB64ssCfBzV0fR9BZtoMP56wRf18aEAQ3XhZprf4DCzgQd4ABAAA=";
		String firstValue=resolveKey.decrypt(value);
		System.out.println(firstValue);

	}


	@Test
	public void encryptR() throws Exception {
		String value = "{\n" +
				"  \"ApplicationName\": \"Mozaik\",\n" +
				"  \"Version\": \"4.3.1\",\n" +
				"  \"UserLoginInfoList\": [],\n" +
				"  \"Platform\": 1,\n" +
				"  \"ChannelId\": 5,\n" +
				"  \"AppName\": \"Android MobileBranch\",\n" +
				"  \"ExtUSessionKey\": \"ejANz9x263FnRwB0fkl281Wki4ZoiZbpghHeQotpy0UBgz\\/3d69tb\\/emnFwog8JugBSXgKzLkEr4JvMv1InOvi4fZ+9cJmF5tKLK8+MIe1dF5T9TATcRAJJzLmQeHAyhpIIgEdZKmqOWBm5thZX3xQ==\",\n" +
				"  \"LanguageId\": 2,\n" +
				"  \"MainResourceCode\": \"MOBRMAINPG\",\n" +
				"  \"MainResourceId\": 8955,\n" +
				"  \"SmsContentType\": 0\n" +
				"}";
		String encValue = resolveKey.encrypt(value);
		System.out.println(encValue);
	}

	@Test
	public void base64Decode() {
		StringBuilder sb = new StringBuilder();
		sb.append("W3sicCI6Ii9JbnRlcm5ldFxcL2luZGV4XFwuYXNweC9pIiwidCI6W3siZSI6ImxvYWQifV0sInRnIjpbXSwicyI6IjYwMDAwIiwiYyI6eyJkb20uYmxvY2txdW90ZSI6eyJtIjpbeyJ0IjoiYXR0cmlidXRlIiwibiI6InRpdGxlIiwiZiI6InBsYWluIiwiZmkiOltdLCJ0ciI6W3sibXQiOiJ0b1N0cmluZyIsInByIjpbXX1dLCJyIjpbXX1dfSwiZG9tLmRpdiI6eyJtIjpbeyJ0IjoiYXR0cmlidXRlIiwibiI6ImlkIiwiZiI6InBsYWluIiwiZmkiOltdLCJ0ciI6W3sibXQiOiJ0b1N0cmluZyIsInByIjpbXX1dLCJyIjpbXX1dfSwianMiOnsibSI6W3sidCI6ImF0dHJpYnV0ZSIsIm4iOiJrZXkiLCJmIjoicGxhaW4iLCJmaSI6W10sInRyIjpbeyJtdCI6InRvU3RyaW5nIiwicHIiOltdfV0sInIiOltdfV19fSwiYiI6bnVsbCwiaXQiOm51bGx9LHsicCI6Ii9JbnRlcm5ldFxcL0Rhc2hib2FyZFxcLmFzcHgvaSIsInQiOlt7ImUiOiJsb2FkIn1dLCJ0ZyI6W10sInMiOiI2MDAwMCIsImMiOnsiZG9tLmJsb2NrcXVvdGUiOnsibSI6W3sidCI6ImF0dHJpYnV0ZSIsIm4iOiJ0aXRsZSIsImYiOiJwbGFpbiIsImZpIjpbXSwidHIiOlt7Im10IjoidG9TdHJpbmciLCJwciI6W119XSwiciI6W119XX0sImRvbS5kaXYiOnsibSI6W3sidCI6ImF0dHJpYnV0ZSIsIm4iOiJpZCIsImYiOiJwbGFpbiIsImZpIjpbXSwidHIiOlt7Im10IjoidG9TdHJpbmciLCJwciI6W119XSwiciI6W119XX0sImpzIjp7Im0iOlt7InQiOiJhdHRyaWJ1dGUiLCJuIjoia2V5IiwiZiI6InBsYWluIiwiZmkiOltdLCJ0ciI6W3sibXQiOiJ0b1N0cmluZyIsInByIjpbXX1dLCJyIjpbXX1dfX0sImIiOm51bGwsIml0IjpudWxsfSx7InAiOiIvSW50ZXJuZXQvaSIsInQiOlt7ImUiOiJsb2FkIn1dLCJ0ZyI6W10sInMiOiI2MDAwMCIsImMiOnsiZG9tLmJsb2NrcXVvdGUiOnsibSI6W3sidCI6ImF0dHJpYnV0ZSIsIm4iOiJ0aXRsZSIsImYiOiJwbGFpbiIsImZpIjpbXSwidHIiOlt7Im10IjoidG9TdHJpbmciLCJwciI6W119XSwiciI6W119XX0sImRvbS5kaXYiOnsibSI6W3sidCI6ImF0dHJpYnV0ZSIsIm4iOiJpZCIsImYiOiJwbGFpbiIsImZpIjpbXSwidHIiOlt7Im10IjoidG9TdHJpbmciLCJwciI6W119XSwiciI6W119XX0sImRvbS5zY3JpcHQiOnsibSI6W3sidCI6ImF0dHJpYnV0ZSIsIm4iOiJpZCIsImYiOiJwbGFpbiIsImZpIjpbXSwidHIiOlt7Im10IjoidG9TdHJpbmciLCJwciI6W119XSwiciI6W119XX0sImpzIjp7Im0iOlt7InQiOiJhdHRyaWJ1dGUiLCJuIjoia2V5IiwiZiI6InBsYWluIiwiZmkiOltdLCJ0ciI6W3sibXQiOiJ0b1N0cmluZyIsInByIjpbXX1dLCJyIjpbXX1dfX0sImIiOm51bGwsIml0IjpudWxsfV0=");
		System.out.println(new String(Base64.decode(sb.toString())));
	}

}
