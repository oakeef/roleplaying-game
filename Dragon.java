
public class Dragon extends Character{
	
	public Dragon() {
		super("Dragon", 5, 100, new Weapon("claws", 35, 0, "grasping-claws.png"), "dragon-head.png");
	}

	@Override
	public int attack() {
		int die1 = diceRoll();
		int die2 = diceRoll();
		return die1 + die2 + equippedWeapon.attack;
	}

	@Override
	public int diceRoll(){
		return 1 + (int)(8 * Math.random());
		
	}
}
