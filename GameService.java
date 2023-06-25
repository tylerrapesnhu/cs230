package com.gamingroom;

import java.util.ArrayList;
import java.util.List;

/**
 * A singleton service for the game engine
 * 
 * @author coce@snhu.edu
 */
public class GameService {

	/**
	 * A list of the active games
	 */
	private static List<Game> games = new ArrayList<Game>();

	/*
	 * Holds the next game identifier
	 */
	private static long nextGameId = 1;
	
	/*
	 * Holds the next Player id
	 */
	private static long nextPlayerId = 1;
	
	/*
	 * Holds the next Team id
	 */
	private static long nextTeamId = 1;
	

	private static GameService service = null;

	/**
	 * The singleton pattern restricts a class to only create one object 
	 * but gives the option to add more objects if needed.
	 * In this case, it restricts the game.
	 * @return
	 */

	public static GameService getInstance() {
		
		if (service == null) {
			service = new GameService();
		}
	
		return service;
	}

	/**
	 * The iterator in this case is used to loop through adding and getting the game.
	 * In general, iterators are used to loop. 
	 * @param name
	 * @return
	 */
	
	
	public Game addGame(String name) {

		// a local game instance
		Game game = null;

		if (getGame(name) != null) {
			game = getGame(name);
		}

		// if not found, make a new game instance and add to list of games
		if (game == null) {
			game = new Game(nextGameId++, name);
			games.add(game);
		}

		// return the new/existing game instance to the caller
		return game;
	}

	/**
	 * Returns the game instance at the specified index.
	 * <p>
	 * Scope is package/local for testing purposes.
	 * </p>
	 * @param index index position in the list to return
	 * @return requested game instance
	 */
	Game getGame(int index) {
		return games.get(index);
	}
	
	/**
	 * Returns the game instance with the specified id.
	 * 
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {

		// a local game instance
		Game game = null;

		for (int i = 0; i <getGameCount(); i++) {
			if (games.get(i).getId() == id) {
				game = games.get(i);
			}
		}

		return game;
	}



	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {

		// a local game instance
		Game game = null;

		for (int i = 0; i < getGameCount(); i++) {
			
			if (games.get(i).getName() == name) {
				game = games.get(i);
			}
		}

		return game;
	}

	/**
	 * Returns the number of games currently active
	 * 
	 * @return the number of games currently active
	 */
	public int getGameCount() {
		return games.size();
	}
	
	/**
	 * Returns Teams ID
	 * 
	 * @return
	 */
	public long getNextTeamId() {
		return nextTeamId++;
	}
	
	/**
	 * Returns Player ID
	 * 
	 * @return
	 */
	public long getNextPlayerId() {
		return nextPlayerId++;
	}
}
