/********************************************************************************
 * Driver.java
 * Eddie Chapman
 * 
 * TODO: driver description
 *******************************************************************************/

package hw5;

import java.util.Scanner;

public class Driver 
{
	public static void main(String[] args) 
	{
		Pokemon[] arrOfPokemons = new Pokemon[4];
		Scanner stdIn = new Scanner(System.in);
		
		Pokemon pokemon = null;
		
		for (int i=0; i<arrOfPokemons.length; i++) 
		{
			while (!contains(pokemon, arrOfPokemons))
			{
				System.out.println("Enter the name, health, power, and level for Pokemon #" + i);
				String[] pokemon_attributes = stdIn.nextLine().split(" ");
				
				String name = pokemon_attributes[0];
				int health = Integer.parseInt(pokemon_attributes[1]);
				int power = Integer.parseInt(pokemon_attributes[2]);
				int level = Integer.parseInt(pokemon_attributes[3]);
				
				pokemon = makePokemon(name, health, power, level);	
				
				if (pokemon != null && !contains(pokemon, arrOfPokemons))
				{
					arrOfPokemons[i] = pokemon;
				}
				else 
				{
					System.out.println("Sorry, something didn't work. Try again?");
				}
			} // end while loop
		} // end for loop
		
		System.out.println();
		System.out.println("Pokemons before playing");
		print(arrOfPokemons);
		System.out.println();
		for(int i=0; i<3;i++)
		{
			play(arrOfPokemons, stdIn, i);
		}
		System.out.println();
		System.out.println("Pokemons After playing");
		print(arrOfPokemons);

		stdIn.close();
	} // end main
	
	//***************************************************************************

	private static void print(Pokemon[] arrOfPokemons)
	{
		//Print the pokemons in the arrOfPokemons array 
		for (int index = 0; index < arrOfPokemons.length; index++) 
		{
			System.out.printf("%d: %s\n", index, arrOfPokemons[index].toString());
		}
	}
	
	//***************************************************************************
	
	private static void play(Pokemon[] arrOfPokemons, Scanner stdIn, int numberOfPlay) 
	{
		int firstPokemon=0;
		int secondPokemon=0;
		do
		{
			System.out.printf("# %d Please enter the pokemons you want to play 0 to 3: ",numberOfPlay);
			firstPokemon = stdIn.nextInt();
			secondPokemon = stdIn.nextInt();
		}
		while(firstPokemon<0 ||firstPokemon>4 ||secondPokemon<0 ||secondPokemon>4 );
		
		arrOfPokemons[firstPokemon].specialAttack(arrOfPokemons[secondPokemon]);

		//think of this part as a counterattack
		arrOfPokemons[secondPokemon].physicalAttack(arrOfPokemons[firstPokemon]);
	} // end Play
	
	//***************************************************************************

	/**
	 * Creates a pokemon based on name passed to method.
	 * 
	 * @param name
	 * @param health
	 * @param power
	 * @param level
	 * @return Pokemon (Charmander or Pikachu)
	 */
	static Pokemon makePokemon(String name, int health, int power, int level) 
	{
		Pokemon pokemon = null;
		
		switch (name)
		{
			case "charmander":
				return pokemon = new Charmander(health, power, level);
			case "pikachu":
				return pokemon = new Pikachu(health, power, level);
			default:
				return pokemon;
		} // end switch
		
	}
	
	//***************************************************************************

	/**
	 * Tells if array contains a pokemon already.
	 * 
	 * @param pok
	 * @param arrOfPokemons
	 * @return boolean
	 */
	protected static boolean contains(Pokemon pok, Pokemon[] arrOfPokemons) 
	{
		for (int i=0; i<arrOfPokemons.length; i++)
		{
			if (arrOfPokemons[i] != null && arrOfPokemons[i].equals(pok))
			{
				return false;
			}
		}
		return true;
	}
} // end Driver
