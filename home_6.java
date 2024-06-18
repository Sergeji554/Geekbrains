package less4;

import less4.controller.StudentController;
import less4.model.Student;

import java.util.List;

public class Lesson4 {

    public static void main(String[] args) {
        // Рефакторинг: Вынести создание списка студентов в отдельный метод.
        // Принцип: Принцип единственной ответственности (Single Responsibility Principle, SRP)
        // Причина: Главный метод должен быть ответственен за организацию потока приложения,
        // а не за создание тестовых данных. Вынося эту логику, мы делаем главный метод более чистым и сфокусированным.
        List<Student> students = createStudents();

        new StudentController()
                .sendOnConsole(students);
    }

    private static List<Student> createStudents() {
        // Рефакторинг: Удалить дублирование ID студента.
        // Принцип: DRY (Don't Repeat Yourself - Не повторяйся)
        // Причина: Использование одного и того же ID для обоих студентов, скорее всего, является ошибкой.
        // Каждый студент должен иметь уникальный ID.
        Student s1 = new Student(1, "Sasha", "Ivanov");
        Student s2 = new Student(2, "Ira", "Ivanova"); // Изменён ID на 2
        return List.of(s1, s2);
    }
}

// Закомментированный метод getStudents можно удалить, так как он заменён на createStudents.
// Принцип: YAGNI (You Aren't Gonna Need It - Вам это не понадобится)
// Причина: Если код закомментирован и не используется, лучше его удалить, чтобы кодовая база оставалась чистой.
