package com.torres.sisgestion.res;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.torres.sisgestion.entity.Infraccion;
import com.torres.sisgestion.service.InfraccionService;


@RestController
@RequestMapping("/api/infracciones")
public class InfraccionApi {
	@Autowired
	private InfraccionService service;
	
	@GetMapping()
	public ResponseEntity<List<Infraccion>> getAll(){
		List<Infraccion> infracciones= service.finAll();
		return ResponseEntity.status(HttpStatus.OK).body(infracciones);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Infraccion> getById(@PathVariable("id") int id) {
		Infraccion infraccion = service.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(infraccion);
	}
	
	@PostMapping
	public ResponseEntity<Infraccion> create(@RequestBody Infraccion infraccion) {
		Infraccion infraccionDb=service.create(infraccion);
		return ResponseEntity.status(HttpStatus.CREATED).body(infraccionDb);
	}
	
	@PutMapping
	public ResponseEntity<Infraccion> update(@RequestBody Infraccion infraccion) {
		Infraccion infraccionDb=service.update(infraccion);
		return ResponseEntity.status(HttpStatus.OK).body(infraccionDb);
	}
	
	@RequestMapping(value = "/{id}", method = {RequestMethod.GET, RequestMethod.PUT})
	public ResponseEntity<Infraccion> getOrEditById(@PathVariable("id") int id, @RequestBody(required = false) Infraccion infraccion) {
	    if (infraccion == null) {
	        // Si no se proporciona el cuerpo de la solicitud (null), entonces es una solicitud GET para obtener detalles
	        Infraccion infraccionDb = service.findById(id);
	        return ResponseEntity.status(HttpStatus.OK).body(infraccionDb);
	    } else {
	        // Si se proporciona el cuerpo de la solicitud, entonces es una solicitud PUT para actualizar
	    	Infraccion infraccionDb = service.update(infraccion);
	        return ResponseEntity.status(HttpStatus.OK).body(infraccionDb);
	    }
	}

	
	@DeleteMapping(value="/{id}")
	public int delete(@PathVariable("id") int id){
		return service.delete(id);
	}
}
