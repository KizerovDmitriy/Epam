package com.epam.rd.autotasks;

public class CompleteByRequestTask implements Task {

    private boolean state = false;
    private boolean flag = false;

    @Override
    public void execute() {
        if (isFlag()) {
            setState(true);
        }
    }

    @Override
    public boolean isFinished() {
        return isState();
    }

    public void complete() {
        setFlag(true);
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}