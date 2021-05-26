package eLearn;

public class OnlineClassroom {
    public String ClassroomName;
    public int ClassroomId;
    private Subject subject;
    private Professor professors[];
    private Student students[];

    public OnlineClassroom(String ClassroomName, int ClassroomId, Subject subject, Professor professors[], Student students[]){
        this.ClassroomName = ClassroomName;
        this.ClassroomId = ClassroomId;
        this.subject = new Subject(subject);
        this.professors = new Professor[professors.length];
        for(int i = 0; i < professors.length; i++){
            this.professors[i] = professors[i];
        }
        this.students = new Student[students.length];
        for(int i = 0; i < students.length; i++){
            this.students[i] = students[i];
        }
    }

    OnlineClassroom(OnlineClassroom copy_this){
        this.ClassroomName = copy_this.ClassroomName;
        this.ClassroomId = copy_this.ClassroomId;
        this.subject = new Subject(copy_this.subject);
        for(int i = 0; i < professors.length; i++){
            this.professors[i] = professors[i];
        }
        for(int i = 0; i < students.length; i++){
            this.students[i] = students[i];
        }
    }

    public void getInfo(){
        System.out.printf("[Class Name :] %s [Class Id :] %i [Subject] %s \n",
                            ClassroomName, ClassroomId, subject.getSubjectName());
    }
}
