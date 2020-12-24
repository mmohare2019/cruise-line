/**
 * This is my code! Its goal is create a person to
 * store their name and age
 * CS312 - Assignment 8
 * @author Molly O'Hare
 * @version 1
 */
public class Person
{
    protected String name;
    protected int age;

    public void create (String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public int age()
    {
        return this.age;
    }

    // returns 0 of the names are the same
    // returns <0 if string is less than
    // returns >0 if string is greater than (more characters)
    public int compareTo (Person otherGuy)
    {
        return name.compareTo(otherGuy.name);
    }

    public void display()
    {
        System.out.println(" Name: " + name + " Age: " + age);
    }
}
