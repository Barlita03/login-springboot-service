package org.example.controller;

import org.example.dto.LoginRequest;
import org.example.dto.LoginResponse;
import org.example.dto.RegisterRequest;
import org.example.model.Usuario;
import org.example.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

  private final AuthService authService;

  public AuthController(AuthService authService) {
    this.authService = authService;
  }

  @PostMapping("/login")
  public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
    String token = authService.login(request.getEmail(), request.getPassword());
    return ResponseEntity.ok(new LoginResponse(token));
  }

  @PostMapping("/register")
  public ResponseEntity<Usuario> register(@RequestBody RegisterRequest request) {
    Usuario usuario =
        authService.register(
            request.getNombre(), request.getApellido(), request.getEmail(), request.getPassword());
    return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
  }
}
