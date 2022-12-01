package com.nttdata.hibernate.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Taller 1 y 2 de Hibernate de las practicas Dual de NTT Data
 * 
 * Entidad de tabla contrato
 * 
 * @author Alvaro Gonzalez Rando
 *
 */
@Entity
@Table(name = "contrato")
public class Contract extends AbstractEntity implements Serializable {

	/** Serial Version */
	private static final long serialVersionUID = 1L;

	/** Identificador (PK) */
	private Long contractID;

	/** Fecha de vigencia */
	private String effectiveDate;

	/** Fecha de caducidad */
	private String expiryDate;

	/** Precio mensual */
	private Double monthlyPrice;

	/** Clientes */
	private List<Client> clientes;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CO_ID")
	public Long getContractID() {
		return contractID;
	}

	/**
	 * @param contractID the contractID to set
	 */
	public void setContractID(Long contractID) {
		this.contractID = contractID;
	}

	/**
	 * @return the effectiveDate
	 */
	@Column(name = "CO_FECHA_VIGENCIA", nullable = false)
	public String getEffectiveDate() {
		return effectiveDate;
	}

	/**
	 * @param string the effectiveDate to set
	 */
	public void setEffectiveDate(String string) {
		this.effectiveDate = string;
	}

	/**
	 * @return the expiryDate
	 */
	@Column(name = "CO_FECHA_CADUCIDAD", nullable = false)
	public String getExpiryDate() {
		return expiryDate;
	}

	/**
	 * @param string the expiryDate to set
	 */
	public void setExpiryDate(String string) {
		this.expiryDate = string;
	}

	/**
	 * @return the monthlyPrice
	 */
	@Column(name = "CO_PRECIO_MENSUAL", nullable = false)
	public Double getMonthlyPrice() {
		return monthlyPrice;
	}

	/**
	 * @param monthlyPrice the monthlyPrice to set
	 */
	public void setMonthlyPrice(Double monthlyPrice) {
		this.monthlyPrice = monthlyPrice;
	}

	/**
	 * @return the clientes
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "contract")
	public List<Client> getClientes() {
		return clientes;
	}

	/**
	 * @param clientes the clientes to set
	 */
	public void setClientes(List<Client> clientes) {
		this.clientes = clientes;
	}

	@Transient
	@Override
	public Long getId() {
		return this.contractID;
	}

}
