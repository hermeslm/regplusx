package org.onedevelopment.model;

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

@Entity
@Table(name = "book")
public class Book extends BaseObject {

	private static final long serialVersionUID = -87348251499161926L;

	private Integer id;
	private String name;
	private BookType bookType;
	private List<RecordType> recordType;
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

	@Column(name = "name", length = 60)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the bookType
	 */
	@ManyToOne
	@JoinColumn(name = "type_id")
	public BookType getBookType() {
		return bookType;
	}

	/**
	 * @param bookType
	 *            the bookType to set
	 */
	public void setBookType(BookType bookType) {
		this.bookType = bookType;
	}

	/**
	 * @return the recordType
	 */
	@OneToMany(mappedBy = "book")
	public List<RecordType> getRecordType() {
		return recordType;
	}

	/**
	 * @param recordType
	 *            the recordType to set
	 */
	public void setRecordType(List<RecordType> recordType) {
		this.recordType = recordType;
	}

	/**
	 * @return the properties
	 */
	@OneToMany(mappedBy = "book")
	public List<Property> getProperties() {
		return properties;
	}

	/**
	 * @param properties
	 *            the properties to set
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
