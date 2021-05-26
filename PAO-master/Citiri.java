package eLearn;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Citiri {
    private static Citiri single_instance = null;

    Citiri(){ }

    public static Citiri getInstance(){
        if(single_instance == null)
            single_instance = new Citiri();
        return single_instance;
    }

    public static Subject getSubjectFromString(Subject[] subjects, String subjectSearch){
        for(int i = 0; i < subjects.length; i++){
            if(subjects[i].getSubjectName().equals(subjectSearch))
                return subjects[i];
        }
        System.out.println("WARNING: The subject you're looking for doesn't exist!");
        return new Subject();
    }

    public static Student[] loadStudents(Subject[] subjects, String filePath) {
        File file = new File(filePath);
        Student students[] = new Student[5];
        try {
            int nr = 0;
            Scanner inputStream = new Scanner(file);
            while (inputStream.hasNext()) {
                String data = inputStream.nextLine();
                String[] info = data.split(",");

                Student student = new Student(info[0], info[1], info[2], Integer.parseInt(info[3]), Integer.parseInt(info[4]), getSubjectFromString(subjects, info[5]));
                students[nr] = new Student(student);
                nr++;
            }
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Students have been loaded successfully!");
        return students;
    }

    public static Subject[] loadSubjects(String filePath){
        File file = new File(filePath);
        Subject subjects[] = new Subject[3];
        try {
            int nr = 0;
            Scanner inputStream = new Scanner(file);
            while (inputStream.hasNext()) {
                String data = inputStream.nextLine();
                String[] info = data.split(",");
                Subject subject = new Subject(info[0], Integer.parseInt(info[1]), Integer.parseInt(info[2]), Integer.parseInt(info[3]), Float.parseFloat(info[4]));
                subjects[nr] = new Subject(subject);
                nr++;
            }
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Subjects have been loaded successfully!");
        return subjects;
    }

    public static Professor[] loadProfessors(String filePath){
        File file = new File(filePath);
        Professor professors[] = new Professor[3];
        try {
            int nr = 0;
            Scanner inputStream = new Scanner(file);
            while (inputStream.hasNext()) {
                String data = inputStream.nextLine();
                String[] info = data.split(",");
                Professor professor = new Professor(info[0], info[1]);
                professors[nr] = new Professor(professor);
                nr++;
            }
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Teachers have been loaded successfully!");
        return professors;
    }

    public static OnlineClassroom loadOnlineClassrooms(Subject subject, Professor professors[], Student students[], String filePath){
        File file = new File(filePath);
        OnlineClassroom ClassroomName = null;
        try {
            Scanner inputStream = new Scanner(file);
            while (inputStream.hasNext()) {
                String data = inputStream.nextLine();
                String[] info = data.split(",");
                ClassroomName = new OnlineClassroom(info[0], Integer.parseInt(info[1]), subject, professors, students);
            }
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return ClassroomName;
    }

    public static void writeOnlineClassrooms(OnlineClassroom[] ClassroomName, String filePath){
        try {
            PrintWriter pw = new PrintWriter(new File(filePath));
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < ClassroomName.length; i++){
                sb.append(ClassroomName[i].ClassroomName);
                sb.append(",");
                sb.append(ClassroomName[i].ClassroomId);
                sb.append("\n");
            }
            pw.write(sb.toString());
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void writeSubjects(Subject[] subjects, String filePath){
        try {
            PrintWriter pw = new PrintWriter(new File(filePath));
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < subjects.length; i++){
                sb.append(subjects[i].getSubjectName());
                sb.append(",");
                sb.append(subjects[i].MaxStudents);
                sb.append(",");
                sb.append(subjects[i].ExamsCount);
                sb.append(",");
                sb.append(subjects[i].TotalCourses);
                sb.append(",");
                sb.append(subjects[i].price);
                sb.append("\n");
            }
            pw.write(sb.toString());
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void writeStudents(Student[] students, String filePath){
        try {
            PrintWriter pw = new PrintWriter(new File(filePath));
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < students.length; i++){
                sb.append(students[i].StudentId);
                sb.append(",");
                sb.append(students[i].subject);
                sb.append(",");
                sb.append(students[i].grade);
                sb.append("\n");
            }
            pw.write(sb.toString());
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void writeProfessors(Professor[] professors, String filePath){
        try {
            PrintWriter pw = new PrintWriter(new File(filePath));
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < professors.length; i++){
                sb.append(professors[i].name);
                sb.append(",");
                sb.append(professors[i].surname);
                sb.append("\n");
            }
            pw.write(sb.toString());
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
