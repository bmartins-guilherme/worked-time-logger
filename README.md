# Worked Time Logger

Worked Time Logger is a Spring Boot microservices project focused on recording worked time by user and task.

The goal is to provide secure APIs for:
- user lifecycle management
- authentication and token validation
- task management
- worked time registration and reporting

## Business Objective

Enable teams to register and track worked time with consistency, auditability, and clear ownership of each time entry.

## Scope (MVP)

The MVP covers 4 epics and 17 user stories:
- Epic 1: User Service
- Epic 2: Authentication Service
- Epic 3: Task Management
- Epic 4: Worked Time Management

Key functional expectations:
- username must be unique
- all protected endpoints require authentication
- task lifecycle uses statuses: TO_DO, IN_PROGRESS, CANCELED, DONE
- worked time can be registered only for tasks in IN_PROGRESS
- listing endpoints are pageable, with default page size = 5 in specified cases

## Proposed Microservices

Initial service boundaries:
- user-service: user registration, lookup, and updates
- auth-service: authentication and token validation
- task-service: task CRUD and task filtering
- worked-time-service: worked time CRUD and reporting

Recommended platform services:
- api-gateway: single entry point for clients
- service-discovery: service registration and lookup (optional at first, useful as services grow)
- config-server: centralized configuration (optional at first)

## Data Model (Initial)

Based on [worked_time_logger.sql](worked_time_logger.sql):
- tb_user_details
- tb_user
- tb_task
- tb_worked_time
- enum task_status = TO_DO | IN_PROGRESS | CANCELED | DONE

## Tech Stack (Planned)

- Java 21
- Spring Boot 3.x
- Spring Web
- Spring Security
- Spring Data JPA
- PostgreSQL
- Maven

## API Expectations

General behavior from the backlog:
- HTTP 201 for successful create operations
- HTTP 200 for successful reads/updates
- HTTP 204 for successful delete operations
- HTTP 400 for invalid payload or business inconsistency
- HTTP 401 for unauthorized access
- HTTP 404 for non-existing resources

## Non-Functional Goals

- clear API contracts and standardized error responses
- observability (health checks, logs, and metrics)
- idempotent and predictable write operations where applicable
- modular design to allow service scaling by domain load

## Status

This repository currently contains:
- initial database script: [worked_time_logger.sql](worked_time_logger.sql)
- architecture draft diagram: [worked_time_logger.drawio](worked_time_logger.drawio)
