import javax.swing.ImageIcon;


public class Weapon {

	public String name;
	public int attack;
	public int cost;
	public ImageIcon image;
	
	public Weapon(String name, int attack, int cost, String imageLocation){
		this.name = name;
		this.attack = attack;
		this.cost = cost;
		this.image = new ImageIcon(getClass().getResource("images/"+imageLocation));
	}
	
	public String toString(){
		return this.name + " Damage: " + this.attack + " Cost: " +this.cost;
	}
}
