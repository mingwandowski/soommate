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
@Controller // AlgorithmController加入Ioc容器
public class AlgorithmController {
	//控制依赖于Service
	@Autowired
	@Qualifier("algorithmService")
	private AlgorithmService algorithmService;
	
//	public void setAlgorithmService(AlgorithmService algorithmService) {
//		this.algorithmService = algorithmService;
//	}
	
	@RequestMapping("startCalculate")
	public String startCalculate(HttpServletRequest req) {
		//拿到session中roomName和userNumber
		HttpSession session = req.getSession();
		Room room = (Room)session.getAttribute("signInRoom");
		String roomName = room.getRoomName();
		int userNumber = room.getUserNumber();
		
		//根据roomName拿到所有的user
		List<User> userList = algorithmService.queryUserByRoomName(roomName);

		algorithmService.calculate(userList, userNumber, req);

		return "resultPage";
	}
	
}
