import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

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
        User user2 = new User(2,"TechUser","usr2@email.com");
        User user3 = new User(1,"User1","usr1@tt.co.uk");
        User user4 = new User(3,"User3","usr23@tt.co.uk");

        Map<User,String> userStringMap = new HashMap<>();
        userStringMap.put(user1,"User1");
        userStringMap.put(user2,"User2");
        userStringMap.put(user3,"User1");

        for(Map.Entry<User,String> entry: userStringMap.entrySet()){
            System.out.println("Key : "+entry.getKey()+" Value:  "+entry.getValue()+"Hash "+entry.getKey().hashCode());
        }

        // List of users

        List<User> userList = new ArrayList<>();
        userList.add(user4);
        userList.add(user1);
        userList.add(user2);

        // natural sorting :
        // approach 1: Comparable (I)
        // approach 2: Comparator (I)
        Collections.sort(userList,new SortUserByName());

        for (User uu:userList) {
            System.out.println(uu);
        }

        List<String> strings = new ArrayList<>();
        strings.add("Hello");
        strings.add("Welcome");
        strings.add("Hola");

        // natural sort
        Collections.sort(strings,Comparator.reverseOrder());

        for (String sr:strings) {
            System.out.println(sr);
        }

        //LinkedHashMap - use this to maintain the insertion order


        // use an interface or abstract class without implementing it


        // anonymous class
        I1 ii = new I1() {
            @Override
            public void add() {
                System.out.println("Hello Ii");
            }
        };

        I1 iLambda = ()-> System.out.println("Hello Lambda");

        I1 iLambda1 = () -> {
            System.out.print("");
            System.out.print("");
        };

        ii.add();

        Employee emp1 = new Employee(1,"Techmomo",1000);
        Employee emp2 = new Employee(4,"John",300);
        Employee emp3 = new Employee(3,"Bob",400);
        Employee emp4 = new Employee(2,"Steve",1500);


        List<Employee> employees = new ArrayList<>();
        employees.add(emp1);
        employees.add(emp4);
        employees.add(emp3);
        employees.add(emp2);

        // traverse via the list using streams
        employees.stream().forEach(e-> System.out.println(e));

        // sort the list

        //List<Employee> sorted = employees.stream().sorted((e1,e2)-> e1.getSalary() - e2.getSalary()).collect(Collectors.toList());
        //employees.stream().sorted((e1,e2)-> e1.getSalary() - e2.getSalary()).forEach(e->System.out.println(e));
        //employees.stream().sorted(Comparator.comparingInt(Employee::getSalary)).forEach(e->System.out.println(e));

        // build a map from the sorted list
        employees
                .stream()
                //.sorted(Comparator.comparingInt(Employee::getSalary))
                //.collect(Collectors.toMap(k->k.getId(),v->v,(uu,v)->uu,LinkedHashMap::new));
                .collect(Collectors.toMap(Employee::getId, Function.identity(),(e1,e2)-> e1,TreeMap::new))
                .forEach((k,v)-> System.out.println(k +" "+v ));
                //.collect(Collectors.toMap(k->k.getId(),v->v)).forEach((k,v)-> System.out.println(k +" "+v ));

        // end of main
    }
}


class Employee implements Comparable<Employee>{
    private int id;
    private String name;
    private int salary;

    public Employee(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                Double.compare(employee.salary, salary) == 0 &&
                name.equals(employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public int compareTo(Employee o) {
        return this.getSalary() - o.getSalary();
    }
}
class User { //implements Comparable<User>{
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
        return this.id +" ,"+ this.name +" ,"+ this.email;
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

//    @Override
//    public int compareTo(User o) {
//        //return this.getId() - o.getId();
//        // sort by string members;
//        return this.getName().compareTo(o.getName());
//    }
}

class SortUserByName implements Comparator<User>{
    @Override
    public int compare(User o1, User o2) {
        return o2.getName().compareTo(o1.getName());
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
* Problem 1: Sort by User name
*   e.g. [ {1,User1, 1000}, {4,User3,400}, {2,User2,600}]
*   Expected : [
*                {1,User1,1000},
*                {2,User2,600},
*                {4,User3,400}
*     ]
* Problem 2: give me the users in order of highest salary, based on user id
*   e.g. [ {u1,User1, 1000}, {u4,User3,400}, {u2,User2,600}]
*  Expected : {
*                   {u1: {u1,User1,1000}}
*                   {u2: {u2,User2,600}}
*                   {u4: {u4,User3,400}}
*               }
*
* */


@FunctionalInterface
interface I1{
    void add();
    //void sub(); // not permitted
    default void process(){
        System.out.println("Welcome to I1");
    }
}

interface I2 {
    void add();
    static void automate(){
        System.out.println("I2");
    }
    default void process(){
        System.out.println("Welcome to I2");
    }
}

class A implements I1,I2{
    @Override
    public void add() {
        I2.automate();
    }

    @Override
    public void process() {
        // if you want to call the interface default methods
        I1.super.process();
        I2.super.process();

        // call static method
        I2.automate();
    }
}
