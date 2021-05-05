package WesCollectionTypes;
import java.util.*;

public class CollectionTypes {

        public static void main(String[] args) {

            System.out.println("Welcome to Assignment 1 for CIT 360");

            System.out.println("\n*----This is my List----*");
            List wesList = new ArrayList();
            wesList.add("Bacon");
            wesList.add("Eggs");
            wesList.add("Toast");
            wesList.add("Bacon");
            wesList.add("Hash Browns");
            wesList.add("Pancakes");
            for (int i = 0; i < wesList.size(); i++){
                System.out.println(wesList.get(i));
            }

            System.out.println("\n*----This is my Set----*");
            Set wesSet = new TreeSet();
            wesSet.add("Bacon");
            wesSet.add("Eggs");
            wesSet.add("Toast");
            wesSet.add("Bacon");
            wesSet.add("Hash Browns");
            wesSet.add("Pancakes");
            for (Object str : wesSet) {
                System.out.println((String)str);
            }

            System.out.println("\n*----This is my Queue----*");
            Queue wesQueue = new PriorityQueue();
            wesQueue.add("Bacon");
            wesQueue.add("Eggs");
            wesQueue.add("Toast");
            wesQueue.add("Bacon");
            wesQueue.add("Hash Browns");
            wesQueue.add("Pancakes");
            //System.out.println(wesQueue);
            Iterator iterator = wesQueue.iterator();
            while (iterator.hasNext()) {
                System.out.println(wesQueue.poll());
            }


            System.out.println("\n*----This is my Map----*");
            Map wesMap = new HashMap();
            wesMap.put(1,"Bacon");
            wesMap.put(2,"Eggs");
            wesMap.put(3,"Toast");
            wesMap.put(4,"Bacon");
            wesMap.put(5,"Hash Browns");
            wesMap.put(6,"Pancakes");
            for (int i = 1; i < 6; i++) {
                String result = (String)wesMap.get(i);
                System.out.println(result);
            }


            System.out.println("\n*----This is my List using Generics----*");
            List<Breakfast_Food> wesListGeneric = new LinkedList<Breakfast_Food>();
            wesListGeneric.add(new Breakfast_Food("Bacon", "Pig"));
            wesListGeneric.add(new Breakfast_Food("Eggs", "Chicken"));
            wesListGeneric.add(new Breakfast_Food("Toast", "Wheat Bread"));
            wesListGeneric.add(new Breakfast_Food("Bacon", "Pig"));
            wesListGeneric.add(new Breakfast_Food("Hash Browns", "Potatoes"));
            wesListGeneric.add(new Breakfast_Food("Pancakes", "Flour, Eggs, Milk, etc"));

            for (Breakfast_Food food : wesListGeneric) {
                System.out.println(food);
            }
        }
    }
