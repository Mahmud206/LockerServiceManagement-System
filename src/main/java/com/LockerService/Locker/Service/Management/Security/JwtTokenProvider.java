package com.LockerService.Locker.Service.Management.Security;

import com.LockerService.Locker.Service.Management.Exception.LockerServiceAPIException;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenProvider {
    @Value("${app.jwt-secret}")
    private String jwtSecret;
    @Value("${app.jwt-expiration-milliseconds}")
    private int jwtExpirationInMs;


    //Generate Token
    public String generateToken(Authentication authentication){
        String username = authentication.getName();
        Date currentDate = new Date();
        Date expireDate = new Date(currentDate.getTime() + jwtExpirationInMs);

        String token = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();

        return token;
    }

    //get username from the token
    public String getUserNameFromJwt(String token){

        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    //validate JWT token

    public boolean validateToken(String token)
    {
        try{
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        }catch (SignatureException ex){
            throw new LockerServiceAPIException(HttpStatus.BAD_REQUEST, "Invalid JWT Signature");
        }catch (MalformedJwtException ex){
            throw new LockerServiceAPIException(HttpStatus.BAD_REQUEST, "Invalid JWT Token");
        }catch (ExpiredJwtException ex){
            throw new LockerServiceAPIException(HttpStatus.BAD_REQUEST, "Expired JWT Token");
        }catch (UnsupportedJwtException ex){
            throw new LockerServiceAPIException(HttpStatus.BAD_REQUEST, "Unsupported JWT Signature");
        }catch (IllegalArgumentException ex){
            throw new LockerServiceAPIException(HttpStatus.BAD_REQUEST, "JWT claims string is empty!");
        }
    }

}
