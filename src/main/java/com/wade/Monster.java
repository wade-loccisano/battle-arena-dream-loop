package com.wade;

public class Monster {
	
	private String monsterName;
	private int monsterHP;
	
	private String[] nameAdjectives = {"Ardent", "Blazing", "Carnivorous", "Destitute", "Energetic", "Fiery", "Gigantic", "Heliotropic",
										"Interred", "Jellicle", "Kinetic", "Lost", "Monstrous", "Nocturnal", "Omnipotent", "Prehistoric",
										"Quintessential", "Random", "Superior", "Territorial", "Unstoppable", "Vengeful", "Weird", "X-ray",
										"Yakuza", "Zephyr"};
	private String[] nameNouns = {"Aswang", "Banshee", "Chupacabra", "Dhampir", "Echidna", "Fae", "Gorgon", "Harpy", "Igor", "Java", "Kitsune",
									"Lamia", "Mermaid", "Necromancer", "Octopus", "Phoenix", "Queen", "Roc", "Succubus", "Titan", "Unicorn",
									"Velociraptor", "Wight", "Xerxes", "Yak", "Zuul"};
	
	public Monster() {
		this.monsterName = randomizeMonsterName(nameAdjectives, nameNouns);
		this.monsterHP = 10;
	}
	
	public String getMonsterName() {
		return this.monsterName;
	}

	public int getMonsterHP() {
		return monsterHP;
	}

	public void setMonsterHP(int monsterHP) {
		this.monsterHP = monsterHP;
	}

	public void setMonsterName(String monsterName) {
		this.monsterName = monsterName;
	}
	
	public void decreaseMonsterHP(int amount) {
		this.monsterHP = monsterHP - amount;
	}
	
	public String randomizeMonsterName(String[] adjective, String[] noun) {
		int rollOne = (int)(Math.random() * 26);
		int rollTwo = (int)(Math.random() * 26);
		
		String name = adjective[rollOne] + " " + noun[rollTwo];
		return name;
	}
	
}
