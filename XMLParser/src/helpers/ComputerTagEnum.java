package helpers;

public enum ComputerTagEnum {

	NAME("name"), ORIGIN("origin"), PRICE("price"), COOLER("cooler"), ENERGY("energy"), GROUP("group"), PORT("port"); 
	
	private String value;
	private ComputerTagEnum(String value) {
	this.value = value;
	}
	public String getValue() {
	return value;
	}
	
}
