package com.gamingroom;

import java.util.List;
import java.util.ArrayList;

/**
 * A simple class to hold information about a game
 * 
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a game is
 * created.
 * </p>
 * 
 * @author coce@snhu.edu
 *
 */

//extending Entity
public class Game extends Entity {
	
	private static List<Team> teams = new ArrayList<Team>();
	
	public Game(long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Team addTeam (String name) {
		
		Team team = null;
		
		for (int i = 0; i < teams.size() - 1; i++) {
			if (teams.get(i).getName() == name) {
				team = teams.get(i);
			}
		}
		
		if (team == null) {
			GameService service = GameService.getInstance();
			
			team = new Team(service.getNextPlayerId(), name);
			teams.add(team);
			
		}
		
		return team;
		
	}
	@Override
	public String toString() {
		
		return "Game [id=" + id + ", name=" + name + "]";
	}

}
