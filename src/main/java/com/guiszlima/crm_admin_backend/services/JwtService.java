package com.guiszlima.crm_admin_backend.services;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

@Service
public class JwtService {

    // Chave secreta para assinar o token. Em produção, deve ser lida de um arquivo
    // de configuração.
    private static final String SECRET_KEY = "SuaChaveSecretaMuitoLongaParaAssinarJWTs";

    // Gera um token JWT com base nos dados do usuário
    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, username);
    }

    // Cria o token com data de expiração
    private String createToken(Map<String, Object> claims, String username) {
        return Jwts.builder()
                .claims(claims)
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30)) // 30 minutos
                .signWith(getSignInKey())
                .compact();
    }

    // Retorna a chave de assinatura decodificada
    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public boolean validateToken(String token) {
        try {
            // Converte a string da chave para SecretKey
            SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));

            // Cria o parser e valida o token
            Jwts.parser()
                    .decryptWith(key)
                    .build()
                    .parseSignedClaims(token);

            return true;
        } catch (JwtException e) {
            // Token inválido ou expirado
            return false;
        }
        // Em uma aplicação real, você também teria métodos para validar o token.
        // public boolean validateToken(String token, UserDetails userDetails) { ... }
    }
}