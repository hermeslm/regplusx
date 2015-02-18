package org.onedevelopment.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.appfuse.model.BaseObject;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "trade_property")
public class TradeProperty extends BaseObject {

	private static final long serialVersionUID = -87348251499161926L;

	private Integer id;
	private Calendar inscriptionDate;
	private String inscriptionNumber;
	private AgreementType agreementType;
	private String businessName;
	private PurchaserType purchaserType;
	private String chassis;
	private String motor;
	private String brand;
	private String model;
	private String manufactureDate;
	private String registrationNumber;
	private String location;
	private Calendar lastModificationDate;
	private String identification;
	private State state;
	private String judgedLetter;
	private String agent;
	private Calendar contractDate;
	private Calendar cancellationDate;

	@Id
	@Column(name = "id", insertable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the inscriptionDate
	 */
	@Column(name = "inscription_date")
	@DateTimeFormat(pattern = "mm/dd/yyyy")
	public Calendar getInscriptionDate() {
		return inscriptionDate;
	}

	/**
	 * @param inscriptionDate the inscriptionDate to set
	 */
	public void setInscriptionDate(Calendar inscriptionDate) {
		this.inscriptionDate = inscriptionDate;
	}

	/**
	 * @return the inscriptionNumber
	 */
	@Column(name = "inscription_number")
	public String getInscriptionNumber() {
		return inscriptionNumber;
	}

	/**
	 * @param inscriptionNumber the inscriptionNumber to set
	 */
	public void setInscriptionNumber(String inscriptionNumber) {
		this.inscriptionNumber = inscriptionNumber;
	}

	/**
	 * @return the agreementType
	 */
	@ManyToOne
	@JoinColumn(name = "agreement_type_id")
	public AgreementType getAgreementType() {
		return agreementType;
	}

	/**
	 * @param agreementType the agreementType to set
	 */
	public void setAgreementType(AgreementType agreementType) {
		this.agreementType = agreementType;
	}

	/**
	 * @return the businessName
	 */
	@Column(name = "business_name")
	public String getBusinessName() {
		return businessName;
	}

	/**
	 * @param businessName the businessName to set
	 */
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	/**
	 * @return the purchaserType
	 */
	@ManyToOne
	@JoinColumn(name = "purchaser_type_id")
	public PurchaserType getPurchaserType() {
		return purchaserType;
	}

	/**
	 * @param purchaserType the purchaserType to set
	 */
	public void setPurchaserType(PurchaserType purchaserType) {
		this.purchaserType = purchaserType;
	}

	/**
	 * @return the chassis
	 */
	@Column(name = "chassis")
	public String getChassis() {
		return chassis;
	}

	/**
	 * @param chassis the chassis to set
	 */
	public void setChassis(String chassis) {
		this.chassis = chassis;
	}

	/**
	 * @return the motor
	 */
	@Column(name = "motor")
	public String getMotor() {
		return motor;
	}

	/**
	 * @param motor the motor to set
	 */
	public void setMotor(String motor) {
		this.motor = motor;
	}

	/**
	 * @return the brand
	 */
	@Column(name = "brand")
	public String getBrand() {
		return brand;
	}

	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * @return the model
	 */
	@Column(name = "model")
	public String getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @return the manufactureDate
	 */
	@Column(name = "manufacture_date")
	public String getManufactureDate() {
		return manufactureDate;
	}

	/**
	 * @param manufactureDate the manufactureDate to set
	 */
	public void setManufactureDate(String manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	/**
	 * @return the registrationNumber
	 */
	@Column(name = "registration_number")
	public String getRegistrationNumber() {
		return registrationNumber;
	}

	/**
	 * @param registrationNumber the registrationNumber to set
	 */
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	/**
	 * @return the location
	 */
	@Column(name = "location")
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the lastModificationDate
	 */
	@Column(name = "last_modification_date")
	@DateTimeFormat(pattern = "mm/dd/yyyy")
	public Calendar getLastModificationDate() {
		return lastModificationDate;
	}

	/**
	 * @param lastModificationDate the lastModificationDate to set
	 */
	public void setLastModificationDate(Calendar lastModificationDate) {
		this.lastModificationDate = lastModificationDate;
	}

	/**
	 * @return the identification
	 */
	@Column(name = "identification")
	public String getIdentification() {
		return identification;
	}

	/**
	 * @param identification the identification to set
	 */
	public void setIdentification(String identification) {
		this.identification = identification;
	}

	/**
	 * @return the judgedLetter
	 */
	@Column(name = "judged_letter")
	public String getJudgedLetter() {
		return judgedLetter;
	}

	/**
	 * @param judgedLetter the judgedLetter to set
	 */
	public void setJudgedLetter(String judgedLetter) {
		this.judgedLetter = judgedLetter;
	}

	/**
	 * @return the agent
	 */
	@Column(name = "agent")
	public String getAgent() {
		return agent;
	}

	/**
	 * @param agent the agent to set
	 */
	public void setAgent(String agent) {
		this.agent = agent;
	}

	/**
	 * @return the contractDate
	 */
	@Column(name = "contract_date")
	@DateTimeFormat(pattern = "mm/dd/yyyy")
	public Calendar getContractDate() {
		return contractDate;
	}

	/**
	 * @param contractDate the contractDate to set
	 */
	public void setContractDate(Calendar contractDate) {
		this.contractDate = contractDate;
	}

	/**
	 * @return the state
	 */
	@ManyToOne
	@JoinColumn(name = "state_id")
	public State getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(State state) {
		this.state = state;
	}

	/**
	 * @return the cancellationDate
	 */
	@Column(name = "cancellation_date")
	@DateTimeFormat(pattern = "mm/dd/yyyy")
	public Calendar getCancellationDate() {
		return cancellationDate;
	}

	/**
	 * @param cancellationDate the cancellationDate to set
	 */
	public void setCancellationDate(Calendar cancellationDate) {
		this.cancellationDate = cancellationDate;
	}

	@Override
	public boolean equals(Object arg0) {
		return false;
	}

	@Override
	public int hashCode() {
		return 0;
	}

	@Override
	public String toString() {
		return null;
	}

}
