package com.epam.rd.autotasks;

public class CountDownTask implements Task {

    private int value;
    private boolean execute = false;

    public CountDownTask(int value) {
        this.value = checkValueConstructor(value);
    }

    public int getValue() {
        return value;
    }

    @Override
    public void execute() {
        if (!isFinished()) {
            setValue(getValue() - 1);
            if (getValue() == 0) {
                setExecute(true);
            }
        }
    }

    @Override
    public boolean isFinished() {
        return isExecute();
    }

    private int checkValueConstructor(int value) {
        if (value <= 0) {
            setExecute(true);
            return 0;
        } else return value;
    }

    public void setExecute(boolean execute) {
        this.execute = execute;
    }

    public boolean isExecute() {
        return execute;
    }

    public void setValue(int value) {
        this.value = value;
    }
}