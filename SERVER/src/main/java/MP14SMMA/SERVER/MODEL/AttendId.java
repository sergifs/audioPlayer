package MP14SMMA.SERVER.MODEL;
// Generated 21-may-2019 11:53:53 by Hibernate Tools 5.3.6.Final

/**
 * AttendId generated by hbm2java
 */
public class AttendId implements java.io.Serializable {

	private int idTable;
	private String dniWaiter;

	public AttendId() {
	}

	public AttendId(int idTable, String dniWaiter) {
		this.idTable = idTable;
		this.dniWaiter = dniWaiter;
	}

	public int getIdTable() {
		return this.idTable;
	}

	public void setIdTable(int idTable) {
		this.idTable = idTable;
	}

	public String getDniWaiter() {
		return this.dniWaiter;
	}

	public void setDniWaiter(String dniWaiter) {
		this.dniWaiter = dniWaiter;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AttendId))
			return false;
		AttendId castOther = (AttendId) other;

		return (this.getIdTable() == castOther.getIdTable())
				&& ((this.getDniWaiter() == castOther.getDniWaiter()) || (this.getDniWaiter() != null
						&& castOther.getDniWaiter() != null && this.getDniWaiter().equals(castOther.getDniWaiter())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getIdTable();
		result = 37 * result + (getDniWaiter() == null ? 0 : this.getDniWaiter().hashCode());
		return result;
	}

}