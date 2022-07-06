package org.gis4fun.otus.spring02;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.gis4fun.otus.spring02.domain.Option;
import org.gis4fun.otus.spring02.domain.Question;
import org.gis4fun.otus.spring02.service.QuestService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class QuestTest {
    private final static Logger LOGGER = LogManager.getLogger(QuestTest.class);

    @Test
    public void questTest() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        QuestService service = context.getBean(QuestService.class);
        List<Question> questions = service.getQuestions();
        Assertions.assertNotNull(questions);
        Assertions.assertEquals(5, questions.size());

        Question question = questions.get(3);
        Assertions.assertEquals(4, question.getOptions().size());

        Option option = question.getOptions().get(2);
        Assertions.assertNotNull(option);
        Assertions.assertEquals("WMTS", option.getName());
    }
}
