# School Management

A collection of Java-based School Management projects demonstrating student/teacher data management with different persistence approaches.

## Projects

### 1. `hybernate/` — Hibernate + PostgreSQL
A JPA/Hibernate demo modeling `Student` and `Teacher` entities with a PostgreSQL database.
- **Stack:** Java, Hibernate (JPA), PostgreSQL, Maven
- **Entities:** `Student`, `Teacher`
- **Config:** `src/main/resources/META-INF/persistence.xml`

### 2. `jdbc-schoolmangement/` — Core Java (layered)
A simpler school management implementation using a clean layered structure (entity → service → driver).
- **Stack:** Java, Maven
- **Structure:** `entity/Student`, `service/StudentService`, `driver/StudentDriver`

## Getting Started

Each project is a standalone Maven module. To build/run one:

```bash
cd hybernate            # or: cd jdbc-schoolmangement
mvn clean compile
```

For the Hibernate module, update the database connection in
`hybernate/src/main/resources/META-INF/persistence.xml` before running.

## Tech Stack
Java · Hibernate (JPA) · JDBC · PostgreSQL · Maven
