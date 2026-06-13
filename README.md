# Java Student Manager (Không dùng Maven)

Dự án Java đơn giản quản lý sinh viên (không dùng Maven). Có 3 file nguồn trong `src/`:

- `Student.java` — model sinh viên
- `StudentManager.java` — quản lý danh sách, lưu/tải file CSV
- `Main.java` — giao diện dòng lệnh

Hướng dẫn biên dịch và chạy:

1. Mở terminal tại thư mục dự án.
2. Biên dịch:

```bash
javac -d out src/*.java
```

3. Chạy chương trình:

```bash
java -cp out Main
```

Lựa chọn trong chương trình cho phép thêm, liệt kê, tìm, xóa sinh viên và lưu/tải file CSV.

Ví dụ lưu file: nhập `students.csv` khi được yêu cầu, file sẽ được tạo trong thư mục hiện tại.

Ghi chú: Java phải được cài và có `javac`/`java` trong PATH.

