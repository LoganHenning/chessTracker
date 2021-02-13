package com.promineotech.chessTracker.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.promineotech.chessTracker.entity.Player;

import javax.persistence.*;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Game {
	
	private Long id;
	private String name;
	
	@JsonIgnore
	private Set<PlayerGame> playerGames;
	
	@JsonIgnore
	private Set<Player> players;
	
	public Game() {}
	public Game(String string) {}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@OneToMany(mappedBy = "game")
	public Set<PlayerGame> getPlayerGames(){
		return playerGames;
	}
	
	public void setPlayerGames(Set<PlayerGame> playerGames) {
		this.playerGames = playerGames;
	}
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "gameHistory",
		joinColumns = @JoinColumn(name = "playerId", referencedColumnName = "id"),
		inverseJoinColumns = @JoinColumn(name = "gameId", referencedColumnName = "id"))
	public Set<Player> getPlayers(){
	return players;
	
	}
	
	public void setPlayers(Set<Player> players) {
		this.players = players;
	}
}
