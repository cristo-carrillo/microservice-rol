package com.rol.servicio.controlador;

import com.rol.servicio.entidades.Rol;
import com.rol.servicio.servicio.RolServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/rol")
@RestController
public class RolControlador {

    @Autowired
    private RolServicio rolServicio;

    @GetMapping
    public ResponseEntity<List<Rol>> listarRoles(){
        List<Rol> roles = rolServicio.getAll();
        if (roles.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(roles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rol> obtenerRol(@PathVariable("id")int id){
        Rol rol = rolServicio.getRolById(id);
        if (rol == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(rol);
    }

    @PostMapping
    public ResponseEntity<Rol> guardarRol(@RequestBody Rol rol){
        Rol nuevoRol = rolServicio.save(rol);
        return ResponseEntity.ok(nuevoRol);
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Rol>> listarRolesPorUsuarioId(@PathVariable("usuarioId")int id) {
        List<Rol> roles =rolServicio.byUsuarioId(id);
        if (roles.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(roles);
    }
}
