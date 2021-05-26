package eLearn;

import java.util.Arrays;

public class Platform {
    public String description;
    private Website website;
    private Subject subjects[];
    private OnlineClassroom onlineClassrooms[];
    private Professor professors[];
    protected Student students[];
    protected Student promoted[];
    private int passingGrade;

    public Platform(Website website, Subject subjects[], OnlineClassroom onlineClassrooms[], Professor professors[], Student students[]){
        this.website = website;

        this.subjects = new Subject[subjects.length];
        for(int i = 0; i < subjects.length; i++){
            this.subjects[i] = subjects[i];
        }

        this.onlineClassrooms = new OnlineClassroom[onlineClassrooms.length];
        for(int i = 0; i < onlineClassrooms.length; i++){
            this.onlineClassrooms[i] = onlineClassrooms[i];
        }

        this.professors = new Professor[professors.length];
        for(int i = 0; i < professors.length; i++){
            this.professors[i] = professors[i];
        }

        this.students = new Student[students.length];
        for(int i = 0; i < students.length; i++){
            this.students[i] = students[i];
        }
    }

    Platform(Platform copy_this){
        this.website = copy_this.website;

        this.subjects = new Subject[copy_this.subjects.length];
        for(int i = 0; i < copy_this.subjects.length; i++){
            this.subjects[i] = copy_this.subjects[i];
        }

        this.onlineClassrooms = new OnlineClassroom[copy_this.onlineClassrooms.length];
        for(int i = 0; i < copy_this.onlineClassrooms.length; i++){
            this.onlineClassrooms[i] = copy_this.onlineClassrooms[i];
        }

        this.professors = new Professor[copy_this.professors.length];
        for(int i = 0; i < copy_this.professors.length; i++){
            this.onlineClassrooms[i] = copy_this.onlineClassrooms[i];
        }

        this.students = new Student[copy_this.students.length];
        for(int i = 0; i < copy_this.students.length; i++){
            this.students[i] = copy_this.students[i];
        }

        this.promoted = new Student[copy_this.promoted.length];
        for(int i = 0; i < copy_this.promoted.length; i++){
            this.promoted[i] = copy_this.promoted[i];
        }
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void printDescription(){
        System.out.println(description);
    }

    public void printWebsite(){
        website.getInfo();
    }
	
	    public void printSubject(int x){
        subjects[x].info();
    }

    public void passed(Student students[], int passingGrade){
        int passedCount = 0;
        this.passingGrade = passingGrade;
        for(int i = 0; i < students.length; i++) {
            if (!"Absent".equals(students[i].getGrade())) {
                if (Integer.parseInt(students[i].getGrade()) >= passingGrade) {
                    passedCount++;
                }
            }
        }

        this.promoted = new Student[passedCount];
        int k = 0;
        for(int i = 0; i < students.length; i++) {
            if (!"Absent".equals(students[i].getGrade())) {
                if (Integer.parseInt(students[i].getGrade()) >= passingGrade) {
                    this.promoted[k] = students[i];
                    k++;
                }
            }
        }
    }

    public void SortStudents(){
        Arrays.sort(students, new AlphSort());
    }

    public void printStudents(){
        System.out.printf("The students that took the quiz:\n");
        for(int i = 0; i < students.length; i++){
            students[i].getInfo();
            System.out.printf("\n");
        }
    }

    public void printPromoted(){
        if(promoted.length == 0){
            System.out.printf("No student has passed the quiz! \n");
            return;
        }
        else {
            System.out.printf("The students that got a grade above %d are: \n", passingGrade);
        }
        for(int i = 0; i < promoted.length; i++){
            if(Integer.parseInt(promoted[i].getGrade()) >= passingGrade) {
                promoted[i].getInfo();
                System.out.printf("\n");
            }
        }
    }
}
