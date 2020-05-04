package com.mingwandowski.soommate.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.mingwandowski.soommate.model.User;

public interface AlgorithmService {

	List<User> queryUserByRoomName(String roomName);

	void calculate(List<User> userList, int userNumber, HttpServletRequest req);
}
