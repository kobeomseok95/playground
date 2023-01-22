package com.pattern.design.creational.prototype._01_before;

import java.util.Objects;

public class GithubIssue implements Cloneable {
    private int id;
    private String title;
    private GithubRepository repository;

    public GithubIssue(GithubRepository repository) {
        this.repository = repository;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public GithubRepository getRepository() {
        return repository;
    }

    public String getUrl() {
        return "https://github.com/" + repository.getUser() + "/" + repository.getName() + "/issues/" + getId();
    }

    @Override
    public GithubIssue clone() {
        try {
            return (GithubIssue) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GithubIssue that = (GithubIssue) o;
        return id == that.id && title.equals(that.title) && repository.equals(that.repository);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, repository);
    }
}
