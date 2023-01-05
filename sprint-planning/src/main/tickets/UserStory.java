package com.epam.rd.autotasks.sprintplanning.tickets;


public class UserStory extends Ticket {

    private UserStory[] depends;

    public UserStory(int id, String name, int estimate, UserStory... dependsOn) {
        super(id, name, estimate);
        if (dependsOn != null) {
            depends = dependsOn.clone();
        } else {
            setState(true);
        }
    }

    @Override
    public void complete() {
        int count = 0;
        if (depends != null) {
            for (UserStory userStory : depends) {
                if (userStory.isCompleted()) {
                    count++;
                }
            }
        }
        if (depends != null) {
            setState(count == depends.length);
        }
    }

    public UserStory[] getDependencies() {
        UserStory[] copy;
        if (depends != null) {
            copy = depends.clone();
            return copy;
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        return "[US " + getId() + "] " + getName();
    }
}
