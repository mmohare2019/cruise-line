/**
 * This is my code! Its goal is to display the code
 * and to run the GUI
 * CS312 - Assignment 8
 * @author Molly O'Hare
 * @version 1
 */

public class Tester
{
    public static void main(String[] args)
    {
        DiningHall dh = new DiningHall();
        dh.create();

        // adding tables to the dining hall
        Table t1 = new Table();
        t1.create(4, "Table 1");
        dh.addTable(t1);

        Table t2 = new Table();
        t2.create(6, "Table 2");
        dh.addTable(t2);

        Table t3 = new Table();
        t3.create(8, "Table 3");
        dh.addTable(t3);

        // adding group 1 and its members
        Group g1 = new Group();
        g1.create();
        Person molly = new Person();
        molly.create("Molly", 19);
        g1.addPerson(molly);
        Person caroline = new Person();
        caroline.create("Caroline", 11);
        g1.addPerson(caroline);
        System.out.println("Expected average age for group 1: 15, actual: " + g1.averageAge());
        //g1.display();

        // adding group 2 and its members
        Group g2 = new Group();
        g2.create();
        Person tom = new Person();
        tom.create("Tom", 22);
        g2.addPerson(tom);
        Person charlie = new Person();
        charlie.create("Charlie", 18);
        g2.addPerson(charlie);
        System.out.println("Expected avg age for group 2: 20, actual: " + g2.averageAge());
        //g2.display();

        // adding group 3 and its members
        Group g3 = new Group();
        g3.create();
        Person joan = new Person();
        joan.create("Joan", 49);
        g3.addPerson(joan);
        Person annie = new Person();
        annie.create("Annie", 55);
        g3.addPerson(annie);
        Person neil = new Person();
        neil.create("Neil", 63);
        g3.addPerson(neil);
        Person kevin = new Person();
        kevin.create("Kevin", 61);
        g3.addPerson(kevin);
        System.out.println("Expected average age for group 3: 57, actual: " + g3.averageAge());
        //g3.display();

        // adding group 4 and its members
        Group g4 = new Group();
        g4.create();
        Person thomas = new Person();
        thomas.create("Thomas", 50);
        g4.addPerson(thomas);
        Person mike = new Person();
        mike.create("Mike", 55);
        g4.addPerson(mike);
        Person tim = new Person();
        tim.create("Tim", 60);
        g4.addPerson(tim);
        System.out.println("Expected average age for group 4: 55, actual: " + g4.averageAge() + "\n");

        // assigning the tables
        dh.placeGroup(g1);
        dh.placeGroup(g2);
        dh.placeGroup(g3);
        dh.placeGroup(g4);

        dh.seatingChart();

        // testing the find table
        Table finder1 = dh.findTable(mike);
        System.out.println("\nTable for mike is: ");
        finder1.display();

        Table finder2 = dh.findTable(tom);
        System.out.println("\nTable for tom is: ");
        finder2.display();

        // call for the GUI 
        GUI gui = new GUI(dh.toString());
    }
}
