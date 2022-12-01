package com.nttdata.hibernate.persistence;

import org.hibernate.Session;

/**
 * Taller 1 y 2 de Hibernate de las practicas Dual de NTT Data
 * 
 * Implementacion DAO de tabla CONTRACT
 * 
 * @author Alvaro Gonzalez Rando
 *
 */
public class ContractDaoImpl extends CommonDaoImpl<Contract> implements ContractDaoI {

	public ContractDaoImpl(Session session) {
		super(session);
		// TODO desarrollar algo aqui
	}

}
