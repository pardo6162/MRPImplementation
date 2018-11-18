package com.coding.mrpImplementation.model;

import javax.persistence.*;

@Entity
@Table
public abstract class Task {
    @Id
    private String id;
    private int initDate;
    private int finishDate;
    private String description;
    private boolean finished;
    @ManyToOne
    @JoinColumn(name="company_nit")
    private Company company;

    public Task(){}

    public Task(String id, int initDate, int finishDate, String description, boolean finished) {
        this.id = id;
        this.initDate = initDate;
        this.finishDate = finishDate;
        this.description = description;
        this.finished = finished;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getInitDate() {
        return initDate;
    }

    public void setInitDate(int initDate) {
        this.initDate = initDate;
    }

    public int getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(int finishDate) {
        this.finishDate = finishDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
