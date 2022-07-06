package org.gis4fun.otus.spring02.dao;

import org.gis4fun.otus.spring02.domain.Question;

import java.util.List;

/**
 * Access to DAO realization.
 */
public interface QuestDao {
    /**
     * Returns list of questions defined in CSV repository or empty list if repository is empty.
     *
     * @return list of questions
     */
    List<Question> getQuestions();
}
