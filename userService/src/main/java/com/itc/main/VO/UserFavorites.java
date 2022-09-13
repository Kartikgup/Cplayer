package com.itc.main.VO;

import com.itc.main.entity.User;

public class UserFavorites {
	private User user;
	private Favorites[] favorites;
	public UserFavorites() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserFavorites(User user, Favorites[] favorites) {
		super();
		this.user = user;
		this.favorites = favorites;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Favorites[] getFavorites() {
		return favorites;
	}
	public void setFavorites(Favorites[] favorites) {
		this.favorites = favorites;
	}


}
