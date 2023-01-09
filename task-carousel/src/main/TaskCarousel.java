package com.epam.rd.autotasks;

import java.util.LinkedList;
import java.util.List;

public class TaskCarousel {
    private final int capacity;
    private final List<Task> taskList;
    private int count = -1;

    public TaskCarousel(int capacity) {
        this.capacity = capacity;
        taskList = new LinkedList<>();
    }

    public boolean addTask(Task task) {
        int value = 1;
        if (task instanceof CountDownTask) {
            value = ((CountDownTask) task).getValue();
        }
        if (!task.isFinished() && !isFull() && value != 0) {
            return taskList.add(task);
        }
        return false;
    }

    public boolean execute() {
        if (!isEmpty()) {
            count++;
            if (count == taskList.size()) {
                count = 0;
            }
            Task task = taskList.get(count);
            task.execute();
            if (task.isFinished()) {
                taskList.remove(task);
                count--;
            }
            return true;
        }
        return false;
    }

    public boolean isFull() {
        return taskList.size() == capacity;
    }

    public boolean isEmpty() {
        return taskList.isEmpty();
    }
}