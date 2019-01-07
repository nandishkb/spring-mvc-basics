package com.spring.mvc.beans;

import com.spring.mvc.entity.FriendEntity;

/**
 * This is a bean class
 * @author nandishkb
 *
 */
public class Friend {

	private int id;
	private String friendName;
	private String location;
	
	public Friend() {
	}
	
//	public Friend(FriendEntity fr) {
//		this.id = fr.getId();
//		this.friendName = fr.getFriendName();
//		this.location = fr.getLocation();
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFriendName() {
		return friendName;
	}

	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
