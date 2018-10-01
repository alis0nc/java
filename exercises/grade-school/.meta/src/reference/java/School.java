import java.util.*;

class School {

  private final Map<Integer, List<String>> database = new HashMap<>();

  int numberOfStudents() {
    int result = 0;
    for (List<String> studentsInGrade : database.values()) {
      result += studentsInGrade.size();
    }
    return result;
  }

  void add(String student, int grade) {
    List<String> students = fetchGradeFromDatabase(grade);
    students.add(student);
  }

  List<String> roster() {
    List<String> result = new ArrayList<String>();
    for (List<String> studentsInGrade : studentsByGradeAlphabetical().values()) {
      result.addAll(studentsInGrade);
    }
    return result;
  }

  List<String> grade(int grade) {
    return new ArrayList<>(fetchGradeFromDatabase(grade));
  }

  List<String> fetchGradeFromDatabase(int grade) {
    if (!database.containsKey(grade)) {
      database.put(grade, new LinkedList<>());
    }
    Collections.sort(database.get(grade));
    return database.get(grade);
  }

  Map<Integer, List<String>> studentsByGradeAlphabetical() {
    Map<Integer, List<String>> sortedStudents = new HashMap<>();
    for (Integer grade : database.keySet()) {
      List<String> studentsInGrade = fetchGradeFromDatabase(grade);
      sortedStudents.put(grade, studentsInGrade);
    }
    return sortedStudents;
  }
}
