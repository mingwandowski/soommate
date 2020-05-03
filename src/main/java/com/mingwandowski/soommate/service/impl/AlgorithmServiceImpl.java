package com.mingwandowski.soommate.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.mingwandowski.soommate.model.Result;
import com.mingwandowski.soommate.model.Room;
import com.mingwandowski.soommate.model.User;
import com.mingwandowski.soommate.dao.IAlgorithmDao;
import com.mingwandowski.soommate.service.AlgorithmService;

public class AlgorithmServiceImpl implements AlgorithmService {
	// service依赖于dao(mapper)
	private IAlgorithmDao algorithmDao;

	public void setIAlgorithmDao(IAlgorithmDao algorithmDao) {
		this.algorithmDao = algorithmDao;
	}

	@Override
	public List<User> queryUserByRoomName(String roomName) {
		List<User> list = algorithmDao.queryUserByRoomName(roomName);
		return list;
	}

	@Override
	public void do2(List<User> userList, HttpServletRequest req) {
		// user各属性转换成数组
		User user1 = userList.get(0);
		User user2 = userList.get(1);

		// 创建result对象，设置roomName
		Result result = new Result();
		result.setRoomName(user1.getRoomName());

		// 从session中拿totalPrice
		HttpSession session = req.getSession();
		Room room = (Room) session.getAttribute("signInRoom");
		double totalPrice = room.getTotalPrice();

		// 定义算法需要的变量，赋值
		double maxPrice = 0;
		double averageSaved = 0;

		// 简单算法
		if (user1.getRoom1Price() >= user2.getRoom1Price()) {
			maxPrice = user1.getRoom1Price() + user2.getRoom2Price();
			averageSaved = (maxPrice - totalPrice) / 2;
			result.setAverageSaved(averageSaved);
			result.setRoom1User(user1.getUserName());
			result.setRoom2User(user2.getUserName());
			result.setRoom1Price(user1.getRoom1Price() - averageSaved);
			result.setRoom2Price(user2.getRoom2Price() - averageSaved);
		} else {
			maxPrice = user2.getRoom1Price() + user1.getRoom1Price();
			averageSaved = (maxPrice - totalPrice) / 2;
			result.setAverageSaved(averageSaved);
			result.setRoom1User(user2.getUserName());
			result.setRoom2User(user1.getUserName());
			result.setRoom1Price(user2.getRoom1Price() - averageSaved);
			result.setRoom2Price(user1.getRoom2Price() - averageSaved);
		}

		algorithmDao.setResult(result);
		session.setAttribute("result", result);
	}

	@Override
	public void do3(List<User> userList, HttpServletRequest req) {
		// user各属性转换成数组
		User user1 = userList.get(0);
		User user2 = userList.get(1);
		User user3 = userList.get(2);

		// 创建result对象，设置roomName
		Result result = new Result();
		result.setRoomName(user1.getRoomName());

		// 从session中拿totalPrice
		HttpSession session = req.getSession();
		Room room = (Room) session.getAttribute("signInRoom");
		double totalPrice = room.getTotalPrice();

		// 定义算法需要的变量，赋值
		double maxPrice = 0;
		double averageSaved = 0;
		String[] index2UserName = { user1.getUserName(), user2.getUserName(), user3.getUserName() };

		int[] combination = new int[3];

		double[][] userPrice = new double[3][3];
		userPrice[0][0] = user1.getRoom1Price();
		userPrice[0][1] = user1.getRoom2Price();
		userPrice[0][2] = user1.getRoom3Price();

		userPrice[1][0] = user2.getRoom1Price();
		userPrice[1][1] = user2.getRoom2Price();
		userPrice[1][2] = user2.getRoom3Price();

		userPrice[2][0] = user3.getRoom1Price();
		userPrice[2][1] = user3.getRoom2Price();
		userPrice[2][2] = user3.getRoom3Price();

		// 排列组合算法
		for (int a = 0; a < 3; a++) {
			combination[0] = a;
			for (int b = 0; b < 3; b++) {
				if (b != a) {
					combination[1] = b;
					for (int c = 0; c < 3; c++) {
						if (c != a && c != b) {
							combination[2] = c;

							double temPrice = userPrice[combination[0]][0] + userPrice[combination[1]][1]
									+ userPrice[combination[2]][2];
							if (temPrice > maxPrice) {
								maxPrice = temPrice;
								averageSaved = (double)Math.round((maxPrice - totalPrice) / 3 * 100) / 100;
								result.setRoom1Price((double)Math.round((userPrice[combination[0]][0] - averageSaved) * 100) / 100);
								result.setRoom1User(index2UserName[combination[0]]);
								result.setRoom2User(index2UserName[combination[1]]);
								result.setRoom3User(index2UserName[combination[2]]);

								result.setRoom1Price(userPrice[combination[0]][0] - averageSaved);
								result.setRoom2Price(userPrice[combination[1]][1] - averageSaved);
								result.setRoom3Price(userPrice[combination[2]][2] - averageSaved);
								
								result.setAverageSaved(averageSaved);
							}

						}
					}
				}
			}
		}
		// for循环结束

		algorithmDao.setResult(result);
		session.setAttribute("result", result);
	}

