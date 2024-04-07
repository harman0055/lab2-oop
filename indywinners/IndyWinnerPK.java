/*
 *  @(#)IndywinnerPK.java
 *
 * Change History:
 * WHEN		WHO		WHAT
 * 
 * 
 * 
 *
 */

package indywinners;


/**
 * IndyWinnerPK is the primary key class for a IndyWinner entity.
 * 
 * Change History:
 * DATE			WHO			WHAT
 * 
 * 
 * 
 * @author    R. Dyer
 * @version   1.0.0
 * 
 */
public class IndyWinnerPK implements java.io.Serializable	{
	/**
	 *	Default constructor.
	 */
	public IndyWinnerPK()	{}

	/**
	 *	Constructor to build a primary key from an Number.
	 *	@param	year	The year of the race.
	 */
	public IndyWinnerPK(Integer year)	{ this.year = year;		}

	/**
	 *	Constructor to build a primary key from a another IndywinnerPK argument.
	 *	@param	primarykey	A IndywinnerPK object.
	 */
	public IndyWinnerPK(IndyWinnerPK primarykey)	{ year = primarykey.getYear();		}


	/* ACCESSORS	--------------------------------------------------	*/
	/**
	 *	Get the customer Number.
	 *	@return	The customer number.
	 */
	public Integer getYear()	{ return year;		}


	/* BEHAVIOR	-----------------------------------------------------	*/
	/**
	 *	Convert this primary key object into a meaningful string.
	 *	@return	This object as a string.
	 */
	@Override
	public String toString()	{ return	year.toString();		}


	/**
	 *	Implementation of the "object" equals method.
	 *	@return	True if the fields of this primary key object equal the
	 *	contents of the fields from the passed primary key object, otherwise
	 *	false, they are not equal.
	 */
	@Override
	public boolean equals(Object obj)	{
		return	obj instanceof IndyWinnerPK
			&&	getYear().equals(((IndyWinnerPK) obj).getYear());
	}

	/**
	 *	Implementation of the "object"hashCode()" method.
	 * Whenever it is invoked on the same object more than once during
	 * an execution of a Java application, the hashCode method
	 * must consistently return the same integer, provided no information
	 * used in equals comparisons on the object is modified.
	 *	@return	A hash code value for the object.
	 */
	@Override
	public int hashCode() {
		return	getYear().toString().hashCode();
	}



	/*	IndyWinner Entity PRIMARY KEY FIELDS ------------------------------	*/
	/** IndyWinner number.																	*/
	private Integer year;

}