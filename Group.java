/**
 * This is my code! Its goal is to create groups to
 * place people in and find their average age
 * CS312 - Assignment 8
 * @author Molly O'Hare
 * @version 1
 */
import java.util.ArrayList;
public class Group
{
    protected ArrayList<Person> people;

    public void create()
    {
        people = new ArrayList<Person>();
    }

    public void addPerson(Person p)
    {
        people.add(p);
    }

    public int averageAge()
    {
        int sum = 0;
        for ( Person p : people )
        {
            sum += p.age();
        }
        return sum / people.size();
    }

    public int size()
    {
        return people.size();
    }

    public void display()
    {
        for ( Person p : people )
        {
            p.display();
        }
    }
}
