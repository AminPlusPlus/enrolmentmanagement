package com.ethermiu.enrolmentmanagement.domain;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Offering {
    @Id
    @GeneratedValue
    private int id;
    private String code;
    @ManyToOne
    @JoinColumn(name = "block_id")
    private Block block;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToMany(mappedBy = "offering")
    List<Section> sectionList = new ArrayList<>();

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

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Section> getSectionList() {
        return sectionList;
    }

    public void setSectionList(List<Section> sectionList) {
        this.sectionList = sectionList;
    }


}
