package com.promineotech.chessTracker.controller;

import com.promineotech.chessTracker.entity.Game;
import com.promineotech.chessTracker.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/games")
public class GameController {
	
	@Autowired
	private GameService service;

	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getGame(@PathVariable Long id) {
		try {
			return new ResponseEntity<Object>(service.getGameById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Object> getGames() {
		return new ResponseEntity<Object>(service.getGames(), HttpStatus.OK);
	}
	
		
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> createGame(@RequestBody Game game) {
		return new ResponseEntity<Object>(service.createGame(game), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateGame(@RequestBody Game game, @PathVariable Long id) {
		try {
			return new ResponseEntity<Object>(service.updateGame(game, id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteGame(@PathVariable Long id) {
		try {
			service.deleteGame(id);
			return new ResponseEntity<Object>("Successfully deleted game with id: " + id, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
}
