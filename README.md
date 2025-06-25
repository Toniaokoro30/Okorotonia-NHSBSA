
# Okorotonia-NHSBSA

## 📌 Project Overview
This project contains an automated test suite for the NHS Jobs search functionality, developed as part of the NHSBSA Automation Test Analyst technical exercise.

The objective is to test the ability of a jobseeker to search for jobs with specific preferences and retrieve results sorted by the newest date posted.

---

## 🛠 Tech Stack
- **Java 21**
- **Selenium 4**
- **Cucumber (BDD)**
- **WebDriverManager**
- **JUnit 4**
- **Maven**

---

## 📁 Project Structure
```
src/
├── main/
│   └── java/
│       └── pages/              # Page Object Model for web interaction
├── test/
│   └── java/
│       ├── stepdefinitions/    # Step definitions for BDD
│       └── runners/            # Test runner class
│   └── resources/
│       └── features/           # Feature files written in Gherkin
```

---

## 🧪 Test Coverage
- Keyword and Location search input
- Clicking the search button
- Retrieving a list of job results
- Sorting results by “Date Posted (newest)”
- Validating the job result dates are correctly sorted in descending order

---

## 🚀 How to Run the Tests

### 💡 Prerequisites:
- Java 21
- Maven installed
- Internet connection (for WebDriverManager)

### 🧾 Command:
```bash
mvn clean test
```

This will run the Cucumber test suite in your default browser (Chrome or Edge).

---

## 🌐 Cross-Browser Support
WebDriverManager ensures tests can run on:
- Google Chrome
- Microsoft Edge

---

## 🧰 Accessibility, Compatibility, Performance (see presentation)
- Accessibility testing planned using Axe-core
- Compatibility tested across Chrome and Edge
- Performance considerations include JMeter

---

## 🔄 Data Migration Considerations
For migrating job data from NHS Trusts:
- Validate field mapping
- Check for integrity and nulls
- Match record counts pre- and post-migration
- Perform UAT and spot checks

---

## 👤 Author
**Okoro Tonia**

For any clarifications, please contact me or refer to the project documentation.
:
