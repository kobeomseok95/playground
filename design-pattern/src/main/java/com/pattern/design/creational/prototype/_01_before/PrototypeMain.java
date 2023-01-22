package com.pattern.design.creational.prototype._01_before;

public class PrototypeMain {
    public static void main(String[] args) {
        GithubRepository githubRepository = new GithubRepository();
        githubRepository.setUser("whiteship");
        githubRepository.setName("live-study");

        GithubIssue githubIssue = new GithubIssue(githubRepository);
        githubIssue.setId(1);
        githubIssue.setTitle("1주차 과제 : JVM이란?");

        GithubIssue cloneIssue = githubIssue.clone();
        System.out.println("cloneIssue.getUrl() = " + cloneIssue.getUrl());

        System.out.println("githubIssue != cloneIssue = " + (githubIssue != cloneIssue));
        System.out.println("cloneIssue.equals(githubIssue) = " + cloneIssue.equals(githubIssue));
        System.out.println("cloneIssue.getClass() == githubIssue.getClass() = " + (cloneIssue.getClass() == githubIssue.getClass()));
        System.out.println("cloneIssue.getRepository() == githubIssue.getRepository() = " + (cloneIssue.getRepository() == githubIssue.getRepository()));
    }
}
