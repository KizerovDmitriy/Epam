package com.epam.rd.autotasks.sprintplanning;

import com.epam.rd.autotasks.sprintplanning.tickets.Bug;
import com.epam.rd.autotasks.sprintplanning.tickets.Ticket;
import com.epam.rd.autotasks.sprintplanning.tickets.UserStory;

public class Sprint {

    private int capacity;
    private int ticketsLimit;
    private Ticket[] tickets;

    public Sprint(int capacity, int ticketsLimit) {
        this.capacity = capacity;
        this.ticketsLimit = ticketsLimit;
        tickets = new Ticket[ticketsLimit];
    }

    public boolean addUserStory(UserStory userStory) {
        int count = 0;

        if (userStory != null && userStory.getEstimate() <= capacity &&
                !userStory.isCompleted() && (capacity - getTotalEstimate() >= 0)) {

            for (int i = 0; i < userStory.getDependencies().length; i++) {
                if (!userStory.getDependencies()[i].isCompleted()) {
                    count++;
                }
            }
            if (count > 0) {
                return false;
            }

            for (int i = 0; i < tickets.length; i++) {
                if (tickets[i] == null) {
                    tickets[i] = userStory;
                    userStory.complete();
                    return true;
                }
            }
        }
        return false;
    }

    public boolean addBug(Bug bugReport) {
        if (bugReport != null && !bugReport.isCompleted() && bugReport.getEstimate() <= capacity && (capacity - (getTotalEstimate() + bugReport.getEstimate()) >= 0)) {
            for (int i = 0; i < tickets.length; i++) {
                if (tickets[i] == null) {
                    tickets[i] = bugReport;
                    return true;
                }
            }
        }
        return false;
    }

    public Ticket[] getTickets() {
        int count = 0;
        for (Ticket ticket : tickets) {
            if (ticket != null) {
                count++;
            }
        }
        Ticket[] copyArray = new Ticket[count];
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i] != null) {
                copyArray[i] = tickets[i];
            }
        }
        return copyArray;
    }

    public int getTotalEstimate() {
        int sum = 0;
        for (Ticket ticket : tickets) {
            if (ticket != null) {
                sum += ticket.getEstimate();
            }
        }
        return sum;
    }
}