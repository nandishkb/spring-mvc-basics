package com.spring.mvc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.spring.mvc.beans.Friend;

@Entity
@Table(name="friend")
public class FriendEntity {

	@Id
	@Column(name="friendId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column
	private String friendName;
	
	@Column(name="friendLocation")
	private String location;
	
	public FriendEntity() {
	}
	
	public FriendEntity(Friend friend) {
		this.id = friend.getId();
		friendName = friend.getFriendName();
		location = friend.getLocation();
	}

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
