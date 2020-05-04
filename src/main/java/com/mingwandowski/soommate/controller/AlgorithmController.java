package com.mingwandowski.soommate.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mingwandowski.soommate.model.Room;
import com.mingwandowski.soommate.model.User;
import com.mingwandowski.soommate.service.AlgorithmService;

@RequestMapping("algorithmController")
@Controller // put AlgorithmController into Ioc container
public class AlgorithmController {
	@Autowired
	@Qualifier("algorithmService")
	private AlgorithmService algorithmService;
	
//	public void setAlgorithmService(AlgorithmService algorithmService) {
//		this.algorithmService = algorithmService;
//	}
	
	@RequestMapping("startCalculate")
	public String startCalculate(HttpServletRequest req) {
		// get roomName and userNumber from session
		HttpSession session = req.getSession();
		Room room = (Room)session.getAttribute("signInRoom");
		String roomName = room.getRoomName();
		int userNumber = room.getUserNumber();

		// get all users by roomName
		List<User> userList = algorithmService.queryUserByRoomName(roomName);

		algorithmService.calculate(userList, userNumber, req);

		return "resultPage";
	}
	
}
