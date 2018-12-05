package com.coding.mrpImplementation.model;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class MachineTask extends Task{
    @ManyToOne
    @JoinColumn(name="machine_id")
    private Machine machine;
    @ManyToOne
    @JoinColumn(name="activity_id")
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
