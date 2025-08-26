package com.glory.servletbookapp.beans;

import java.util.Date;

public class IssuedProjectBean {
    private String bookCode, studentId, studentName;
    private String returnStatus;
    private long studentMobile;
    private Date issuedDate;

    public IssuedProjectBean(){
    }

    public IssuedProjectBean(String bookCode, String studentId, String studentName, String returnStatus,
                             long studentMobile, Date issuedDate) {
        this.bookCode = bookCode;
        this.studentId = studentId;
        this.studentName = studentName;
        this.returnStatus = returnStatus;
        this.studentMobile = studentMobile;
        this.issuedDate = issuedDate;
    }

    public Date getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
    }

    public long getStudentMobile() {
        return studentMobile;
    }

    public void setStudentMobile(long studentMobile) {
        this.studentMobile = studentMobile;
    }

    public String getReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(String returnStatus) {
        this.returnStatus = returnStatus;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }
}
