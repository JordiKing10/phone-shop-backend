# PhoneShop Backend

PhoneShop Backend is a Spring Boot application that exposes a REST API for similar products using hexagonal architecture. The application runs on port 5000 and integrates with external mocks on port 3001.

## Technologies

- Java 17
- Spring Boot 3.4.3
- Maven
- Docker

1. Build and run with Maven:
   ```bash
   mvn spring-boot:run
2. The application will be available at http://localhost:5000.

## Testing the Application
1. Enable file sharing for the shared folder in Docker settings.
2. Start the mocks and necessary infrastructure:
    ```bash
    docker-compose up -d simulado influxdb grafana
2. Verify the mocks work with:
    ```bash
    http://localhost:3001/product/1/similarids
3. Run the performance test:
   ```bash
   docker-compose run --rm k6 run scripts/test.js
3. View the test results at:
   ```bash
   http://localhost:3000/d/Le2Ku9NMk/k6-performance-test