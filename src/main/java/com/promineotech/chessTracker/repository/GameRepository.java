package com.promineotech.chessTracker.repository;

import com.promineotech.chessTracker.entity.Game;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Game, Long>{

}
