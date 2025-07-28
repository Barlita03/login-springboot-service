package org.example.service;

import org.example.model.Rol;
import org.example.model.Usuario;
import org.example.repository.UsuarioRepository;
import org.example.security.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
  private final UsuarioRepository usuarioRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtUtil jwtUtil;

  public AuthService(
      UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
    this.usuarioRepository = usuarioRepository;
    this.passwordEncoder = passwordEncoder;
    this.jwtUtil = jwtUtil;
  }

  public String login(String email, String password) {
    Usuario usuario =
        usuarioRepository
            .findByEmail(email)
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

    if (!passwordEncoder.matches(password, usuario.getPassword())) {
      throw new RuntimeException("Contraseña incorrecta");
    }

    return jwtUtil.generarToken(usuario.getEmail());
  }

  public Usuario register(String nombre, String apellido, String email, String password) {
    if (usuarioRepository.findByEmail(email).isPresent()) {
      throw new RuntimeException("Ya existe un usuario con ese email");
    }

    String passwordHasheada = passwordEncoder.encode(password);

    Usuario nuevoUsuario = new Usuario(nombre, apellido, email, passwordHasheada, Rol.USUARIO);
    return usuarioRepository.save(nuevoUsuario);
  }
}
