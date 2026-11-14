<div align="center">

<h1>🏨 GrandStay — Hotel Management System</h1>

<p>
  <strong>A full-featured, desktop hotel management application built with Java, JavaFX & MySQL.</strong><br/>
  Manage rooms, guests, reservations, services, and billing — all from a single, role-aware interface.
</p>

<p>
  <img src="https://img.shields.io/badge/Java-17+-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white"/>
  <img src="https://img.shields.io/badge/JavaFX-17+-5382A1?style=for-the-badge&logo=java&logoColor=white"/>
  <img src="https://img.shields.io/badge/MySQL-8.0+-4479A1?style=for-the-badge&logo=mysql&logoColor=white"/>
  <img src="https://img.shields.io/badge/NetBeans-IDE-1B6AC6?style=for-the-badge&logo=apache-netbeans-ide&logoColor=white"/>
  <img src="https://img.shields.io/badge/License-MIT-green?style=for-the-badge"/>
</p>

</div>

---

## 📋 Table of Contents

- [About the Project](#-about-the-project)
- [Features](#-features)
- [Architecture](#-architecture)
- [Database Schema](#-database-schema)
- [Tech Stack](#-tech-stack)
- [Prerequisites](#-prerequisites)
- [Installation & Setup](#-installation--setup)
- [Project Structure](#-project-structure)
- [Role-Based Access Control](#-role-based-access-control)
- [Author](#-author)

---

## 🎯 About the Project

**GrandStay** is a desktop application that covers the full operational cycle of a hotel:

> **Reservation → Check-In → Service Consumption → Check-Out → Invoice**

Built with clean **DAO + Service** architecture and **MVC** separation, it demonstrates professional Java development practices including JDBC, JavaFX FXML views, stored procedures, role-based security, and PBKDF2 password hashing.

---

## ✨ Features

| Module | Description |
|---|---|
| 🔐 **Authentication** | Secure login with PBKDF2+Salt password hashing |
| 👥 **Role Management** | 5 roles (Admin, Receptionist, Cashier, Auditor, Housekeeping) |
| 🛏️ **Room Types** | CRUD for room categories with pricing |
| 🏠 **Rooms** | CRUD with status tracking (available, occupied, cleaning, maintenance) |
| 🧳 **Guests** | Full guest registry with ID document, contact info & nationality |
| 📅 **Reservations** | Create, update, and track reservations with deposits |
| ✅ **Check-In** | Register guest arrival and update room status |
| 🚪 **Check-Out** | Automated checkout via MySQL stored procedure |
| 🍽️ **Service Consumption** | Register hotel services (minibar, restaurant, laundry, spa) |
| 🧾 **Invoicing** | Auto-generated invoices at checkout with full billing breakdown |
| 📊 **Dashboard** | Overview screen for quick operational insight |

---

## 🏗️ Architecture

The project follows a layered **MVC + DAO + Service** architecture:

```
┌─────────────────────────────────────────────────────────────┐
│                        VIEW  (JavaFX / FXML)                │
│              LoginView.fxml  •  DashboardView.fxml          │
└─────────────────────────┬───────────────────────────────────┘
                          │
┌─────────────────────────▼───────────────────────────────────┐
│                     CONTROLLER                               │
│          LoginController  •  DashboardController            │
└──────────────┬──────────────────────────┬───────────────────┘
               │                          │
┌──────────────▼──────────┐  ┌────────────▼───────────────────┐
│       SERVICE LAYER     │  │        SECURITY LAYER          │
│  CheckInService         │  │  RolePermissions (RBAC)        │
│  CheckoutService        │  │  SesionContext (Session State) │
└──────────────┬──────────┘  └────────────────────────────────┘
               │
┌──────────────▼──────────────────────────────────────────────┐
│                     DAO LAYER  (JDBC)                        │
│  HuespedDAO  • HabitacionDAO  • ReservaDAO  • UsuarioDAO    │
│  TipoHabitacionDAO  • ConsumoServicioDAO  • FacturaHotelDAO │
└──────────────┬──────────────────────────────────────────────┘
               │
┌──────────────▼──────────────────────────────────────────────┐
│               DATABASE  (MySQL 8 — grandstay_in4cm)         │
│         Tables • Stored Procedures • Views • Indexes        │
└─────────────────────────────────────────────────────────────┘
```

---

## 🗄️ Database Schema

The database (`grandstay_in4cm`) includes **7 tables**, **stored procedures** for all CRUD operations, **6 query views**, and a transactional **checkout stored procedure**.

```
usuario ──────────────────────────────────────────────────────
tipo_habitacion ──► habitacion ──► reserva ──► consumo_servicio
                                       └──────► factura_hotel
                        huesped ──────►
```

**Tables:** `usuario`, `tipo_habitacion`, `habitacion`, `huesped`, `reserva`, `consumo_servicio`, `factura_hotel`

**Key stored procedure:** `sp_realizarcheckout` — executes the entire checkout as an atomic transaction: calculates totals, applies deposits, generates the invoice, marks the reservation as checked out, and sets the room to cleaning status.

---

## 🛠️ Tech Stack

| Technology | Purpose |
|---|---|
| **Java 17+** | Core application language |
| **JavaFX 17+** | Desktop UI framework |
| **FXML** | Declarative UI layout |
| **MySQL 8.0+** | Relational database |
| **JDBC (MySQL Connector/J)** | Database connectivity |
| **PBKDF2 + SHA-256** | Secure password hashing |
| **Apache NetBeans** | IDE & build tool (`build.xml`) |

---

## 📋 Prerequisites

Before running the project, make sure you have the following installed:

- ☕ **JDK 17** or higher — [Download](https://adoptium.net/)
- 🎨 **JavaFX SDK 17+** — [Download](https://gluonhq.com/products/javafx/)
- 🐬 **MySQL 8.0+** — [Download](https://dev.mysql.com/downloads/)
- 🔌 **MySQL Connector/J** — [Download](https://dev.mysql.com/downloads/connector/j/)
- 🛠️ **Apache NetBeans 20+** (recommended) — [Download](https://netbeans.apache.org/)

---

## 🚀 Installation & Setup

### 1. Clone the repository

```bash
git clone https://github.com/octavioLF/hotel-management-system.git
cd hotel-management-system
```

### 2. Set up the database

Connect to your MySQL server and run the SQL scripts **in order**:

```bash
mysql -u root -p < sql/01-ddl-grandstay.sql
mysql -u root -p < sql/02-dml-grandstay.sql
```

> This creates the `grandstay_in4cm` database, all tables, stored procedures, indexes, and views, and seeds it with initial data.

### 3. Configure database connection

Copy the example properties file and fill in your credentials:

```bash
cp db.properties.example src/db.properties
```

Edit `src/db.properties`:

```properties
db.url=jdbc:mysql://localhost:3306/grandstay_in4cm
db.user=YOUR_MYSQL_USER
db.password=YOUR_MYSQL_PASSWORD
db.driver=com.mysql.cj.jdbc.Driver
```

> ⚠️ `src/db.properties` is listed in `.gitignore` — your credentials will never be committed.

### 4. Add libraries to the project

In **NetBeans**, right-click the project → **Properties** → **Libraries** → **Add JAR/Folder**, and add:

- `mysql-connector-j-x.x.x.jar`
- All `javafx-*.jar` files from your JavaFX SDK `lib/` folder

### 5. Build and run

Open the project in **Apache NetBeans** and press **F6** (Run Project), or build from the command line:

```bash
ant run
```

---

## 📁 Project Structure

```
hotel-management-system/
├── src/
│   ├── db.properties              ← Your local DB config (git-ignored)
│   └── com/olf/
│       ├── system/
│       │   └── Main.java          ← JavaFX Application entry point
│       ├── model/                 ← Domain entities (POJOs)
│       │   ├── Usuario.java
│       │   ├── TipoHabitacion.java
│       │   ├── Habitacion.java
│       │   ├── Huesped.java
│       │   ├── Reserva.java
│       │   ├── ConsumoServicio.java
│       │   └── FacturaHotel.java
│       ├── dao/                   ← DAO interfaces
│       │   ├── Crud.java
│       │   ├── Dao.java
│       │   └── impl/              ← JDBC implementations
│       ├── service/               ← Business logic
│       │   ├── CheckInService.java
│       │   └── CheckoutService.java
│       ├── security/              ← Auth & RBAC
│       │   ├── RolePermissions.java
│       │   └── SesionContext.java
│       ├── controller/            ← JavaFX controllers
│       │   ├── LoginController.java
│       │   └── DashboardController.java
│       ├── view/                  ← FXML layouts & CSS
│       │   ├── LoginView.fxml
│       │   ├── DashboardView.fxml
│       │   └── loginview.css
│       ├── exception/             ← Custom exceptions
│       │   ├── AppException.java
│       │   ├── DBException.java
│       │   └── GlobalExceptionHandler.java
│       └── util/
│           ├── Conexion.java      ← Singleton DB connection
│           └── PasswordHasher.java← PBKDF2 password hashing
├── sql/
│   ├── 01-ddl-grandstay.sql      ← Schema: tables, procedures, views
│   └── 02-dml-grandstay.sql      ← Seed data
├── db.properties.example          ← Connection config template
├── build.xml                      ← Ant build file
└── manifest.mf
```

---

## 🔐 Role-Based Access Control

The system supports **5 user roles**, each with a different set of allowed modules:

| Role | Dashboard | Room Types | Rooms | Guests | Reservations | Services | Invoices | Users | Check-In | Check-Out |
|---|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|
| **Admin / Gerente** | ✅ | ✅ | ✅ | ✅ | ✅ | ✅ | ✅ | ✅ | ✅ | ✅ |
| **Recepcionista** | ✅ | ✅ | ✅ | ✅ | ✅ | ✅ | ✅ | ❌ | ✅ | ✅ |
| **Cajero / Contador** | ✅ | ❌ | ❌ | ❌ | ✅ | ✅ | ✅ | ❌ | ✅ | ✅ |
| **Auditor** | ✅ | ✅ | ✅ | ✅ | ✅ | ✅ | ✅ | ❌ | ❌ | ❌ |
| **Housekeeping** | ✅ | ❌ | ✅ | ❌ | ❌ | ❌ | ❌ | ❌ | ❌ | ❌ |

---

## 👤 Author

**Octavio López Flores**

[![GitHub](https://img.shields.io/badge/GitHub-octavioLF-181717?style=for-the-badge&logo=github)](https://github.com/octavioLF)

---

<div align="center">
  <sub>Built with ❤️ using Java · JavaFX · MySQL</sub>
</div>
