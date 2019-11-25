package com.soommatePlus.mapper;

import java.util.List;

import com.soommatePlus.entity.Room;
import com.soommatePlus.entity.User;

public interface RoomMapper {

	List<Room> signInRoom(Room room);

	List<User> queryUserByRoomName(String roomName);

	void signUpRoom(Room room);

	void createResultTable(Room room);

	void signUpUser(User user);

}
