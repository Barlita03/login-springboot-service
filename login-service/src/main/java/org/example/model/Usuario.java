package org.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nombre;
  private String apellido;

  @Column(nullable = false, unique = true)
  private String email;

  @Column(nullable = false)
  private String password;

  @Enumerated(EnumType.STRING)
  private Rol rol;

  // --- Constructores ---

  protected Usuario() {}

  public Usuario(String nombre, String apellido, String email, String password, Rol rol) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.email = email;
    this.password = password;
    this.rol = rol;
  }

  // --- Getters ---

  public Long getId() {
    return id;
  }

  public String getNombre() {
    return nombre;
  }

  public String getApellido() {
    return apellido;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public Rol getRol() {
    return rol;
  }

  // ---  Setters ---

  public void setPassword(String password) {
    this.password = password;
  }

  public void setRol(Rol rol) {
    this.rol = rol;
  }
}
