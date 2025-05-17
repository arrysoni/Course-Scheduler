# 🎓 Course Scheduler – Java + DerbyDB

A Java Swing-based Course Scheduler application that allows academic administrators and students to manage course enrollment for different semesters. This project simulates a university registration system with functionalities to add semesters, register/drop students and classes, and handle class waitlists.

---

## 🛠️ Tech Stack

- **Language**: Java
- **UI Framework**: Java Swing (via NetBeans GUI Builder)
- **Database**: Apache Derby (Java DB)
- **IDE**: Apache NetBeans IDE 14

---

## 📸 UI Preview

![Course Scheduler Screenshot](./relative/path/to/your/screenshot.png)

---

## 🔑 Features

### 👨‍💼 Admin Functionalities
- Add a new semester
- Add courses to the catalog
- Add students to the system
- Add new class instances under a course
- View the complete class list
- Drop students from a course
- Drop an entire class from a semester

### 👨‍🎓 Student Functionalities
- Register for classes in the selected semester
- View enrolled and waitlisted classes
- Unenroll from classes
- Automatic enrollment from waitlist upon seat availability

### 📅 Semester Management
- Set or change the current semester
- Load semester-specific data
- Maintain separation of schedule and records per semester

---

## 🗃️ Database Schema (DerbyDB)
- `Students` – stores student IDs and names
- `Courses` – stores course codes, names, and credit hours
- `Classes` – section-specific data such as max capacity and instructor
- `Enrollments` – tracks active enrollments and waitlist positions
- `Semesters` – records of each semester added

> All database interactions are managed through the DAO-like query classes (`*Queries.java`).

---

## 🚀 How to Run the Project

1. **Clone the Repository**
    ```bash
    git clone https://github.com/yourusername/CourseSchedulerAaryaABS.git
    ```

2. **Open in NetBeans**
    - Open the `.zip` or project folder in NetBeans IDE.
    - Ensure Derby DB is installed and configured in your environment.

3. **Run the MainFrame**
    - Right-click `MainFrame.java` and select `Run File`.
    - Use the GUI to add semesters, classes, and interact as admin or student.

---

## 🧠 Learning Outcomes

- Mastery over Java Swing UI components
- Hands-on with SQL operations using embedded Derby DB
- Understanding MVC-like structure using DAO pattern
- Real-world simulation of academic course scheduling
- Managing state across UI, database, and custom logic layers

---

## 📌 Future Improvements

- Add authentication for admin and student roles
- Support CSV imports for bulk student/course registration
- Integrate persistent settings storage
- Enhance UI with modern look (e.g., JavaFX or external themes)

---

## 👨‍💻 Author

**Aarya Soni**  
Java Developer | Undergraduate Student | Course Scheduling Enthusiast

---

## 📜 License

This project is for educational purposes. All rights reserved © Aarya Soni.
