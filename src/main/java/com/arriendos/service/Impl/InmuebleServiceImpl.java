package com.arriendos.service.Impl;

import com.arriendos.entity.Inmueble;
import com.arriendos.repository.InmuebleRepository;
import com.arriendos.service.InmuebleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InmuebleServiceImpl implements InmuebleService {

    private final InmuebleRepository inmuebleRepository;

    @Override
    public Inmueble crear(Inmueble inmueble){
        return inmuebleRepository.save(inmueble);
    }
}
