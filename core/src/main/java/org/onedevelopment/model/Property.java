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
@Table(name = "property")
public class Property extends BaseObject {

	private static final long serialVersionUID = -87348251499161926L;

	private Integer id;
	private Integer year;
	private Integer repertory;
	private Record record;
	private String keyValue;
	private String propertyNumber;
	private String blockNumber;
	private String cooperative;
	private String surface;
	private Parroquia parroquia;
	private String north;
	private String south;
	private String east;
	private String west;
	private State state;
	private Float amount;
	private Book book;
	private String salesPeople;
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
	 * @return the year
	 */
	@Column(name = "year")
	public Integer getYear() {
		return year;
	}

	/**
	 * @param year the year to set
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
	 * @param repertory the repertory to set
	 */
	public void setRepertory(Integer repertory) {
		this.repertory = repertory;
	}

	/**
	 * @return the record
	 */
	@ManyToOne
	@JoinColumn(name = "record_id")
	public Record getRecord() {
		return record;
	}

	/**
	 * @param record the record to set
	 */
	public void setRecord(Record record) {
		this.record = record;
	}

	/**
	 * @return the key
	 */
	@Column(name = "key_value")
	public String getKeyValue() {
		return keyValue;
	}

	/**
	 * @param key the key to set
	 */
	public void setKeyValue(String keyValue) {
		this.keyValue = keyValue;
	}

	/**
	 * @return the propertyNumber
	 */
	@Column(name = "property_number")
	public String getPropertyNumber() {
		return propertyNumber;
	}

	/**
	 * @param propertyNumber the propertyNumber to set
	 */
	public void setPropertyNumber(String propertyNumber) {
		this.propertyNumber = propertyNumber;
	}

	/**
	 * @return the blokNumber
	 */
	@Column(name = "block_number")
	public String getBlockNumber() {
		return blockNumber;
	}

	/**
	 * @param blokNumber the blokNumber to set
	 */
	public void setBlockNumber(String blockNumber) {
		this.blockNumber = blockNumber;
	}

	/**
	 * @return the cooperative
	 */
	@Column(name = "cooperative")
	public String getCooperative() {
		return cooperative;
	}

	/**
	 * @param cooperative the cooperative to set
	 */
	public void setCooperative(String cooperative) {
		this.cooperative = cooperative;
	}

	/**
	 * @return the surface
	 */
	@Column(name = "surface")
	public String getSurface() {
		return surface;
	}

	/**
	 * @param surface the surface to set
	 */
	public void setSurface(String surface) {
		this.surface = surface;
	}

	/**
	 * @return the parroquia
	 */
	@ManyToOne
	@JoinColumn(name = "parroquia_id")
	public Parroquia getParroquia() {
		return parroquia;
	}

	/**
	 * @param parroquia the parroquia to set
	 */
	public void setParroquia(Parroquia parroquia) {
		this.parroquia = parroquia;
	}

	/**
	 * @return the north
	 */
	@Column(name = "north")
	public String getNorth() {
		return north;
	}

	/**
	 * @param north the north to set
	 */
	public void setNorth(String north) {
		this.north = north;
	}

	/**
	 * @return the south
	 */
	@Column(name = "south")
	public String getSouth() {
		return south;
	}

	/**
	 * @param south the south to set
	 */
	public void setSouth(String south) {
		this.south = south;
	}

	/**
	 * @return the east
	 */
	@Column(name = "east")
	public String getEast() {
		return east;
	}

	/**
	 * @param east the east to set
	 */
	public void setEast(String east) {
		this.east = east;
	}

	/**
	 * @return the west
	 */
	@Column(name = "west")
	public String getWest() {
		return west;
	}

	/**
	 * @param west the west to set
	 */
	public void setWest(String west) {
		this.west = west;
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
	 * @return the amount
	 */
	@Column(name = "amount")
	public Float getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Float amount) {
		this.amount = amount;
	}

	/**
	 * @return the book
	 */
	@ManyToOne
	@JoinColumn(name = "book_id")
	public Book getBook() {
		return book;
	}

	/**
	 * @param book the book to set
	 */
	public void setBook(Book book) {
		this.book = book;
	}

	/**
	 * @return the salesPeople
	 */
	@Column(name = "sales_people")
	public String getSalesPeople() {
		return salesPeople;
	}

	/**
	 * @param salesPeople the salesPeople to set
	 */
	public void setSalesPeople(String salesPeople) {
		this.salesPeople = salesPeople;
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
