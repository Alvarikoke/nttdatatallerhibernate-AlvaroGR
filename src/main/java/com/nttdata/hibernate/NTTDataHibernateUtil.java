package com.nttdata.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Taller 1 y 2 de Hibernate de las practicas Dual de NTT Data
 * 
 * Hibernate Util
 * 
 * @author Alvaro Gonzalez Rando
 *
 */
public class NTTDataHibernateUtil {

	/** Factoría de sesiones */
	private static final SessionFactory SESSION_FACTORY;

	/**
	 * Constructor privado.
	 */
	private NTTDataHibernateUtil() {

	}

	/**
	 * Generación de factoría de sesiones.
	 */
	static {

		try {

			// Generación de configuración.
			SESSION_FACTORY = new Configuration().configure().buildSessionFactory();

		} catch (final Exception ex) {

			// Error de inicialización.
			System.err.println("[ERROR] Configuración de Hibernate - " + ex);
			throw new ExceptionInInitializerError();
		}

	}

	/**
	 * Retorna la factoría de sesiones.
	 * 
	 * @return SessionFactory
	 */
	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
	}

}
