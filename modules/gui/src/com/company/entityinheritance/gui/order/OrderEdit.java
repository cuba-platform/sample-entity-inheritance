/*
 * Copyright (c) 2016 entity-inheritance
 */
package com.company.entityinheritance.gui.order;

import com.company.entityinheritance.entity.Company;
import com.company.entityinheritance.entity.Order;
import com.company.entityinheritance.entity.Person;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.LookupPickerField;
import com.haulmont.cuba.gui.components.OptionsGroup;
import com.haulmont.cuba.gui.components.PickerField.LookupAction;
import com.haulmont.cuba.gui.data.CollectionDatasource;

import javax.inject.Inject;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author krivopustov
 */
public class OrderEdit extends AbstractEditor<Order> {

    @Inject
    private OptionsGroup customerTypeField;
    @Inject
    private LookupPickerField customerField;
    @Inject
    private CollectionDatasource<Company, UUID> companiesDs;
    @Inject
    private CollectionDatasource<Person, UUID> peopleDs;

    @Override
    protected void postInit() {
        // Currently edited entity
        Order order = getItem();

        // Options for the OptionsGroup selecting a Customer type
        Map<String, Object> customerTypes = new LinkedHashMap<>();
        customerTypes.put("Company", Company.class);
        customerTypes.put("Person", Person.class);
        customerTypeField.setOptionsMap(customerTypes);

        // If a Customer is not selected yet, switch to Comppany type. Otherwise use the concrete Customer type.
        Class customerType = order.getCustomer() != null ? order.getCustomer().getClass() : Company.class;
        customerTypeField.setValue(customerType);
        initCustomerField(customerType);

        // Add a listener to re-initialize the Customer lookup field when a user changes the Customer type
        customerTypeField.addValueChangeListener(e -> {
            // Reset the value when the type changes
            customerField.setValue(null);
            initCustomerField((Class) e.getValue());
        });
    }

    private void initCustomerField(Class customerType) {
        CollectionDatasource optionsDs;
        String lookupScreenId;
        if (customerType == Company.class) {
            optionsDs = companiesDs;
            lookupScreenId = "demo$Company.browse";
        } else {
            optionsDs = peopleDs;
            lookupScreenId = "demo$Person.browse";
        }
        // Set an options datasource for the drop-down list
        customerField.setOptionsDatasource(optionsDs);
        // Set a lookup screen id
        Action action = customerField.getActionNN(LookupAction.NAME);
        ((LookupAction) action).setLookupScreen(lookupScreenId);
    }
}