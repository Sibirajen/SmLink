# SmLink

SmLink is a simple **URL shortener application** built with **Spring Boot (backend)** and **React (frontend)**.  
It allows users to shorten long URLs, track usage, and redirect seamlessly.

---

## Features
- Shorten long URLs into custom short codes
- Redirect users to the original URL
- Track access count for each short link
- REST API built with Spring Boot
- MySQL database support

---

## Tech Stack
- **Backend**: Java, Spring Boot, Spring Data JPA
- **Database**: MySQL
- **Build Tool**: Maven

---

## API Endpoints
- `POST /api/shorten` → Create a short URL
- `GET /{shortCode}` → Redirect to original URL
- `GET /api/stats/{shortCode}` → Get stats (like access count)

---

## License
This project is open-source and available under the **MIT License**.

---

This project is a taken from [URL Shortening Service](https://roadmap.sh/projects/url-shortening-service)