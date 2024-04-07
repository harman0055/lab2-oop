package indywinners;

import java.sql.*;
import java.util.*;

import sql.CoreDAO;
import sql.CoreDAOImpl;
import sql.DAOSysException;
import sql.NoSuchEntityException;

/**
 *	Data access object for customer data.  This class bridges the
 *	object to non-object data-store layer.
 *	TODO:	change the following constants in the CoreDAO interface for your database.
 * @author RD
 */
public class IndyWinnerDAO extends CoreDAOImpl<IndyWinnerModel, IndyWinnerPK>	{
	/**
	 * Creates a new instance of IndyWinnerDAO
	 */
	public IndyWinnerDAO() { this(CoreDAO.DRIVER_NAME, CoreDAO.URL, CoreDAO.USER, CoreDAO.PASSWORD);		}

	/**
	 *	Parameterized constructor.  When extending this class the
	 *	derived class must invoke one of this classes constructors
	 *	for proper initialization.
	 *	@param drivername	Driver name for this database
	 * @param url	Database URL which identifies what drive to select.
	 * @param	user		Database user name.
	 *	@param	password	Database password for access.
	 */
	public IndyWinnerDAO(String drivername,
						String url,
						String user,
						String password)	{
		super(drivername, url, user, password);
	}


	/* ACCESSORS	---------------------------------------------------------------- */


	/* MUTATORS	------------------------------------------------------------------- */


	/* BEHAVIOR	--------------------------------------------------------------------	*/
	/**
	 * Called by create() to insert entity state into the data store for a new entity.
	 *	@param	model	Persistence data model for the entity.
	 *	@throws	DAOSysException
	 */
	@Override
	public void dbInsert(IndyWinnerModel model)	throws DAOSysException {
		dbInsert(model, IndyWinnerDAO.INSERT_STM);
	}


