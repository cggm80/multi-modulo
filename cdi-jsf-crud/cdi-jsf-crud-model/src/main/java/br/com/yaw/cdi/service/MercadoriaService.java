package br.com.yaw.cdi.service;

import java.util.List;

import javax.ejb.Local;

import br.com.yaw.cdi.model.Mercadoria;

@Local
public interface MercadoriaService {

	public Mercadoria save(Mercadoria mercadoria);
	
	public void remove(Mercadoria mercadoria);
	
	public Mercadoria find(Long id);
	
	public List<Mercadoria> findAll();

}
