
public class Goblin extends Character {
	
	public Goblin() {
		super("Goblin", 1, 20, new Weapon("fists", 10, 0, "punch.png"), "orc-head.png");
	}

	@Override
	public int attack() {
		return diceRoll() + equippedWeapon.attack;
	}

	@Override
	public int diceRoll() {
		return 1 + (int)(6 * Math.random());
	}

}
