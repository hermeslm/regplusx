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
@Table(name = "client")
public class Client extends BaseObject {

	private static final long serialVersionUID = -87348251499161926L;

	private Integer id;
	private String name;
	private String lastName;
	private String address;
	private Province province;
	private Canton canton;
	private Parroquia parroquia;
	private List<Repertory> repertories;

	@Id
	@Column(name = "id", insertable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name", length = 255)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the canton
	 */
	@ManyToOne
	@JoinColumn(name = "canton_id")
	public Canton getCanton() {
		return canton;
	}

	/**
	 * @param canton
	 *            the canton to set
	 */
	public void setCanton(Canton canton) {
		this.canton = canton;
	}

	@Column(name = "last_name", length = 255)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "address", length = 255)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@ManyToOne
	@JoinColumn(name = "province_id")
	public Province getProvince() {
		return province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	@ManyToOne
	@JoinColumn(name = "parroquia_id")
	public Parroquia getParroquia() {
		return parroquia;
	}

	public void setParroquia(Parroquia parroquia) {
		this.parroquia = parroquia;
	}

	/**
	 * @return the repertories
	 */
	@OneToMany(mappedBy = "client")
	public List<Repertory> getRepertories() {
		return repertories;
	}

	/**
	 * @param repertories the repertories to set
	 */
	public void setRepertories(List<Repertory> repertories) {
		this.repertories = repertories;
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
