/*
 *  @(#)IndyWinner.java
 *
 * Change History:
 * WHEN        WHO     WHAT
 * 
 * 
 * 
 *
 *
 */

package indywinners;

import java.util.*;
import sql.*;

/**
 * <p>Class representing an Indianapolis 500 race winner.
 * This class represents a DOMAIN class type object. It makes use
 * of the DAO design pattern requiring a DAO class, Model class, and Primary Key class.
 * Contained within this class are a number of static members which can be invoked without creating
 * an IndyWinner object. Typically these members perform some kind of search for specific IndyWinner
 * entities or groups of entities. Following the static members you will find the normal POJO type
 * class members representing constructors, getters,setters, normal behavior and helper type methods.
 * Attributes are declared at the bottom of the class definition and include a reference to an Indy Winner model.
 * </p>
 * @author harmandeep,vishu,parinay,harmeet
 * @see indywinners.IndyWinnerDAO
 * @see indywinners.IndyWinnerModel
 * @see indywinners.IndyWinnerPK
 */
public class IndyWinner		{
    /* STATIC PRE-OBJECT BEHAVIOR    -----------------------------------    */
    /* CREATORS    -----------------------------------------------------    */
    /**
     * Create an instance of a new Indy winner.
     * @param year    The year this driver won the Indy.
     * @param driver    The winning driver for the year of the race.
     * @param averageSpeed    The average speed the driver attained for the year of the race.
     * @return    An instance of an IndyWinner entity.
     * @throws sql.CreateException
     */
    public static IndyWinner create(Integer year,
                                            String driver,
                                            Double averageSpeed)
                                                    throws CreateException    {

        /*  TODO:    Add the code for creating an IndyWinner object from the database
         * using the DAO object to insert into the database
         * the appropriate rows and columns for an IndyWinner object. 
         * Use the provided example as a guideline.
         * STEPS:
         * create a model
         * create a try block to catch possible exceptions
         *  get the dao object
         *  use the dao object to insert into the database (pass the model)
         * 
         *      catch any possible exceptions
         * 
         *  return a newly created object (use the overloaded constructor requiring the model
         */

        IndyWinnerModel model = new IndyWinnerModel(year, driver, averageSpeed);
        IndyWinnerDAO dao = null;

        try {
            dao = (IndyWinnerDAO) DAOFactory.getDAO(IndyWinner.className);
            dao.dbInsert(model);
        } catch (Exception ex) {
            throw new CreateException(ex.getMessage());
        }

        return new IndyWinner(model);
    }

    /* FINDERS    -----------------------------------------------------    */
    /*  Finder methods are used to search for a particular instance
     *  or a collection of instances, therefore finders either return
     *  an instance to the entity, or a collection of instances.
     */

    
    /**
     *  Find an Indy winner by its primary key.
     *  @return    An instance of an existing Indy winner entity.
     *  @throws sql.FinderException
     * @throws sql.NoSuchEntityException
     * @param    primarykey    The primary key of the IndyWinner to find.
     */
    public static IndyWinner findByPrimarykey(IndyWinnerPK primarykey)
                                throws FinderException, NoSuchEntityException            {

        IndyWinnerModel model = null;
        IndyWinner entity = null;
        IndyWinnerDAO dao = null;

        /*  TODO:    Add the code for creating an IndyWinner object from the database
         * using the DAO object to insert into the database
         * the appropriate rows and columns for an IndyWinner object. 
         * Use the provided example as a guideline.
         * STEPS:
         * 
         * declare an Indy Winner model (already done above)
         * declare an Indy Winner object (already done above)
         * declare an Indy Winner DAO object (already done above)
         * 
         * create a try block to catch possible exceptions (DAOSysException and NoSuchEntityExcption)
         *  Try
         *      get the dao object
         *      use the dao object to select by primary key
         *          create a new IndyWinner object with the returned model from the dao call
         *
         *  catch any possible exceptions (DAOSysException and NoSuchEntityExcption)
         *          Throw a FinderException
         *  end catch
         * 
         *  return the IndyWinner object
         */

        try {
            model = (IndyWinnerModel) DAOFactory.getDAO(IndyWinner.className).dbSelectByPrimaryKey(primarykey);
            entity = new IndyWinner(model);
        } catch (DAOSysException ex) {
            throw new FinderException(ex.getMessage());
        }

        return entity;
    }

