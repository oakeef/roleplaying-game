
public class Spider extends Character{

	public Spider() {
		super("Spider", 2, 30, new Weapon("Jaws", 10, 0, "insect-jaws.png"), "spider-alt.png");
	}

	@Override
	public int attack() {
		return diceRoll() + equippedWeapon.attack;
	}

	@Override
	public int diceRoll() {
		return 1 + (int)(10 * Math.random());
	}

}
