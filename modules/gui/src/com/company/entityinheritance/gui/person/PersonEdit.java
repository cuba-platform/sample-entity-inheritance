/*
 * Copyright (c) 2016 entity-inheritance
 */
package com.company.entityinheritance.gui.person;

import com.haulmont.cuba.gui.components.AbstractEditor;
import com.company.entityinheritance.entity.Person;
import com.haulmont.cuba.gui.data.Datasource;

import javax.inject.Inject;
import java.util.Map;

/**
 * @author krivopustov
 */
public class PersonEdit extends AbstractEditor<Person> {

    @Inject
    private Datasource<Person> personDs;

    @Override
    public void init(Map<String, Object> params) {
        personDs.addItemPropertyChangeListener(e -> {
            Person person = e.getItem();
            person.setName(person.getFirstName() + " " + person.getLastName());
        });
    }
}