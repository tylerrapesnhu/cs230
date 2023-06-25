package com.gamingroom;

import java.util.List;
import java.util.ArrayList;

/**
 * A simple class to hold information about a team
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a team is
 * created.
 * </p>
 * @author coce@snhu.edu
 *
 */
public class Team extends Entity {
	
	private static List<Player> players = new ArrayList<Player>();
	
	/*
	 * Constructor with an identifier and name
	 */
	public Team(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Player addPlayer(String name ) {
		
		Player player = null;
		
		for (int i = 0; i < players.size() - 1; i++) {
			
			if (players.get(i).getName() == name) {
				player = players.get(i);
			}
		}
		
		if (player == null) {
			GameService service = GameService.getInstance();
			
			player = new Player(service.getNextPlayerId(), name);
			players.add(player);
		}
		
		return player;
		
	}

	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + "]";
	}
}
