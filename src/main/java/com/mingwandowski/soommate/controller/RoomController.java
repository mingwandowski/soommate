package com.mingwandowski.soommate.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;

import com.mingwandowski.soommate.model.Room;
import com.mingwandowski.soommate.model.User;
import com.mingwandowski.soommate.service.RoomService;

@RequestMapping("roomController")
@Controller // RoomController加入Ioc容器
public class RoomController {
	// 控制依赖于Service
	@Autowired
	@Qualifier("roomService")
	private RoomService roomService;

//	public void setRoomService(RoomService roomService) {
//		this.roomService = roomService;
//	}
	
	@RequestMapping("signInRoom")
	public String signInRoom(Room room, HttpServletRequest req) {
		boolean signInRoomSucceed = roomService.signInRoomSucceed(room, req);
		if(signInRoomSucceed) {
			return "roomPage";
		}
		return "signInRoomFailed";
	}
	
	@RequestMapping("toSignUpRoomPage")
	public String toSignUpRoomPage() {
		return "signUpRoomPage";
	}
	
	@RequestMapping("signUpRoom")
	public String signUpRoom(Room room, HttpServletRequest req) {
		roomService.signUpRoom(room, req);
		return "roomPage";
	}
	
	@RequestMapping("signUpUser")
	public String signUpUser(User user, HttpServletRequest req) {
		roomService.signUpUser(user, req);
		return "roomPage";
	}
}
