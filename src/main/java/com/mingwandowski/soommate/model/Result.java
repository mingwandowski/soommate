package com.mingwandowski.soommate.model;

public class Result {

	//field
	private int resultId;
	private String roomName;
	private double averageSaved;
	private String room1User;
	private double room1Price;
	private String room2User;
	private double room2Price;
	private String room3User;
	private double room3Price;
	private String room4User;
	private double room4Price;
	private String room5User;
	private double room5Price;
	
	//constructor
	public Result() {}
	
	public Result(int resultId, String roomName, double averageSaved, String room1User, double room1Price, String room2User,
			double room2Price, String room3User, double room3Price, String room4User, double room4Price,
			String room5User, double room5Price) {
		this.resultId = resultId;
		this.roomName = roomName;
		this.averageSaved = averageSaved;
		this.room1User = room1User;
		this.room1Price = room1Price;
		this.room2User = room2User;
		this.room2Price = room2Price;
		this.room3User = room3User;
		this.room3Price = room3Price;
		this.room4User = room4User;
		this.room4Price = room4Price;
		this.room5User = room5User;
		this.room5Price = room5Price;
	}

	//getters and setters
	public int getResultId() {
		return resultId;
	}

	public void setResultId(int resultId) {
		this.resultId = resultId;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	
	public double getAverageSaved() {
		return averageSaved;
	}
	
	public void setAverageSaved(double averageSaved) {
		this.averageSaved = averageSaved;
	}

	public String getRoom1User() {
		return room1User;
	}

	public void setRoom1User(String room1User) {
		this.room1User = room1User;
	}

	public double getRoom1Price() {
		return room1Price;
	}

	public void setRoom1Price(double room1Price) {
		this.room1Price = room1Price;
	}

	public String getRoom2User() {
		return room2User;
	}

	public void setRoom2User(String room2User) {
		this.room2User = room2User;
	}

	public double getRoom2Price() {
		return room2Price;
	}

	public void setRoom2Price(double room2Price) {
		this.room2Price = room2Price;
	}

	public String getRoom3User() {
		return room3User;
	}

	public void setRoom3User(String room3User) {
		this.room3User = room3User;
	}

	public double getRoom3Price() {
		return room3Price;
	}

	public void setRoom3Price(double room3Price) {
		this.room3Price = room3Price;
	}

	public String getRoom4User() {
		return room4User;
	}

	public void setRoom4User(String room4User) {
		this.room4User = room4User;
	}

	public double getRoom4Price() {
		return room4Price;
	}

	public void setRoom4Price(double room4Price) {
		this.room4Price = room4Price;
	}

	public String getRoom5User() {
		return room5User;
	}

	public void setRoom5User(String room5User) {
		this.room5User = room5User;
	}

	public double getRoom5Price() {
		return room5Price;
	}

	public void setRoom5Price(double room5Price) {
		this.room5Price = room5Price;
	}
	
	
	
}
