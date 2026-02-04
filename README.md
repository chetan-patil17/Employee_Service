# Employee_Service

Struggling with scattered employee records and manual data entry errors? Employee_Service transforms chaotic HR management into a streamlined, real-time web application—built with Spring Boot for robust backend logic and a dynamic HTML/CSS/JS frontend that delivers instant CRUD operations without a single page reload.

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=spring-boot)](https://spring.io/projects/spring-boot) [![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)](https://www.mysql.com/) [![Real-Time CRUD](https://img.shields.io/badge/Real--Time%20CRUD-00D4AA?style=for-the-badge&logo=data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iMTIiIGhlaWdodD0iMTIiIHZpZXdCb3g9IjAgMCAxMiAxMiIgZmlsbD0ibm9uZSIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIj48cGF0aCBkPSJNNiAwTDEyIDZMNiAxMkwzIDZMNiA0TDkgNloiIGZpbGw9IiMwMEQ0QUEiLz48L3N2Zz4=)](https://github.com/chetan-patil17/Employee_Service)

## Overview

In today's fast-paced business environment, manual HR record-keeping leads to inefficiencies: duplicated data, lost updates, and compliance risks from errors. Employee_Service addresses this head-on with a centralized web app for managing employee details—name, phone, and email—in real time.

Powered by a Spring Boot REST API, it handles secure CRUD operations via MySQL persistence, while the vanilla JavaScript frontend ensures seamless updates without disrupting user workflow. No more spreadsheets or clunky tools; access everything from a single, responsive interface.

Ideal for small businesses, HR teams, or startups needing quick, accurate employee tracking. Deploy it locally or scale to production to cut admin time by hours weekly.

## Key Features

- 🚀 **Full CRUD Operations**: Easily create, read, update, or delete employee records with intuitive forms and buttons—no manual database tweaks required.
- 📱 **Responsive UI**: Clean HTML/CSS design adapts to desktops, tablets, and mobiles for on-the-go HR access.
- ⚡ **Real-Time Updates**: JavaScript fetches data instantly from the backend API, refreshing the view without page reloads—see changes propagate live as you add or edit.
- 🛡️ **Secure Persistence**: All data stored in MySQL with JPA for reliable, ACID-compliant transactions.
- 🏗️ **Layered Architecture**: Follows MVC best practices—Controller for API endpoints, Service for business logic, Repository for data access—ensuring maintainability and scalability.

This end-to-end full-stack setup showcases industry-ready skills: from API design to dynamic frontend integration, making it more than a demo—it's a deployable HR solution.

## Architecture

Employee_Service employs a classic MVC pattern tailored for full-stack efficiency. The Spring Boot backend exposes REST endpoints, while the static frontend consumes them via JavaScript for dynamic behavior.

### Core Components
- **Frontend (/src/main/resources/static)**: `index.html` serves the main view with employee lists and forms. `style.css` handles responsive styling. `script.js` orchestrates real-time fetches (e.g., `fetch('/employees')` to load data) and API calls for CRUD.
- **Backend Controller (EmpController.java)**: Defines REST endpoints under `/employees` for all operations.
- **Service Layer (EmployeeServiceImpl.java)**: Encapsulates business logic, like validation and logging, using SLF4J for traceability.
- **Data Layer (EmployeeRepository.java)**: Extends JpaRepository for seamless MySQL interactions via Hibernate.
- **Entity (Employee.java)**: Maps to the `emp_db_pr` table with fields: `id` (auto-generated), `name`, `phone`, `email`.

### Data Flow Diagram
```
[Frontend: index.html + script.js]
          ↓ (JS fetch/AJAX)
[API: EmpController → /employees endpoints]
          ↓ (Spring Boot routing)
[Service: EmployeeServiceImpl → Business Logic + Logging]
          ↓ (Dependency Injection)
[Repository: EmployeeRepository → JPA Queries]
          ↓ (Hibernate ORM)
[Database: MySQL → emp_db_pr table]
          ↑ (Save/Retrieve)
```

This flow enables "real-time magic": User actions trigger API calls, updating the UI instantly via `document.getElementById` manipulations in JS. For example, adding an employee posts to `/employees`, then reloads the list without refresh.

The structure promotes separation of concerns—easy to extend with features like search—while keeping the app lightweight at ~100KB JAR.

## Tech Stack

Employee_Service leverages proven, modern tools for reliability and ease of deployment:

- **Backend**: Spring Boot (Java 17+), Spring Web for REST, Spring Data JPA/Hibernate for ORM.
- **Database**: MySQL 8+ for persistent storage of employee data in the `emp_db_pr` table.
- **Frontend**: HTML5, CSS3, Vanilla JavaScript—no frameworks needed for snappy, lightweight interactions.
- **Build & Dependencies**: Maven (pom.xml includes spring-boot-starter-web, spring-boot-starter-data-jpa, mysql-connector-java).

This stack ensures secure, performant operations: JPA handles SQL generation, JS enables client-side real-time without heavy libraries, and Spring Boot simplifies configuration for quick starts.

Key pom.xml snippets:
```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <scope>runtime</scope>
    </dependency>
</dependencies>
```

## Getting Started

Get up and running in under 5 minutes. This self-contained Spring Boot app requires minimal setup.

### Prerequisites
- JDK 11 or higher (recommend 17 for best compatibility).
- MySQL 8+ server running locally or remotely.
- Maven 3.6+ (or use the bundled `mvnw` wrapper).
- Optional: IDE like IntelliJ or VS Code for editing.

### Setup Steps
1. **Clone the Repository**:
   ```
   git clone https://github.com/chetan-patil17/Employee_Service.git
   cd Employee_Service
   ```

2. **Configure Database**:
   - Start MySQL and create the database:
     ```sql
     CREATE DATABASE employee_db;
     ```
   - Edit `src/main/resources/application.properties` with your MySQL credentials:
     ```
     spring.datasource.url=jdbc:mysql://localhost:3306/employee_db
     spring.datasource.username=your_username
     spring.datasource.password=your_password
     spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
     spring.jpa.hibernate.ddl-auto=update
     spring.jpa.show-sql=true
     ```
     (JPA will auto-create the `emp_db_pr` table on first run.)

3. **Run the Application**:
   - Via Maven:
     ```
     ./mvnw spring-boot:run  # On Windows: mvnw.cmd spring-boot:run
     ```
   - Or in your IDE: Open `EmProjectApplication.java` and run as Spring Boot App.
   - The app starts on http://localhost:8080. Open `http://localhost:8080/index.html` in a browser.

4. **Verify**:
   - The frontend loads an empty employee list. Use browser dev tools (F12) to check for JS errors.
   - Test API directly: `curl http://localhost:8080/employees` should return `[]` initially.

### Troubleshooting
- **DB Connection Error**: Ensure MySQL is running and credentials match. Check logs for "Access denied" or "Unknown database".
- **Port Conflict**: Change server.port in application.properties if 8080 is busy.
- **Maven Issues**: Run `./mvnw clean install` to resolve dependencies.

## Usage Guide

Interact via the web interface at `http://localhost:8080/index.html`. The UI displays a table of employees with action buttons; forms handle inputs.

### Viewing Employees
- On load, `script.js` fetches `/employees` and populates the table:
  ```javascript
  fetch('/employees')
      .then(response => response.json())
      .then(employees => {
          // Render table rows with name, phone, email, edit/delete buttons
      });
  ```
- *Screenshot Placeholder*: Clean table view showing columns: ID, Name, Phone, Email, Actions (Edit/Delete). Empty state: "No employees found—add one below!"

### Adding an Employee
- Fill the form (Name, Phone, Email) and submit.
- JS sends POST to `/employees`:
  ```javascript
  const employeeData = { name: document.getElementById('name').value, phone: ..., email: ... };
  fetch('/employees', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(employeeData)
  }).then(() => loadEmployees());  // Refresh list instantly
  ```
- *Screenshot Placeholder*: Form submission—before: empty fields; after: new row appears in table without reload.

### Updating an Employee
- Click "Edit" on a row to pre-fill the form with current data.
- Modify and submit; JS PUTs to `/employees/{id}`:
  ```javascript
  fetch(`/employees/${id}`, {
      method: 'PUT',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(updatedData)
  }).then(() => loadEmployees());
  ```
- *Screenshot Placeholder*: Edit mode—row highlighted; post-update: changes reflected live.

### Deleting an Employee
- Click "Delete" and confirm; JS DELETEs via `/employees/{id}` and refreshes the list.
- *Screenshot Placeholder*: Confirmation dialog; after: row vanishes instantly.

All actions provide user feedback (e.g., alerts for success/failure) and maintain data sync.

## API Documentation

Test endpoints with Postman or curl. Base URL: `http://localhost:8080`. All return JSON; errors use standard HTTP codes (e.g., 404 for not found).

| Method | Endpoint              | Description                          | Request Body/Example                  | Response Example |
|--------|-----------------------|--------------------------------------|---------------------------------------|------------------|
| GET    | /employees            | Retrieve all employees               | None                                  | `[{"id":1,"name":"John Doe","phone":"123-456","email":"john@example.com"}]` |
| GET    | /employees/{id}       | Get employee by ID                   | Path: id=1                            | `{"id":1,"name":"John Doe","phone":"123-456","email":"john@example.com"}` |
| POST   | /employees            | Create new employee                  | JSON: `{"name":"Jane","phone":"789","email":"jane@example.com"}` | `{"id":2,"name":"Jane",...}` |
| PUT    | /employees/{id}       | Update employee by ID                | Path: id=1; JSON: updated fields      | `"Employee updated successfully"` or `"Employee not found"` |
| DELETE | /employees/{id}       | Delete employee by ID                | Path: id=1                            | `"Employee deleted successfully"` or `"Employee deletion failed"` |

- **Postman Tips**: Create a collection with these requests. Use raw JSON for POST/PUT. Auth: None (extend with Spring Security for prod).
- Handles edge cases: Non-existent ID throws 500 with "Employee not found"; empty lists return [].

## Testing and Validation

Built-in tests ensure reliability; extend with external tools for full coverage.

### Unit/Integration Tests
- Run `EmProjectApplicationTests.java` via `./mvnw test`:
  ```java
  @SpringBootTest
  class EmProjectApplicationTests {
      @Test
      void contextLoads() { /* Verifies Spring context starts */ }
  }
  ```
- Covers app bootstrap; add more for service methods (e.g., mock repository to test createEmployee).

### API Testing
- Use Postman: Import endpoints above, send requests, validate JSON responses and status codes (200 OK for success).
- Example: POST employee, then GET /employees to confirm addition.

### Frontend Testing
- Browser dev tools: Inspect network tab during JS fetches—verify no CORS errors, quick <100ms responses.
- Manual: Add/edit/delete via UI, check MySQL table updates with `SELECT * FROM emp_db_pr;`.

This setup validates the full stack: backend logic, DB integrity, and real-time UI sync.

## Deployment Notes

Package and deploy as a JAR for cloud or server environments.

1. **Build JAR**:
   ```
   ./mvnw clean package
   ```
   - Outputs `target/EmProject-0.0.1-SNAPSHOT.jar`.

2. **Local/Prod Config**:
   - Update `application.properties` for production DB (e.g., AWS RDS URL).
   - Set `spring.profiles.active=prod` for separate configs if needed.
   - Secure credentials: Use environment variables or Spring Vault.

3. **Deployment Options**:
   - **Heroku**: Push via Git, add MySQL addon: `heroku create; heroku addons:create cleardb:ignite`.
   - **Tomcat**: Drop JAR in webapps/ or use embedded server.
   - **AWS/Docker**: Dockerfile example:
     ```
     FROM openjdk:17-jdk-slim
     COPY target/*.jar app.jar
     ENTRYPOINT ["java","-jar","/app.jar"]
     ```
     Build/run: `docker build -t employee-service .; docker run -p 8080:8080 employee-service`.
   - Access at your domain:8080/index.html.

Warnings: Enable HTTPS in prod; monitor logs for DB connections. Scales easily—add caching for high traffic.

## Contributing and Future Enhancements

Fork the repo, create a feature branch (`git checkout -b feature/search`), commit changes, and open a PR. Focus on clean code and tests.

Ideas for extensions:
- 🔐 Add Spring Security for JWT auth and role-based access (HR vs. Employee views).
- 🔍 Implement search/filtering in JS (query param on GET /employees?filter=name).
- 📊 Export to CSV via new endpoint.
- 📈 Pagination for large datasets.

Check open issues for priorities. Contributions welcome to evolve this into a full HR suite!