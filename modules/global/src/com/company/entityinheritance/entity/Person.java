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
@DiscriminatorValue("P")
@Table(name = "DEMO_PERSON")
@Entity(name = "demo$Person")
public class Person extends Customer {
    private static final long serialVersionUID = 3869337951525176523L;

    @Column(name = "FIRST_NAME", length = 100)
    protected String firstName;

    @Column(name = "LAST_NAME", length = 100)
    protected String lastName;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }


}