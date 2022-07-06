package org.gis4fun.otus.spring02.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Question model.
 */
public class Question {
    private final int id;
    private final String question;

    private final List<Option> options = new ArrayList<>();

    public Question(int id, String question) {
        this.id = id;
        this.question = question;
    }

    public int getId() {
        return id;
    }

    public List<Option> getOptions() {
        return options;
    }

    /**
     * 0 -> its id of question
     * 1 -> name (value)
     * 2....x -> variant of choices
     * length - 1 -> comma separated correct answers
     *
     * @param csvStr string separated by `;`
     * @return Question object
     */
    public static Question create(String csvStr) {
        List<String> cols = Arrays.stream(csvStr.split(";")).collect(Collectors.toList());
        if (cols.size() != 7) {
            throw new IllegalArgumentException("String from CSV mast have 7 columns of data");
        }
        int id = Integer.parseInt(cols.get(0));

        Question qst = new Question(id, cols.get(1));
        qst.getOptions().addAll(IntStream.range(2, cols.size() - 1)
                .mapToObj(i -> new Option(i - 1, cols.get(i)))
                .collect(Collectors.toList()));

        return qst;
    }

    public String getQuestion() {
        return question;
    }
}