	/**
	 * Called by create() to insert entity state into the data store for a new entity.
	 *	@param	model	Persistence data model for the entity.
	 *	@param	insertStm	Data store statement for inserting into the data store.
	 *	@throws	DAOSysException
	 */
	@Override
	public void dbInsert(IndyWinnerModel model, String insertStm) throws DAOSysException		{
		PreparedStatement preparedStm = null;
		Connection connection = null;

		/*
		 * TODO:	Add the code to do an insert into the database based on the passed model object and SQL insert statement
		 * 
		 */
		try {
            connection = connectToDB();
            preparedStm = connection.prepareStatement(insertStm);
            preparedStm.setInt(1, model.getPrimarykey().getYear());
            preparedStm.setString(2, model.getDriver());
            preparedStm.setDouble(3, model.getAverageSpeed());
            preparedStm.executeUpdate();
        } catch (SQLException sex) {
            throw new DAOSysException("dbInsert() SQL Exception\n" + sex.getMessage());
        } finally {
            try {
                releaseAll(null, preparedStm, connection);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
	}

	
	/**
	 * Called by findByPrimaryKey() to retrieve an entity by the primary key.
	 *	@param	primarykey The primary key for an entity.
	 *	@return	The persistence model for the entity, else null entity data is not found.
	 * @throws sql.DAOSysException
	 * @throws sql.NoSuchEntityException
	 */
	@Override
	public IndyWinnerModel dbSelectByPrimaryKey(IndyWinnerPK primarykey)
				throws DAOSysException, NoSuchEntityException	{
		return dbSelectByPrimaryKey(primarykey, IndyWinnerDAO.SELECT_STM);
	}

	
	/**
	 * Called by findByPrimaryKey() to retrieve an entity by the primary key.
	 *	@param	primarykey The primary key for an entity.
	 *	@param	selectStm	Data store statement to get the entity.
	 *	@return	The persistence model for the entity, else null entity data is not found.
	 */
	@Override
	public IndyWinnerModel dbSelectByPrimaryKey(IndyWinnerPK primarykey, String selectStm)
				throws DAOSysException, NoSuchEntityException	{
		
		IndyWinnerPK pk = primarykey;
		Connection connection = null;
		PreparedStatement preparedStm = null;
		ResultSet rs = null;
		IndyWinnerModel model = null;

		/*	
		 * TODO:	Add the code to process a select by primary key against the database
		 * if successful return the newly created model object to the caller
		 */
		try {
            connection = connectToDB();
            preparedStm = connection.prepareStatement(selectStm);
            preparedStm.setInt(1, pk.getYear());
            rs = preparedStm.executeQuery();
            if (rs.next()) {
                model = new IndyWinnerModel();
                model.setPrimarykey(pk);
                model.setDriver(rs.getString("driver"));
                model.setAverageSpeed(rs.getDouble("avgSpeed"));
            } else {
                throw new NoSuchEntityException("No entity found with primary key: " + pk);
            }
        } catch (SQLException sex) {
            throw new DAOSysException("dbSelectByPrimaryKey() SQL Exception\n" + sex.getMessage());
        } finally {
            try {
                releaseAll(rs, preparedStm, connection);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return model;
	}

	/**
	 * Called by findAll() to find all entities in the data store.
	 *	@return	A collection of primary keys representing all of the entities.
	 */
	@Override
	public Collection<IndyWinnerPK> dbSelectAll()	throws DAOSysException {
		return dbSelectAll(IndyWinnerDAO.SELECT_ALL_STM);
	}


	/**
	 * Called by findAll() to find all entities in the data store.
	 *	@param selectStm
	 * @return	A collection of primary keys representing all of the entities.
	 */
	@Override
	public Collection<IndyWinnerPK> dbSelectAll(String selectStm)	throws DAOSysException {
		Connection connection = null;
		PreparedStatement preparedStm = null;
		ResultSet rs = null;
		ArrayList<IndyWinnerPK> list = null;

		/*	
		 * TODO:	Write the code to handle processing of the select statement to select all rows from the IndyWinners table
		 */
        try {
            connection = connectToDB();
            preparedStm = connection.prepareStatement(selectStm);
            rs = preparedStm.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                list.add(new IndyWinnerPK(rs.getInt("year")));
            }
        } catch (SQLException sex) {
            throw new DAOSysException("dbSelectAll() SQL Exception\n" + sex.getMessage());
        } finally {
            try {
                releaseAll(rs, preparedStm, connection);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return list;
	}

	/**
	 * Called by findAll() to find all entities in the data store.
	 *	@return	A collection of primary keys representing all of the entities.
	 */
	public Collection<IndyWinnerPK> dbSelectSetByYear(IndyWinnerPK pk, int setSize)	throws DAOSysException {
		return dbSelectSetByYear(IndyWinnerDAO.SELECT_SET_BY_YEAR_STM, pk, setSize);
	}


	/**
	 * Called by findAll() to find all entities in the data store.
	 *	@param selectStm
	 * @return	A collection of primary keys representing all of the entities.
	 */
	public Collection<IndyWinnerPK> dbSelectSetByYear(String selectStm, IndyWinnerPK pk, int setSize)	throws DAOSysException {
		Connection connection = null;
		PreparedStatement preparedStm = null;
		ResultSet rs = null;
		ArrayList<IndyWinnerPK> list = null;

		try	{
			connection = connectToDB();
			preparedStm = connection.prepareStatement(selectStm);
			preparedStm.setInt(1, pk.getYear());
			rs = preparedStm.executeQuery();

			list = new ArrayList<>();
			int count = 0;
			while (rs.next() && count != setSize) {
                list.add(new IndyWinnerPK(rs.getInt(1)));
                count++;
            }
		}	catch (SQLException sex)	{
			throw new DAOSysException(
						"dbSelectAll() SQL Exception\n"
						+ sex.getMessage());
		}	finally	{
			try	{
				releaseAll(rs, preparedStm, connection);
			} catch (Exception ex)	{
				System.err.println("Error releasing resources <" + ex.toString());
			}
		}

		return list;
	}

	
	
	/**
	 * Called by update() to update state for an entity in the database.
	 *	@param	data	Persistence model for the entity.
	 *	@throws	DAOSysException
	 */
	@Override
	public void dbUpdate(IndyWinnerModel data)	throws DAOSysException	{
		dbUpdate(data, IndyWinnerDAO.UPDATE_STM);
	}

	/**
	 * Called by update() to update state for an entity in the database.
	 *	@param	data	Persistence model for the entity.
	 *	@param	updateStm	Data store update statement.
	 *	@throws	DAOSysException
	 */
	@Override
	public void dbUpdate(IndyWinnerModel data, String updateStm)	throws DAOSysException {
		IndyWinnerModel model = data;
		Connection connection = null;
		PreparedStatement preparedStm = null;
		try	{
			connection = connectToDB();
			preparedStm = connection.prepareStatement(updateStm);

			/*	Grab values from persistent fields to store in database	*/
			preparedStm.setString(1, model.getDriver());
			preparedStm.setDouble(2, model.getAverageSpeed());

 			int rowCount = preparedStm.executeUpdate();
			if (rowCount == 0)	{
 				throw new DAOSysException(
 					"Failed to store state for IndyWinner <"
 					+ model.getYear() + ">");
 			}

		}	catch (SQLException sex)	{
			throw new DAOSysException(
					"dbUpdate() SQL Exception <"
					+ sex.getMessage() + ">");

		}	finally	{
			try	{
				releaseAll(null, preparedStm, connection);
			} catch (Exception ex)	{
				System.err.println("Error releasing resources <" + ex.toString());
			}
		}
	}

	/**
	 * Called by remove() to remove the state for an entity from the data store.
	 *	@param	primarykey	The primary key of the entity to be removed.
	 *	@return
	 * @throws	DAOSysException
	 */
	@Override
	public int dbRemove(IndyWinnerPK primarykey)	throws DAOSysException	{
		return dbRemove(primarykey, IndyWinnerDAO.DELETE_STM);
	}

	/**
	 * Called by remove() to remove the state for a IndyWinner entity from the database.
	 *	@param	primarykey	The primary key of the IndyWinner entity
	 *	to be removed from the data store.
	 *	@param	deleteStm	Statement to remove entity data from the data store.
	 *	@throws	DAOSysException
	 */
	@Override
	public int dbRemove(IndyWinnerPK primarykey, String deleteStm)	throws DAOSysException	{
		IndyWinnerPK pk = primarykey;
		Connection connection = null;
		PreparedStatement preparedStm = null;
		int result = 0;

		try	{
			connection = connectToDB();
			preparedStm = connection.prepareStatement(deleteStm);
			preparedStm.setInt(1, pk.getYear());
			result = preparedStm.executeUpdate();

			if (result == 0)	{
				throw new SQLException(
						"Failed to remove IndyWinner <"
						+ pk.toString() + ">.");
			}

		}	catch (SQLException sex)	{
			throw new DAOSysException(
					"dbRemove() SQL Exception <" + pk.toString() + "> " + sex.getMessage());

		}	finally	{
			try	{
				releaseAll(null, preparedStm, connection);
			} catch (SQLException sqlex)	{
				throw new DAOSysException(sqlex.toString());
			}
		}

		return result;
	}


	/**
	 * Called by getTotalEntities().
	 *	@return	The total number of entities in the data store.
	 *	@throws	DAOSysException
	 */
	@Override
	public int dbCountTotalEntities()	throws DAOSysException	{
		Connection connection = null;
		PreparedStatement preparedStm = null;
		ResultSet rs = null;
		int count = 0;

		try	{
			connection = connectToDB();
			/*	Request a resultset that is scrollable to easily count rows	*/
			preparedStm = connection.prepareStatement(
										IndyWinnerDAO.SELECT_DISTINCT_STM,
										ResultSet.TYPE_SCROLL_INSENSITIVE,
										ResultSet.CONCUR_UPDATABLE);
			rs = preparedStm.executeQuery();

			/*	Go to the last row and get its row number							*/
			rs.last();
			count = rs.getRow();

		}	catch (SQLException sex)	{
			throw new DAOSysException(
						"dbCountTotalIndyWinners() SQL Exception\n"
						+ sex.getMessage());

		}	finally	{
			try	{
				releaseAll(rs, preparedStm, connection);
			} catch	(SQLException sqlex)	{
				throw new DAOSysException(sqlex.toString());
			}
		}

		return count;
	}



	/* ATTRIBUTES	-----------------------------------------------	*/

	/** Statement to select the year from the IndyWinners table															*/
	private static String SELECT_DISTINCT_STM =
		"SELECT DISTINCT year FROM " + "IndyWinners";

	/** Statement to delete an Indy winner row based on primary key, year, from the IndyWinners table.		*/
	private static String DELETE_STM =
		"DELETE FROM " + "IndyWinners"
		+ " WHERE year = ?";

	/** Statement to update a row from the IndyWinners table.															*/
	private static String UPDATE_STM =
		"UPDATE " + "IndyWinners"
		+ " SET "
		+ "driver = ? "
		+ "avgSpeed = ? ";

	/** TODO: fill in the select statement string to select all rows from the IndyWinners table.				*/
	private static String SELECT_ALL_STM = "SELECT year FROM IndyWinners";
	
	/** SQL statement to select by uear from the IndyWinners table.													*/
	private static String SELECT_SET_BY_YEAR_STM =
			"SELECT DISTINCT year " + "FROM " + "IndyWinners WHERE YEAR > ?";

	/** Default SQL select statement for the IndyWinners table.															*/
	private static String SELECT_STM = "SELECT "
		+ " year, "
		+ " driver, "
		+ " avgSpeed "
		+ " FROM IndyWinners "
		+ " WHERE year = ?";

	/** Default prepared insert statement for the IndyWinners table.													*/ 
	private static String INSERT_STM = "INSERT INTO "
		+ "IndyWinners"
		+ " VALUES "
		+ "( ?, ?, ? )";


}	/*	End of Class:	IndyWinnerDAO.java				*/
