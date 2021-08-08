package com.example.events;

import java.io.Serializable;

public class Model implements Serializable {
    private String Title;
    private String Description;
    private String StartDate;
    private String EndDate;
    private String StartTime;
    private String EndTime;
    private String Price;

    public Model(String title, String description, String startDate, String endDate,
                 String startTime, String endTime, String price) {
        Title = title;
        Description = description;
        StartDate = startDate;
        EndDate = endDate;
        StartTime = startTime;
        EndTime = endTime;
        Price = price;
    }

    public String getTitle() {
        return Title;
    }

    public String getDescription() {
        return Description;
    }

    public String getStartDate() {
        return StartDate;
    }

    public String getEndDate() {
        return EndDate;
    }

    public String getStartTime() {
        return StartTime;
    }

    public String getEndTime() {
        return EndTime;
    }

    public String getPrice() {
        return Price;
    }
}
