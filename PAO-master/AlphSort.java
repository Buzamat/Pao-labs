package eLearn;

import java.util.Comparator;

public class AlphSort implements Comparator<Student> {
    public int compare(Student a, Student b){
        if(Integer.parseInt(a.getGrade()) < Integer.parseInt(b.getGrade()))
            return 1;
        else if (Integer.parseInt(a.getGrade()) > Integer.parseInt(b.getGrade()))
            return -1;
        else if(Integer.parseInt(a.getGrade()) == Integer.parseInt(b.getGrade())){
            Person a1 = a.getPerson();
            Person b1 = b.getPerson();

            int name = a1.getName().compareTo(b1.getName());
            if(name < 0)
                return -1;
            else if(name > 0)
                return 1;
            else if(name == 0){
                int surname = a1.getSurname().compareTo(b1.getSurname());
                if(surname < 0)
                    return -1;
                else if(surname > 0)
                    return 1;
            }
        }
        return 0;
    }
}
