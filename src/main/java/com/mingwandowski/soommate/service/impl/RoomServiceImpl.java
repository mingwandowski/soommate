package com.mingwandowski.soommate.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import com.mingwandowski.soommate.model.Room;
import com.mingwandowski.soommate.model.User;
import com.mingwandowski.soommate.dao.IRoomDao;
import com.mingwandowski.soommate.service.RoomService;

public class RoomServiceImpl implements RoomService {
	// IRoomDao is in Ioc container
	// service depends on dao
	private IRoomDao roomDao;
	
	public void setIRoomDao(IRoomDao roomDao) {
		this.roomDao = roomDao;
	}

	@Override
	public boolean signInRoomSucceed(Room room, HttpServletRequest req) {
		List<Room> roomList = roomDao.signInRoom(room);
		if(roomList.size() == 1) {
			//put room in session
			Room signInRoom = roomList.get(0);
			HttpSession session = req.getSession();
			session.setAttribute("signInRoom", signInRoom);
			//put users in session
			String roomName = signInRoom.getRoomName();
			List<User> userList = roomDao.queryUserByRoomName(roomName);
			session.setAttribute("signInUser", userList);
			session.setAttribute("currentUserNo", userList.size());
			return true;
		}
		return false;
	}

	@Override
	public boolean signUpRoom(Room room, HttpServletRequest req) {
		roomDao.signUpRoom(room);
		roomDao.createResultTable(room);
		HttpSession session = req.getSession();
		session.setAttribute("signInRoom", room);
		//put users in session
		String roomName = room.getRoomName();
		List<User> userList = roomDao.queryUserByRoomName(roomName);
		session.setAttribute("signInUser", userList);
		session.setAttribute("currentUserNo", 0);
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
		roomDao.signUpUser(user);
		//update users and put users in session
		List<User> userList = roomDao.queryUserByRoomName(roomName);
		session.setAttribute("signInUser", userList);
		session.setAttribute("currentUserNo", userList.size());
	}
}
