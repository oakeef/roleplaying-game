import java.util.ArrayList;

public class Armory {

	public ArrayList<Weapon> weapons = new ArrayList<Weapon>();
	
	public Armory(){
		weapons.add(new Weapon("Axe", 25, 40, "battle-axe.png"));
		weapons.add(new Weapon("Sword", 40, 100, "broadsword.png"));
		weapons.add(new Weapon("Mace", 27, 56, "spiked-mace.png"));
		weapons.add(new Weapon("Bow", 20, 37, "pocket-bow.png"));
	}
	

	
	public void listWeapons(){
		for(int i = 0; i < weapons.size(); i++)
			System.out.println(weapons.get(i));
		
	}
	
	public void buyWeapon(int index, Hero hero){
		Weapon newWeapon = weapons.get(index);
		if(newWeapon.cost <= hero.gold){
			hero.equippedWeapon = newWeapon;
			hero.spendGold(newWeapon.cost);
		}else
			System.out.println("You don't have enough money");
	}
}
