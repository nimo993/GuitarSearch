package model;

public class Guitar {
	private String serialNumber;
	private double price;
	private String style;
	private String model;
	private String builder;
	private String backWood;
	private String topWood;
	public Guitar() {}
	public Guitar(String serialNumber,double price,String style,String model,String builder,String backWood,String topWood) {
		this.serialNumber=serialNumber;
		this.price=price;
		this.style=style;
		this.model=model;
		this.builder=builder;
		this.backWood=backWood;
		this.topWood=topWood;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getBuilder() {
		return builder;
	}
	public void setBuilder(String builder) {
		this.builder = builder;
	}
	public String getBackWood() {
		return backWood;
	}
	public void setBackWood(String backWood) {
		this.backWood = backWood;
	}
	public String getTopWood() {
		return topWood;
	}
	public void setTopWood(String topWood) {
		this.topWood = topWood;
	}
}
