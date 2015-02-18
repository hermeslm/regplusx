package org.onedevelopment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.appfuse.model.BaseObject;

@Entity
@Table(name = "volume")
public class Volume extends BaseObject {

	private static final long serialVersionUID = -87348251499161926L;

	private Integer id;
	private String name;
	private Integer folioStart;
	private Integer folioEnd;

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
	 * @return the folioStart
	 */
	@Column(name = "start_folio")
	public Integer getFolioStart() {
		return folioStart;
	}

	/**
	 * @param folioStart the folioStart to set
	 */
	public void setFolioStart(Integer folioStart) {
		this.folioStart = folioStart;
	}

	/**
	 * @return the folioEnd
	 */
	@Column(name = "end_folio")
	public Integer getFolioEnd() {
		return folioEnd;
	}

	/**
	 * @param folioEnd the folioEnd to set
	 */
	public void setFolioEnd(Integer folioEnd) {
		this.folioEnd = folioEnd;
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
