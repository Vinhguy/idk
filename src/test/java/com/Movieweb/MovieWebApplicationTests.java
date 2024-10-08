//package com.Movieweb;
//
//import com.mysql.cj.log.Log;
//import jakarta.xml.bind.DatatypeConverter;
//import org.apache.logging.log4j.LogManager;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
//
//@SpringBootTest
//class MovieWebApplicationTests {
//    Logger logger = LogManager.getLogger(Mo)
//    void hash() throws NoSuchAlgorithmException {
//        String password = "123456";
//
//        MessageDigest md = MessageDigest.getInstance("MD5");
//        md.update(password.getBytes());
//
//        byte[] digest = md.digest();
//        String md5Hash = DatatypeConverter.printHexBinary(digest);
//
//        log.info("MD5 round 1: {}", md5Hash);
//
//        md.update(password.getBytes());
//        digest = md.digest();
//        md5Hash = DatatypeConverter.printHexBinary(digest);
//
//        log.info("MD5 round 2: {}", md5Hash);
//
//        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
//
//        log.info("BCrypt round 1: {}", passwordEncoder.encode(password));
//        log.info("BCrypt round 2: {}", passwordEncoder.encode(password));
//    }
//}