    /**
     *  Find all Indywinner entities.
     *  @return    A collection of Indywinner instances.
     *  @throws    FinderException
     * @throws    CreateException
     */
    public static Collection<IndyWinner> findAll() throws FinderException, CreateException            {
        ArrayList<IndyWinner> listOfIndyWinners = new ArrayList<>();
        IndyWinnerDAO dao = null;

        /*  TODO:    Add the code for creating an array of Indy Winner objects from the database
         * STEPS:
         *  declare an IndyWinner ArrayList (already done, see above)
         *  declare an IndyWinner DAO object (already done, see above)
         * 
         * in a try block:
         *  initialize an Indy Winner DAO object
         *  initialize an Indy Winner collection (use the dao object to run a selectAll to get a collection of primary keys.
         *      get the iterator for the collection of Indy Winners
         *      use a while(...) loop to iterate thru the collection
         * 
         *  use the Iterator to move thru the created array of primary keys
         *      for each primary key
         *          in a try block
         *              use the IndyWinner class to execute findByPrimarykey()
         *              add the IndyWinner object to the array list
         *      when complete exit the loop
         *      exit the outer try block
         *  return the created ArrayList
         */

        try {
            dao = (IndyWinnerDAO) DAOFactory.getDAO(IndyWinner.className);
            Collection<IndyWinnerPK> pkCollection = dao.dbSelectAll();
            Iterator<IndyWinnerPK> pkIterator = pkCollection.iterator();

            while (pkIterator.hasNext()) {
                IndyWinnerPK pk = pkIterator.next();
                try {
                    IndyWinner winner = IndyWinner.findByPrimarykey(pk);
                    listOfIndyWinners.add(winner);
                } catch (FinderException | NoSuchEntityException ex) {
                    System.err.println("IndyWinner: Error processing list <" + ex.toString());
                }
            }
        } catch (DAOSysException ex) {
            throw new FinderException(ex.getMessage());
        }

        return listOfIndyWinners;
    }
    
    /**
     *  Find Indywinner entities

 based on a primary key starting point and retrieve a limited number of entities.
     *  @return    A collection of Indywinner instances.
     *  @throws    FinderException
     * @throws    CreateException
     */
    public static Collection<IndyWinner> findSetGreaterThan(int year, int setSize) throws FinderException, CreateException            {
        ArrayList<IndyWinner> listOfIndyWinners = new ArrayList<>();
        IndyWinnerDAO dao = null;
        IndyWinnerPK primarykey = new IndyWinnerPK(year);
        
        try    {
            dao = (IndyWinnerDAO) DAOFactory.getDAO(IndyWinner.className);
            Collection<IndyWinnerPK> c = dao.dbSelectSetByYear(primarykey, setSize);
            Iterator<IndyWinnerPK> itr = c.iterator();
            while (itr.hasNext())    {
                IndyWinnerPK cpk = itr.next();
                try    {
                    IndyWinner entity = IndyWinner.findByPrimarykey(cpk);

                    /* build/get any other objects for this IndyWinner here        */

                    /* Add this Indywinner to the list.                        */
                    listOfIndyWinners.add(entity);

                } catch (FinderException | NoSuchEntityException ex)    {
                    System.err.println("IndyWinner: Error processing list <" + ex.toString());
                }
            }

        } catch (Exception sqlex)    {
            sqlex.printStackTrace();
            throw new CreateException(sqlex.getMessage());
        }


        return listOfIndyWinners;
    }


    /* REMOVERS    -----------------------------------------------------    */
    /**
     *  Remove an Indywinner by primary key.
     *  @param    primarykey    The primary key for the Indywinner to find.

     */
    private static int removeByPrimarykey(IndyWinnerPK primarykey)
                                throws    DAOSysException, NoSuchEntityException    {
        int rc = 0;
        IndyWinnerDAO dao = null;

        /*  remove any other objects here first ...              */

        /* ...then remove the Indy Winner                                    */
        dao = (IndyWinnerDAO) DAOFactory.getDAO(IndyWinner.className);
        rc = dao.dbRemove(primarykey);

        return rc;
    }


    /* CONSTRUCTORS    -----------------------------------------------    */
    /**
     *  Default constructor
     */
    private IndyWinner()    { super();        }

    /**
     *  Parameterized constructor.
     * @param year    The year this driver won the Indy.
     * @param driver    The winning driver for the year of the race.
     * @param averageSpeed    The average speed the driver attained for the year of the race.
     */
    private IndyWinner(Integer year,
                            String driver,
                            Double averageSpeed)        {
        this(new IndyWinnerModel(year, driver, averageSpeed));
    }

