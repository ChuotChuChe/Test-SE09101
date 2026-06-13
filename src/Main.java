import java.util.*;

public class Main {
    private static StudentManager manager = new StudentManager();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            printMenu();
            String choice = sc.nextLine().trim();
            switch (choice) {
                case "1": addStudent(); break;
                case "2": listStudents(); break;
                case "3": findStudent(); break;
                case "4": removeStudent(); break;
                case "5": save(); break;
                case "6": load(); break;
                case "0": running = false; break;
                default: System.out.println("Không hợp lệ");
            }
        }
        System.out.println("Thoát.");
    }

    private static void printMenu() {
        System.out.println("\n--- QUẢN LÝ SINH VIÊN ---");
        System.out.println("1. Thêm sinh viên");
        System.out.println("2. Danh sách sinh viên");
        System.out.println("3. Tìm theo mã");
        System.out.println("4. Xóa theo mã");
        System.out.println("5. Lưu file");
        System.out.println("6. Tải file");
        System.out.println("0. Thoát");
        System.out.print("Chọn: ");
    }

    private static void addStudent() {
        System.out.print("Mã: ");
        String id = sc.nextLine().trim();
        System.out.print("Tên: ");
        String name = sc.nextLine().trim();
        System.out.print("Tuổi: ");
        int age = Integer.parseInt(sc.nextLine().trim());
        manager.addStudent(new Student(id, name, age));
        System.out.println("Đã thêm.");
    }

    private static void listStudents() {
        List<Student> list = manager.listAll();
        if (list.isEmpty()) System.out.println("Không có sinh viên.");
        else for (Student s : list) System.out.println(s);
    }

    private static void findStudent() {
        System.out.print("Mã: ");
        String id = sc.nextLine().trim();
        Student s = manager.findById(id);
        System.out.println(s == null ? "Không tìm thấy" : s);
    }

    private static void removeStudent() {
        System.out.print("Mã: ");
        String id = sc.nextLine().trim();
        boolean ok = manager.removeById(id);
        System.out.println(ok ? "Đã xóa" : "Không tìm thấy");
    }

    private static void save() {
        System.out.print("Đường dẫn file (ví dụ students.csv): ");
        String path = sc.nextLine().trim();
        try { manager.saveToFile(path); System.out.println("Đã lưu."); }
        catch (Exception e) { System.out.println("Lỗi: " + e.getMessage()); }
    }

    private static void load() {
        System.out.print("Đường dẫn file: ");
        String path = sc.nextLine().trim();
        try { manager.loadFromFile(path); System.out.println("Đã tải."); }
        catch (Exception e) { System.out.println("Lỗi: " + e.getMessage()); }
    }
}
