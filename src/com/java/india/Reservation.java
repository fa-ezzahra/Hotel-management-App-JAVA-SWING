package com.java.india;

public class Reservation {
	private int number;
	private Client client;
	private Room room;
	private Date date;
	private int days;

	private static int ci = 1;

	public Reservation() {
		number = ci;
		ci++;
	}

	public Reservation(Client client, Room room, Date date, int days) {
		this();
		this.client = client;
		this.room = room;
		this.date = date;
		this.days = days;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String toString() {
		return "Reservation [number=" + number + ", client=" + client + ", room=" + room + ", date=" + date + ", days="
				+ days + "]";
	}

}
