package org.onedevelopment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.appfuse.model.BaseObject;

@Entity
@Table(name = "repertory")
public class Repertory extends BaseObject {

	private static final long serialVersionUID = -87348251499161926L;

	private Integer id;
	private String day;
	private Integer year;
	private String repertory;
	private Client client;
	private String reasonAct;
	private String nameAct;
	private Record record;
	private String observations;
	private Integer invoice;

	@Id
	@Column(name = "id", insertable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "day")
	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	@Column(name = "year")
	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	@Column(name = "repertory")
	public String getRepertory() {
		return repertory;
	}

	public void setRepertory(String repertory) {
		this.repertory = repertory;
	}

	@ManyToOne
	@JoinColumn(name = "client_id")
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Column(name = "reason_act")
	public String getReasonAct() {
		return reasonAct;
	}

	public void setReasonAct(String reasonAct) {
		this.reasonAct = reasonAct;
	}

	/**
	 * @return the nameAct
	 */
	@Column(name = "name_act")
	public String getNameAct() {
		return nameAct;
	}

	/**
	 * @param nameAct
	 *            the nameAct to set
	 */
	public void setNameAct(String nameAct) {
		this.nameAct = nameAct;
	}

	@ManyToOne
	@JoinColumn(name = "record_id")
	public Record getRecord() {
		return record;
	}

	public void setRecord(Record record) {
		this.record = record;
	}

	@Column(name = "observations")
	public String getObservations() {
		return observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}

	@Column(name = "invoice")
	public Integer getInvoice() {
		return invoice;
	}

	public void setInvoice(Integer invoice) {
		this.invoice = invoice;
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
