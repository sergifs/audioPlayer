package MP14SMMA.SERVER.MODEL;
// Generated 21-may-2019 12:14:37 by Hibernate Tools 5.3.6.Final

/**
 * Hasdrink generated by hbm2java
 */
public class Hasdrink implements java.io.Serializable {

	private HasdrinkId id;
	private Integer quantityItem;

	public Hasdrink() {
	}

	public Hasdrink(HasdrinkId id) {
		this.id = id;
	}

	public Hasdrink(HasdrinkId id, Integer quantityItem) {
		this.id = id;
		this.quantityItem = quantityItem;
	}

	public HasdrinkId getId() {
		return this.id;
	}

	public void setId(HasdrinkId id) {
		this.id = id;
	}

	public Integer getQuantityItem() {
		return this.quantityItem;
	}

	public void setQuantityItem(Integer quantityItem) {
		this.quantityItem = quantityItem;
	}

}
