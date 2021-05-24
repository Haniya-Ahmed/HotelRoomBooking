/**
	This class represents a Hotel Room.
	@author Haniya Ahmed
*/

public abstract class Room
{
	//The name of the guest Booking.
	private String guestName;

	//The total number of guest.
	private int numGuests;

	//The number of bed needed.
	private int numBeds;

	//The number of nights guest are staying.
	private int numNights;
	

	/**
	This method create a hotel room.
	@param guestName Name of guest making booking.
	@param numGuests total number of guest.
	@parma numBeds number of beds required.
	@param numNights number of night staying.
	*/
	public Room(String guestName, int numGuests, int numBeds, int numNights)
	{
	  this.guestName = guestName;
	  this.numGuests = numGuests;
	  this.numBeds = numBeds;
	  this.numNights = numNights;
	}
	 
	/**
	This method retrives the guestName.
	@return The name of guest making the booking.
	*/
	public String getName()
	{
	 return guestName;
	}
	 

	/**
	This method retrives the number of guests staying.
	@return number of guests staying.
	*/
	public int getnumGuests()
	{
	 return numGuests;
	}
	

	/**
	This method retrives the number of beds required.
	return number of beds.
	*/
	public int getnumBeds()
	{
	 return numBeds;
	}

	
	/**
	This method retrives the number of nights guests are staying.
	@return number of nights guests are staying.
	*/	
	public int getnumNights()
	{
	 return numNights;
	}


	/**
	This is an abstract method for calculating cost.
	*/
	public abstract double calcCost();

}
