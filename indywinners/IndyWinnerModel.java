/*
 * IndywinnerModel.java
 *
 * Change History:
 * WHEN		WHO		WHAT
 * 
 * 
 * 
 *
 */

package indywinners;

import sql.CorePersistenceModel;

/**
 * IndywinnerModel represents the persistence model for an Indy Winner  object.
 * @author Reg
 */
public class IndyWinnerModel extends CorePersistenceModel<IndyWinnerPK>	{
	/**
	 * Creates a default instance of IndywinnerModel
	 */
	public IndyWinnerModel() { super();		}

	/**
	 * Creates a new instance of IndywinnerModel with appropriate initial state.
	 * @param year	The year this driver won the Indy.
	 * @param driver	The winning driver for the year of the race.
	 * @param averageSpeed	The average speed the driver attained for the year of the race.
	 */
	public IndyWinnerModel(Integer year,
								String driver,
								Double averageSpeed )	{
		this(new IndyWinnerPK(year), driver, averageSpeed);
	}

	/**
	 * Creates a new instance of IndywinnerModel which represents all of the persistent domain
	 * data for this object type.
	 * @param primarykey	The primary key for this indy winner object.
	 * @param driver	The winning driver for the year of the race.
	 * @param averageSpeed	The average speed the driver attained for the year of the race.
	 */
	public IndyWinnerModel(IndyWinnerPK primarykey,
								String driver,
								Double averageSpeed )	{
		super(primarykey);
		this.driver = driver;
		this.averageSpeed = averageSpeed;
	}


	/* ACCESSORS	--------------------------------------------------	*/
	public Integer  getYear()			{ return getPrimarykey().getYear();		}
	public String getDriver()			{ return driver;								}
	public double getAverageSpeed()	{ return averageSpeed;						}

	
	/* MODIFIERS	--------------------------------------------------	*/
	public void setDriver(String driver)					{ this.driver = driver;					}
	public void setAverageSpeed(double averageSpeed)	{ this.averageSpeed = averageSpeed;	}


	/* ATTRIBUTES	--------------------------------------------------	*/
	/** Drivers name.																	*/
	private String driver;
	/** Average speed during race.												*/
	private Double averageSpeed;

}
