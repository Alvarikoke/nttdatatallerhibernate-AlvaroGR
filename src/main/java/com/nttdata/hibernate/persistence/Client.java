package com.nttdata.hibernate.persistence;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Taller 1 y 2 de Hibernate de las practicas Dual de NTT Data
 * 
 * Entidad de tabla cliente
 * 
 * @author Alvaro Gonzalez Rando
 *
 */
@Entity
@Table(name = "cliente")
public class Client extends AbstractEntity implements Serializable {

	/** Serial Version */
	private static final long serialVersionUID = 1L;

	/** Identificador (PK) */
	private Long clientID;

	/** Nombre Cliente */
	private String clientName;

	/** Primer Apellido Cliente */
	private String clientFirstSurname;

	/** Segundo Apellido Cliente */
	private String clientSecondSurname;

	/** DNI Cliente */
	private String clientDNI;

	/** Contrato */
	private Contract contract;

	/**
	 * @return the clientID
	 */
	@Id
	// En una empresa real se usaria el SEQUENCE, pero se podria usar
	// AUTO o IDENTITY (con el riesgo de que MySQL u Oracle no lo pillen bien)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CL_ID")
	public Long getClientID() {
		return clientID;
	}

	/**
	 * @param clientID the clientID to set
	 */
	public void setClientID(Long clientID) {
		this.clientID = clientID;
	}

	/**
	 * @return the clientName
	 */
	@Column(name = "CL_NOMBRE", nullable = false)
	public String getClientName() {
		return clientName;
	}

	/**
	 * @param clientName the clientName to set
	 */
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	/**
	 * @return the clientFirstSurname
	 */
	@Column(name = "CL_APELLIDO1", nullable = false)
	public String getClientFirstSurname() {
		return clientFirstSurname;
	}

	/**
	 * @param clientFirstSurname the clientFirstSurname to set
	 */
	public void setClientFirstSurname(String clientFirstSurname) {
		this.clientFirstSurname = clientFirstSurname;
	}

	/**
	 * @return the clientSecondSurname
	 */
	@Column(name = "CL_APELLIDO2", nullable = false)
	public String getClientSecondSurname() {
		return clientSecondSurname;
	}

	/**
	 * @param clientSecondSurname the clientFirstSurname to set
	 */
	public void setClientSecondSurname(String clientSecondSurname) {
		this.clientSecondSurname = clientSecondSurname;
	}

	/**
	 * @return the clientDNI
	 */
	@Column(name = "CL_DNI", nullable = false)
	public String getClientDNI() {
		return clientDNI;
	}

	/**
	 * @param clientDNI the clientDNI to set
	 */
	public void setClientDNI(String clientDNI) {
		this.clientDNI = clientDNI;
	}

	/**
	 * @return the empresa
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "FK_CO_ID", referencedColumnName = "CO_ID")
	public Contract getContract() {
		return contract;
	}

	/**
	 * @param contract the contract to set
	 */
	public void setContract(Contract contract) {
		this.contract = contract;
	}

	@Override
	public String toString() {
		return "Client [clientID=" + clientID + ", clientName=" + clientName + ", clientFirstSurname="
				+ clientFirstSurname + ", clientSecondSurname=" + clientSecondSurname + ", clientDNI=" + clientDNI
				+ "]";
	}

	@Transient
	public Class<?> getClase() {
		return Client.class;
	}

	@Transient
	@Override
	public Long getId() {
		return this.clientID;
	}

}
