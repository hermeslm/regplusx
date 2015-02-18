package org.onedevelopment.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.appfuse.model.BaseObject;

@Entity
@Table(name = "agreement_type")
public class AgreementType extends BaseObject {

	private static final long serialVersionUID = -87348251499161926L;

	private Integer id;
	private String name;
	private List<TradeProperty> tradeProperties;

	@Id
	@Column(name = "id", insertable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name", length = 512)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the tradeProperties
	 */
	@OneToMany(mappedBy = "agreementType")
	public List<TradeProperty> getTradeProperties() {
		return tradeProperties;
	}

	/**
	 * @param tradeProperties the tradeProperties to set
	 */
	public void setTradeProperties(List<TradeProperty> tradeProperties) {
		this.tradeProperties = tradeProperties;
	}

	@Override
	public int hashCode() {
		return 0;
	}

	@Override
	public String toString() {
		return null;
	}

	@Override
	public boolean equals(Object o) {
		return false;
	}

}
