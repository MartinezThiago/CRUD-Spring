package com.example.democrud.services;


import com.example.democrud.interfaceService.IpersonaService;
import com.example.democrud.interfaces.IPersona;
import com.example.democrud.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService implements IpersonaService {

    @Autowired
    private IPersona data;

    @Override
    public List<Persona> listar() {
        Iterable<Persona> li= data.findAll();
        return (List<Persona>) li;
    }
    @Override
    public Optional<Persona> listarId(int id) {

        return data.findById(id);
    }

    @Override
    public int save(Persona p) {
        int res=0;
        Persona persona=data.save(p);
        if (!persona.equals(null)){
            res=1;
        }
        return res;
    }

    @Override
    public void delete(int id) {
        data.deleteById(id);
    }
}
