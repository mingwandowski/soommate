package com.mingwandowski.soommate.service;

import javax.servlet.http.HttpServletRequest;

import com.mingwandowski.soommate.model.Room;
import com.mingwandowski.soommate.model.User;

public interface RoomService {

	boolean signInRoomSucceed(Room room, HttpServletRequest req);

	boolean signUpRoom(Room room, HttpServletRequest req);

	void signUpUser(User user, HttpServletRequest req);
	
}
