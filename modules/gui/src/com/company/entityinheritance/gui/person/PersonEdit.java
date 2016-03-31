/*
 * Copyright (c) 2016 Haulmont
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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