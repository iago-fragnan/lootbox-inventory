package dev.iagof.lootbox.helpers;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import dev.iagof.lootbox.enumerables.Roles;
import dev.iagof.lootbox.models.User;

import javax.management.relation.Role;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Date;
import java.util.UUID;

public class JWTHelper {

    private static RSAPublicKey rsaPublicKey;
    private static RSAPrivateKey rsaPrivateKey;

    public static void init(){
        if(rsaPublicKey != null && rsaPrivateKey != null) return;
        try {
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
            kpg.initialize(1024);
            KeyPair kp = kpg.generateKeyPair();
            rsaPrivateKey = (RSAPrivateKey) kp.getPrivate();
            rsaPublicKey = (RSAPublicKey) kp.getPublic();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public static String authSigning(User model){
        try {
            Algorithm algorithm = Algorithm.RSA256(rsaPublicKey, rsaPrivateKey);
            return JWT.create()
                    .withIssuer("auth0")
                    .withClaim("id", model.getId().toString())
                    .withClaim("name", model.getName())
                    .withClaim("email", model.getEmail())
                    .withClaim("pass", model.getPassword())
                    .withClaim("role", model.getRole().toString())
                    .withExpiresAt(new Date(System.currentTimeMillis() + 3600000))
                    .sign(algorithm);

        } catch (JWTCreationException exception){
            return null;
        }

    }

    public static boolean validate(String token){
        DecodedJWT decodedJWT;
        try {
            Algorithm algorithm = Algorithm.RSA256(rsaPublicKey, rsaPrivateKey);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("auth0")
                    .build();

            decodedJWT = verifier.verify(token);
            return true;
        } catch (JWTVerificationException exception){
            return false;
        }
    }

    public static User getUserByToken(String token){
        try{
            Algorithm algorithm = Algorithm.RSA256(rsaPublicKey, rsaPrivateKey);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("auth0")
                    .build();

            DecodedJWT jwt = verifier.verify(token);
            User user = new User();
            user.setName(jwt.getClaim("name").toString());
            user.setEmail(jwt.getClaim("email").toString());
            user.setPassword(jwt.getClaim("pass").toString());
            user.setId(UUID.fromString(jwt.getClaim("id").asString()));
            user.setRole(Roles.valueOf(jwt.getClaim("role").asString()));

            return user;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean isAdmin(String token) {
        try {
            Algorithm algorithm = Algorithm.RSA256(rsaPublicKey, rsaPrivateKey);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("auth0")
                    .build();

            DecodedJWT jwt = verifier.verify(token);
            String role = jwt.getClaim("role").asString();
            return "admin".equals(role);

        } catch (JWTVerificationException exception) {
            return false;
        }
    }

}
