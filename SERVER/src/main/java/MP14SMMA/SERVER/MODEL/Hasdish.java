package MP14SMMA.SERVER.MODEL;
// Generated 21-may-2019 11:53:53 by Hibernate Tools 5.3.6.Final

/**
 * Hasdish generated by hbm2java
 */
public class Hasdish implements java.io.Serializable {

	private HasdishId id;
	private Integer quantityItem;

	public Hasdish() {
	}

	public Hasdish(HasdishId id) {
		this.id = id;
	}

	public Hasdish(HasdishId id, Integer quantityItem) {
		this.id = id;
		this.quantityItem = quantityItem;
	}

	public HasdishId getId() {
		return this.id;
	}

	public void setId(HasdishId id) {
		this.id = id;
	}

	public Integer getQuantityItem() {
		return this.quantityItem;
	}

	public void setQuantityItem(Integer quantityItem) {
		this.quantityItem = quantityItem;
	}

}
