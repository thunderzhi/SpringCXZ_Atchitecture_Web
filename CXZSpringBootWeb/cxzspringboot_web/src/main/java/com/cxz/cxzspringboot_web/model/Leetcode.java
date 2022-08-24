package com.cxz.cxzspringboot_web.model;

/**
 * Auto-generated: 2022-08-23 14:51:20
 *
 * @author
 * @website
 */
public class Leetcode {

    private int id;
    private String frontend_question_id;
    private int question_id;
    private String title;
    private String content;
    private int level;
    private String slug_title;
    private boolean expand;
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setFrontend_question_id(String frontend_question_id) {
        this.frontend_question_id = frontend_question_id;
    }
    public String getFrontend_question_id() {
        return frontend_question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }
    public int getQuestion_id() {
        return question_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public String getContent() {
        return content;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    public int getLevel() {
        return level;
    }

    public void setSlug_title(String slug_title) {
        this.slug_title = slug_title;
    }
    public String getSlug_title() {
        return slug_title;
    }

    public void setExpand(boolean expand) {
        this.expand = expand;
    }
    public boolean getExpand() {
        return expand;
    }

}