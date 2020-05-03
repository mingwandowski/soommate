package com.mingwandowski.soommate.dao;

import java.util.List;

import com.mingwandowski.soommate.model.Result;
import com.mingwandowski.soommate.model.User;

public interface IAlgorithmDao {

	List<User> queryUserByRoomName(String roomName);

	void setResult(Result result);

}
