package org.gis4fun.otus.spring02.service;

import org.gis4fun.otus.spring02.dao.QuestDao;
import org.gis4fun.otus.spring02.domain.Question;

import java.util.List;

/**
 * Realization of quests service.
 */
public class QuestServiceImpl implements QuestService {
    private final QuestDao dao;

    public QuestServiceImpl(QuestDao dao) {
        this.dao = dao;
    }

    public List<Question> getQuestions() {
        return this.dao.getQuestions();
    }
}
