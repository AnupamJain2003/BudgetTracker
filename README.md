# BudgetTracker
Personal finance management system
# 💰 Budget Tracker System

The **Budget Tracker System** is a full-stack web application designed to help users manage their finances by tracking income and expenses, providing visual insights, and displaying account balances. This project is built with React for the frontend and Node.js with Express for the backend.

---

## 🌟 Features
- 🚀 **Account Management**: Create and validate bank accounts.
- 💸 **Transactions**: Add income or expense transactions with amount, category, and description.
- 📊 **Balance Display**: View the current balance of an account.
- 📈 **Visualizations**: Interactive bar charts showing income sources and expense categories.
- 🌐 **Responsive Design**: Built with React, Material-UI, and Recharts for a modern, responsive UI.

---

## 🛠️ Tech Stack
- **Frontend**: React, Material-UI (MUI), Recharts
- **Backend**: Spring boot
- **Database**: Hinernate(JPA)

---

https://github.com/user-attachments/assets/6ec52f75-d3bc-4821-ad5e-ae6e308b2bb3



📖 API Endpoints (Backend)
Method	Endpoint	Description
POST	/api/accounts	Create a new account
POST	/api/accounts/validate	Validate an account
POST	/api/accounts/:accountId/transactions	Add a transaction
GET	/api/accounts/:accountId/balance	View current balance
GET	/api/accounts/:accountId/expenses-by-category	View categorized expenses
GET	/api/accounts/:accountId/income-sources	View categorized income

