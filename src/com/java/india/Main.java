package com.java.india;

public class Main {

	public static void main(String[] args) {
		Room r1 = new Room(101, Room.SINGLE, Room.FREE, 1, 590);
		Room r2 = new Room(102, Room.SINGLE, Room.FREE, 1, 40);
		
		Client c1 = new Client("C01", "Ali Alaoui", "Rabat", "Maroc");
		
		Hotel h = new Hotel();
		h.addRoom(r1);
		h.addRoom(r2);
		h.addRoom(103, 2460);
		h.addClient(c1);
		
		h.addReservation("C01", 103, new Date(22,12,2009), 30);
	
		System.out.println(h.getReservation(0));
		
		h.assign("C01", 103, new Date(22,12,2009), 30);
		
		System.out.println(h.getClientInRoom(103));
	}

}
