# 🚗 FleetTrack — Vehicle Fleet Management System

FleetTrack is a scalable backend system built with **Java Spring Boot** for managing vehicle fleets efficiently.  
It supports vehicle tracking, driver management, real-time updates, caching, and secure REST APIs using modern backend architecture.

---

## 📌 Features

### 🚙 Vehicle Management
- Create, update, delete vehicles
- Track vehicle status (ACTIVE, INACTIVE, MAINTENANCE)
- Store details: make, model, year, license plate

### 👨‍✈️ Driver Management
- Driver profile CRUD operations
- Assign drivers to vehicles
- Store license and contact information

### 📍 Real-Time Tracking
- WebSocket-based live GPS tracking
- Real-time vehicle location updates
- Dashboard-ready streaming system

### 🔐 Security (JWT)
- Stateless authentication
- Role-based access control (ADMIN, FLEET_MANAGER)
- Protected REST endpoints

### ⚡ Caching (Redis)
- Cache frequently accessed data
- Improve API response performance
- Reduce database load

### 🗄️ Database (PostgreSQL + Flyway)
- Version-controlled database migrations
- Clean schema evolution across environments
- Transaction-safe relational design

### 🔍 Filtering & Pagination
- Dynamic filtering (status, driver, model, etc.)
- Sorting support
- Pagination for large datasets

### ⚙️ Scheduling
- Automated maintenance reminders
- Background cleanup tasks

### 📄 API Documentation
- Swagger / OpenAPI integration
- Interactive API testing UI

---

## 🧠 Architecture

- Monolithic Spring Boot Backend
- Layered Architecture (Controller → Service → Repository)
- DTO + MapStruct mapping
- REST + WebSocket hybrid communication

---

## 🛠️ Tech Stack

- Java 21
- Spring Boot
- Spring Security (JWT)
- Spring WebSocket
- Spring Data JPA
- PostgreSQL
- Redis
- Flyway
- MapStruct
- Swagger / OpenAPI

---

## 🚀 Learning Objectives

- Database migration with Flyway
- Real-time communication using WebSocket
- Secure REST APIs with JWT authentication
- Redis caching & performance optimization
- Advanced filtering, sorting, pagination
- Asynchronous processing & scheduling
- Clean architecture principles

---

## ⚙️ Setup Instructions

### 1. Clone project
```bash
git clone https://github.com/your-username/fleettrack.git
cd fleettrack
