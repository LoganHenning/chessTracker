package com.promineotech.chessTracker.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.promineotech.chessTracker.entity.Game;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Player {
	
	private Long id;
	private String firstName;
	private String lastName;
	private Set<Game> games;
	
	@JsonIgnore
	private Set<PlayerGame> playerGames;
	
	public Player() {}
	public Player(String string) {}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@OneToMany(mappedBy = "player")
	public Set<PlayerGame> getPlayerGames(){
		return playerGames;
	}
	
	public void setPlayerGames(Set<PlayerGame> playerGames) {
		this.playerGames = playerGames;
	}
	
	@ManyToMany(mappedBy = "players")
	public Set<Game> getGames(){
		return games;
	}
	
	public void setGames(Set<Game> games) {
		this.games = games;
	}
	
	

}
