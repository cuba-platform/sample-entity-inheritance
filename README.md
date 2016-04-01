# Entity Inheritance

This project demonstrates how to use entity inheritance in [CUBA](https://www.cuba-platform.com) applications.

## Objective

Let's assume that we have two types of customers - companies and individuals, which have some common attributes. We would like to store the common attributes in one table, and use separate linked tables to store specific attributes.

So the data model contains the `Customer` entity, which is a base class stored in the `DEMO_CUSTOMER` table. The `Company` and `Person` entities stored in separate tables with foreign keys that reference the base table.

The `Order` entity has a reference to `Customer`. As the customer can be of the different types, when users create orders, they should be able to choose the type of the customer.

## Implementation Details

In the `Customer` entity:
* Inheritance strategy is set to `JOINED`
* Discriminator column name `DTYPE` and type `String` are left default
* Discriminator value is set to `C`

In the `Company` entity:
* Parent class is set to `Customer`
* Discriminator value is set to `M`

In the `Person` entity:
* Parent class is set to `Customer`
* Discriminator value is set to `P`

The `order-edit.xml` screen descriptor and the corresponding `OrderEdit` controller contain the customer selection components and logic.

## How to Run

To see the example in action, do the following:

* Open the project in Studio
* Click *Run > Start application server*
* If you see the warning *Database does not exist ...*, click *Create DB in background*
* Go to `http://localhost:8080/app` and log in as `admin` / `admin`
* Open *Application > Orders* and create a new order.

Based on CUBA Platform 6.1.1
