# Account & Transactions
This is a sample project to fetch accounts and their transactions from an in-memory database. As it is code challenge
project, the services are not limited to a single user so everyone can see the list of accounts and transaction. 
There is no UI for this code sample so you may test it only with REST clients such as POSTMAN.

### Data Import
The dummy data is stored in data.sql in `src/main/resources` package.

### Build Project
This is a maven project, so you can build the application using `mvn clean package`.

### Run The Application
Simply run the project with `mvn spring-boot:run`.
The application is hosted on port 8080 and you can find the description of the endpoint bellow.

After running the application there are two endpoints available in this project:
* GET `localhost:8080/account` it will return the list of accounts 
* GET `localhost:8080/account/transaction` it will return all the transactions in the system. To fetch the transactions 
for an account simply add `?accountId={id}` to the end of the URL and replace `{id}` with the account id for example: 
`localhost:8080/account/transaction?accountId=1`
