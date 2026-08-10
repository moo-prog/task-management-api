# Task Management API

A lightweight RESTful API built with Java and Spring Boot for managing daily tasks and productivity. It provides endpoints to create, retrieve, search, and filter tasks efficiently based on priority and completion status.

---

## 🛠️ Tech Stack

- **Java 17+**
- **Spring Boot** (Spring Web, Spring Boot DevTools)
- **Maven** (Dependency Management)
- **In-Memory Storage** (List-based repository)

---

## 🚀 API Endpoints

| HTTP Method | Endpoint | Description |
| :--- | :--- | :--- |
| `GET` | `/api/tasks` | Fetch all tasks |
| `GET` | `/api/tasks/{id}` | Fetch a specific task by its unique ID |
| `GET` | `/api/tasks/search` | Search & filter tasks by `priority`, `completed` status, or both using query params |
| `POST` | `/api/tasks` | Create a new task (auto-generates `id` and `createdAt` timestamp) |

### 📌 Query Parameters Example:
- Filter by Priority: `/api/tasks/search?priority=HIGH`
- Filter by Completion: `/api/tasks/search?completed=false`
- Combined Search: `/api/tasks/search?priority=HIGH&completed=false`

---

## 🗺️ Roadmap

- [x] Layered Architecture setup (`model`, `controller`, `service`, `repository`)
- [x] In-memory CRUD operations (`GET`, `POST`)
- [x] Query Parameter search & filtration
- [ ] **Task Updating & Deletion (`PUT`, `DELETE`)**
- [ ] **Request Validation (`@Valid`, `@NotNull`, `@NotBlank`)**
- [ ] **Database Integration (Spring Data JPA with H2/MySQL)**
- [ ] **Global Exception Handling (`@ControllerAdvice`)**

---

## 📄 Sample Task JSON Structure

```json
{
  "id": 1,
  "title": "First Task",
  "description": "Description of the first task",
  "completed": false,
  "priority": "HIGH",
  "createdAt": "2026-08-10T16:38:00.123456"
}