package it.schipani.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import it.schipani.businessLayer.services.security.SecurityUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;

import java.util.Date;


@Component
/*questa classe è un componente Spring che gestisce i token JWT per l'autenticazione e
 l'autorizzazione degli utenti*/
public class JwtUtils {

    private String securityKey = "password123password";
    private long expirationMs = 864000000;

    /*Questo metodo genera un JWT per un utente*/
    public String generateToken(Authentication auth) {
        byte[] keysBytes = securityKey.getBytes();
        Key key = Keys.hmacShaKeyFor(keysBytes);
        var employee = (SecurityUserDetails) auth.getPrincipal();
        return Jwts.builder()
                .subject(employee.getUsername())
                .issuedAt(new Date())
                .issuer("GestioneDispositivi")
                .expiration(new Date(new Date().getTime() + expirationMs))
                .signWith(key)
                .compact();
    }

    /* Utilizza il parser Jwts per verificare il token con la chiave.
Richiede che l'emittente (issuer) sia "GestioneDispositivi".
Se il token è valido, ritorna true. In caso di eccezione, ritorna false. */
    public boolean isTokenValid(String token) {
        try {
            byte[] keyBytes = securityKey.getBytes();
            SecretKey key = Keys.hmacShaKeyFor(keyBytes);
            Jwts.parser()
                    .verifyWith(key).requireIssuer("GestioneDispositivi");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /*Utilizza il parser Jwts per verificare e decodificare il token con la chiave.
Estrae il soggetto (subject) dal token, che in questo caso è il nome utente.*/
    public String getFullNameFromToken(String token) {
        byte[] keyBytes = securityKey.getBytes();
        SecretKey key = Keys.hmacShaKeyFor(keyBytes);
        var fullName = Jwts.parser()
                .verifyWith(key).build()
                .parseSignedClaims(token).getPayload().getSubject();
        return fullName;
    }
}
