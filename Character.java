import javax.swing.ImageIcon;


public abstract class Character {

	public String name;
	public int level;
	public static final int BASE_HP = 50;
	public int gold = 0;
	Weapon equippedWeapon;
	public int damageTaken;
	public int currentHP = BASE_HP;
	public ImageIcon image;

	public Character(String name, int level, int gold, Weapon weapon, String imageLocation){
		this.name = name;
		this.level = level;
		this.gold = gold;
		equippedWeapon = weapon;
		this.image = new ImageIcon(getClass().getResource("images/"+imageLocation));
	}
	
	public abstract int attack();
	
	public void takeDamage(int damage){
		damageTaken +=damage;
	}//end takeDamage
	
	public int getCurrentHealth(){
		currentHP = BASE_HP - damageTaken;
		if(currentHP <0)
			return 0;
		return currentHP;
	}//end getCurrentHealth
	
	public boolean isDead(){
		return currentHP <= 0;
	}
	
	public abstract int diceRoll();
	
}
