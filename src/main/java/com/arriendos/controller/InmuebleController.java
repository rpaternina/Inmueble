package com.arriendos.controller;

import com.arriendos.entity.Inmueble;
import com.arriendos.service.InmuebleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class InmuebleController {

    private final InmuebleService inmuebleService;

    @PostMapping("/crear-inmueble")
    public ResponseEntity<Inmueble> crear(@RequestBody Inmueble inmueble) {
        Inmueble nuevo = inmuebleService.crear(inmueble);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

}
