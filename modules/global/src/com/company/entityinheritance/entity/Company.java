/*
 * Copyright (c) 2016 entity-inheritance
 */
package com.company.entityinheritance.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.DiscriminatorValue;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Column;

/**
 * @author krivopustov
 */
@PrimaryKeyJoinColumn(name = "ID", referencedColumnName = "ID")
@DiscriminatorValue("M")
@Table(name = "DEMO_COMPANY")
@Entity(name = "demo$Company")
public class Company extends Customer {
    private static final long serialVersionUID = 3876368460154315569L;

    @Column(name = "INDUSTRY")
    protected String industry;

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getIndustry() {
        return industry;
    }



}