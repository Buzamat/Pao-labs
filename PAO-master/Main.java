package eLearn;

import java.util.*;

import static eLearn.Citiri.*;

public class Main {

    public static void runQuiz(Student students[], int oficiu){
        Random rand = new Random();
        for(int i = 0; i < students.length; i++) {
            students[i].setGrade(rand.nextInt(100 - oficiu + 1) + oficiu);
        }
    }

    public static void interogari(Platform platform){
        Scanner in = new Scanner(System.in);
        int interogare;

        platform.printDescription();
        Interogari:
        while(true) {
            interogare = in.nextInt();
            switch (interogare) {
                case 0:
                    platform.printWebsite();
                    break;
                case 1:
                    platform.printStudents();
                    System.out.printf("\n");
                    break;
                case 2:
                    platform.printPromoted();
                    System.out.printf("\n");
                    break;
                case 3:
					System.out.printf("Enter subject id\n");
					//if input > total subjects then break
                    platform.printSubject(in.nextInt());
                    System.out.printf("\n");
                    break;
                default:
                    break Interogari;
            }
        }
    }

    public static void main(String[] args) {
        Citiri CSV = Citiri.getInstance();
        Set<Platform> Platforms = new HashSet<Platform>();
        Platform Udecademy;
        Vector<Website> websitesV = new Vector();
        Website wbs = new Website("www.udemy.com", "300 EUR", 30, 0, "Medium");
        websitesV.add(wbs);

        Subject subjects[] = CSV.loadSubjects("data/Subjects.csv");
        CSV.writeSubjects(subjects, "data/WrittenSubjects.csv");
        Student students[] = CSV.loadStudents(subjects, "data/Students.csv");
        CSV.writeStudents(students, "data/WrittenStudents.csv");
        Professor professors[] = CSV.loadProfessors("data/Professors.csv");
        CSV.writeProfessors(professors, "data/WrittenProfessors.csv");
        OnlineClassroom onlineClassrooms[] = new OnlineClassroom[2];
        Professor professorName1[] = new Professor[2];
        Professor professorName2[] = new Professor[2];
        professorName1[0] = professors[0];
        professorName1[1] = professors[1];
        professorName2[0] = professors[1];
        professorName2[1] = professors[2];
        onlineClassrooms[0] = CSV.loadOnlineClassrooms(subjects[0], professorName1, students, "data/OnlineClassrooms.csv");
        onlineClassrooms[1] = CSV.loadOnlineClassrooms(subjects[0], professorName2, students, "data/OnlineClassrooms.csv");
        CSV.writeOnlineClassrooms(onlineClassrooms, "data/WrittenOnlineClassrooms.csv");

        Udecademy = new Platform(websitesV.get(0), subjects, onlineClassrooms, professors, students);
        Udecademy.setDescription("Online course provider aimed at professional adults and students. ");
        Platforms.add(Udecademy);
        System.out.println("Introduceti un numar din urmatoarele:");
        System.out.println("[0] Show platform details");
        System.out.println("[1] Show all students");
        System.out.println("[2] Show the students that graduated the quiz");
        System.out.println("[3] Show subject information");
        System.out.println("[9] Next Platform\n");
        for(Platform i : Platforms){
            runQuiz(i.students, 10);
            i.passed(i.students, 50);
            i.SortStudents();
            interogari(i);
        }
    }
}
