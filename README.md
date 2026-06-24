# BFHL Data Processor API

This is a REST API built with Java and Spring Boot for the Bajaj Finserv Health Limited (BFHL) recruitment process. The API processes an array of data containing numbers and alphabets, performing specific calculations and string manipulations.

## Tech Stack
* **Language**: Java 17
* **Framework**: Spring Boot 4.1.0
* **Build Tool**: Maven
* **Hosting/Deployment**: Docker & Render

---

## API Endpoints

### 1. Process Data
* **URL**: `/bfhl`
* **Method**: `POST`
* **Description**: Accepts a JSON array of strings containing numbers and alphabetic characters. It separates them into distinct categories, calculates the sum of all numbers, and concatenates all alphabetic characters in reverse order with alternating capitalization.

#### Request Format
```json
{
  "data": ["a", "1", "334", "4", "R", "$"]
}
```

#### Response Format
```json
{
  "is_success": true,
  "user_id": "raghav_verma_29012006",
  "email": "raghav1185.be23@chitkara.edu.in",
  "roll_number": "2310991185",
  "odd_numbers": ["1"],
  "even_numbers": ["334", "4"],
  "alphabets": ["A", "R"],
  "special_characters": ["$"],
  "sum": "339",
  "concat_string": "Ra"
}
```

### 2. Health Check
* **URL**: `/health`
* **Method**: `GET`
* **Description**: A simple health check endpoint to verify the API is running correctly.

#### Response Format
```json
{
  "status": "UP"
}
```

---

## Logic Details

When the POST `/bfhl` endpoint is hit:
1. **Numbers** are parsed. If a number is even, it goes to the `even_numbers` array. If odd, it goes to `odd_numbers`. The total sum of all numbers is returned as a string in `sum`.
2. **Alphabets** are extracted and stored as uppercase letters in the `alphabets` array.
3. **Special Characters** (anything that is not a number or a letter) are stored in the `special_characters` array.
4. **String Concatenation**: All alphabetic characters found in the input are concatenated in **reverse order**, with **alternating capitalization** (starting with uppercase for the 0th index). This is returned in `concat_string`.

## Edge Cases Handled
- Empty input arrays or missing `data` fields are handled gracefully without crashing, always returning the required user identity fields.
- Non-alphanumeric special characters are captured in a dedicated array.

## How to Run Locally

1. Clone the repository
2. Navigate to the project root directory
3. Run the application using Maven:
   ```bash
   cd BajajAPIRound
   ./mvnw spring-boot:run
   ```
4. The API will be available at `http://localhost:8080/bfhl`
