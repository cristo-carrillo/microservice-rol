package com.rol.servicio.repositorio;

import com.rol.servicio.entidades.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolRepositorio extends JpaRepository<Rol, Integer> {

    List<Rol> findByUsuarioId(int usuarioId);


}
