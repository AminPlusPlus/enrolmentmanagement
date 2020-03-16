package com.ethermiu.enrolmentmanagement.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Entity
public class Block {
    @Id
    @GeneratedValue
    private int id;
    private String code;
    private String name;
    private String semester;
    private int blockSequenceNumber;
    private Date startDate;
    private Date endDate;

    @OneToMany(mappedBy = "block")
    List<Offering> offeringList;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public int getBlockSequenceNumber() {
        return blockSequenceNumber;
    }

    public void setBlockSequenceNumber(int blockSequenceNumber) {
        this.blockSequenceNumber = blockSequenceNumber;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<Offering> getOfferingList() {
        return offeringList;
    }

    public void setOfferingList(List<Offering> offeringList) {
        this.offeringList = offeringList;
    }
}
