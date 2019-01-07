package com.spring.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.mvc.beans.Friend;
import com.spring.mvc.dao.FriendDao;

@Service("friendService")
public class FriendService {

	@Autowired
	private FriendDao friendDao;
	
	public void saveFriend(Friend friend) {
		friendDao.saveToDB(friend);
	}

	public List<Friend> listFriends() {
		return friendDao.listFriends();
	}

	public void deleteFriend(int id) {
		friendDao.deleteFriend(id);
	}

	public Friend getFriendById(int id) {
		return friendDao.getFriendById(id);
	}

}
