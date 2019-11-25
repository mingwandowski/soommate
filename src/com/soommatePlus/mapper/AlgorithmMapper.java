package com.soommatePlus.mapper;

import java.util.List;

import com.soommatePlus.entity.Result;
import com.soommatePlus.entity.User;

public interface AlgorithmMapper {

	List<User> queryUserByRoomName(String roomName);

	void setResult(Result result);

}
