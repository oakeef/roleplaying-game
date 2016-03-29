public class Game {
	
	Hero hero;
	Character enemy;
	Armory armory = new Armory();
	
	public void setHero(String heroName) {
		this.hero = new Hero(heroName);
	}
	//battle method runs the hero attack and enemy attack methods until one of their isDead methods is true.
	//In which case it jumps out to the winBattle method or just quits the game if you lose.
	//this returns a string which is the message it displays to the textbox.
	public String battle(){
		enemy = (Character) getEnemy();
		String message="";
		while(true){
			message += (attack(hero, enemy) + "\n");
			message += (enemy.name + " has " + enemy.getCurrentHealth() + "HP remaining \n");
			if(enemy.isDead()){
				message += (winBattle(hero, enemy)+"\n");
				break;
			}//end if
			message += (attack(enemy, hero)+"\n");
			message += (hero.name + " has " + hero.getCurrentHealth() + "HP remaining \n");
			if(hero.isDead()){
				message += (hero.name + " was killed by the " + enemy.name +"\n");
				break;
			}//end if
		}//end while
		return message;
	}//end battle
	
	//attack method takes an attacker object and a defender object so it can be used for each characters attack.
	//creates an integer with the attackers damage dealt and pumps it into the takeDamage method of the defender.
	//returns a string of what happened that turn.
	public String attack(Character attacker, Character defender){
		int attackDamage = attacker.attack();
		defender.takeDamage(attackDamage);
		defender.getCurrentHealth();
		String message = attacker.name + " did " + attackDamage + " Damage with "
				+ attacker.equippedWeapon.name;
		return  message;
	}//end attack
	
	//winBattle method takes a Hero object and a Character object because the hero is the only one that can win a battle, 
	//if an enemy wins than the game is over. this method gives the hero the enemy's gold, goes up a level and resets HP and damageTaken.
	public String winBattle(Hero hero, Character defender){
		hero.getGold(defender.gold);
		hero.level +=1;
		hero.currentHP = Character.BASE_HP;
		hero.damageTaken = 0;
		String message = hero.name + " slayed the " + defender.name + " and gained "
						+ defender.gold + " gold!";
		return message;
	}
	
	//getEnemy Method checks the hero character's level and send returns more difficult ones based on that.
	public Character getEnemy(){
		if(hero.level <= 2){
			return new Goblin();
		}else if(hero.level == 3){
			return new Spider();
		}else if(hero.level == 4){
			return new DarkLord();
		}else 
			return new Dragon();
	}
}//end game
