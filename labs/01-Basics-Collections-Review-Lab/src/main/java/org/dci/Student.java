package org.dci;

public class Student {

    private String name;
    private Character score;

    public Student(String name, Character score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Character getScore() {
        return score;
    }

    public void setScore(Character score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
