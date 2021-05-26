package eLearn;

public class Person {
    private String name;
    private String surname;
    private String CNP;
    private int age;

    public Person(String name, String surname, String CNP, int age){
        this.name = name;
        this.surname = surname;
        this.CNP = CNP;
        this.age = age;
    }

    Person(Person copy_this){
        this.name = copy_this.name;
        this.surname = copy_this.surname;
        this.CNP = copy_this.CNP;
        this.age = copy_this.age;
    }

    public String getName(){
        return this.name;
    }

    public String getSurname(){
        return this.surname;
    }

    public Person getPerson(){
        return new Person(this);
    }

    public void getInfo(){
        System.out.printf("[Name] %s [Surname] %s [Age] %d \n",
                            name, surname, age);//we don't print cnp for obvious reasons
    }
}
