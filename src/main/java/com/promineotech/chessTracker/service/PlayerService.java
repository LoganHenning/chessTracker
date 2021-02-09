package com.promineotech.chessTracker.service;

import com.promineotech.chessTracker.entity.Game;

import com.promineotech.chessTracker.entity.Player;
import com.promineotech.chessTracker.entity.PlayerGame;
import com.promineotech.chessTracker.repository.PlayerRepository;
import com.promineotech.chessTracker.view.PlayerHistory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PlayerService {
	
	private static final Logger logger = LogManager.getLogger(PlayerService.class);
	
	@Autowired
	private PlayerRepository repo;
	
	@Autowired
	PlayerGameService playerGameService;
	
	public Player getPlayerById(Long id) {
		try {
			return repo.findOne(id);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to retrieve player: " + id, e);
			throw e;
		}
	}
	
	public Iterable<Player> getPlayers() {
		return repo.findAll();
	}
	
	public Player createPlayer(Player player) {
		return repo.save(player);
	}
	
	public Player updatePlayer(Player player, Long id) throws Exception {
		try {
			Player oldPlayer = repo.findOne(id);
			oldPlayer.setFirstName(player.getFirstName());
			oldPlayer.setLastName(player.getLastName());
			return repo.save(oldPlayer);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to update player: " + id, e);
			throw new Exception("Unable to update player.");
		}
	}
	
	public void deletePlayer(Long id) throws Exception {
		try {
			repo.delete(id);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to delete player: " + id, e);
			throw new Exception("Unable to delete player.");
		}
	}
	
	public PlayerHistory getPlayerHistoryById(Long id) throws Exception {
		try {
			PlayerHistory playerHistory = new PlayerHistory();
			playerHistory.setPlayer(getPlayerById(id));
			Iterable<PlayerGame> playerGames = playerGameService.getPlayerGames();
			
			Set<Game> gamesList = new HashSet<>();
			for (PlayerGame pg : playerGames) {
				if (pg.getPlayer().getId() == id) {
					gamesList.add(pg.getGame());
					
					if (pg.getPlayerWon()) {
						playerHistory.setWins(playerHistory.getWins() +1);
					} else {
						playerHistory.setLosses((playerHistory.getLosses() + 1));
					}
				}
			}
			playerHistory.setGames(gamesList);
			
			return playerHistory;
		} catch (Exception e) {
			logger.error("Exception occurred while trying to retrieve player hitory: " + id, e);
			throw e;
		}
	}
	
}
