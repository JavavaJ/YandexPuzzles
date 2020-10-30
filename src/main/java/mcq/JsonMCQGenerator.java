package mcq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JsonMCQGenerator {

    public static final String FILE_PATH = "src/main/resources/questions_json.txt";

    public void writeAsFile(String json) {
        try {
            Files.write(Paths.get(FILE_PATH), json.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String createJson(List<Question> questions) {
        ObjectMapper mapper = new ObjectMapper();
        String result = null;
        try {
            result = mapper.writeValueAsString(questions);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Question> readAllQuestions() {
        List<Question> allQuestions = new ArrayList<>();

        String currWorkDir = new File("").getAbsolutePath();

//        String path = "/Users/alex/Documents/Development/Main/YandexPuzzles";
//        String pathToAllElemDB = currWorkDir + "/resources/ALL_ELEM.db";

        String pathToAllElemDB = "/Users/alex/Documents/Development/Main/YandexPuzzles/src/main/resources/ALL_ELEM.db";

        String tableName = "all_elem";
        String urlSQLite = "jdbc:sqlite:" + pathToAllElemDB.replace("\\", "/");

        Connection connection;
        Statement stmt = null;
        ResultSet rs;

        try {
            // load driver
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(urlSQLite);


            stmt = connection.createStatement();
            String sqlCommand = "select * from all_elem";
            rs = stmt.executeQuery(sqlCommand);

            long rowNum = 0;
            while (rs.next()) {
                rowNum++;
                Question question = new Question();
                question.setId(rowNum);

                String questionText = rs.getString("question");
                question.setQuestion(questionText);

                String aOption = rs.getString("a");
                question.setA(aOption);

                String bOption = rs.getString("b");
                question.setB(bOption);

                String cOption = rs.getString("c");
                question.setC(cOption);

                String dOption = rs.getString("d");
                question.setD(dOption);

                String right = rs.getString("right");
                question.setRightAn(right);

                String tags = rs.getString("tags");
                question.setTags(tags);

                allQuestions.add(question);

            } // end of while loop

        } catch (Exception e) {
            // Handle errors for class.forName
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return allQuestions;
    }
}
