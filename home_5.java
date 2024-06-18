// Class representing a Teacher
class Teacher {
    private String id;
    private String name;
    // Constructor, getters, setters
}

// Class representing a Student
class Student {
    private String id;
    private String name;
    // Constructor, getters, setters
}

// Class representing a StudyGroup
class StudyGroup {
    private Teacher teacher;
    private List<Student> students;
    
    public StudyGroup(Teacher teacher, List<Student> students) {
        this.teacher = teacher;
        this.students = students;
    }
    
    // Getters
}

// Service class to form a StudyGroup
class StudyGroupService {
    public StudyGroup formStudyGroup(Teacher teacher, List<Student> students) {
        return new StudyGroup(teacher, students);
    }
}

// Controller class
class StudyGroupController {
    private StudyGroupService service;

    public StudyGroupController(StudyGroupService service) {
        this.service = service;
    }

    public StudyGroup createStudyGroup(String teacherId, List<String> studentIds) {
        // Here you would have logic to get Teacher and Students by their IDs
        // For example:
        Teacher teacher = getTeacherById(teacherId);
        List<Student> students = getStudentsByIds(studentIds);
        
        return service.formStudyGroup(teacher, students);
    }
    
    // Methods to get Teacher and Students by IDs (not implemented here)
}
