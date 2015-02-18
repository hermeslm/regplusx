package org.onedevelopment.model;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.appfuse.model.BaseObject;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "record")
public class Record extends BaseObject {

	private static final long serialVersionUID = -87348251499161926L;

	private Integer id;
	private Integer year;
	private Integer repertory;
	private Integer record;
	private Calendar recordDate;
	private String afecta1;
	private String afecta2;
	private String notaryOffice;
	private String details;
	private Calendar notarizeDate;
	private Integer folio;
	private String observations;
	private Book book;
	private Volume volume;
	private State state;
	private List<Company> company;
	private List<Repertory> repertories;
	private List<Property> properties;

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
	 * @return the year
	 */
	@Column(name = "year")
	public Integer getYear() {
		return year;
	}

	/**
	 * @param year
	 *            the year to set
	 */
	public void setYear(Integer year) {
		this.year = year;
	}

	/**
	 * @return the repertory
	 */
	@Column(name = "repertory")
	public Integer getRepertory() {
		return repertory;
	}

	/**
	 * @param repertory
	 *            the repertory to set
	 */
	public void setRepertory(Integer repertory) {
		this.repertory = repertory;
	}

	/**
	 * @return the record
	 */
	@Column(name = "record")
	public Integer getRecord() {
		return record;
	}

	/**
	 * @param record
	 *            the record to set
	 */
	public void setRecord(Integer record) {
		this.record = record;
	}

	/**
	 * @return the recordDate
	 */
	@Column(name = "record_date")
	@DateTimeFormat(pattern = "mm/dd/yyyy")
	public Calendar getRecordDate() {
		return recordDate;
	}

	/**
	 * @param recordDate
	 *            the recordDate to set
	 */
	public void setRecordDate(Calendar recordDate) {
		this.recordDate = recordDate;
	}

	@Column(name = "afecta1", length = 20)
	public String getAfecta1() {
		return afecta1;
	}

	public void setAfecta1(String afecta1) {
		this.afecta1 = afecta1;
	}

	@Column(name = "afecta2", length = 20)
	public String getAfecta2() {
		return afecta2;
	}

	public void setAfecta2(String afecta2) {
		this.afecta2 = afecta2;
	}

	@Column(name = "notary_office", length = 250)
	public String getNotaryOffice() {
		return notaryOffice;
	}

	public void setNotaryOffice(String notaryOffice) {
		this.notaryOffice = notaryOffice;
	}

	@Column(name = "details", length = 512)
	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Column(name = "notarize_date")
	@DateTimeFormat(pattern = "mm/dd/yyyy")
	public Calendar getNotarizeDate() {
		return notarizeDate;
	}

	public void setNotarizeDate(Calendar notarizeDate) {
		this.notarizeDate = notarizeDate;
	}

	@Column(name = "folio")
	public Integer getFolio() {
		return folio;
	}

	public void setFolio(Integer folio) {
		this.folio = folio;
	}

	@Column(name = "observations", length = 512)
	public String getObservations() {
		return observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}

	@ManyToOne
	@JoinColumn(name = "book_id")
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@ManyToOne
	@JoinColumn(name = "volume_id")
	public Volume getVolume() {
		return volume;
	}

	public void setVolume(Volume volume) {
		this.volume = volume;
	}

	@ManyToOne
	@JoinColumn(name = "state_id")
	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	/**
	 * @return the company
	 */
	@OneToMany(mappedBy = "record")
	public List<Company> getCompany() {
		return company;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompany(List<Company> company) {
		this.company = company;
	}

	/**
	 * @return the repertories
	 */
	@OneToMany(mappedBy = "record")
	public List<Repertory> getRepertories() {
		return repertories;
	}

	/**
	 * @param repertories the repertories to set
	 */
	public void setRepertories(List<Repertory> repertories) {
		this.repertories = repertories;
	}

	/**
	 * @return the properties
	 */
	@OneToMany(mappedBy = "record")
	public List<Property> getProperties() {
		return properties;
	}

	/**
	 * @param properties the properties to set
	 */
	public void setProperties(List<Property> properties) {
		this.properties = properties;
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
