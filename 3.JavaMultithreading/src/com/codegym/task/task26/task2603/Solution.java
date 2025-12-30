package com.codegym.task.task26.task2603;

/* 
A convert can easily convert others

*/

import java.util.Comparator;

public class Solution {

    public static void main(String[] args) {

    }

    public static class CustomizedComparator<T> implements Comparator<T> {

        private Comparator<T>[] comparators;

        public CustomizedComparator(Comparator<T>... comparators) {
            this.comparators = comparators;
        }

        @Override
        public int compare(T o1, T o2) {
            for (Comparator<T> comp: comparators
                 ) {
                int result = comp.compare(o1, o2);
                if (result!=0) return result;
            }
            return 0;
        }
    }
}
