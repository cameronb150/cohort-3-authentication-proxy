# Authentication & Proxy
## Team 1 | Pro.To.Type
### - Mason K.
### - Seven A.
### - Joshua H.
### - Cameron B.
### - Owen S.

## Setup
- Open a git bash prompt in the root of the project
- Run "./mvnw generate-resources"
- Run "npm i"
- Run "./npm i @angular/cli"
- Run "./npm i"
- Run "./mvnw generate-resources"

# IntelliJ
- Open the project in intellij
- Change the user to postgres and password to the password for that superuser in application.properties
- Build and run src/main/java/AuthenticationProxyApplication.java

# pgAdmin
- Go into pgAdmin, navigate to the capstone_user user under Login/Group Roles under the PostgreSQL 15 server. 
- Right-click and select Properties, go to the Privileges tab, and enable the 'Can initiate streaming replication and backups?' privilege, then click Save
- Open up the Capstone database under PostgreSQL 15, then navigate to the 2 tables that were created under the Public schema
- If the tables aren't there, click 'Refresh' by right-clicking anywhere
- On both the users and user_roles tables, right-click and select Properties
- Within the Security tab, click the add (+) button in the top-right, then select the Grantee as capstone_user and the Privileges as Select (r) in the dropdowns
- Click Save

# IntelliJ pt. 2
- Head back into the application.properties file and change the username and password back to capstone_user and ${ENV_NAME} respectively

## Angular
- Every time an update is made to the Angular side of the project, you must rebuild the project with "./mvnw generate-resources" and re-run it