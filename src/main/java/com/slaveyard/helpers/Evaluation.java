package com.slaveyard.helpers;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Evaluation extends HashMap<String, List<Integer>> {


    public List<Integer> put(String name, int num) {

        if (this.containsKey(name)) {
            this.get(name).add(num);
            return this.get(name);
        }

        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(num);

        return super.put(name, nums);

    }


    public String calculateGrade(String name) {

        List<Integer> grades = this.get(name);

        float size = 0;
        float sum = 0;

        for (Integer g : grades) {

            if (g > 0) {
                sum += g;
                size++;
            }
        }

        if (size == 0) return "";

        return String.format("%.2f", sum / size);
    }


    public String calculatePresence(String name) {
        List<Integer> grades = this.get(name);
        float all = grades.size();
        float absence = 0;
        for (Integer g : grades) {
            if (g == 0) {
                absence++;
            }
        }
        if (all == 0 || (all - absence) == 0) return "0,00";
        return String.format("%.2f", (all - absence) / all * 100);
    }

    public String getHighestGrade(String name) {
        List<Integer> grades = this.get(name);
        int max = 0;
        for (Integer g : grades) {
            if (max < g) max = g;
        }
        if (max == 0) return "";
        return String.format("%d", max);
    }

    public String getLowestGrade(String name) {
        List<Integer> grades = this.get(name);
        int min = 13;
        for (Integer g : grades) {
            if (min > g && g != 0) min = g;
        }
        if (min == 13) return "";
        return String.format("%d", min);
    }

    public String getNumOfLessons(String name) {
        return String.format("%d", this.get(name).size());
    }

    public String getAbsence(String name) {
        List<Integer> grades = this.get(name);
        int absence = 0;
        for (Integer g : grades) {
            if (g == 0) {
                absence++;
            }
        }
        return String.format("%d", absence);

    }


}
