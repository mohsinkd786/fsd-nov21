import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        int i;
        i = 12;
        Integer in = new Integer(12);

        String str = ""; // literal
        String str1 = new String("");

        int[] nums = new int[2];
        nums[0] = 1;
        nums[1] = 2;

        int[] nums1 = {1,28,9};

        int u = nums1[2];

        // loops
        // for loop
        for (int j = 0; j < nums1.length; j++) {
            System.out.println(nums1[j]);
        }

        // while loop
//        i = nums.length;
//        while(i>0){
//            System.out.println(nums[i]);
//            i--;
//        }

        // for each
        for (int k: nums) {
            System.out.println(k);
        }

        /*
        * Collections :
        *
        *  package : java.util
        * List (I):
        *   Vector
        *   ArrayList
        *   LinkedList
        *
        * Set (I):
        *   HashSet
        *   TreeSet
        *
        * Queue (I):
        *   BlockingQueue
        *   PriorityQueue
        *
        * Stack:
        *
        * Map:
        *   HashMap
        *   TreeMap
        *
        * */

        Child child = new Child();
        child.callMe();

        StepChild stepChild = new StepChild();
        stepChild.tryMe();

        StepParent stepParent1 = new Child();
        stepParent1.add();
        StepParent stepParent2 = new StepChild();

        Parent parent = new Child();
        parent.sayHello();

        // Parent parent1 = new Parent();

        // Iterable -> Collection -> List -> ArrayList
        // Collection (I) - parent I for Java Collections
        // Collections (c) - utility class for java collections
        List list = new ArrayList();
        list.add(10);
        list.add("String");
        list.add(true);
        list.add(10);

        //list.remove(new Integer(10));
        list.remove("String");
        //
        list.get(1);

//        System.out.println("LIST########");
//        for (int j = 0; j < list.size() ; j++) {
//            System.out.println(list.get(j));
//        }

        //for each
        for (Object obj:list) {
            System.out.println(obj);
        }

        //System.out.println("SET^^^^^^^");
        Set set = new HashSet();
        set.add(15);
        set.add("String");
        set.add(true);
        set.add(15);
        set.remove(15);

        //for each
//        for (Object obj:set) {
//            System.out.println(obj);
//        }

        List linkedList = new LinkedList();
        linkedList.add(10);
        linkedList.add("Test");
        linkedList.add("Welcome");

        for (Object o:linkedList) {
            System.out.println(o);
        }

        // Key - value based collections = HashTable / HashMap / Concurrent HashMap
        HashMap<String,Integer> map = new HashMap();
        map.put("One",1);
        map.put("Three",3);
        map.put("One",5);

        //map.put(1,1);


//        for (Map.Entry entry:map.entrySet()) {
////            System.out.println(object);
////        }

        for (String key: map.keySet()) {
            for (Integer val:map.values()) {
                System.out.println(key +"  "+val);
            }
        }

        map.get("One");

        User user1 = new User(1,"User1","usr@gg.com");
        User user2 = new User(2,"User2","usr2@email.com");
        User user3 = new User(1,"User1","usr1@tt.co.uk");

        Map<User,String> userStringMap = new HashMap<>();
        userStringMap.put(user1,"User1");
        userStringMap.put(user2,"User2");
        userStringMap.put(user3,"User1");

        for(Map.Entry<User,String> entry: userStringMap.entrySet()){
            System.out.println("Key : "+entry.getKey()+" Value:  "+entry.getValue()+"Hash "+entry.getKey().hashCode());
        }
    }
}

class User{
    public User(){

    }
    public User(int id, String name,String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    private int id;
    private String name;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.id +" ,"+ this.name + this.email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                name.equals(user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}

//class Abc{
//
//}

/**
 * compilation : javac Main.java
 * class file generation : Main.class , Abc.class
 * runtime execution : java Main or java Abc 1 12
 *
 * integer - byte /short / int / long
 * char - char
 * decimal - float / double
 * boolean - boolean
 *
 *
 * Problem 1: arranges the even numbers first & then the odd numbers in sorted order .
 *
 * e.g. [1,2,9,8,10,5]
 *
 *  expected : [10,8,2,9,5,1]
 *
 * Problem 2: arrange the elements in the order of exact square root in sorted order.
 *
 * e.g. [8,9,10,15,16]
 * roots : [2.8,3,3.3,3.6,4]
 * expected : [4,3,3.6,2.8]
 *
 * */

interface StepParent{
    void add();
}
abstract class Parent{

    void add(){
        System.out.println("Parent");
    }

    abstract void sayHello();
}

class Child extends Parent implements StepParent{

    public void add(){
        System.out.println("Child");
    }
    public void callMe(){

    }

    @Override
    void sayHello() {

    }
}
class StepChild implements StepParent{
    @Override
    public void add() {
        System.out.println("Step Child");
    }

    public void tryMe(){

    }
}

/*
*  Tomorrows Session :
*   Collections : Map , Set
*   Java 8 Streams,
*   Functional Interfaces,
*   Lambdas,
*   Anonymous class
*   Default methods, Static methods
*
*
* */
