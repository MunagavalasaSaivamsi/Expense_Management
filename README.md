# Expense Management API

## Project Overview
The **Expense Management API** is a Spring Boot application for managing employees, roles, and expenses efficiently.  
It features **JWT-based authentication**, a layered architecture (controller, service, repository), and DTOs for clean data transfer.

**Technologies used:**
- Java 17
- Spring Boot
- Spring Security (JWT)
- Maven
- MySQL / H2 Database

---

<details>
<summary><strong> Project Structure</strong></summary>
*com.example.expense_management*

- *controller-*
- AuthController.java, EmployeeController.java, ExpenseController.java  

- *service-*  
  EmployeeService.java, ExpenseService.java, RoleService.java

- *repository-*  
  EmployeeRepository.java, ExpenseRepository.java, RoleRepository.java

- *model-*  
  Employee.java, Expense.java, Role.java

- *dto-*  
  AuthDTO.java, EmployeeDTO.java, ExpenseDTO.java

- *security-*  
  CustomUserDetailsService.java, CustomUserDetails.java, JwtFilter.java, JwtUtil.java, SecurityConfig.java

- *main application-*  
  ExpenseManagementApplication.java

- *resources-*  
application.properties, data.sql

- *project root-*  
pom.xml, README.md


</details>

---

<details>
<summary><strong>📝 API Endpoints</strong></summary>

| Method | Endpoint          | Description               | Request Body Example                 |
|--------|-----------------|---------------------------|------------------------------------|
| POST   | /auth/login      | Authenticate user         | `{ "username": "admin", "password": "123" }` |
| POST   | /employees       | Add new employee          | `{ "name": "John", "role": "Manager" }` |
| GET    | /employees       | Get all employees         | -                                  |
| POST   | /expenses        | Add new expense           | `{ "amount": 100, "employeeId": 1 }` |
| GET    | /expenses        | Get all expenses          | -                                  |

</details>

---

<details>
<summary><strong> Security</strong></summary>

- **Authentication:** JWT-based for all endpoints.
- **Security Classes:**
    - `CustomUserDetailsService` – loads user details from the database
    - `CustomUserDetails` – implements `UserDetails`
    - `JwtFilter` – filters requests and validates tokens
    - `JwtUtil` – generates and validates JWT tokens
    - `SecurityConfig` – configures endpoint security and authentication
- **Roles:** Can be extended in `RoleService` for role-based access.

</details>

---

<details>
<summary><strong> Setup & Run</strong></summary></details>

1. **Clone the repository**
```bash
git clone <repository-url>
cd expense-management







