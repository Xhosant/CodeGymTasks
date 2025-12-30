package com.codegym.task.task29.task2909.user;

import java.util.concurrent.atomic.AtomicInteger;

public class UserHelper {
    private User userAnna = new User("Anna", "Larsen", 10);
    private User userRoman = new User("Roman", "Crouch", 30);

    public void printUsers() {
        userAnna.printInfo();
        userAnna.printAdditionalInfo();

        userRoman.printInfo();
        userRoman.printAdditionalInfo();
    }

    public int calculateAverageAge() {
        int constAge = 28;
        User userGeorge = new User("George", "Carp", constAge);

        int finalAge = (userAnna.getAge() + userRoman.getAge() + userGeorge.getAge()) / 3;

        return finalAge;
    }

    public int calculateRate(AtomicInteger base, int age, boolean hasJob, boolean hasHouse) {
        int a = base.get();

        a = (a + age / 100);
        a = (int) (a * (hasJob ? 1.1 : 0.9));
        a = (int) (a * (hasHouse ? 1.1 : 0.9));
        return a;
    }

    public String getBossName(User user) {
        return user.getBoss();
    }
}