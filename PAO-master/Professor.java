package eLearn;

public class Professor {
    public String name;
    public String surname;

    public Professor(String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    Professor(Professor copy_this){
        this.name = copy_this.name;
        this.surname = copy_this.surname;
    }

    public Professor getProfessor(){
        return new Professor(this);
    }

    public void getInfo(){
        System.out.printf("[Name] %s [Surname] %s \n",
                            name, surname);
    }
}
