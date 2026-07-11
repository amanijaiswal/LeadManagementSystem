# Lead Management System

## Technology

- Spring Boot
- React
- MySQL
- Bootstrap
- Java Mail

---

## Features

- Lead Capture
- Email Sending
- Email Tracking
- Link Tracking
- Dashboard
- REST API

---

## Backend

```bash
mvn spring-boot:run
```

---

## Frontend

```bash
npm install

npm run dev
```

---

## Database

```sql
CREATE DATABASE lead_management;
```

---

## API

POST

```
/api/leads
```

GET

```
/api/dashboard
```

GET

```
/api/track/open/{token}
```

GET

```
/api/track/click/{token}
```