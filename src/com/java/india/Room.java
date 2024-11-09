package com.java.india;

public class Room {
	public static final int SINGLE = 0;
	public static final int DOUBLE = 1;
	
	public static final int FREE = 0;
	public static final int NOT_FREE = 1;
	
	private static String types[] = {"SIMPLE","DOUBLE"};
	private static String states[] = {"LIBRE","OCCUPEE"};
	
	private int number;
	private int type;
	private int state;
	private int bedCount;
	private double price;
	
	public Room() {
	}

	public Room(int number, int type, int state, int bedCount, double price) {
		this.number = number;
		this.type = type;
		this.state = state;
		this.bedCount = bedCount;
		this.price = price;
	}

	public int getBedCount() {
		return bedCount;
	}

	public void setBedCount(int bedCount) {
		this.bedCount = bedCount;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	public String toString() {
		String s = "Chambre N " + number
			+ ", " + types[type] + ", " + states[state]
			+ ", Nombre de lits : " + bedCount + ", Prix : " + price + " DH";
		
		return s;
	}
	
	public boolean equals(Room obj) {
		return (number == obj.number);
	}
}
