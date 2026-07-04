# bank-microservices

A hands-on bank simulation project built while learning Spring Boot, Microservices, Docker, and Kubernetes. This project follows the EazyBank pattern used in popular Spring Boot microservices courses.

## Overview

This project simulates core banking operations broken into independent microservices. Each service owns its own data and business logic, and they communicate with each other as needed, following microservices architecture principles.

## Microservices

| Service | Description | Port |
|---|---|---|
| `accounts` | Manages customer accounts: creation, updates, and account details | 8080 |
| `loans` | Manages loan applications, approvals, and loan details | 8090 |
| `cards` | Manages credit/debit card issuance and card details | 9000 |

## Tech Stack

- **Java 17+**
- **Spring Boot** – core application framework
- **Spring Data JPA** – database persistence
- **MySQL / H2** – database (H2 for local dev, MySQL for containerized setup)
- **Docker** – containerization
- **Kubernetes** – container orchestration
- **Spring Cloud Config** – centralized configuration (added later in the course)
- **Eureka** – service discovery (added later in the course)
- **Spring Cloud Gateway** – API gateway (added later in the course)
- **Resilience4j** – circuit breakers and fault tolerance (added later in the course)

## Project Structure

```
bank-microservices/
├── accounts/
├── loans/
├── cards/
├── configserver/       (added later)
├── eurekaserver/       (added later)
├── gatewayserver/      (added later)
└── README.md
```

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven
- Docker (for containerized run)
- An IDE (IntelliJ IDEA recommended)

### Running a Service Locally

Navigate into any service folder and run:

```bash
mvn spring-boot:run
```

### Building Docker Images

Each service includes its own `Dockerfile` (or uses Spring Boot's built-in Buildpacks support). Example using Maven's Spring Boot plugin:

```bash
mvn spring-boot:build-image
```

### Running with Docker Compose

Once a `docker-compose.yml` is added at the root, all services can be started together:

```bash
docker-compose up
```

### Deploying to Kubernetes

Kubernetes manifests (Deployments, Services, ConfigMaps) will be added under a `k8s/` folder as the course progresses.

```bash
kubectl apply -f k8s/
```

## Learning Goals

This project is a learning exercise covering:

- Designing independent, loosely coupled microservices
- REST API development with Spring Boot
- Containerizing services with Docker
- Orchestrating services with Kubernetes
- Service discovery, config management, and API gateways
- Resilience patterns in distributed systems

## Status

🚧 Work in progress — services and infrastructure are being added incrementally as the course progresses.
