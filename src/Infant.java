import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Infant class that contains information about infant trials
 * 
 * @author Huy Vu
 * @version 10/8/17
 */
public class Infant extends MultipleItemAbstract implements Iterable<Trial>
{
    /** ArrayList containing all the available trials for the infant */
    private ArrayList<Trial> trialList;
    
    /** String with ID of the infant */
    private String infantID;
    
    /** Maximum weeks the infant has trial data for */
    private final int maxWeeks = 16;
    
    /**
     * Constructs an Infant item that contains its weeks of trials
     * @param directory location of the trial file
     * @param infantID ID of the infant being studied
     * @throws IOException if there is an error finding a trial
     */
    public Infant(String directory, String infantID) throws IOException
    {
        this.infantID = infantID;
        this.trialList = new ArrayList<Trial>();
        
        for (int week = 1; week <= maxWeeks; ++week)
        {
            try
            {
                trialList.add(new Trial(this, directory, infantID, week));
            }
            catch (FileNotFoundException e)
            {
                //Trial was unavailable. Move to next Trial
            }
        }
    }
    
    /**
     * Constructor which takes an already existing infant and makes a subset of trials
     * from that infant
     * @param infant the already existing infant
     * @param indices a list of indices which correspond to the subset of trials
     */
    public Infant(Infant infant, int[] indices)
    {
        this.infantID = infant.getInfantID();
        trialList = new ArrayList<Trial>();
        for (int i = 0; i < indices.length; ++i)
        {
            // Ensure that the index is legal
            if (indices[i] >= 0 && indices[i] < infant.getSize())
            {
                // Add the trial reference to this infant's trial list
                this.trialList.add(infant.getItem(indices[i]));
            }
        }
    }
    
    /**
     * Retrieves a trial at a specified index
     * @param index int for index of the trial wanted
     * @return Trial item at the index
     */
    public Trial getItem(int index)
    {
        return trialList.get(index);
    }
    
    /**
     * Retrieves the amount of trials there are for the infant
     * @return size of the trialList
     */
    public int getSize()
    {
        return trialList.size();
    }
    
    /**
     * Retrieve the ID of the infant
     * @return infantID string
     */
    public String getInfantID()
    {
        return infantID;
    }
    
    /**
     * Creates an iterator to iterate over the infant's trials
     * @return an iterator which iterates over the infant's trials
     */
    public Iterator<Trial> iterator()
    {
        return trialList.iterator();
    }
}
