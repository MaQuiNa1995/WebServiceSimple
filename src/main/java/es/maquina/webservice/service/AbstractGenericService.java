package es.maquina.webservice.service;

import java.io.Serializable;
import java.util.List;

import es.maquina.webservice.dto.AbstractDto;

/**
 * 
 * @author MaQuiNa1995
 *
 * @param <T> entidad
 * @param <K> id de la entidad
 * @param <D> dto
 */
public interface AbstractGenericService<T extends Serializable, K extends Serializable, D extends AbstractDto<K>> {

	T create(D dto);

	D find(K id);

	List<D> findAll();

	T update(D dto);

	void delete(K id);

}