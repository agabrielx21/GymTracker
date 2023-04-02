import classes.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.util.Vector;


public class Main {
    public static void main(String[] args) throws ParseException {
        Person p1 = new Person("Alex","Gabriel",21,true);
        System.out.println(p1.toString());

        Client c1 = new Client("Alex","Gabriel",21,false,"1121170015943",false);
        System.out.println(c1.toString());

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date data = formatter.parse("21/10/2020");

        STAFF s1 = new STAFF(true,data);
        System.out.println(s1.toString());

        PersonalTrainer a1 = new PersonalTrainer("Alex","Gabriel",21,true,true,data,"Get Fit Programs",7);
        System.out.println(a1.toString());

        Receptioner r1 = new Receptioner("Alex","Gabriel",21,true,true,data,7,"Morning");
        System.out.println(r1.toString());

        Exercise e1 = new Exercise("Plank",4,"Abdomen");
        Exercise e2 = new Exercise("Biceps Curls",3,"Biceps");
        Exercise e3 = new Exercise("Squats",7,"Picioare");
        Meal m1 = new Meal("Curry chicken","pui","orez", 775);
        Meal m2 = new Meal("Steak fries & Pork","porc","cartofi", 1123);

        Vector<Exercise> exercises = new Vector<Exercise>();
        exercises.add(e1);
        exercises.add(e2);
        exercises.add(e3);

        Vector<Meal> meals = new Vector<Meal>();
        meals.add(m1);
        meals.add(m2);

        WorkoutPlan wp1 = new WorkoutPlan(1000,100,exercises);
        EatingPlan ep1 = new EatingPlan(meals);

        Membership mb1 = new Membership(wp1,ep1,new Date(),new Date(),2515);
        System.out.println(mb1.toString());

    }
}