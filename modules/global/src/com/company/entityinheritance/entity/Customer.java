/*
 * Copyright (c) 2016 entity-inheritance
 */
package com.company.entityinheritance.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.DiscriminatorValue;
import javax.persistence.InheritanceType;
import javax.persistence.DiscriminatorType;
import javax.persistence.Inheritance;
import javax.persistence.DiscriminatorColumn;
import com.haulmont.cuba.core.entity.StandardEntity;
import javax.persistence.Column;
import com.haulmont.chile.core.annotations.NamePattern;

/**
 * @author krivopustov
 */
@NamePattern("%s|name")
@DiscriminatorColumn(name = "DTYPE", discriminatorType = DiscriminatorType.STRING)
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue("C")
@Table(name = "DEMO_CUSTOMER")
@Entity(name = "demo$Customer")
public class Customer extends StandardEntity {
    private static final long serialVersionUID = -6095911468923591928L;

    @Column(name = "NAME", nullable = false)
    protected String name;

    @Column(name = "EMAIL", length = 100)
    protected String email;

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}