package org.gis4fun.otus.spring02.service;

import org.gis4fun.otus.spring02.domain.Question;

import java.util.List;

/**
 * Service of Quests.
 */
public interface QuestService {
    List<Question> getQuestions();
}
