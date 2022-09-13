package com.itc.main.VO;

import com.itc.main.entity.User;

public class ResponseTemplateVO {
	private User user;
	private Favorites favorites;
	private UserFavorites userfavorites;
	
	public ResponseTemplateVO() {
		super();
	}

	public ResponseTemplateVO(User user, Favorites favorites,
			UserFavorites userfavorites) {
		super();
		this.user = user;
		this.favorites = favorites;
		this.userfavorites = userfavorites;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Favorites getFavorites() {
		return favorites;
	}

	public void setFavorites(Favorites favorites) {
		this.favorites = favorites;
	}


	public UserFavorites getUserfavorites() {
		return userfavorites;
	}

	public void setUserfavorites(UserFavorites userfavorites) {
		this.userfavorites = userfavorites;
	}

		

}
