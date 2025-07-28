package org.example.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {
  private static final String secretKey = "clave-secreta-ultrasegura";

  public String generarToken(String email) {
    return Jwts.builder()
        .setSubject(email)
        .setIssuedAt(new Date())
        .setExpiration(
            Date.from(LocalDateTime.now().plusDays(1).atZone(ZoneId.systemDefault()).toInstant()))
        .signWith(SignatureAlgorithm.HS256, secretKey)
        .compact();
  }

  public String extraerEmail(String token) {
    return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
  }
}
