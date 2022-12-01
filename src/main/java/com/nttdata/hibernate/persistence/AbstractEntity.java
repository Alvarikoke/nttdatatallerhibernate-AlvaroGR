package com.nttdata.hibernate.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

/**
 * Taller 1 y 2 de Hibernate de las practicas Dual de NTT Data
 * 
 * Abstract Entity
 * 
 * @author Alvaro Gonzalez Rando
 *
 */
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

	/** SERIAL VERSION */
	private static final long serialVersionUID = 1L;

	/** Auditoría | Usuario que actualiza */
	private String updatedUser;

	/** Auditoría | Día actualizado */
	private Date updatedDate;

	/**
	 * Metodo generico para la obtencion de PK
	 * 
	 * @return Long
	 */
	@Transient
	public abstract Long getId();

	/**
	 * @return the updatedUser
	 */
	@Column(name = "AUDIT_UPDATED_USER", nullable = false)
	public String getUpdatedUser() {
		return updatedUser;
	}

	/**
	 * @param updatedUser the updatedUser to set
	 */
	public void setUpdatedUser(String updatedUser) {
		this.updatedUser = updatedUser;
	}

	/**
	 * @return the updatedDate
	 */
	@Column(name = "AUDIT_UPDATED_DATE", nullable = false)
	public Date getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * @param updatedDate the updatedDate to set
	 */
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

}
