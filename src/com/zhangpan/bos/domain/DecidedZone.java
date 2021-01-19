package com.zhangpan.bos.domain;
// default package

import java.util.HashSet;
import java.util.Set;


/**
 * DecidedZone entity. @author MyEclipse Persistence Tools
 */

public class DecidedZone  implements java.io.Serializable {


    // Fields    

     private String id;
     private Staff staff;
     private String name;
     private Set subareas = new HashSet(0);


    // Constructors

    /** default constructor */
    public DecidedZone() {
    }

	/** minimal constructor */
    public DecidedZone(String id) {
        this.id = id;
    }
    
    /** full constructor */
    public DecidedZone(String id, Staff staff, String name, Set subareas) {
        this.id = id;
        this.staff = staff;
        this.name = name;
        this.subareas = subareas;
    }

   
    // Property accessors

    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public Staff getStaff() {
        return this.staff;
    }
    
    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public Set getSubareas() {
        return this.subareas;
    }
    
    public void setSubareas(Set subareas) {
        this.subareas = subareas;
    }

    @Override
    public String toString() {
        return "DecidedZone{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}