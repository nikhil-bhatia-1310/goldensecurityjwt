package com.nik.golden.security.security;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Date;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

@Component
public class JWTGenerator {

    public String generateToken(Authentication authentication) throws NoSuchAlgorithmException, InvalidKeySpecException {
        String username = authentication.getName();
        Date currentDate = new Date();
        Date expireDate = new Date(currentDate.getTime() + SecurityConstants.JWT_EXPIRATION);
        
        Algorithm algorithm = Algorithm.HMAC256(SecurityConstants.JWT_SECRET);
        return JWT.create()
                .withIssuer(username)
                .withIssuedAt(currentDate)
                .withExpiresAt(expireDate)
                .sign(algorithm);
    }

    public String getUsernameFromJWT(String token) throws NoSuchAlgorithmException, InvalidKeySpecException {
        Algorithm algorithm = Algorithm.HMAC256(SecurityConstants.JWT_SECRET);

        JWTVerifier verifier = JWT
        						.require(algorithm)
                				.build();

        DecodedJWT decoded = verifier.verify(token);
        return decoded.getIssuer();
    }

    public boolean validateToken(String token) {
        try {
        	Algorithm algorithm = Algorithm.HMAC256(SecurityConstants.JWT_SECRET);

            JWTVerifier verifier = JWT.require(algorithm)
                    .build();
            verifier.verify(token);
        	return true;
        } catch (Exception ex) {
            throw new AuthenticationCredentialsNotFoundException("JWT was expired or incorrect");
        }
    }
}
