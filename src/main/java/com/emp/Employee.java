package com.emp;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Employee {
    private int id;
    private String name;
    private Calendar dob;
    private String email;
    private Calendar joiningDate;
    private int totalVacationLeave;
    private int totalSickLeave;

    public Employee(int id, String name, Calendar dob, String email, Calendar joiningDate) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.joiningDate = joiningDate;
        this.totalVacationLeave = (id % 2 == 1) ? 15 : 10;
        this.totalSickLeave = (id % 2 == 1) ? 10 : 7;
    }

    public int calculateLeave() {
        int daysWorked = joiningDate.getActualMaximum(Calendar.DAY_OF_YEAR) - joiningDate.get(Calendar.DAY_OF_YEAR) + 1;
        int maxDaysInYear = (joiningDate.getActualMaximum(Calendar.DAY_OF_YEAR) == 366) ? 366 : 365;
        return (daysWorked * totalVacationLeave) / maxDaysInYear;
    }
    public int calculateSickLeave() {
        return (id % 2 == 1) ? 8 : 5;
    }


    public String getFormattedDOB() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(dob.getTime());
    }

    public String getFormattedJoiningDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(joiningDate.getTime());
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getTotalVacationLeave() {
        return totalVacationLeave;
    }

    public int getTotalSickLeave() {
        return totalSickLeave;
    }
}
