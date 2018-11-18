package com.coding.mrpImplementation.model;

public class MachineTask extends Task{

    private Machine machine;
    private Activity activity;

    public MachineTask(){super();}

    public MachineTask(String id, int initDate, int finishDate, String description, boolean finished, Machine machine, Activity activity) {
        super(id, initDate, finishDate, description, finished);
        this.machine = machine;
        this.activity = activity;
    }

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }
}
