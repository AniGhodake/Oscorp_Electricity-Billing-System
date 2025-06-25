# Oscorp_Electricity-Billing-System


## 👨‍💻 About
A desktop application for managing customer billing for electricity usage. Includes bill calculation, report generation, and login system.

## 💻 Technologies Used
- Java (Swing for UI)
- MySQL 8
- JDBC (mysql-connector-java-5.1.6-bin.jar)

## 📁 Folder Structure
- `src/` - Java source code
- `lib/` - Required JAR libraries
- `database/` - MySQL `.sql` file for setup

## 🛠️ How to Run
1. Import `electricity_billing.sql` into MySQL
2. Compile and run:
   ```bash
   javac -cp "lib/*" -d bin src/electricitybillingsystem/*.java
   java -cp "bin;lib/*" electricitybillingsystem.splash
