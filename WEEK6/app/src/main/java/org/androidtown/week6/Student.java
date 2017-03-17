package org.androidtown.week6;

/**
 * Created by User on 2017-03-11.
 */

public class Student {
    private String name = null;
    private String number = null;

    public Student(String name, String number) { //alt+insert 키로 constructor로 생성자를 만들어줌
        this.name = name;
        this.number = number;
    }

    public String getName() { //alt+insert 키로 getter로 둘다 선택
        return name;
    }

    public String getNumber() {
        return number;
    }
}
