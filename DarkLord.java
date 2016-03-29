
public class DarkLord extends Character{

	public DarkLord() {
		super("Dark Lord", 4, 70, new Weapon("Mace", 27, 0, "spiked-mace.png"), "overlord-helm.png");
	}

	@Override
	public int attack() {
		int die1 = diceRoll();
		int die2 = diceRoll();
		return die1 + die2 + equippedWeapon.attack;
	}

	@Override
	public int diceRoll() {
		return 1 + (int)(6 * Math.random());
	}

}
