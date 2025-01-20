package uebung_8_1;

public abstract class Vehicle {

	private String id;
	private boolean isGasoline;
	private Color color;
	private int ps;

	protected Vehicle(String id, boolean isGasoline, Color color, int ps) {
		super();
		this.id = id;
		this.isGasoline = isGasoline;
		this.color = color;
		this.ps = ps;
	}

	protected String getId() {
		return id;
	}

	protected void setId(String id) {
		this.id = id;
	}

	protected boolean isGasoline() {
		return isGasoline;
	}

	protected void setGasoline(boolean isGasoline) {
		this.isGasoline = isGasoline;
	}

	protected Color getColor() {
		return color;
	}

	protected void setColor(Color color) {
		this.color = color;
	}

	protected int getPs() {
		return ps;
	}

	protected void setPs(int ps) {
		this.ps = ps;
	}

	// The overridden equals(). If the passed object is this object, return true. If
	// null or not an instance of this class, return false. Otherwise cast and check
	// attributes.
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null) {
			return false;
		}

		if (this.getClass() != obj.getClass()) {
			return false;
		}

		Vehicle vehicle = (Vehicle) obj;

		if (this.id != vehicle.getId())
			return false;
		if (this.isGasoline != vehicle.isGasoline())
			return false;
		if (this.color != vehicle.getColor())
			return false;
		if (this.ps != vehicle.getPs())
			return false;

		return true;
	}

	@Override
	public String toString() {
		return "Fahrzeug: {kennzeichen=" + this.id + ", istBenziner=" + this.isGasoline + ", color=" + this.color
				+ ", ps=" + this.ps + "}";
	}
}
