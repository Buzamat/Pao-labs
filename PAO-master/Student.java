package eLearn;

public class Student extends Person {
    public int StudentId;
    public String subject;
    public String grade;

    public Student(){
        super("", "", "", -1);
        StudentId = -1;
        subject = "";
        grade = "";
    }

    public Student(String name, String surname, String CNP, int age, int StudentId, Subject subject) {
        super(name, surname, CNP, age);
        this.StudentId = StudentId;
        this.subject = subject.getSubjectName();
        this.grade = "Absent";
    }

    Student(Student copy_this){
        super(copy_this.getPerson());
        this.StudentId = copy_this.StudentId;
        this.subject = copy_this.subject;
        this.grade = copy_this.grade;
    }

    public void setGrade(int grade){
        this.grade = String.valueOf(grade);
    }

    public String getGrade(){
        return this.grade;
    }

    public Student getStudent(){
        return new Student(this);
    }

    @Override
    public Person getPerson(){
        return super.getPerson();
    }

    @Override
    public void getInfo(){
        super.getInfo();
        System.out.printf("[Student Id] %d \n[Subject] %s \n[Grade] %d \n",
                            StudentId, subject, Integer.parseInt(grade));
    }
}
