******** Employee Shift Management System (ESMS) ********

**************************
******** Submitters ******
**************************
Yaniv Kaveh - Shtul: 206768004
Elad Sztejnworcel: 204296495

**************************
******** Overview ********
**************************

The Employee Shift Management System (ESMS) is a comprehensive, Java-based application designed for efficient workforce scheduling, time tracking, and employee management. With robust role-based access control, the system caters to various user roles, including employees, shift managers, and administrators, each having access to specific functionalities according to their permissions.

Key Features:
	- Role-Based Access Control: Adaptive menus and functionalities based on the user's role (e.g., Admin, Manager, Employee).
	- Shift Management:
		Add, update, delete, and search for shifts.
		Register shift start and end times.
		Print shifts by day, week, or month.
	- Employee Management:
		Add, update, delete, and search for employees.
		Assign employees to shifts.
	- User Management:
		Initialization with an admin setup.
		Login and logout functionality.
		Dynamic menu generation based on user roles.
	- Reporting and Logs:
		Automatic log generation at each startup, capturing timestamps for auditing purposes.
		Detailed reporting features for shifts and employee activities.

****************************
******** How to Use ********
****************************

	- System Initialization: Upon first startup, an administrator account is automatically generated with the following credentials:
		Username: admin
		Password: admin
		Additionally, random user accounts are created and pre-assigned to shifts to simulate a populated system.

	- User Login: Log in with the provided credentials. Based on your role (Admin, Manager, Employee), you will have access to different functionalities.

	- Shift Operations: Administrators and Managers can manage shifts by adding, updating, searching, or deleting them. Employees can register shift start and end times.

	- Employee Operations: Administrators can manage employees, including adding new staff, updating information, or removing employees from the system.

	- Reporting: Print detailed shift reports filtered by day, week, or month. These reports allow for effective workforce monitoring and management.

***************************************
******** Important Information ********
***************************************

	- Default Admin Account: The default admin account (admin/admin) should be used for the initial system configuration.
	- Auto-Generated Data: Random user accounts and shifts are automatically created during system startup to ensure the system is fully operational from the outset.
	- Logs: A log file is generated at every system startup, recording the date and time for system auditing and tracking.