# ADS Dental Appointment Management System

This is a Command-Line Interface (CLI) application for the ADS Dental Appointment Management System.

The application loads existing appointment data and displays information about appointments and patients in JSON format.

## Technologies Used

- Java 25
- Apache Maven
- Gson JSON processing library
- GitHub Actions
- Docker

## Project Architecture

This project follows a layered architecture and Separation of Concerns.

### Layers

- `domain` - contains domain model classes such as Patient, Dentist, and Appointment
- `repository` - contains data access classes and loads existing data
- `service` - contains business logic
- `ui` - contains the command-line user interface
- `config` - contains Gson adapters for LocalDate and LocalTime

## Features

1. Display all appointments
2. Display all patients
3. Display appointment data in JSON format
4. Sort appointments by appointment date and time
5. Include patient data, patient age, and dentist information inside appointment output

## Runtime Requirement

Java 25 is required to run this application.

Check Java version:

```bash
java --version
```

## Run with Docker

Pull the Docker image:

```bash
docker pull darkhaa/ads:1.0.2
```

Run the application:

```bash
docker run -it --rm darkhaa/ads:1.0.2
```

## Links

- GitHub: https://github.com/Darkhaamn/miu-cs425-midterm
- Docker Hub: https://hub.docker.com/r/darkhaa/ads