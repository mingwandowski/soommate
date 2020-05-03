package com.mingwandowski.soommate.dao;

import java.util.List;

import com.mingwandowski.soommate.model.Room;
import com.mingwandowski.soommate.model.User;

public interface IRoomDao {

	List<Room> signInRoom(Room room);

	List<User> queryUserByRoomName(String roomName);

	void signUpRoom(Room room);

	void createResultTable(Room room);

	void signUpUser(User user);

}
