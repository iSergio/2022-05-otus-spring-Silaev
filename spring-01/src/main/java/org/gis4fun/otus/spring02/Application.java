package org.gis4fun.otus.spring02;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.gis4fun.otus.spring02.domain.Option;
import org.gis4fun.otus.spring02.domain.Question;
import org.gis4fun.otus.spring02.service.QuestService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Simple application for use Quest service.
 *
 * <p>This application only print questions and they answer options</p>
 */
public class Application {
    private static final Logger LOGGER = LogManager.getLogger(Application.class);

    /**
     * Simple application for use Quest service.
     *
     * <p>This application only print questions and they answer options</p>
     */
    public static void main(String... args) {
        LOGGER.debug("Application started");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        QuestService service = context.getBean(QuestService.class);
        List<Question> questions = service.getQuestions();
        questions.stream()
                .peek(q -> System.out.printf("%d) %s:%n", q.getId(), q.getQuestion()))
                .flatMap(q -> q.getOptions().stream())
                .map(Option::toString)
                .forEach(System.out::println);
        LOGGER.debug("Application exited");
    }
}
