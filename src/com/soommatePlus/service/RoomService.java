package com.soommatePlus.service;

import javax.servlet.http.HttpServletRequest;

import com.soommatePlus.entity.Room;
import com.soommatePlus.entity.User;

public interface RoomService {

	boolean signInRoomSucceed(Room room, HttpServletRequest req);

	boolean signUpRoom(Room room, HttpServletRequest req);

	void signUpUser(User user, HttpServletRequest req);
	
}
