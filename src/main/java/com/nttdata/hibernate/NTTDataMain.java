package com.nttdata.hibernate;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;

import com.nttdata.hibernate.persistence.Client;
import com.nttdata.hibernate.persistence.Contract;
import com.nttdata.hibernate.services.ClientManagementServiceI;
import com.nttdata.hibernate.services.ClientManagementServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Taller 1 y 2 de Hibernate de las practicas Dual de NTT Data
 * 
 * Clase Main de la aplicacion
 * 
 * @author Alvaro Gonzalez Rando
 *
 */
public class NTTDataMain {

	/**
	 * Metodo principal
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// Apertura de sesion.
		final Session session = NTTDataHibernateUtil.getSessionFactory().openSession();

		// Inicializacion de servicios.
		final ClientManagementServiceI contractService = new ClientManagementServiceImpl(session);

		// Llamada a la clase Logger.
		Logger logger = LoggerFactory.getLogger(NTTDataMain.class);

		// Auditoria.
		final String updatedUser = "agonzalez";
		final Date updatedDate = new Date();

		// Generacion de clientes.
		final Client client1 = new Client();
		client1.setClientName("Elisabeth");
		client1.setClientFirstSurname("Lopez");
		client1.setClientSecondSurname("Perez");
		client1.setClientDNI("12345678B");
		client1.setUpdatedDate(updatedDate);
		client1.setUpdatedUser(updatedUser);

		final Client client2 = new Client();
		client2.setClientName("Arnaldo");
		client2.setClientFirstSurname("Jimenez");
		client2.setClientSecondSurname("Campos");
		client2.setClientDNI("98765432T");
		client2.setUpdatedDate(updatedDate);
		client2.setUpdatedUser(updatedUser);

		// Insercion de clientes.
		contractService.insertNewClient(client1);
		contractService.insertNewClient(client2);

		// Generacion del contrato.
		final Contract contract1 = new Contract();
		contract1.setEffectiveDate("2022-11-30");
		contract1.setExpiryDate("2023-06-30");
		contract1.setMonthlyPrice(2000.0);
		contract1.setUpdatedUser(updatedUser);
		contract1.setUpdatedDate(updatedDate);

		// Asignacion del contrato a los clientes.
		client1.setContract(contract1);
		client2.setContract(contract1);

		// Insercion del contrato.
		contractService.insertNewContract(contract1);

		// Busqueda de clientes por nombre y apellidos en HQL.
		List<Client> clientsName = contractService.searchByName("Elisabeth", "Lopez", "Perez");

		// Busqueda de clientes por nombre del cliente e ID del contrato en JPA.
		// Criteria.
		List<Client> clientsNameAndContract = contractService.searchByNameAndContractId("A%", 3L);

		// Generacion de resultados:
		// Consulta HQL.
		for (final Client client : clientsName) {
			logger.info("Nombre del cliente: {} {} {}; DNI del cliente: {}.", client.getClientName(),
					client.getClientFirstSurname(), client.getClientSecondSurname(), client.getClientDNI());
		}

		// Consulta JPA Criteria.

		String monthlyPriceStr;

		for (final Client client : clientsNameAndContract) {

			monthlyPriceStr = String.format("%.0f", client.getContract().getMonthlyPrice());

			logger.info(
					"Nombre del cliente: {} {} {}; ID del cliente: {}; Expiracion del contrato: {}; Sueldo mensual: {} €.",
					client.getClientName(), client.getClientFirstSurname(), client.getClientSecondSurname(),
					client.getContract().getContractID(), client.getContract().getExpiryDate(), monthlyPriceStr);
		}

		// Cierre de sesion.
		session.close();

	}

}
