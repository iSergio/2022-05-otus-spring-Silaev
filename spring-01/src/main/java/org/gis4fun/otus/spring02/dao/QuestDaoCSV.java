package org.gis4fun.otus.spring02.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.gis4fun.otus.spring02.domain.Question;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

/**
 * CSV repository realization for basic DAO.
 */
public class QuestDaoCSV implements QuestDao {
    private static final Logger LOGGER = LogManager.getLogger(QuestDaoCSV.class);

    private final List<Question> questions;

    /**
     * Construct repository from CSV file. File defines static into spring context by constructor-arg.
     *
     * @param path path to CSV file
     * @throws IOException if no CSV file defined
     */
    public QuestDaoCSV(String path) throws IOException {
        LOGGER.debug("Construct of DAO of CSV by path " + path);
        try (var is = new ClassPathResource(path).getInputStream()) {
            this.questions = new BufferedReader(new InputStreamReader(is))
                    .lines()
                    .parallel()
                    .map(Question::create)
                    .collect(Collectors.toList());
        }
    }

    @Override
    public List<Question> getQuestions() {
        return questions;
    }
}
