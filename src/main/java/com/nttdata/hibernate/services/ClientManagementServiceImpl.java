package com.nttdata.hibernate.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;

import com.nttdata.hibernate.persistence.Client;
import com.nttdata.hibernate.persistence.ClientDaoI;
import com.nttdata.hibernate.persistence.ClientDaoImpl;
import com.nttdata.hibernate.persistence.Contract;
import com.nttdata.hibernate.persistence.ContractDaoI;
import com.nttdata.hibernate.persistence.ContractDaoImpl;

/**
 * Taller 1 y 2 de Hibernate de las practicas Dual de NTT Data
 * 
 * Implementacion del servicio cliente
 * 
 * @author Alvaro Gonzalez Rando
 *
 */
public class ClientManagementServiceImpl implements ClientManagementServiceI {

	/** DAO: CLIENT */
	private ClientDaoI clientDao;

	/** DAO: CONTRACT */
	private ContractDaoI contractDao;

	/**
	 * Metodo constructor de la sesion de contrato y cliente.
	 */
	public ClientManagementServiceImpl(final Session session) {
		this.clientDao = new ClientDaoImpl(session);
		this.contractDao = new ContractDaoImpl(session);
	}

	@Override
	public void insertNewClient(final Client newClient) {

		// Verificacion de nulidad e inexistencia.
		if (newClient != null && newClient.getClientID() == null) {

			// Inserccion del nuevo contrato.
			clientDao.insert(newClient);
		}

	}

	@Override
	public void updateClient(final Client updatedClient) {

		// Verificacion de nulidad y existencia.
		if (updatedClient != null && updatedClient.getClientID() != null) {

			// Actualizacion del contrato.
			clientDao.update(updatedClient);
		}

	}

	@Override
	public void deleteClient(final Client deletedClient) {

		// Verificacion de nulidad y existencia.
		if (deletedClient != null && deletedClient.getClientID() != null) {

			// Eliminacion del contrato.
			clientDao.delete(deletedClient);
		}

	}

	@Override
	public Client searchById(final Long clientId) {

		// Resultado.
		Client client = null;

		// Verificacion de nulidad.
		if (clientId != null) {

			// Obtencion del contrato por ID.
			client = clientDao.searchById(clientId);
		}

		return client;
	}

	@Override
	public List<Client> searchByName(final String name, String surname1, String surname2) {

		// Resultado.
		List<Client> clientsList = new ArrayList<>();

		// Verificación de nulidad.
		if (StringUtils.isNotBlank(name)) {

			// Obtención del cliente por nombre y apellidos.
			clientsList = clientDao.searchByName(name, surname1, surname2);
		}
		return clientsList;
	}

	@Override
	public List<Client> searchAll() {

		// Resultado.
		List<Client> clientList;

		// Obtencion de contratos.
		clientList = clientDao.searchAll();

		return clientList;
	}

	@Override
	public void insertNewContract(final Contract newContract) {

		// Verificacion de nulidad.
		if (newContract != null && newContract.getContractID() == null) {
			// Insercion del nuevo contrato.
			contractDao.insert(newContract);
		}
	}

	@Override
	public void updateContract(final Contract updateContract) {

		// Verificacion de nulidad.
		if (updateContract != null && updateContract.getContractID() != null) {
			// Actualizacion del contrato.
			contractDao.update(updateContract);
		}
	}

	@Override
	public void deleteContract(Contract deleteContract) {

		// Verificacion de nulidad.
		if (deleteContract != null && deleteContract.getContractID() != null) {

			// Eliminacion del contrato.
			contractDao.delete(deleteContract);
		}
	}

	@Override
	public List<Client> searchByNameAndContractId(final String namePattern, final Long contractId) {

		List<Client> clientList;

		// Obtención de clientes.
		clientList = clientDao.searchByNameAndContractId(namePattern, contractId);
		return clientList;
	}

	@Override
	public List<Contract> searchAllContract() {
		// Resultado.
		List<Contract> contractList;

		// Obtencion de contratos.
		contractList = contractDao.searchAll();

		return contractList;
	}

}
