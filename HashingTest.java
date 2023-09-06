/**
 * This file shows how to use MD5 algorithm in java to hash a text using salt.
 * MD5 with or without salt is discouraged to store passowrd as they can be easily decrypted these days
 * with many precomputed hash.
 * e.g: https://www.dcode.fr/md5-hash
 * Include below dependency for DatatypeConverter
 * 		<dependency>
			<groupId>javax.xml.bind</groupId>
			<artifactId>jaxb-api</artifactId>
			<version>2.4.0-b180830.0359</version>
		</dependency>

    Or include the jar file during compilation and run.
    Compilation command:  javac -cp "C:/Users/macma/.m2/repository/javax/xml/bind/jaxb-api/2.4.0-b180830.0359/jaxb-api-2.4.0-b180830.0359.jar" HashingTest.java
    Run Command: java -classpath "C:\Users\macma\lvm;C:/Users/macma/.m2/repository/javax/xml/bind/jaxb-api/2.4.0-b180830.0359/jaxb-api-2.4.0-b180830.0359.jar" HashingTest
    Path of Workgin Directory = C:\Users\macma\lvm
 */
import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.UUID;


public class HashingTest {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String message = "manas";
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        String salt = UUID.randomUUID().toString();
        System.out.println("Salt: " + salt);
        messageDigest.update(salt.getBytes(StandardCharsets.UTF_8));
        messageDigest.update(message.getBytes(StandardCharsets.UTF_8));

        byte[] digest = messageDigest.digest();
        String myHash = DatatypeConverter.printHexBinary(digest).toLowerCase(Locale.ROOT);

        System.out.println(myHash);
        // print binary representation of the hash (total 128 bits)
        for (byte b : digest) {
            System.out.println(Integer.toBinaryString(b & 255 | 256).substring(1));
        }
    }
}