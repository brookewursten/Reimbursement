# Reimbursement
The employee reimbursement system is a full-stack java application designed to manage reimbursements for a fictional company called Vandelay Industries. 

The repo layer was created using the DAO design pattern and JDBC. The controller and servlet layers use an MVC design pattern and the HttpServlet Class. The
front end is all html,css and javascript.

To launch, the project must be built with maven and the war deployed to a tomcat server.

Vandelay Industries Reimbursement System
The employee reimbursement system is a full-stack java application designed to manage reimbursements for a fictional company called Vandelay Industries.

Technologies Used

    Java 8
    Javascript - ES6
    HTML5
    CSS
    JUnit- version 4.12
    Spring Security - version 5.4.1

Features

List of features ready and TODOs for future development

    Login as employee or finance manager
    As an employee, request reimbursement for business expenses
    As a manager, approve or reject reimbursements
    Password hashing using Bcrypt

To-do list:

    Improve styling on the reimbursements page
    Implement way to create new users from client side

Getting Started

(include git clone command) (include all environment setup steps)

    git clone https://github.com/brookewursten/Reimbursement.git

    mvn clean package
    
    Deploy the war to tomcat and visit localhost:{tomcat port}/Reimbursement
    
    You should see the login page:
    ![](./VandelayReimbursement.png)

Usage

    After installation, you must set up a Postgresql database and add its url and credentials to the environment variables to be used by EnvironmentConnectionUtil.java. You should populate the database with any employees or admins you want to use.
