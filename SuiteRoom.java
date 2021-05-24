/**
	This class represents a Suite Hotel Room.
	@author Haniya Ahmed
*/

import java.util.Random;

public class SuiteRoom extends Room
{
	// Number of beds included in room cost.
	private int NUM_BEDS_INC = 3;

	//The cost of extra bed per night.
	private int BED_COST = 15;

	//The base rate per night.
	private int BASE_RATE = 380;

	/**
	This method create a suite hotel room.
	@param guestName Name of guest making booking.
	@param numGuests total number of guest.
	@parma numBeds number of beds required.
	@param numNights number of night staying.
	*/
	public SuiteRoom(String guestName, int numGuests, int numBeds, int numNights)
	{
	  super(guestName,numGuests,numBeds,numNights);
	}
	

	/**
	 This method calculate and return the total cost.
	 @return returns the Total cost.
	*/	
	
	public double calcCost()
	{
	 double bedCost = 0.0;
	 int bedwant = getnumBeds();
	 while(bedwant > NUM_BEDS_INC) {
	  bedCost = bedCost + BED_COST;
	  bedwant = bedwant - 1;
	  }

	  double cost = (getnumNights() * BASE_RATE) + (getnumNights() * bedCost);
	  return cost;
	}
	
	/**
	This method randomly chooses between 3 perks.
	@returns retuns the chooses perks.
	*/
	public String perks()
	{
	  Random generator = new Random(); 
	  String perk = "NO";
	  int randInt = generator.nextInt(3);
	  if(randInt == 0)
	    perk = "Champagne";
	
	  if(randInt == 1)
	     perk = "Chocolates";

	  if(randInt == 2)
	    perk = "Fruit Basket";

	 return perk;
	   
	}
	
}

