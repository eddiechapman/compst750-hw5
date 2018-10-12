/********************************************************************************
f * Charmander.java
 * Eddie Chapman
 * 
 * TODO: class description
 *******************************************************************************/

package hw5;

public class Charmander extends Pokemon {

	private final static int fireBall = 5;
	private final static int bite = 4;
	
	//***************************************************************************
	
	public Charmander(int health, int power, int level)
	{
		super("Charmander", health, power, level);
	}
	
	//***************************************************************************
	
	@Override
	public String toString()
	{
		return "Name: " + name +
				"\nLevel: " + level +
				"\nHealth: " + health +
				"\nPower: " + power;
		
	} // end toString
	
	//***************************************************************************
	
	@Override
	public boolean equals(Object other)
	{
		if (other == this)
		{
			return true;
		}
		if (!(other instanceof Charmander))
		{
			return false;
		}
		Charmander c = (Charmander) other;
		return c.name.equals(this.name) && 
				c.health == this.health && 
				c.level == this.level &&
				c.power == this.power;
	} // end equals
	
	//***************************************************************************
	
	@Override
	public void specialAttack(Pokemon target)
	{
		// Call physical attack instead when power is insufficient for fireBall
		if (power < fireBall) 
		{
			physicalAttack(target);
			return;
		}
		
		target.hurt(fireBall);
		power -= fireBall;
		
		// Deplete power when remainder is insufficient for another attack
		if (power < fireBall) 
		{
			power = 0;
		}
	} // end specialAttack
	
	//***************************************************************************
	
	@Override
	public void physicalAttack(Pokemon target)
	{
		target.hurt(bite);
	}
} // end class Pikachu
