package com.soommatePlus.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.soommatePlus.entity.Room;
import com.soommatePlus.entity.User;
import com.soommatePlus.mapper.RoomMapper;
import com.soommatePlus.service.RoomService;

public class RoomServiceImpl implements RoomService {
	//service依赖于dao(mapper)
	private RoomMapper roomMapper;
	
	public void setRoomMapper(RoomMapper roomMapper) {
		this.roomMapper = roomMapper;
	}

	@Override
	public boolean signInRoomSucceed(Room room, HttpServletRequest req) {
		List<Room> roomList = roomMapper.signInRoom(room);
		if(roomList.size() == 1) {
			//put room in session
			Room signInRoom = roomList.get(0);
			HttpSession session = req.getSession();
			session.setAttribute("signInRoom", signInRoom);
			//put users in session
			String roomName = signInRoom.getRoomName();
			List<User> userList = roomMapper.queryUserByRoomName(roomName);
			session.setAttribute("signInUser", userList);
			session.setAttribute("currentUserNo", userList.size());
			return true;
		}
		return false;
	}

	@Override
	public boolean signUpRoom(Room room, HttpServletRequest req) {
		roomMapper.signUpRoom(room);
		roomMapper.createResultTable(room);
		HttpSession session = req.getSession();
		session.setAttribute("signInRoom", room);
		//put users in session
		String roomName = room.getRoomName();
		List<User> userList = roomMapper.queryUserByRoomName(roomName);
		session.setAttribute("signInUser", userList);
		return true;
	}

	@Override
	public void signUpUser(User user, HttpServletRequest req) {
		// TODO Auto-generated method stub
		//get roomName from session and put into user;
		HttpSession session = req.getSession();
		Room room = (Room)session.getAttribute("signInRoom");
		String roomName = room.getRoomName();
		user.setRoomName(roomName);
		roomMapper.signUpUser(user);
		//update users and put users in session
		List<User> userList = roomMapper.queryUserByRoomName(roomName);
		session.setAttribute("signInUser", userList);
		session.setAttribute("currentUserNo", userList.size());
	}
}
