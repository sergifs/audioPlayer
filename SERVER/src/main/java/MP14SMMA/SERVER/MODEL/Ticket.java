package MP14SMMA.SERVER.MODEL;
// Generated 21-may-2019 11:53:53 by Hibernate Tools 5.3.6.Final

/**
 * Ticket generated by hbm2java
 */
public class Ticket implements java.io.Serializable {

	private Integer idTicket;
	private Float totalPrice;
	private Integer idTable;

	public Ticket() {
	}

	public Ticket(Float totalPrice, Integer idTable) {
		this.totalPrice = totalPrice;
		this.idTable = idTable;
	}

	public Integer getIdTicket() {
		return this.idTicket;
	}

	public void setIdTicket(Integer idTicket) {
		this.idTicket = idTicket;
	}

	public Float getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Integer getIdTable() {
		return this.idTable;
	}

	public void setIdTable(Integer idTable) {
		this.idTable = idTable;
	}

}
