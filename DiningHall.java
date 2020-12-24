/**
 * This is my code! Its goal is to assign passengers
 * to tables in our dining hall
 * CS312 - Assignment 8
 * @author Molly O'Hare
 * @version 1
 */
import java.util.ArrayList;
import java.lang.StringBuffer;

public class DiningHall
{
    protected ArrayList<Table> tables;

    public void create()
    {
        tables = new ArrayList<Table>();
    }

    public void addTable (Table t)
    {
        tables.add(t);
    }

    public Table findTable (Person p)
    {
        for ( Table t : tables )
        {
            if (t.lookupPerson(p) == p)
                return t;
        }
        return null;
    }

    public void placeGroup ( Group g )
    {
        // there is a table available in the age range of the group
        Table t = findTableAgeRange(g.averageAge(), g.size());
        if ( t != null )
        {
            for ( Person p : g.people )
                t.addPerson(p);
        }

        // no table that we can add to in the age range
        else
        {
            // try to place them at an empty table
            t = findTableEmpty(g.size());
            if ( t != null )
            {
                for ( Person p : g.people )
                    t.addPerson(p);
            }
            // put group at a table with enough seats
            else
            {
                t = findTableWithFreeSeats(g.size());
                for ( Person p : g.people )
                    t.addPerson(p);
            }
        }

    }

    private boolean ageMatch (Table t, int targetAge, int seatsNeeded)
    {
        return t.isEmpty() && t.spaceFor(seatsNeeded) && t.averageAge() == targetAge + 5 || t.averageAge() == targetAge - 5;
    }

    private boolean zeroOccupants (Table t, int seatsNeeded)
    {
        return t.isEmpty() && t.spaceFor(seatsNeeded);
    }

    private boolean freeSeats (Table t, int seatsNeeded)
    {
        return t.spaceFor(seatsNeeded);
    }

    public Table findTableAgeRange (int targetAge, int seatsNeeded)
    {
        for ( Table t : tables )
        {
            if (ageMatch(t, targetAge, seatsNeeded))
                return t;
        }
        return null;
    }

    public Table findTableEmpty (int seatsNeeded)
    {
        for ( Table t : tables )
        {
            if (zeroOccupants(t, seatsNeeded))
                return t;
        }
        return null;
    }

    public Table findTableWithFreeSeats (int seatsNeeded)
    {
        for ( Table t : tables )
        {
            if (freeSeats(t, seatsNeeded))
                return t;
        }
        return null;
    }

    public void seatingChart()
    {
        System.out.println("Seating Chart");
        for ( Table t : tables )
            t.display();
    }

    // for use in GUI
    // added some HTML for styling
    public String toString()
    {
        StringBuffer buffer = new StringBuffer("<html>");
        buffer.append("<h2>Seating Chart</h2>");
        buffer.append("<ul>");
        for ( Table t : tables ) {
            buffer.append("<li>" + t.tableName + "</li>");
            buffer.append("<ul>");
            for (Person p : t.occupants) {
                buffer.append("<li>Name: " + p.name + " Age: " + p.age + "</li>");
            }
            buffer.append("</ul>");
        }
        buffer.append("</ul></html>");
        String string = buffer.toString();
        return string;
    }
}
