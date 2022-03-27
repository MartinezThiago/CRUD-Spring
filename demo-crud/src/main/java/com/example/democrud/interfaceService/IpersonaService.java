package com.example.democrud.interfaceService;


import com.example.democrud.model.Persona;

import java.util.List;
import java.util.Optional;

public interface IpersonaService {
    public List<Persona> listar();
    public Optional<Persona> listarId(int id);
    public int save(Persona p);
    public void delete(int id);


}
