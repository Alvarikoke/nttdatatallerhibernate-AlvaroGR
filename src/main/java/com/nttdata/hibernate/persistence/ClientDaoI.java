package com.nttdata.hibernate.persistence;

import java.util.List;

/**
 * Taller 1 y 2 de Hibernate de las practicas Dual de NTT Data
 * 
 * Interfaz DAO de tabla CLIENT
 * 
 * @author Alvaro Gonzalez Rando
 *
 */
public interface ClientDaoI extends CommonDaoI<Client> {

	// METODOS CONCRETOS DE LA TABLA

	/**
	 * Obtiene clientes por nombre.
	 * 
	 * @param name
	 * @return List<Client>
	 */
	public List<Client> searchByName(final String clientName, final String clientFirstSurname,
			final String clientSecondSurname);

	List<Client> searchByNameAndContractId(String namePattern, Long contractId);

}