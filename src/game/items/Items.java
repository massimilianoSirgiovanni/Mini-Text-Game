package game.items;

import game.BoardContent;
import game.Hero;

public abstract class Items extends BoardContent {

	public Items() {
		this.setIcon("I");
	}
	
	public abstract void use(Hero hero);
}
