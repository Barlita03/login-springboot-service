package org.example.dto;

public class RegisterRequest {
  private String nombre;
  private String apellido;
  private String email;
  private String password;

  // --- Getters ---

  public String getNombre() {
    return nombre;
  }

  public String getApellido() {
    return apellido;
  }

  public String getPassword() {
    return password;
  }

  public String getEmail() {
    return email;
  }

  // --- Setters ---

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
