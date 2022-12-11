package com.rol.servicio.servicio;

import com.rol.servicio.entidades.Rol;
import com.rol.servicio.repositorio.RolRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolServicio {

    @Autowired
    private RolRepositorio rolRepositorio;

    public List<Rol> getAll(){
        return rolRepositorio.findAll();
    }

    public   Rol getRolById(int id){
        return rolRepositorio.findById(id).orElse(null);
    }

    public Rol save(Rol rol){
        Rol nuevoRol = rolRepositorio.save(rol);
        return nuevoRol;
    }

    public List<Rol> byUsuarioId(int usuarioId){
        return rolRepositorio.findByUsuarioId(usuarioId);
    }
}