	@Override
	public void do4(List<User> userList, HttpServletRequest req) {

		// user各属性转换成数组
		User user1 = userList.get(0);
		User user2 = userList.get(1);
		User user3 = userList.get(2);
		User user4 = userList.get(3);

		// 创建result对象，设置roomName
		Result result = new Result();
		result.setRoomName(user1.getRoomName());

		// 从session中拿totalPrice
		HttpSession session = req.getSession();
		Room room = (Room) session.getAttribute("signInRoom");
		double totalPrice = room.getTotalPrice();

		// 定义算法需要的变量，赋值
		double maxPrice = 0;
		double averageSaved = 0;
		String[] index2UserName = { user1.getUserName(), user2.getUserName(), user3.getUserName(),
				user4.getUserName() };

		int[] combination = new int[4];

		double[][] userPrice = new double[4][4];
		userPrice[0][0] = user1.getRoom1Price();
		userPrice[0][1] = user1.getRoom2Price();
		userPrice[0][2] = user1.getRoom3Price();
		userPrice[0][3] = user1.getRoom4Price();

		userPrice[1][0] = user2.getRoom1Price();
		userPrice[1][1] = user2.getRoom2Price();
		userPrice[1][2] = user2.getRoom3Price();
		userPrice[1][3] = user2.getRoom4Price();

		userPrice[2][0] = user3.getRoom1Price();
		userPrice[2][1] = user3.getRoom2Price();
		userPrice[2][2] = user3.getRoom3Price();
		userPrice[2][3] = user3.getRoom4Price();

		userPrice[3][0] = user4.getRoom1Price();
		userPrice[3][1] = user4.getRoom2Price();
		userPrice[3][2] = user4.getRoom3Price();
		userPrice[3][3] = user4.getRoom4Price();

		// 排列组合算法
		for (int a = 0; a < 4; a++) {
			combination[0] = a;
			for (int b = 0; b < 4; b++) {
				if (b != a) {
					combination[1] = b;
					for (int c = 0; c < 4; c++) {
						if (c != a && c != b) {
							combination[2] = c;
							for (int d = 0; d < 4; d++) {
								if (d != a && d != b && d != c) {
									combination[3] = d;

									double temPrice = userPrice[combination[0]][0] + userPrice[combination[1]][1]
											+ userPrice[combination[2]][2] + userPrice[combination[3]][3];
									if (temPrice > maxPrice) {
										maxPrice = temPrice;
										averageSaved = (maxPrice - totalPrice) / 4;
										result.setRoom1User(index2UserName[combination[0]]);
										result.setRoom2User(index2UserName[combination[1]]);
										result.setRoom3User(index2UserName[combination[2]]);
										result.setRoom4User(index2UserName[combination[3]]);

										result.setRoom1Price(userPrice[combination[0]][0] - averageSaved);
										result.setRoom2Price(userPrice[combination[1]][1] - averageSaved);
										result.setRoom3Price(userPrice[combination[2]][2] - averageSaved);
										result.setRoom4Price(userPrice[combination[3]][3] - averageSaved);

										result.setAverageSaved(averageSaved);
									}
								}
							}
						}
					}
				}
			}
		}
		// for循环结束

		algorithmDao.setResult(result);
		session.setAttribute("result", result);
	}

