package eLearn;

public class Subject {
    private String subjectName;
	public int ExamsCount;
    public int TotalCourses;
    public int MaxStudents;
    public float price;

    public Subject(){
        this.subjectName = "";
        this.MaxStudents = 0;
        this.price = 0f;
		this.ExamsCount = 0;
        this.TotalCourses = 0;
    }

    public Subject(String subjectName, int MaxStudents, int ExamsCount, int TotalCourses, float price){
        this.subjectName = subjectName;
        this.MaxStudents = MaxStudents;
        this.ExamsCount = ExamsCount;
        this.TotalCourses = TotalCourses;
        this.price = price;
    }

    Subject(Subject copy_this){
        this.subjectName = copy_this.subjectName;
        this.TotalCourses = copy_this.TotalCourses;
		this.MaxStudents = copy_this.MaxStudents;
        this.ExamsCount = copy_this.ExamsCount;
        this.price = copy_this.price;
    }

    public void info(){
        System.out.printf("[Subject name] %s \n[Max students] %d \n[Number of exams] %d \n[Total number of hours] %d \n[Full price] %f \n",
                            subjectName, MaxStudents, ExamsCount, TotalCourses, price);
    }

    public Subject getSubject(){
        return new Subject(this);
    }

    public String getSubjectName(){
        return subjectName;
    }

}
