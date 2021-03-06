package MP14SMMA.SERVER.MODEL;
// Generated 21-may-2019 12:14:37 by Hibernate Tools 5.3.6.Final

/**
 * Drink generated by hbm2java
 */
public class Drink implements java.io.Serializable {

	private int idItemDrink;
	private float price;
	private String nameDrink;
	private int quantityStock;
	private int statusDrink;
	private String descriptionDrink;

	public Drink() {
	}

	public Drink(int idItemDrink, float price, String nameDrink, int quantityStock, int statusDrink) {
		this.idItemDrink = idItemDrink;
		this.price = price;
		this.nameDrink = nameDrink;
		this.quantityStock = quantityStock;
		this.statusDrink = statusDrink;
	}

	public Drink(int idItemDrink, float price, String nameDrink, int quantityStock, int statusDrink,
			String descriptionDrink) {
		this.idItemDrink = idItemDrink;
		this.price = price;
		this.nameDrink = nameDrink;
		this.quantityStock = quantityStock;
		this.statusDrink = statusDrink;
		this.descriptionDrink = descriptionDrink;
	}

	public int getIdItemDrink() {
		return this.idItemDrink;
	}

	public void setIdItemDrink(int idItemDrink) {
		this.idItemDrink = idItemDrink;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getNameDrink() {
		return this.nameDrink;
	}

	public void setNameDrink(String nameDrink) {
		this.nameDrink = nameDrink;
	}

	public int getQuantityStock() {
		return this.quantityStock;
	}

	public void setQuantityStock(int quantityStock) {
		this.quantityStock = quantityStock;
	}

	public int getStatusDrink() {
		return this.statusDrink;
	}

	public void setStatusDrink(int statusDrink) {
		this.statusDrink = statusDrink;
	}

	public String getDescriptionDrink() {
		return this.descriptionDrink;
	}

	public void setDescriptionDrink(String descriptionDrink) {
		this.descriptionDrink = descriptionDrink;
	}

}
