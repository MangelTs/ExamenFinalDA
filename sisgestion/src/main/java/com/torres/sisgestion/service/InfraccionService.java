package com.torres.sisgestion.service;

import java.util.List;

import com.torres.sisgestion.entity.Infraccion;

public interface InfraccionService {
	public List<Infraccion> finAll();
	public Infraccion findById(int id);
	public Infraccion findByDni(String dni);
	public Infraccion create(Infraccion obj);
	public Infraccion update(Infraccion obj);
	public int delete(int id);
}
