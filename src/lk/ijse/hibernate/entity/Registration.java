package lk.ijse.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Registration implements SuperEntity{
    @Id
    private String regNo;
    private String date;
    private double regFee;
    private String StudentId;
    private String courseId;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Course course;

    public Registration() {
    }

    public Registration(String regNo, String date, double regFee, String studentId, String courseId) {
        this.regNo = regNo;
        this.date = date;
        this.regFee = regFee;
        StudentId = studentId;
        this.courseId = courseId;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getRegFee() {
        return regFee;
    }

    public void setRegFee(double regFee) {
        this.regFee = regFee;
    }

    public String getStudentId() {
        return StudentId;
    }

    public void setStudentId(String studentId) {
        StudentId = studentId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "regNo='" + regNo + '\'' +
                ", date='" + date + '\'' +
                ", regFee=" + regFee +
                ", StudentId='" + StudentId + '\'' +
                ", courseId='" + courseId + '\'' +
                '}';
    }
}
