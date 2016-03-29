
public class Hero extends Character{

	public Hero(String heroName) {
		super(heroName, 1, 50, new Weapon("fists", 10, 0, "punch.png"), "visored-helm.png");
	}//end constructor
	
	@Override
	public int attack(){
		return diceRoll() + equippedWeapon.attack;
	}
	
	public void spendGold(int cost){
		gold -= cost;
	}
	
	public void getGold(int goldDrop){
		gold += goldDrop;
	}

	@Override
	public int diceRoll() {
		return 1 + (int)(6 * Math.random());
	}
	
	
}
