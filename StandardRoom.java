/**
	This class represents a Standard Hotel Room.
	@author Haniya Ahmed
*/

import java.util.Random;

public class StandardRoom extends Room
{
	// Number of beds included in room cost.
	private int NUM_BEDS_INC = 2;

	//The cost of extra bed per night.
	private int BED_COST = 20;

	//The base rate per night.
	private int BASE_RATE = 225;

	//The breakfast cost per night for each guest.
	private double BREAKFAST_RATE = 9.75;

	
	/**
	This method create a standard hotel room.
	@param guestName Name of guest making booking.
	@param numGuests total number of guest.
	@parma numBeds number of beds required.
	@param numNights number of night staying.
	*/
	public StandardRoom(String guestName, int numGuests, int numBeds, int numNights)
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

 	  double costBF = getnumGuests() * BREAKFAST_RATE;
	  double cost = (getnumNights() * BASE_RATE) + (getnumNights() * bedCost) +(getnumNights()* costBF);
	  return cost;
	}
	
	

	/**
	This method randomly chooses a check out time.
	@return returns whether the checkout time is 10 am or 11 am.
	*/
	public String getChekout()
	{
	  Random generator = new Random(); 
	  int randInt = generator.nextInt(2);
	  String Checkout;
	  if(randInt == 0)
	    Checkout = "10 am";
	
	  else
	    Checkout = "11 am";

	 return Checkout;
	}

}