    /**
     *  Parameterized constructor.
     *  @param    model    The persistence model for a Indywinner object.
     */
    private IndyWinner(IndyWinnerModel model)    {
        setModel(model);

        /* add any other initialization requirements here            */

    }


    /* ACCESSORS    --------------------------------------------------    */
    public IndyWinnerModel getModel()            { return model;                                                }
    public IndyWinnerPK getPrimaryKey()            { return getModel().getPrimarykey();                    }
    public Integer getYear()                        { return getModel().getPrimarykey().getYear();         }
    public String getDriver()                        { return getModel().getDriver();                            }
    public Double getAverageSpeed()                { return getModel().getAverageSpeed();                    }


    /* MODIFIERS    --------------------------------------------------    */
    private void setModel(IndyWinnerModel model)    { this.model = model;                                }

    private void setPrimarykey(IndyWinnerPK pk)    { getModel().setPrimarykey(pk);                        }
    public void setDriver(String driver)                {
        getModel().setDriver(driver);
        update();
    }
    public void setAverageSpeed(Double averageSpeed)        {
        getModel().setAverageSpeed(averageSpeed);
        update();
    }

    /* BEHAVIOR    -----------------------------------------------------    */
    /**
     *  Implementation of the "object" equals method.  IndyWinners objects are equal
     * if their primary key's are equal.
     *  @return    True if the fields of this primary key object equal the
     * contents of the fields from the passed primary key object, otherwise
     * false, they are not equal.
     */
    @Override
    public boolean equals(Object obj)    {
        return    obj instanceof IndyWinner
            &&    (getYear().equals(((IndyWinner) obj).getYear())
            );
    }

    /**
     *  Implementation of the "object"hashCode()" method.
     * Whenever it is invoked on the same object more than once during
     * an execution of a Java application, the hashCode method
     * must consistently return the same integer, provided no information
     * used in equals comparisons on the object is modified.
     *  @return    A hash code value for the object.
     */
    @Override
    public int hashCode() {
        return    getYear().toString().concat(
                                getDriver()
                                + getAverageSpeed().toString()
                            ).hashCode();
    }

    /**
     *  Flush cached attribute values to the datastore.
     * Catch and report any errors.
     */
    public void update()    {
        try    {
            store();
        } catch (Exception ex)    {
            System.out.println("C: Error in update(), <" + ex.toString() + ">");
        }
    }


    @Override
    public String toString()    { return this.toString(", ");                }
    public String toString(String sep)    {
        return "year=" + getYear()
                + sep + "driver=" + getDriver()
                + sep + "averageSpeed=" + getAverageSpeed()
            ;
    }

    /**
     *  Remove an Indywinner from the data store (by primary key).
     * @return
     * @throws sql.NoSuchEntityException
     * @throws sql.DAOSysException
     */
    public IndyWinner remove()    throws NoSuchEntityException, DAOSysException    {
        IndyWinner c = null;
        if (removeByPrimarykey(getPrimaryKey()) > 0)    {
            c = this;
        }

        return c;
    }

    /**
     * Invoke this method to refresh the cached attribute values
     * from the database.
     */
    private void load() throws DAOSysException        {
        IndyWinnerDAO dao = null;
        try    {
            dao = (IndyWinnerDAO) DAOFactory.getDAO(IndyWinner.className);
            setModel((IndyWinnerModel)dao.dbLoad(getPrimaryKey()));

        } catch (DAOSysException | NoSuchEntityException ex)    {
            throw new DAOSysException(ex.getMessage());
        }
    }


    /**
     * Invoke this method to save the cached attribute values to the datastore.
     */
    private void store()    throws DAOSysException        {
        IndyWinnerDAO dao = null;
        try    {
            dao = (IndyWinnerDAO) DAOFactory.getDAO(IndyWinner.className);
            dao.dbStore(getModel());
        } catch (Exception ex)    {
            throw new DAOSysException(ex.getMessage());
        }
    }



    /* ATTR

IBUTES    --------------------------------------------------    */
    private static final boolean _debug = false;

    /** Class name for static method purposes.                                */
    private static String className = "indywinners.IndyWinner";

    /** Persistence model for an Indy Winner object.                            */
    private IndyWinnerModel model;


    /* REFERENCE ATTRIBUTES    -----------------------------------------    */


}    /*    End of CLASS:    IndyWinner.java                */

