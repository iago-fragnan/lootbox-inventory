package dev.iagof.lootbox.helpers;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import dev.iagof.lootbox.models.User;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

public class JWTHelper {

    private static RSAPublicKey rsaPublicKey;
    private static RSAPrivateKey rsaPrivateKey;

    public static String authSigning(User model){
        try {
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
            kpg.initialize(1024);
            KeyPair kp = kpg.generateKeyPair();
            rsaPrivateKey = (RSAPrivateKey) kp.getPrivate();
            rsaPublicKey = (RSAPublicKey) kp.getPublic();
            Algorithm algorithm = Algorithm.RSA256(rsaPublicKey, rsaPrivateKey);
            String token = JWT.create()
                    .withIssuer("auth0")
                    .withClaim("userSessionToken", "{email}:+-{pass};+={user}".replace("{email}", model.getEmail()).replace("{pass}", model.getPassword()).replace("{user}", model.getName()))
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException exception){
            return null;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
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

}
