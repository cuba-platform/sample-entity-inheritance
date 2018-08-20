package com.company.entityinheritance.gui.customer;

import com.company.entityinheritance.entity.Company;
import com.company.entityinheritance.entity.Customer;
import com.haulmont.cuba.gui.WindowManager;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.components.actions.CreateAction;
import com.haulmont.cuba.gui.components.actions.EditAction;
import com.haulmont.cuba.gui.data.GroupDatasource;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Map;
import java.util.UUID;

public class CustomerBrowse extends AbstractLookup {

    @Inject
    private GroupTable<Customer> customersTable;

    @Inject
    private PopupButton createBtn;

    @Named("customersTable.edit")
    private EditAction customersTableEdit;

    @Inject
    private GroupDatasource<Customer, UUID> customersDs;

    @Override
    public void init(Map<String, Object> params) {
        CreateAction createCompanyAction = new CreateAction(customersTable, WindowManager.OpenType.THIS_TAB, "createCompany");
        createCompanyAction.setCaption("Create company");
        createCompanyAction.setShortcut(null);
        createCompanyAction.setWindowId("demo$Company.edit");
        createBtn.addAction(createCompanyAction);
        customersTable.addAction(createCompanyAction, 0);

        CreateAction createPersonAction = new CreateAction(customersTable, WindowManager.OpenType.THIS_TAB, "createPerson");
        createPersonAction.setCaption("Create person");
        createPersonAction.setShortcut(null);
        createPersonAction.setWindowId("demo$Person.edit");
        createBtn.addAction(createPersonAction);
        customersTable.addAction(createPersonAction, 1);

        customersDs.addItemChangeListener(e -> {
            Customer customer = e.getItem();
            customersTableEdit.setWindowId(customer instanceof Company ? "demo$Company.edit" : "demo$Person.edit");
        });
    }

    public Component generateTypeCell(Customer entity) {
		return new Table.PlainTextCell(entity instanceof Company ? "Company" : "Person");
    }
}