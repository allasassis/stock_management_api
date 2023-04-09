package stock.management.api_stock.controllers;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import stock.management.api_stock.dto.DataAuthentication;
import stock.management.api_stock.dto.DataJWTtoken;
import stock.management.api_stock.models.User;
import stock.management.api_stock.security.AuthenticationCentral;
import stock.management.api_stock.security.TokenService;

@RestController
@RequestMapping("/authentication")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationCentral authenticationCentral;

    @PostMapping
    @Transactional
    public ResponseEntity<DataJWTtoken> authenticationLogin(@RequestBody DataAuthentication dataAuthentication) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(dataAuthentication.username(), dataAuthentication.password());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        String token = tokenService.generateToken((User) authenticate.getPrincipal());

        return ResponseEntity.ok(new DataJWTtoken(token));
    }

    @PostMapping("/new")
    @Transactional
    public ResponseEntity<DataJWTtoken> signUp(@RequestBody DataAuthentication dataAuthentication) {
        User user = authenticationCentral.cryptography(dataAuthentication);
        String token = tokenService.generateToken(user);
        return ResponseEntity.ok(new DataJWTtoken(token));
    }
}
