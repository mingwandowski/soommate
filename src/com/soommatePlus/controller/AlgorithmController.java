package com.soommatePlus.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.soommatePlus.entity.Room;
import com.soommatePlus.entity.User;
import com.soommatePlus.service.AlgorithmService;

@RequestMapping("algorithmController")
@Controller // AlgorithmController加入Ioc容器
public class AlgorithmController {
	//控制依赖于Service
	@Autowired
	@Qualifier("algorithmService")
	private AlgorithmService algorithmService;
	
	public void setAlgorithmService(AlgorithmService algorithmService) {
		this.algorithmService = algorithmService;
	}
	
	@RequestMapping("startCalculate")
	public String startCalculate(HttpServletRequest req) {
		//拿到session中roomName和userNumber
		HttpSession session = req.getSession();
		Room room = (Room)session.getAttribute("signInRoom");
		String roomName = room.getRoomName();
		int userNumber = room.getUserNumber();
		
		//根据roomName拿到所有的user
		List<User> userList = algorithmService.queryUserByRoomName(roomName);
		
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
