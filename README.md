# email_Api
owner priyanka

📧 Spring Boot Email Sending Application

This is a simple Spring Boot web app that lets you send emails via a REST API using SMTP (like Gmail).

---

📦 Technologies Used:
- Java 17+
- Spring Boot
- Spring Web + Spring Boot Starter Mail
- Maven
- Gmail SMTP

---

📁 Files Included:
1. EmailController.java – Handles `/sendMail` POST endpoint
2. EmailRequest.java – Model class with `to`, `subject`, `message`
3. EmailService.java – Handles email logic using JavaMailSender

---

🛠 Setup Instructions:

1. Add this in `application.properties`:

2. 
2. Replace `your_email@gmail.com` and `your_app_password` with actual values.
- Create an [App Password](https://support.google.com/accounts/answer/185833) if using Gmail.

---

🚀 How to Run:

▶ With Maven:
```bash
mvn spring-boot:run

 API: Send Email

URL: POST http://localhost:8080/sendMail

Headers: Content-Type: application/json

Body:

json
Copy
Edit
{
  "to": "someone@example.com",
  "subject": "Test",
  "message": "This is a test email."
}

✅ Response: "Email sent successfully"
❌ On failure: 500 Internal Server Error




