package com.sot.springSecurity;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.encrypt.BytesEncryptor;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.keygen.KeyGenerators;

@SpringBootApplication
public class SpringSecurityApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
	}

    @Bean
    public BytesEncryptor aesBytesEncryptor(){
        String password = "hackme";
        String salt = "8560b4f4b3";
        return Encryptors.standard(password,salt);
    }

    @Bean
    public TextEncryptor hexEncodingTextEncryptor(){
        String password = "hackme";
        String salt = KeyGenerators.string().generateKey();
        System.out.println("Salt - " + salt);
        return Encryptors.text(password,salt);
    }

    @Override
    public void run(String... args) throws Exception {
        BytesEncryptor bytesEncryptor = aesBytesEncryptor();
        TextEncryptor textEncryptor = hexEncodingTextEncryptor();

        byte[] inputData = {104, 121, 112, 101, 114, 115, 107, 105, 108, 108};
        byte[] encryptedData = bytesEncryptor.encrypt(inputData);
        byte[] decryptedData = bytesEncryptor.decrypt(encryptedData);

        String inputString = "hyperskill";
        String encryptedString = textEncryptor.encrypt(inputString);
        String decryptedString = textEncryptor.decrypt(encryptedString);


        System.out.println("Input data: " + new String(inputData));
        System.out.println("Encrypted data: " + new String(encryptedData));
        System.out.println("Decrypted data: " + new String(decryptedData));

        System.out.println("---------------------------------------------------------------------------------------");

        System.out.println("Input string: " + inputString);
        System.out.println("Encrypted string: " + encryptedString);
        System.out.println("Decrypted string: " + decryptedString);
    }
}
