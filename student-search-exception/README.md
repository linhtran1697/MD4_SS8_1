# Student Search API - Global Exception Handling

Bài tập Spring Boot: tìm sinh viên bằng ID trong danh sách giả lập và trả lỗi JSON khi không tồn tại.

## Công nghệ
- Java 17+
- Maven
- Spring Boot 3.3.13 / Spring Web
- JUnit 5 + MockMvc
- **Không cần database**: danh sách được khai báo sẵn trong `StudentService`.

## Cấu trúc
```text
src/main/java/com/example/studentsearch/
├── StudentSearchApplication.java
├── controller/StudentController.java
├── service/StudentService.java
├── model/entity/Student.java
└── exception/
    ├── StudentNotFoundException.java
    ├── GlobalExceptionHandler.java
    └── ErrorResponse.java
```

## Chạy bằng IntelliJ IDEA
1. Giải nén, chọn **File > Open** và mở thư mục chứa `pom.xml`.
2. Chờ IntelliJ tải các thư viện Maven; chọn JDK 17 trở lên.
3. Chạy `StudentSearchApplication.main()`.
4. Server chạy tại `http://localhost:8080`.

Hoặc chạy trong Terminal:
```bash
mvn spring-boot:run
```

## Kiểm thử bằng Postman
Import file `postman/Student_Search_API.postman_collection.json`, rồi chạy 2 request GET.

**Có sinh viên:** `GET http://localhost:8080/api/v1/students/1` — HTTP **200 OK**.
```json
{
  "id": 1,
  "fullName": "Nguyen Van An",
  "major": "Information Technology"
}
```

**Không có sinh viên:** `GET http://localhost:8080/api/v1/students/999` — HTTP **404 Not Found**.
```json
{
  "status": 404,
  "message": "Sinh viên không tồn tại",
  "timestamp": "2026-10-26T19:00:00"
}
```
> Timestamp trên chỉ là ví dụ; hệ thống sinh thời điểm thực tế mỗi lần có lỗi.

## Chạy test
```bash
mvn clean test
```
`StudentControllerTest` kiểm tra HTTP 200 khi ID tồn tại và HTTP 404, JSON chuẩn khi ID không tồn tại.

## Yêu cầu đề bài
- [x] GET `/api/v1/students/{id}`
- [x] `List<Student>` cố định
- [x] `StudentNotFoundException extends RuntimeException`
- [x] `@RestControllerAdvice` + `@ExceptionHandler`
- [x] JSON `{ status, message, timestamp }` với HTTP 404
- [x] Controller **không dùng try-catch**

## Đẩy lên GitHub
Tạo repository trống trên GitHub, sau đó chạy trong thư mục project:
```bash
git init
git add .
git commit -m "Implement student search API with global exception handling"
git branch -M main
git remote add origin https://github.com/USERNAME/student-search-exception.git
git push -u origin main
```
Đổi `USERNAME` thành tên tài khoản GitHub của bạn.
