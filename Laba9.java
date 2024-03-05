public class Laba9 {
    public static class Student {
        private String fullName;
        private String admissionDate;
        private String address;
        private String phone;
        private int course;
        private String faculty;
    
        public Student(String fullName, String admissionDate, String address, String phone, int course, String faculty) {
            this.fullName = fullName;
            this.admissionDate = admissionDate;
            this.address = address;
            this.phone = phone;
            this.course = course;
            this.faculty = faculty;
        }
    
        public String getFullName() {
            return fullName;
        }
    
        public void setFullName(String fullName) {
            this.fullName = fullName;
        }
    
        public String getAdmissionDate() {
            return admissionDate;
        }
    
        public void setAdmissionDate(String admissionDate) {
            this.admissionDate = admissionDate;
        }
    
        public String getAddress() {
            return address;
        }
    
        public String getPhone() {
            return phone;
        }
    
        public void setPhone(String phone) {
            this.phone = phone;
        }
    
        public int getCourse() {
            return course;
        }
    
        public void setCourse(int course) {
            this.course = course;
        }
    
        public String getFaculty() {
            return faculty;
        }
    }

    public static void main(String[] args) {
        Student[] students = new Student[3];
        students[0] = new Student("Манушина П.В.", "2020-09-01", "Кижеватова, д.14", "79870774153", 1, "Экономический");
        students[1] = new Student("Огурцова П.А.", "2019-08-15", "Лермонтова д.54", "79876535167", 2, "Юриспруденция");
        students[2] = new Student("Шаров К.П.", "2021-01-10", "Калинина, д.17 кв.14", "79876553927", 1, "Экономический");

 System.out.println("ФИО всех студентов:");
 for (Student student : students) {
     System.out.println(student.getFullName());
 }

 String targetFaculty = "Экономический";
 System.out.println("\nСтуденты факультета " + targetFaculty + ":");
 for (Student student : students) {
     if (student.getFaculty().equals(targetFaculty)) {
         System.out.println(student.getFullName());
     }
 }

 String targetYear = "2020г.";
 System.out.println("\nСтуденты, поступившие после " + targetYear + ":");
 for (Student student : students) {
     if (student.getAdmissionDate().compareTo(targetYear) > 0) {
         System.out.println(student.getFullName());
     }
 }
}
    }
