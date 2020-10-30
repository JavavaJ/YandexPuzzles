package mcq;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class JsonMCQGeneratorTest {

    @Test
    void readAllQuestions() {
        JsonMCQGenerator generator = new JsonMCQGenerator();
        List<Question> questions = generator.readAllQuestions();
        assertThat(questions).isNotEmpty();
        assertThat(questions.size()).isGreaterThan(100);
    }

    @Test
    public void testCreateJson() {
        JsonMCQGenerator generator = new JsonMCQGenerator();
        List<Question> questions = generator.readAllQuestions();
        String json = generator.createJson(questions);
        System.out.println("Json size: " + json.length());
        System.out.println(json);
        assertThat(json).isNotNull();
        assertThat(json.length()).isGreaterThan(50);
        assertThat(json.contains("\"id\"")).isFalse();
    }

    @Test
    public void testWriteJson() {
        JsonMCQGenerator generator = new JsonMCQGenerator();
        List<Question> questions = generator.readAllQuestions();
        String json = generator.createJson(questions);

        generator.writeAsFile(json);

        File file = new File(JsonMCQGenerator.FILE_PATH);

        assertThat(file.exists()).isTrue();
    }

}