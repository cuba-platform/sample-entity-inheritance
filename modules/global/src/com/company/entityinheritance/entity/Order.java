/*
 * Copyright (c) 2016 entity-inheritance
 */
package com.company.entityinheritance.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.haulmont.cuba.core.entity.StandardEntity;
import java.math.BigDecimal;

/**
 * @author krivopustov
 */
@Table(name = "DEMO_ORDER")
@Entity(name = "demo$Order")
public class Order extends StandardEntity {
    private static final long serialVersionUID = -8899541467292122902L;

    @Column(name = "NUM", nullable = false, length = 20)
    protected String num;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_", nullable = false)
    protected Date date;

    @Column(name = "AMOUNT")
    protected BigDecimal amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUSTOMER_ID")
    protected Customer customer;

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }


    public void setNum(String num) {
        this.num = num;
    }

    public String getNum() {
        return num;
    }


    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }


}