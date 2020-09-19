package com.example.demo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Persona;

@Repository
public interface Repositorio extends JpaRepository<Persona, Long>{

}