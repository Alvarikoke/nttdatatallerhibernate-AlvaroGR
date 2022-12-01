package com.nttdata.hibernate.services;

import java.util.List;

import com.nttdata.hibernate.persistence.Client;
import com.nttdata.hibernate.persistence.Contract;

/**
 * Taller 1 y 2 de Hibernate de las practicas Dual de NTT Data
 * 
 * Interfaz del servicio cliente
 * 
 * @author Alvaro Gonzalez Rando
 *
 */
public interface ClientManagementServiceI {

	/**
	 * Inserta un nuevo cliente.
	 * 
	 * @param newClient
	 */
	public void insertNewClient(final Client newClient);

	/**
	 * Actualiza un cliente existente.
	 * 
	 * @param updatedClient
	 */
	public void updateClient(final Client updatedClient);

	/**
	 * Elimina un cliente existente.
	 * 
	 * @param deletedClient
	 */
	public void deleteClient(final Client deletedClient);

	/**
	 * Obtiene un cliente mediante su ID.
	 * 
	 * @param clientID
	 */
	public Client searchById(final Long clientID);

	/**
	 * Obtiene todos los clientes existentes.
	 * 
	 * @return List<Client>
	 */
	public List<Client> searchAll();

	/**
	 * Inserta un nuevo contrato.
	 * 
	 * @param newContract
	 */
	public void insertNewContract(final Contract newContract);

	/**
	 * Actualiza un Contrato existente.
	 * 
	 * @param updatedContract
	 */
	public void updateContract(final Contract updateContract);

	/**
	 * Elimina un contrato existente.
	 * 
	 * @param deleteContract
	 */
	public void deleteContract(final Contract deleteContract);

	/**
	 * Obtiene un contrato mediante su ID.
	 * 
	 * @param contractId
	 */
	public List<Client> searchByNameAndContractId(final String namePattern, final Long contractId);

	/**
	 * Obtiene todos los contratos existentes.
	 * 
	 * @return List<Contract>
	 */
	public List<Contract> searchAllContract();

	List<Client> searchByName(String name, String surname1, String surname2);

}
