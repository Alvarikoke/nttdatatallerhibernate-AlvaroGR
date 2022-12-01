package com.nttdata.hibernate.persistence;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

/**
 * Taller 1 y 2 de Hibernate de las practicas Dual de NTT Data
 * 
 * Implementacion DAO de tabla CLIENT
 * 
 * @author Alvaro Gonzalez Rando
 *
 */
public class ClientDaoImpl extends CommonDaoImpl<Client> implements ClientDaoI {

	/** Sesion de conexion a BBDD */
	private Session session;

	/**
	 * Método constructor
	 */
	public ClientDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Client> searchByName(final String clientName, final String clientFirstSurname,
			final String clientSecondSurname) {

		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Localiza clientes en función del nombre y apellidos.
		return session.createQuery("FROM Client WHERE clientName='" + clientName + "' AND clientFirstSurname='"
				+ clientFirstSurname + "' AND clientSecondSurname='" + clientSecondSurname + "'").list();
	}

	@Override
	public List<Client> searchByNameAndContractId(final String namePattern, final Long contractID) {

		// Consulta.
		final CriteriaBuilder cb = session.getCriteriaBuilder();
		final CriteriaQuery<Client> cquery = cb.createQuery(Client.class);
		final Root<Client> rootP = cquery.from(Client.class);
		final Join<Client, Contract> pJoinT = rootP.join("contract");

		// Where.
		final Predicate pr1 = cb.equal(pJoinT.<Long>get("contractID"), contractID);
		final Predicate pr2 = cb.like(rootP.<String>get("clientName"), namePattern);

		// Consulta.
		cquery.select(rootP).where(cb.and(pr1,pr2));

		// Ejecución de consulta.
		return session.createQuery(cquery).getResultList();
	}

}
