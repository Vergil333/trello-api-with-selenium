# trello-api-with-selenium
Operate Trello with API and Selenium

Prerequisites:
- Java JDK 11.0.4+ (there is a bug in older versions)
- GeckoDriver


Basic Auth:
- Username: admin
- Password: heslo

Trello Login:
- Username: mojtestovaciucet1@gmail.com
- Password: BOnubsIldAdHoa6

POST http://localhost:8080/trello/make-bity-happy
- removes all items from Demo Board
- puts Demo List into Board
- puts Demo Card into List

Test TrelloApiWithSeleniumApplicationTests
- gets to the Trello
- performs Login
- checks if it is on Baords menu or gets there
- archives all lists from the Demo Board
- on empty boards creates Demo List and Demo Card in it