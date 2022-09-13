package com.itc.main.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Favorites {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int favId;
	private String name;
	private String team;
	private int run;
	private int userId;
	public Favorites() {
		super();
	}
	public Favorites(int favId, String name, int run, String team, int userId) {
		super();
		this.favId = favId;
		this.name = name;
		this.team = team;
		this.run = run;
		this.userId = userId;
	}
	public Favorites(int i, String string, int j, String string2) {
		// TODO Auto-generated constructor stub
	}
	public int getFavId() {
		return favId;
	}
	public void setFavId(int favId) {
		this.favId = favId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public int getRun() {
		return run;
	}
	public void setRun(int run) {
		this.run = run;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
}
