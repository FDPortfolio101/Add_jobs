package com.availablejobs.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Jobs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;

    @NotNull
    @Size(min=4)
    private String position;

    @NotNull
    @Size(min=3)
    private String company;

    @NotNull
    @Size(min=10)
    private String requirements;

    @NotNull
    @Size(min=10)
    private String skills;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }


    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }



}
