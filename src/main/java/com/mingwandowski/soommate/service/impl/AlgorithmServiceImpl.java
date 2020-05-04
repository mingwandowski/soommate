package com.mingwandowski.soommate.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.mingwandowski.soommate.model.Result;
import com.mingwandowski.soommate.model.Room;
import com.mingwandowski.soommate.model.User;
import com.mingwandowski.soommate.dao.IAlgorithmDao;
import com.mingwandowski.soommate.service.AlgorithmService;

public class AlgorithmServiceImpl implements AlgorithmService {
	// IAlgorithmDao is in Ioc container
	// service depends on dao
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
	public void calculate(List<User> userList, int userNumber, HttpServletRequest req) {
		// convert userList to User[] array
		User[] users = userList.toArray(new User[0]);

		// create result, set roomName
		Result result = new Result();
		result.setRoomName(users[0].getRoomName());

		// get totalPrice from session
		HttpSession session = req.getSession();
		Room room = (Room) session.getAttribute("signInRoom");
		double totalPrice = room.getTotalPrice();

		// set variables
		double maxPrice = 0;
		double averageSaved = 0;

		double[][] userPrice = new double[userNumber][userNumber];

		// set userPrice
		for(int i = 0; i < userNumber; i++){
			userPrice[i][0] = users[i].getRoom1Price();
			userPrice[i][1] = users[i].getRoom2Price();
			if(userNumber == 2) continue;
			userPrice[i][2] = users[i].getRoom3Price();
			if(userNumber == 3) continue;
			userPrice[i][3] = users[i].getRoom4Price();
			if(userNumber == 4) continue;
			userPrice[i][4] = users[i].getRoom5Price();
		}

		// set combination
		List<Integer[]> combinations = getCombination(userNumber);

		// traversal all combination
		for(Integer[] combination : combinations){
			// get tmp price
			double tmpPrice = 0.0;
			for(int i = 0; i < combination.length; i++)
				tmpPrice += userPrice[combination[i]][i];
			if(tmpPrice <= maxPrice) continue;
			// tmp price > max price
			maxPrice = tmpPrice;
			averageSaved = (maxPrice - totalPrice) / userNumber;
			BigDecimal bg = new BigDecimal(averageSaved);
			averageSaved = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();


			result.setRoom1User(users[combination[0]].getUserName());
			result.setRoom2User(users[combination[1]].getUserName());
			if(userNumber >= 3) result.setRoom3User(users[combination[2]].getUserName());
			if(userNumber >= 4) result.setRoom4User(users[combination[3]].getUserName());
			if(userNumber == 5) result.setRoom5User(users[combination[4]].getUserName());

			result.setRoom1Price(userPrice[combination[0]][0] - averageSaved);
			result.setRoom2Price(userPrice[combination[1]][1] - averageSaved);
			if(userNumber >= 3) result.setRoom3Price(userPrice[combination[2]][2] - averageSaved);
			if(userNumber >= 4) result.setRoom4Price(userPrice[combination[3]][3] - averageSaved);
			if(userNumber == 5) result.setRoom5Price(userPrice[combination[4]][4] - averageSaved);

			result.setAverageSaved(averageSaved);
		}

		// set result into session
		algorithmDao.setResult(result);
		session.setAttribute("result", result);
	}

	private List<Integer[]> getCombination(int userNumber) {
		List<Integer[]> res = new ArrayList<>();
		boolean[] visited = new boolean[userNumber];
		backtrack(res, visited, new ArrayList<Integer>());
		return res;
	}

	private void backtrack(List<Integer[]> res, boolean[] visited, ArrayList<Integer> list) {
		if(list.size() == visited.length){
			res.add(list.toArray(new Integer[0]));
			return;
		}
		for(int i = 0; i < visited.length; i++){
			if(visited[i]) continue;
			list.add(i);
			visited[i] = true;
			backtrack(res, visited, list);
			visited[i] = false;
			list.remove((Integer)i);
		}
	}
}
