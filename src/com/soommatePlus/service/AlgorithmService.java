package com.soommatePlus.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.soommatePlus.entity.User;

public interface AlgorithmService {

	List<User> queryUserByRoomName(String roomName);

	void do2(List<User> userList, HttpServletRequest req);

	void do3(List<User> userList, HttpServletRequest req);

	void do4(List<User> userList, HttpServletRequest req);
	
	void do5(List<User> userList, HttpServletRequest req);


}