	@Override
	public void do5(List<User> userList, HttpServletRequest req) {
		// TODO Auto-generated method stub
		// user各属性转换成数组
		User user1 = userList.get(0);
		User user2 = userList.get(1);
		User user3 = userList.get(2);
		User user4 = userList.get(3);
		User user5 = userList.get(4);
		
		// 创建result对象，设置roomName
		Result result = new Result();
		result.setRoomName(user1.getRoomName());

		// 从session中拿totalPrice
		HttpSession session = req.getSession();
		Room room = (Room) session.getAttribute("signInRoom");
		double totalPrice = room.getTotalPrice();
		
		// 定义算法需要的变量，赋值
		double maxPrice = 0;
		double averageSaved = 0;
		String[] index2UserName = { user1.getUserName(), user2.getUserName(), user3.getUserName(),
				user4.getUserName(), user5.getUserName() };
		
		int[] combination = new int[5];

		double[][] userPrice = new double[5][5];
		userPrice[0][0] = user1.getRoom1Price();
		userPrice[0][1] = user1.getRoom2Price();
		userPrice[0][2] = user1.getRoom3Price();
		userPrice[0][3] = user1.getRoom4Price();
		userPrice[0][4] = user1.getRoom5Price();

		userPrice[1][0] = user2.getRoom1Price();
		userPrice[1][1] = user2.getRoom2Price();
		userPrice[1][2] = user2.getRoom3Price();
		userPrice[1][3] = user2.getRoom4Price();
		userPrice[1][4] = user2.getRoom5Price();

		userPrice[2][0] = user3.getRoom1Price();
		userPrice[2][1] = user3.getRoom2Price();
		userPrice[2][2] = user3.getRoom3Price();
		userPrice[2][3] = user3.getRoom4Price();
		userPrice[2][4] = user3.getRoom5Price();

		userPrice[3][0] = user4.getRoom1Price();
		userPrice[3][1] = user4.getRoom2Price();
		userPrice[3][2] = user4.getRoom3Price();
		userPrice[3][3] = user4.getRoom4Price();
		userPrice[3][4] = user4.getRoom5Price();
		
		userPrice[4][0] = user5.getRoom1Price();
		userPrice[4][1] = user5.getRoom2Price();
		userPrice[4][2] = user5.getRoom3Price();
		userPrice[4][3] = user5.getRoom4Price();
		userPrice[4][4] = user5.getRoom5Price();
		
		for (int a = 0; a < 5; a++) {
			combination[0] = a;
			for (int b = 0; b < 5; b++) {
				if (b != a) {
					combination[1] = b;
					for (int c = 0; c < 5; c++) {
						if (c != a && c != b) {
							combination[2] = c;
							for (int d = 0; d < 5; d++) {
								if (d != a && d != b && d != c) {
									combination[3] = d;
									for(int e = 0; e < 5; e++) {
										if (e != a && e != b && e != c && e != d) {
											combination[4] = e;
											double temPrice = userPrice[combination[0]][0] + userPrice[combination[1]][1]
													+ userPrice[combination[2]][2] + userPrice[combination[3]][3] + userPrice[combination[4]][4];
											if (temPrice > maxPrice) {
												maxPrice = temPrice;
												averageSaved = (maxPrice - totalPrice) / 5;
												result.setRoom1User(index2UserName[combination[0]]);
												result.setRoom2User(index2UserName[combination[1]]);
												result.setRoom3User(index2UserName[combination[2]]);
												result.setRoom4User(index2UserName[combination[3]]);
												result.setRoom5User(index2UserName[combination[4]]);

												result.setRoom1Price(userPrice[combination[0]][0] - averageSaved);
												result.setRoom2Price(userPrice[combination[1]][1] - averageSaved);
												result.setRoom3Price(userPrice[combination[2]][2] - averageSaved);
												result.setRoom4Price(userPrice[combination[3]][3] - averageSaved);
												result.setRoom5Price(userPrice[combination[4]][4] - averageSaved);

												result.setAverageSaved(averageSaved);
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		// for循环结束

		algorithmDao.setResult(result);
		session.setAttribute("result", result);
	}
}
