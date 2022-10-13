package com.example.marioradi.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.stream.Collectors;

@Service
public class JwtServiceImpl {


    public String generateJwtToken(User user, String issuer){
        return JWT.create()
                .withSubject(user.getUsername())
                .withIssuer(issuer)
                .withExpiresAt(new Date(System.currentTimeMillis() + 15778440000L))
                .withClaim("roles", user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .sign(Algorithm.HMAC256("secret"));
    }


    public DecodedJWT verifyJwtToken(String token){
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256("secret")).build();
        return verifier.verify(token);
    }






}
