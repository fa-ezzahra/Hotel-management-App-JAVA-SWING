package com.java.india;

import java.util.LinkedList;
import java.util.Vector;

public class Hotel {
	private Vector<Room> roomList;
	private LinkedList<Client> clientList;
	private LinkedList<Reservation> reservationList;
	private LinkedList<Reservation> occupationList;

	public Hotel() {
		roomList = new Vector<Room>();
		clientList = new LinkedList<Client>();
		reservationList = new LinkedList<Reservation>();
		occupationList = new LinkedList<Reservation>();
	} 
	
	public void addRoom(Room r) {
		roomList.add(r);
	}
	
	public void addRoom(int number, double price) {
		Room r = new Room(number, Room.SINGLE, Room.FREE, 1, price);
		roomList.add(r);
	}
	
	public void addRoom(int number, double price, int type, int bedCount) {
		Room r = new Room(number, type, Room.FREE, bedCount, price);
		roomList.add(r);
	}

	public Room getRoom(int number) {
		for (Room r : roomList) {
			if (r.getNumber() == number)
				return r;
		}
		return null;
	}
	
	public void addClient(Client client) {
		clientList.add(client);
	}
	
	public Client getClient(String id) {
		for (Client c : clientList) {
			if (c.getId().equals(id))
				return c;
		}
		return null;
	}
	
	public void addReservation(Reservation r) {
		reservationList.add(r);
	}

	public void addReservation(String id, int number, Date d, int days) {
		Client c = getClient(id);
		Room r = getRoom(number);
		if (c!=null && r!=null) {
			reservationList.add(new Reservation(c, r, d, days));
		}
	}

	public Reservation getReservation(int number) {
		return reservationList.get(number);
	}
	
	public void assign(String id, int number, Date d, int days) {
		Client c = getClient(id);
		Room r = getRoom(number);
		if (c!=null && r!=null) {
			occupationList.add(new Reservation(c, r, d, days));
		}
	}
	
	public LinkedList<Client> getClientList() {
		return clientList;
	}

	public Client getClientInRoom(int number) {
		for(Reservation r : occupationList) {
			if (r.getRoom().getNumber() == number) {
				Client c = r.getClient();
				return c;
			}
		}
		return null;
	}
}
