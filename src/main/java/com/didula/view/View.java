package com.didula.view;

import com.didula.buisness.model.metadata.*;
import com.didula.buisness.model.metadata.Module;
import com.didula.controller.*;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class View {

  private final Map<String, String> menu;
  private final Map<String, Printable> methodsMenu;
  private static final Scanner input = new Scanner(System.in);

  private static final CourseController courseController = new CourseController();
  private static final AnswerController answerController = new AnswerController();
  private static final GenderController genderController = new GenderController();
  private static final UserController userController = new UserController();
  private static final SecurityController securityController = new SecurityController();
  private static final CourseInfoController courseInfoController = new CourseInfoController();
  private static final TestController testController = new TestController();
  private static final ModuleController moduleController = new ModuleController();
  private static final MessageController messageController = new MessageController();
  private static final TestHasAnswerController testHasAnswerController = new TestHasAnswerController();

  public View() {
    menu = new LinkedHashMap<>();
    methodsMenu = new LinkedHashMap<>();

    menu.put("0", "0-Select all tables");

    methodsMenu.put("0", this::printAllTables);

    //Course Menu
    menu.put("1", "1-Table:Course");
    menu.put("11", "11-Find all the courses");
    menu.put("12", "12-Find course by id");
    menu.put("13", "13-Create a course");
    menu.put("14", "14-Update a course");
    menu.put("15", "15-Delete a course");

    methodsMenu.put("11", this::printCourseTable);
    methodsMenu.put("12", this::printSingleRecordByIdFromCourseTable);
    methodsMenu.put("13", this::createCourse);
    methodsMenu.put("14", this::updateCourse);
    methodsMenu.put("15", this::deleteCourse);

    //Answer Menu
    menu.put("2", "2-Table:Answer");
    menu.put("21", "21-Find all the answers");
    menu.put("22", "22-Find answer by id");
    menu.put("23", "23-Create a answer");
    menu.put("24", "24-Update a answer");
    menu.put("25", "25-Delete a answer");

    methodsMenu.put("21", this::printAnswerTable);
    methodsMenu.put("22", this::printSingleRecordByIdFromAnswerTable);
    methodsMenu.put("23", this::createAnswer);
    methodsMenu.put("24", this::updateAnswer);
    methodsMenu.put("25", this::deleteAnswer);

    //Gender Menu
    menu.put("3", "3-Table:Gender");
    menu.put("31", "31-Find all the genders");
    menu.put("32", "32-Find gender by id");
    menu.put("33", "33-Create a gender");
    menu.put("34", "34-Update a gender");
    menu.put("35", "35-Delete a gender");

    methodsMenu.put("31", this::printGenderTable);
    methodsMenu.put("32", this::printSingleRecordByIdFromGenderTable);
    methodsMenu.put("33", this::createGender);
    methodsMenu.put("34", this::updateGender);
    methodsMenu.put("35", this::deleteGender);

    //User Menu
    menu.put("4", "4-Table:User");
    menu.put("41", "41-Find all the users");
    menu.put("42", "42-Find user by id");
    menu.put("43", "43-Create a user");
    menu.put("44", "44-Update a user");
    menu.put("45", "45-Delete a user");

    methodsMenu.put("41", this::printUserTable);
    methodsMenu.put("42", this::printSingleRecordByIdFromUserTable);
    methodsMenu.put("43", this::createUser);
    methodsMenu.put("44", this::updateUser);
    methodsMenu.put("45", this::deleteUser);

    //Security Menu
    menu.put("5", "5-Table:Security");
    menu.put("51", "51-Find all the securities");
    menu.put("52", "52-Find security by id");
    menu.put("53", "53-Create a security");
    menu.put("54", "54-Update a security");
    menu.put("55", "55-Delete a security");

    methodsMenu.put("51", this::printSecurityTable);
    methodsMenu.put("52", this::printSingleRecordByIdFromSecurityTable);
    methodsMenu.put("53", this::createSecurity);
    methodsMenu.put("54", this::updateSecurity);
    methodsMenu.put("55", this::deleteSecurity);

    //Course Info Menu
    menu.put("6", "6-Table:CourseInfo");
    menu.put("61", "61-Find all the courses info");
    menu.put("62", "62-Find course info by id");
    menu.put("63", "63-Create a course info");
    menu.put("64", "64-Update a course info");
    menu.put("65", "65-Delete a course info");

    methodsMenu.put("61", this::printCourseInfoTable);
    methodsMenu.put("62", this::printSingleRecordByIdFromCourseInfoTable);
    methodsMenu.put("63", this::createCourseInfo);
    methodsMenu.put("64", this::updateCourseInfo);
    methodsMenu.put("65", this::deleteCourseInfo);

    //Test Menu
    menu.put("7", "7-Table:Test");
    menu.put("71", "71-Find all the tests");
    menu.put("72", "72-Find test by id");
    menu.put("73", "73-Create a test");
    menu.put("74", "74-Update a test");
    menu.put("75", "75-Delete a test");

    methodsMenu.put("71", this::printTestTable);
    methodsMenu.put("72", this::printSingleRecordByIdFromTestTable);
    methodsMenu.put("73", this::createTest);
    methodsMenu.put("74", this::updateTest);
    methodsMenu.put("75", this::deleteTest);

    //Module Menu
    menu.put("8", "8-Table:Module");
    menu.put("81", "81-Find all the modules");
    menu.put("82", "82-Find module by id");
    menu.put("83", "83-Create a module");
    menu.put("84", "84-Update a module");
    menu.put("85", "85-Delete a module");

    methodsMenu.put("81", this::printModuleTable);
    methodsMenu.put("82", this::printSingleRecordByIdFromModuleTable);
    methodsMenu.put("83", this::createModule);
    methodsMenu.put("84", this::updateModule);
    methodsMenu.put("85", this::deleteModule);

    //Message Menu
    menu.put("9", "9-Table:Message");
    menu.put("91", "91-Find all the messages");
    menu.put("92", "92-Find message by id");
    menu.put("93", "93-Create a message");
    menu.put("94", "94-Update a message");
    menu.put("95", "95-Delete a message");

    methodsMenu.put("91", this::printMessageTable);
    methodsMenu.put("92", this::printSingleRecordByIdFromMessageTable);
    methodsMenu.put("93", this::createMessage);
    methodsMenu.put("94", this::updateMessage);
    methodsMenu.put("95", this::deleteMessage);

    //Test has answer Menu
    menu.put("B", "B-Table:TestHasAnswer");
    menu.put("B1", "B1-Find all the test has answers");
    menu.put("B2", "B2-Find test has answer by id");
    menu.put("B3", "B3-Create a test has answer");
    menu.put("B4", "B4-Update a test has answer");
    menu.put("B5", "B5-Delete a test has answer");

    methodsMenu.put("B1", this::printTestHasAnswerTable);
    methodsMenu.put("B2", this::printSingleRecordByIdFromTestHasAnswerTable);
    methodsMenu.put("B3", this::createTestHasAnswer);
    methodsMenu.put("B4", this::updateTestHasAnswer);
    methodsMenu.put("B5", this::deleteTestHasAnswer);

  }

  private void printAllTables() throws SQLException {
    printCourseTable();
    printAnswerTable();
    printGenderTable();
    printUserTable();
    printSecurityTable();
    printCourseInfoTable();
    printTestTable();
    printModuleTable();
    printMessageTable();
    printTestHasAnswerTable();
  }

  public void show() {

    String keyMenu;

    do {
      printMenu();
      System.out.println("Please, select point:");
      keyMenu = input.nextLine().toUpperCase();
      while (keyMenu.equals("")) {
        keyMenu = input.nextLine().toUpperCase();
      }

      if (keyMenu.matches("(^\\d)|(^B)")) {
        printSubMenu(keyMenu);
        System.out.println("Select the point of menu:");
        keyMenu = input.nextLine().toUpperCase();
        while (keyMenu.equals("")) {
          keyMenu = input.nextLine().toUpperCase();
        }
      }

      if (keyMenu.equals("L")) {
        continue;
      }
      if (keyMenu.equals("Q")) {
        break;
      }

      try {
        methodsMenu.get(keyMenu).print();
      } catch (Exception throwables) {
        System.out.println("Can't execute command");
        System.out.println("Expresion is " + throwables.getMessage());
      }

    } while (true);

  }

  private void printMenu() {
    System.out.print("\nMenu:\n");
    for (Map.Entry<String, String> item : menu.entrySet()) {
      if (item.getKey().length() == 1 && !item.getValue().equals("L")) {
        System.out.println(item.getValue());
      }
    }
  }

  private void printSubMenu(String fig) {
    System.out.println("\nSubMenu:\n");
    for (Map.Entry<String, String> item : menu.entrySet()) {
      if (item.getValue().length() != 1 && item.getValue().substring(0, 1).equals(fig)
              || item.getValue().equals("L") || item.getValue().equals("Q")) {
        System.out.println(item.getValue());
      }
    }
  }

  //==========COURSE=============
  private Course readCourse() {
    System.out.println("Enter name of the course: ");
    final String enteredCourseName = input.nextLine();

    System.out.println("Enter duration in hours of the course: ");
    final double enteredDurationInHours = input.nextDouble();

    return new Course(0, enteredCourseName, enteredDurationInHours);
  }

  private int readIdOfCourse() {
    System.out.println("Enter ID of the course: ");
    return input.nextInt();
  }

  private void printCourseTable() throws SQLException {
    List<Course> courses = courseController.getAllCourses();
    System.out.println("\nCourses\n");
    System.out.format("%3s   %30s   %15s ", "id", "courseName", "durationInHours");
    for (Course course : courses) {
      System.out.print("\n" + course);
    }
    System.out.println("\n");
  }

  private void printSingleRecordByIdFromCourseTable() throws SQLException {
    int enteredIdOfCourse = readIdOfCourse();
    System.out.println("\nCourse\n");
    System.out.format("%3s   %30s   %15s ", "id", "courseName", "durationInHours");
    System.out.println("\n" + courseController.getCourse(enteredIdOfCourse) + "\n");
  }

  private void createCourse() throws SQLException {
    Course course = readCourse();
    courseController.postCourse(course);
  }

  private void updateCourse() throws SQLException {
    Course course = readCourse();
    int enteredIdOfCourse = readIdOfCourse();
    course.setId(enteredIdOfCourse);
    courseController.putCourse(course);
  }

  private void deleteCourse() throws SQLException {
    Integer enteredIdOfCourse = readIdOfCourse();
    courseController.deleteCourse(enteredIdOfCourse);
  }

  //==========ANSWER=============
  private Answer readAnswer() {
    System.out.println("Enter name of the answer: ");
    final String enteredAnswerName = input.nextLine();

    return new Answer(0, enteredAnswerName);
  }

  private int readIdOfAnswer() {
    System.out.println("Enter ID of the answer: ");
    return input.nextInt();
  }

  private void printAnswerTable() throws SQLException {
    List<Answer> answers = answerController.getAllAnswers();
    System.out.println("\nAnswers\n");
    System.out.format("%3s   %30s ", "id", "answerName");
    for (Answer answer : answers) {
      System.out.print("\n" + answer);
    }
    System.out.println("\n");
  }

  private void printSingleRecordByIdFromAnswerTable() throws SQLException {
    int enteredIdOfAnswer = readIdOfAnswer();
    System.out.println("\nAnswer\n");
    System.out.format("%3s   %30s ", "id", "answerName");
    System.out.println("\n" + answerController.getAnswer(enteredIdOfAnswer) + "\n");
  }

  private void createAnswer() throws SQLException {
    Answer answer = readAnswer();
    answerController.postAnswer(answer);
  }

  private void updateAnswer() throws SQLException {
    Answer answer = readAnswer();
    int enteredIdOfAnswer = readIdOfAnswer();
    answer.setId(enteredIdOfAnswer);
    answerController.putAnswer(answer);
  }

  private void deleteAnswer() throws SQLException {
    Integer enteredIdOfAnswer = readIdOfAnswer();
    answerController.deleteAnswer(enteredIdOfAnswer);
  }

  //==========GENDER=============
  private Gender readGender() {
    System.out.println("Enter name of the gender: ");
    final String enteredGenderName = input.nextLine();

    return new Gender(0, enteredGenderName);
  }

  private int readIdOfGender() {
    System.out.println("Enter ID of the gender: ");
    return input.nextInt();
  }

  private void printGenderTable() throws SQLException {
    List<Gender> genders = genderController.getAllGenders();
    System.out.println("\nGenders\n");
    System.out.format("%3s   %15s ", "id", "genderName");
    for (Gender gender : genders) {
      System.out.print("\n" + gender);
    }
    System.out.println("\n");
  }

  private void printSingleRecordByIdFromGenderTable() throws SQLException {
    int enteredIdOfGender = readIdOfGender();
    System.out.println("\nGender\n");
    System.out.format("%3s   %15s ", "id", "genderName");
    System.out.println("\n" + genderController.getGender(enteredIdOfGender) + "\n");
  }

  private void createGender() throws SQLException {
    Gender gender = readGender();
    genderController.postGender(gender);
  }

  private void updateGender() throws SQLException {
    Gender gender = readGender();
    int enteredIdOfGender = readIdOfGender();
    gender.setId(enteredIdOfGender);
    genderController.putGender(gender);
  }

  private void deleteGender() throws SQLException {
    Integer enteredIdOfGender = readIdOfGender();
    genderController.deleteGender(enteredIdOfGender);
  }

  //==========USER=============
  private User readUser() {
    System.out.println("Enter full name of the user: ");
    final String enteredFullName = input.nextLine();

    System.out.println("Enter forums name of the user: ");
    final String enteredForumsName = input.nextLine();

    System.out.println("Enter email of the user: ");
    final String enteredEmail = input.nextLine();

    System.out.println("Enter birth year of the user: ");
    final int enteredBirthYear = input.nextInt();

    System.out.println("Enter gender id of the user: ");
    final Integer enteredGenderId = input.nextInt();

    return new User(0, enteredFullName, enteredForumsName, enteredEmail, enteredBirthYear, enteredGenderId);
  }

  private int readIdOfUser() {
    System.out.println("Enter ID of the user: ");
    return input.nextInt();
  }

  private void printUserTable() throws SQLException {
    List<User> users = userController.getAllUsers();
    System.out.println("\nUsers\n");
    System.out.format("%3s   %50s   %50s   %30s   %4s   %6s ", "id", "fullName", "forumsName", "email", "birthYear", "genderId");
    for (User user : users) {
      System.out.print("\n" + user);
    }
    System.out.println("\n");
  }

  private void printSingleRecordByIdFromUserTable() throws SQLException {
    int enteredIdOfUser = readIdOfUser();
    System.out.println("\nUser\n");
    System.out.format("%3s   %50s   %50s   %30s   %4s   %6s ", "id", "fullName", "forumsName", "email", "birthYear", "genderId");
    System.out.println("\n" + userController.getUser(enteredIdOfUser) + "\n");
  }

  private void createUser() throws SQLException {
    User user = readUser();
    userController.postUser(user);
  }

  private void updateUser() throws SQLException {
    User user = readUser();
    int enteredIdOfUser = readIdOfUser();
    user.setId(enteredIdOfUser);
    userController.putUser(user);
  }

  private void deleteUser() throws SQLException {
    Integer enteredIdOfUser = readIdOfUser();
    userController.deleteUser(enteredIdOfUser);
  }

  //==========SECURITY=============
  private Security readSecurity() {
    System.out.println("Enter password of the security: ");
    final String enteredPassword = input.nextLine();

    System.out.println("Enter user id of the security: ");
    final Integer enteredUserId = input.nextInt();

    return new Security(0, enteredPassword, enteredUserId);
  }

  private int readIdOfSecurity() {
    System.out.println("Enter ID of the security: ");
    return input.nextInt();
  }

  private void printSecurityTable() throws SQLException {
    List<Security> securities = securityController.getAllSecurities();
    System.out.println("\nSecurities\n");
    System.out.format("%3s   %8s   %3s ", "id", "password", "userId");
    for (Security security : securities) {
      System.out.print("\n" + security);
    }
    System.out.println("\n");
  }

  private void printSingleRecordByIdFromSecurityTable() throws SQLException {
    int enteredIdOfSecurity = readIdOfSecurity();
    System.out.println("\nSecurity\n");
    System.out.format("%3s   %8s   %3s ", "id", "password", "userId");
    System.out.println("\n" + securityController.getSecurity(enteredIdOfSecurity) + "\n");
  }

  private void createSecurity() throws SQLException {
    Security security = readSecurity();
    securityController.postSecurity(security);
  }

  private void updateSecurity() throws SQLException {
    Security security = readSecurity();
    int enteredIdOfSecurity = readIdOfSecurity();
    security.setId(enteredIdOfSecurity);
    securityController.putSecurity(security);
  }

  private void deleteSecurity() throws SQLException {
    Integer enteredIdOfSecurity = readIdOfSecurity();
    securityController.deleteSecurity(enteredIdOfSecurity);
  }

  //==========COURSE INFO=============
  private CourseInfo readCourseInfo() throws ParseException {
    System.out.println("Enter start date of the course info: ");
    SimpleDateFormat formatterDate = new SimpleDateFormat("yyyy-MM-dd");
    String dateString = input.nextLine();
    java.util.Date date = formatterDate.parse(dateString);
    final java.sql.Date enteredStartDate = convertUtilDateToSql(date);

    System.out.println("Enter completion in percents of the course info :");
    final BigDecimal enteredCompletion = input.nextBigDecimal();

    System.out.println("Enter if there are available message of the course info : ");
    final Boolean enteredAvailableMessage = input.nextBoolean();

    System.out.println("Enter course id of the course info : ");
    final Integer enteredCourseId = input.nextInt();

    System.out.println("Enter user id of the course info : ");
    final Integer enteredUserId = input.nextInt();

    return new CourseInfo(0, enteredStartDate, enteredCompletion, enteredAvailableMessage, enteredCourseId, enteredUserId);
  }

  private static java.sql.Date convertUtilDateToSql(java.util.Date uDate) {
    return new java.sql.Date(uDate.getTime());
  }

  private int readIdOfCourseInfo() {
    System.out.println("Enter ID of the course info: ");
    return input.nextInt();
  }

  private void printCourseInfoTable() throws SQLException {
    List<CourseInfo> coursesInfo = courseInfoController.getAllCoursesInfo();
    System.out.println("\nCourses Info\n");
    System.out.format("%3s   %12s   %16s   %16s   %10s   %8s", "id", "startDate", "completionInPercents", "availableMessage", "courseId", "userId");
    for (CourseInfo courseInfo : coursesInfo) {
      System.out.print("\n" + courseInfo);
    }
    System.out.println("\n");
  }

  private void printSingleRecordByIdFromCourseInfoTable() throws SQLException {
    int enteredIdOfCourseInfo = readIdOfCourseInfo();
    System.out.println("\nCourse Info\n");
    System.out.format("%3s   %12s   %16s   %16s   %10s   %8s", "id", "startDate", "completionInPercents", "availableMessage", "courseId", "userId");
    System.out.println("\n" + courseInfoController.getCourseInfo(enteredIdOfCourseInfo) + "\n");
  }

  private void createCourseInfo() throws SQLException, ParseException {
    CourseInfo courseInfo = readCourseInfo();
    courseInfoController.postCourseInfo(courseInfo);
  }

  private void updateCourseInfo() throws SQLException, ParseException {
    CourseInfo courseInfo = readCourseInfo();
    Integer enteredIdOfCourseInfo = readIdOfCourseInfo();
    courseInfo.setId(enteredIdOfCourseInfo);
    courseInfoController.putCourseInfo(courseInfo);
  }

  private void deleteCourseInfo() throws SQLException {
    Integer enteredIdOfCourseInfo = readIdOfCourseInfo();
    courseInfoController.deleteCourseInfo(enteredIdOfCourseInfo);
  }

  //==========TEST=============
  private Test readTest() {
    System.out.println("Enter name of the test :");
    final String enteredTestName = input.nextLine();

    System.out.println("Enter deadline datetime of the test : ");
    String datetimeString = input.nextLine();
    Timestamp enteredDatetime = Timestamp.valueOf(datetimeString);

    System.out.println("Enter if the test is completed : ");
    final Boolean enteredCompleted = input.nextBoolean();

    System.out.println("Enter if the test is overdue : ");
    final Boolean enteredOverdue = input.nextBoolean();

    System.out.println("Enter course info id of the test : ");
    final Integer enteredCourseInfoId = input.nextInt();

    return new Test(0, enteredTestName, enteredDatetime, enteredCompleted, enteredOverdue, enteredCourseInfoId);
  }

  private int readIdOfTest() {
    System.out.println("Enter ID of the test: ");
    return input.nextInt();
  }

  private void printTestTable() throws SQLException {
    List<Test> tests = testController.getAllTests();
    System.out.println("\nTest\n");
    System.out.format("%3s   %50s   %20s   %10s   %10s   %3s", "id", "testName", "deadlineDatetime", "completed", "overdue", "courseInfoId");
    for (Test test : tests) {
      System.out.print("\n" + test);
    }
    System.out.println("\n");
  }

  private void printSingleRecordByIdFromTestTable() throws SQLException {
    int enteredIdOfTest = readIdOfTest();
    System.out.println("\nTest\n");
    System.out.format("%3s   %50s   %20s   %10s   %10s   %3s", "id", "testName", "deadlineDatetime", "completed", "overdue", "courseInfoId");
    System.out.println("\n" + testController.getTest(enteredIdOfTest) + "\n");
  }

  private void createTest() throws SQLException {
    Test test = readTest();
    testController.postTest(test);
  }

  private void updateTest() throws SQLException {
    Test test = readTest();
    int enteredIdOfTest = readIdOfTest();
    test.setId(enteredIdOfTest);
    testController.putTest(test);
  }

  private void deleteTest() throws SQLException {
    Integer enteredIdOfTest = readIdOfTest();
    testController.deleteTest(enteredIdOfTest);
  }

  //==========MODULE=============
  private Module readModule() {
    System.out.println("Enter name of the module :");
    final String enteredModuleName = input.nextLine();

    System.out.println("Enter deadline datetime of the module : ");
    String datetimeString = input.nextLine();
    Timestamp enteredDatetime = Timestamp.valueOf(datetimeString);

    System.out.println("Enter if the module is completed : ");
    final Boolean enteredCompleted = input.nextBoolean();

    System.out.println("Enter if the module is overdue : ");
    final Boolean enteredOverdue = input.nextBoolean();

    System.out.println("Enter course info id of the module : ");
    final Integer enteredCourseInfoId = input.nextInt();

    return new Module(0, enteredModuleName, enteredDatetime, enteredCompleted, enteredOverdue, enteredCourseInfoId);
  }

  private int readIdOfModule() {
    System.out.println("Enter ID of the module: ");
    return input.nextInt();
  }

  private void printModuleTable() throws SQLException {
    List<Module> modules = moduleController.getAllModules();
    System.out.println("\nModule\n");
    System.out.format("%3s   %50s   %20s   %10s   %10s   %3s", "id", "moduleName", "deadlineDatetime", "completed", "overdue", "courseInfoId");
    for (Module module : modules) {
      System.out.print("\n" + module);
    }
    System.out.println("\n");
  }

  private void printSingleRecordByIdFromModuleTable() throws SQLException {
    int enteredIdOfModule = readIdOfModule();
    System.out.println("\nModule\n");
    System.out.format("%3s   %50s   %20s   %10s   %10s   %3s", "id", "moduleName", "deadlineDatetime", "completed", "overdue", "courseInfoId");
    System.out.println("\n" + moduleController.getModule(enteredIdOfModule) + "\n");
  }

  private void createModule() throws SQLException {
    Module module = readModule();
    moduleController.postModule(module);
  }

  private void updateModule() throws SQLException {
    Module module = readModule();
    int enteredIdOfModule = readIdOfModule();
    module.setId(enteredIdOfModule);
    moduleController.putModule(module);
  }

  private void deleteModule() throws SQLException {
    Integer enteredIdOfModule = readIdOfModule();
    moduleController.deleteModule(enteredIdOfModule);
  }

  //==========MESSAGE=============
  private Message readMessage() {
    System.out.println("Enter content of the message :");
    final String enteredMessageContent = input.nextLine();

    System.out.println("Enter count of overdued tests : ");
    final Integer enteredCountOfOverduedTests = input.nextInt();

    System.out.println("Enter count of overdued modules : ");
    final Integer enteredCountOfOverduedModules = input.nextInt();

    System.out.println("Enter course info id of the module : ");
    final Integer enteredCourseInfoId = input.nextInt();

    return new Message(0, enteredMessageContent, enteredCountOfOverduedTests, enteredCountOfOverduedModules, enteredCourseInfoId);
  }

  private int readIdOfMessage() {
    System.out.println("Enter ID of the message: ");
    return input.nextInt();
  }

  private void printMessageTable() throws SQLException {
    List<Message> messages = messageController.getAllMessages();
    System.out.println("\nMessage\n");
    System.out.format("%3s   %70s   %20s   %20s   %10s ", "id", "messageContent", "countOfOverduedTests", "countOfOverduedModules", "courseInfoId");
    for (Message message : messages) {
      System.out.print("\n" + message);
    }
    System.out.println("\n");
  }

  private void printSingleRecordByIdFromMessageTable() throws SQLException {
    int enteredIdOfMessage = readIdOfMessage();
    System.out.println("\nMessage\n");
    System.out.format("%3s   %70s   %20s   %20s   %10s ", "id", "messageContent", "countOfOverduedTests", "countOfOverduedModules", "courseInfoId");
    System.out.println("\n" + messageController.getMessage(enteredIdOfMessage) + "\n");
  }

  private void createMessage() throws SQLException {
    Message message = readMessage();
    messageController.postMessage(message);
  }

  private void updateMessage() throws SQLException {
    Message message = readMessage();
    int enteredIdOfMessage = readIdOfMessage();
    message.setId(enteredIdOfMessage);
    messageController.putMessage(message);
  }

  private void deleteMessage() throws SQLException {
    Integer enteredIdOfMessage = readIdOfMessage();
    messageController.deleteMessage(enteredIdOfMessage);
  }

  //==========TEST HAS ANSWER=============
  private TestHasAnswer readTestHasAnswer() {
    System.out.println("Enter test id of the test has answer :");
    final int enteredTestId = input.nextInt();

    System.out.println("Enter answer id of the test has answer : ");
    final int enteredAnswerId = input.nextInt();

    System.out.println("Enter if the combination is correct : ");
    final Boolean enteredCorrect = input.nextBoolean();

    return new TestHasAnswer(enteredTestId, enteredAnswerId, enteredCorrect);
  }

  private int readIdOfTestHasAnswer() {
    System.out.println("Enter ID of the test/answer: ");
    return input.nextInt();
  }

  private void printTestHasAnswerTable() throws SQLException {
    List<TestHasAnswer> testHasAnswers = testHasAnswerController.getAllTestHasAnswers();
    System.out.println("\nTestHasAnswer\n");
    System.out.format("%10s   %10s   %10s ", "testId", "answerId", "correct");
    for (TestHasAnswer testHasAnswer : testHasAnswers) {
      System.out.print("\n" + testHasAnswer);
    }
    System.out.println("\n");
  }

  private void printSingleRecordByIdFromTestHasAnswerTable() throws SQLException {
    int enteredIdOfTest = readIdOfTestHasAnswer();
    int enteredIdOfAnswer = readIdOfTestHasAnswer();
    System.out.println("\nTestHasAnswer\n");
    System.out.format("%10s   %10s   %10s ", "testId", "answerId", "correct");
    System.out.println("\n" + testHasAnswerController.getTestHasAnswer(enteredIdOfTest, enteredIdOfAnswer) + "\n");
  }

  private void createTestHasAnswer() throws SQLException {
    TestHasAnswer testHasAnswer = readTestHasAnswer();
    testHasAnswerController.postTestHasAnswer(testHasAnswer);
  }

  private void updateTestHasAnswer() throws SQLException {
    TestHasAnswer testHasAnswer = readTestHasAnswer();
    int enteredIdOfTest = readIdOfTestHasAnswer();
    testHasAnswer.setTestId(enteredIdOfTest);
    int enteredIdOfAnswer = readIdOfTestHasAnswer();
    testHasAnswer.setAnswerId(enteredIdOfAnswer);
    testHasAnswerController.putTestHasAnswer(testHasAnswer);
  }

  private void deleteTestHasAnswer() throws SQLException {
    Integer enteredIdOfTest = readIdOfTestHasAnswer();
    Integer enteredIdOfAnswer = readIdOfTestHasAnswer();
    testHasAnswerController.deleteTestHasAnswer(enteredIdOfTest, enteredIdOfAnswer);
  }

}
