package com.example.demo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.ResourceNotFoundException;
import com.example.demo.Persona;
import com.example.demo.Controlador;


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/apiv1")
public class Controlador {
	@Autowired
    private Repositorio repositorio;
	
	
	

	
    @GetMapping("/personas")
    public List<Persona> getAllPersonas() {
        return repositorio.findAll();
    }
    
    
    
    @GetMapping("/personas/{id}")
    public ResponseEntity<Persona> getPersonaById(@PathVariable(value = "id") Long personaId)
    	throws ResourceNotFoundException {
        Persona employee = repositorio.findById(personaId)
          .orElseThrow(() -> new ResourceNotFoundException("La persona no fue encontrada con el id :: " + personaId));
        return ResponseEntity.ok().body(employee);
    }

    @PostMapping("/personas")
    public Persona createEmployee(@Valid @RequestBody Persona persona) {
        return repositorio.save(persona);
    }
    
    @PutMapping("/personas/{id}")
    public ResponseEntity<Persona> updatePersona(@PathVariable(value = "id") Long personaId,
         @Valid @RequestBody Persona personaDetails) throws ResourceNotFoundException {
        Persona persona = repositorio.findById(personaId)
        .orElseThrow(() -> new ResourceNotFoundException("La persona no fue encontrada con el id  :: " + personaId));
        
        persona.setApellidos((personaDetails.getApellidos()));
        persona.setName((personaDetails.getName()));
        persona.setiddoc((personaDetails.getiddoc()));
        persona.setresidencia((personaDetails.getresidencia()));
        persona.setEmail((personaDetails.getEmail()));
        persona.setuser((personaDetails.getuser()));
        persona.setpass((personaDetails.getpass()));
        persona.settelef((personaDetails.gettelef()));
        final Persona updatedPersona = repositorio.save(persona);
        return ResponseEntity.ok(updatedPersona);
    }
    

    @DeleteMapping("/personas/{id}")
    public Map<String, Boolean> deletePersona(@PathVariable(value = "id") Long personaId)
         throws ResourceNotFoundException {
        Persona persona = repositorio.findById(personaId)
       .orElseThrow(() -> new ResourceNotFoundException("La persona no fue encontrada con el id :: " + personaId));

        repositorio.delete(persona);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}