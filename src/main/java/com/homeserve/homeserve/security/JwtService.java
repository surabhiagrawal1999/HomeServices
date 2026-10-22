package com.homeserve.homeserve.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtService {

@Value("${jwt.secret}")
private String jwtSecret;


    public String generateToken(String email){
        Date now= new Date();
        Date expDate = new Date(now.getTime()+15*60*1000);

        String token =Jwts.builder().subject(email).issuedAt(now).expiration(expDate).signWith(getSigningKey()).compact();

        return token;
    }

    public SecretKey getSigningKey(){

        //jwtSecret — reads the secret text from your configuration.
        //Decoders.BASE64.decode(jwtSecret) — converts that text into bytes.
        //Keys.hmacShaKeyFor(...) — turns those bytes into a cryptographic key.

        //secret text → bytes → usable key.
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));


    }
}
