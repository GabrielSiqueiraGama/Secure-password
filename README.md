# Secure Password Validator

A simple **Spring Boot REST API** for validating passwords according to common security requirements.  
It checks if a password meets the rules and returns either `204 No Content` for a valid password or `400 Bad Request` for a invalid password, with a list of failures.

Supports **internationalization (i18n)**.  
By setting the header `Accept-Language` to `en` or `pt`, the failure messages will be returned in English or Portuguese, respectively.

🌐 Available languages: [English](README.md) | [Português](README-pt.md)

## 📌 Features
- REST API with a single endpoint: `/validate-password`
- Validates passwords against the following rules:
  - Must not be null or empty
  - Minimum length of **8 characters**
  - At least **one uppercase letter** (`A-Z`)
  - At least **one lowercase letter** (`a-z`)
  - At least **one number** (`0-9`)
  - At least **one special character** (`!@#$%^&*...`)

---

## ⚙️ Tools
- Java
- Spring Boot 

---

## 🚀 Running the project

```bash
# Clone the repository
git clone https://github.com/GabrielSiqueiraGama/Secure-password.git
cd secure-password
```
# Build and run a application spring-boot

The API will be available at:
POST
localhost:8080/validate-password
 
Request body:
```bash
{
  "password": "YourPassword123!"
}
```


## 🛠️ Example with curl
```bash
http://localhost:8080/validate-password
  "Content-Type: application/json" \
  "Accept-Language: en"
{
	"password": "Weak"
}

```
Response:
```bash
{
  "failures": [
    "Password must be at least 8 characters long.",
    "Password must contain at least one number.",
    "Password must contain at least one special character."
  ]
}
```
