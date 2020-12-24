/**
 * This is my code! Its goal is to create tables of
 * people where we can add people to them and find
 * who is sitting at a particular table for a forgetful
 * passenger
 * CS312 - Assignment 8
 * @author Molly O'Hare
 * @version 1
 */
import java.util.ArrayList;
public class Table
{
    protected ArrayList<Person> occupants;
    protected int seatsAvailable;
    protected String tableName;

    public void create (int seats, String name)
    {
        occupants = new ArrayList<Person>();
        seatsAvailable = seats;
        tableName = name;
    }

    public void addPerson (Person p)
    {
        occupants.add(p);
        seatsAvailable --;
    }

    public int averageAge()
    {
        int sum = 0;
        for ( Person p : occupants )
        {
            sum += p.age();
        }
        if ( occupants.size() != 0 )
            return sum / occupants.size();
        else
            return 0;
    }

    public boolean isEmpty()
    {
        return occupants.isEmpty();
    }

    public Person lookupPerson (Person lost)
    {
        for ( Person p : occupants )
        {
            if (p.compareTo(lost) == 0)
                return p;
        }
        return null;
    }

    public boolean spaceFor (int seatsNeeded)
    {
        return seatsAvailable >= seatsNeeded;
    }

    public void display()
    {
        System.out.println(tableName);
        for ( Person p : occupants )
        {
            p.display();
        }
    }
}
