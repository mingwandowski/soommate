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

		//
		//根据userNumber，选择不同的算法，在service层将计算结果放入t_result
		switch (userNumber) {
		case 2: 
			algorithmService.do2(userList, req); break;
		case 3: 
			algorithmService.do3(userList, req); break;
		case 4: 
			algorithmService.do4(userList, req); break;
		case 5: 
			algorithmService.do5(userList, req); break;
		}

		return "resultPage";
	}
	
}
