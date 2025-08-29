package com.glory.servletbookapp.beans;

public class LibraryOfficerBean {
    private int LibrarianId;
    private String LibrarianName;
    private String LibrarianEmail;
    private String LibrarianPassword;
    private long LibrarianMobileNumber;

    public LibraryOfficerBean(){
    }

    public LibraryOfficerBean(int librarianId, String librarianName, String librarianEmail, String librarianPassword, long librarianMobileNumber) {
        LibrarianId = librarianId;
        LibrarianName = librarianName;
        LibrarianEmail = librarianEmail;
        LibrarianPassword = librarianPassword;
        LibrarianMobileNumber = librarianMobileNumber;
    }

    public int getLibrarianId() {
        return LibrarianId;
    }

    public void setLibrarianId(int librarianId) {
        LibrarianId = librarianId;
    }

    public String getLibrarianName() {
        return LibrarianName;
    }

    public void setLibrarianName(String librarianName) {
        LibrarianName = librarianName;
    }

    public String getLibrarianEmail() {
        return LibrarianEmail;
    }

    public void setLibrarianEmail(String librarianEmail) {
        LibrarianEmail = librarianEmail;
    }

    public String getLibrarianPassword() {
        return LibrarianPassword;
    }

    public void setLibrarianPassword(String librarianPassword) {
        LibrarianPassword = librarianPassword;
    }

    public long getLibrarianMobileNumber() {
        return LibrarianMobileNumber;
    }

    public void setLibrarianMobileNumber(long librarianMobileNumber) {
        LibrarianMobileNumber = librarianMobileNumber;
    }
}
