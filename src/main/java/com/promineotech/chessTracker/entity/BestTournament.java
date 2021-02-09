package com.promineotech.chessTracker.entity;

import javax.persistence.*;


@Entity
public class BestTournament {
	
	private Long id;
	private String tournamentName;
	private String tournamentLocation;
	private String tournamentPlacing;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String tournamentName() {
		return tournamentName;
	}
	
	public void setTournamentName(String tournamentName) {
		this.tournamentName = tournamentName;
	}
	
	public String tournamentLocation() {
		return tournamentLocation;
	}
	
	public void setTournamentLocation(String tournamentLocation) {
		this.tournamentLocation = tournamentLocation;
	}
	
	public String tournamentPlacing() {
		return tournamentPlacing;
	}
	
	public void setTournamentPlacing(String tournamentPlacing) {
		this.tournamentPlacing = tournamentPlacing;
	}
	
}