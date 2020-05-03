package com.mingwandowski.soommate.model;

public class Room {

	//field
	private int roomId;
	private String roomName;
	private String roomPassword;
	private int userNumber;
	private double totalPrice;
	private String room1Name;
	private String room2Name;
	private String room3Name;
	private String room4Name;
	private String room5Name;
	
	//constructor
	public Room() {	}
	
	public Room(int roomId, String roomName, String roomPassword, int userNumber, double totalPrice, String room1Name,
			String room2Name, String room3Name, String room4Name, String room5Name) {
		this.roomId = roomId;
		this.roomName = roomName;
		this.roomPassword = roomPassword;
		this.userNumber = userNumber;
		this.totalPrice = totalPrice;
		this.room1Name = room1Name;
		this.room2Name = room2Name;
		this.room3Name = room3Name;
		this.room4Name = room4Name;
		this.room5Name = room5Name;
	}

	//getters and setters
	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getRoomPassword() {
		return roomPassword;
	}

	public void setRoomPassword(String roomPassword) {
		this.roomPassword = roomPassword;
	}

	public int getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getRoom1Name() {
		return room1Name;
	}

	public void setRoom1Name(String room1Name) {
		this.room1Name = room1Name;
	}

	public String getRoom2Name() {
		return room2Name;
	}

	public void setRoom2Name(String room2Name) {
		this.room2Name = room2Name;
	}

	public String getRoom3Name() {
		return room3Name;
	}

	public void setRoom3Name(String room3Name) {
		this.room3Name = room3Name;
	}

	public String getRoom4Name() {
		return room4Name;
	}

	public void setRoom4Name(String room4Name) {
		this.room4Name = room4Name;
	}

	public String getRoom5Name() {
		return room5Name;
	}

	public void setRoom5Name(String room5Name) {
		this.room5Name = room5Name;
	}
	
	
	
}
