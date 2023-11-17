package com.emp;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@WebServlet(name = "EmployeeManagementServlet", urlPatterns = {"/addEmployee", "/employeeList"})
public class EmployeeManagementServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private List<Employee> employeeList = new CopyOnWriteArrayList<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int employeeId = Integer.parseInt(request.getParameter("employeeId"));
            String employeeName = request.getParameter("employeeName");
            String dobString = request.getParameter("dob");
            Calendar dob = getCalendarFromDate(dobString);
            String email = request.getParameter("email");
            String joiningDateString = request.getParameter("joiningDate");
            Calendar joiningDate = getCalendarFromDate(joiningDateString);

            Employee employee = new Employee(employeeId, employeeName, dob, email, joiningDate);
            int calculatedVacationLeave = employee.calculateLeave();
            int calculatedSickLeave = calculatedVacationLeave;

            employeeList.add(employee);

            response.sendRedirect(request.getContextPath() + "/employeeList");
        } catch (NumberFormatException | ParseException e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/addEmployee?error=InvalidInput");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if ("/employeeList".equals(request.getServletPath())) {
            request.setAttribute("employeeList", employeeList);
            request.getRequestDispatcher("/employeeList.jsp").forward(request, response);
        }
    }

    private Calendar getCalendarFromDate(String date) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        calendar.setTime(dateFormat.parse(date));
        return calendar;
    }
}
