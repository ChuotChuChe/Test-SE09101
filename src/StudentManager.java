import java.util.*;
import java.io.*;

public class StudentManager {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student s) { students.add(s); }

    public boolean removeById(String id) {
        Iterator<Student> it = students.iterator();
        while (it.hasNext()) {
            if (it.next().getId().equals(id)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    public Student findById(String id) {
        for (Student s : students) if (s.getId().equals(id)) return s;
        return null;
    }

    public List<Student> listAll() { return new ArrayList<>(students); }

    public void saveToFile(String path) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(path))) {
            for (Student s : students) {
                pw.println(s.getId() + "," + s.getName() + "," + s.getAge());
            }
        }
    }

    public void loadFromFile(String path) throws IOException {
        students.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",", -1);
                if (parts.length >= 3) {
                    students.add(new Student(parts[0], parts[1], Integer.parseInt(parts[2])));
                }
            }
        }
    }
}
