package com.mingwandowski.soommate.model;

public class User {

	//field
	private int userId;
	private String userName;
	private String roomName;
	private double room1Price;
	private double room2Price;
	private double room3Price;
	private double room4Price;
	private double room5Price;
	
	//constructor
	public User() {	}
	
	public User(int userId, String userName, String roomName, double room1Price, double room2Price, double room3Price,
			double room4Price, double room5Price) {
		this.userId = userId;
		this.userName = userName;
		this.roomName = roomName;
		this.room1Price = room1Price;
		this.room2Price = room2Price;
		this.room3Price = room3Price;
		this.room4Price = room4Price;
		this.room5Price = room5Price;
	}

	//getters and setters
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public double getRoom1Price() {
		return room1Price;
	}

	public void setRoom1Price(double room1Price) {
		this.room1Price = room1Price;
	}

	public double getRoom2Price() {
		return room2Price;
	}

	public void setRoom2Price(double room2Price) {
		this.room2Price = room2Price;
	}

	public double getRoom3Price() {
		return room3Price;
	}

	public void setRoom3Price(double room3Price) {
		this.room3Price = room3Price;
	}

	public double getRoom4Price() {
		return room4Price;
	}

	public void setRoom4Price(double room4Price) {
		this.room4Price = room4Price;
	}

	public double getRoom5Price() {
		return room5Price;
	}

	public void setRoom5Price(double room5Price) {
		this.room5Price = room5Price;
	}
	
}
