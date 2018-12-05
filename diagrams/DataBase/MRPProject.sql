-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2018-11-18 18:01:37.771

-- tables
-- Table: ActivitiesOfMachines
CREATE TABLE ActivitiesOfMachines (
    activitie_id varchar(5) NOT NULL,
    machine_id varchar(5) NOT NULL,
    CONSTRAINT ActivitiesOfMachines_pk PRIMARY KEY (activitie_id,machine_id)
);

-- Table: MachineOfCompanies
CREATE TABLE MachineOfCompanies (
    company_nit varchar(5) NOT NULL,
    machine_id varchar(5) NOT NULL,
    CONSTRAINT MachineOfCompanies_pk PRIMARY KEY (company_nit,machine_id)
);

-- Table: MaterialsOfActivities
CREATE TABLE MaterialsOfActivities (
    material_id varchar(5) NOT NULL,
    activity_id varchar(5) NOT NULL,
    CONSTRAINT MaterialsOfActivities_pk PRIMARY KEY (material_id,activity_id)
);

-- Table: SuppliersOfMaterial
CREATE TABLE SuppliersOfMaterial (
    material_id varchar(5) NOT NULL,
    supplier_id varchar(5) NOT NULL,
    CONSTRAINT SuppliersOfMaterial_pk PRIMARY KEY (material_id,supplier_id)
);

-- Table: activity
CREATE TABLE activity (
    id varchar(5) NOT NULL,
    name varchar(20) NULL,
    CONSTRAINT activity_pk PRIMARY KEY (id)
);

-- Table: company
CREATE TABLE company (
    nit varchar(5) NOT NULL,
    name varchar(20) NOT NULL,
    CONSTRAINT company_pk PRIMARY KEY (nit)
);

-- Table: inventoryTasks
CREATE TABLE inventoryTasks (
    id varchar(5) NOT NULL,
    initDate int NULL,
    finishDate int NULL,
    description varchar(200) NOT NULL,
    finished bool NULL,
    quantity int NOT NULL,
    material_id varchar(5) NOT NULL,
    supplier_id varchar(5) NOT NULL,
    company_nit varchar(5) NOT NULL,
    materialControls_id varchar(5) NOT NULL,
    CONSTRAINT inventoryTasks_pk PRIMARY KEY (id)
);

-- Table: machine
CREATE TABLE machine (
    id varchar(5) NOT NULL,
    name varchar(20) NOT NULL,
    CONSTRAINT machine_pk PRIMARY KEY (id)
);

-- Table: machineTasks
CREATE TABLE machineTasks (
    id varchar(5) NOT NULL,
    initDate int NULL,
    finishDate int NULL,
    decription varchar(200) NOT NULL,
    finished bool NULL,
    machine_id varchar(5) NOT NULL,
    activity_id varchar(5) NOT NULL,
    company_nit varchar(5) NOT NULL,
    CONSTRAINT machineTasks_pk PRIMARY KEY (id)
);

-- Table: material
CREATE TABLE material (
    id varchar(5) NOT NULL,
    name varchar(20) NULL,
    orderingCost int NULL,
    maintainCost int NULL,
    CONSTRAINT material_pk PRIMARY KEY (id)
);

-- Table: materialControls
CREATE TABLE materialControls (
    id varchar(5) NOT NULL,
    date int NULL,
    quantity int NULL,
    securityStock int NULL,
    sizeOfLot int NULL,
    company_nit varchar(5) NOT NULL,
    CONSTRAINT materialControls_pk PRIMARY KEY (id)
);

-- Table: supplier
CREATE TABLE supplier (
    id varchar(5) NOT NULL,
    bussiness_name varchar(30) NULL,
    country varchar(4) NULL,
    address varchar(50) NULL,
    deliveryTime int NOT NULL,
    phone int NOT NULL,
    CONSTRAINT supplier_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: AvtivitiesOfMachines_Activities (table: ActivitiesOfMachines)
ALTER TABLE ActivitiesOfMachines ADD CONSTRAINT AvtivitiesOfMachines_Activities FOREIGN KEY AvtivitiesOfMachines_Activities (activitie_id)
    REFERENCES activity (id);

-- Reference: AvtivitiesOfMachines_Machines (table: ActivitiesOfMachines)
ALTER TABLE ActivitiesOfMachines ADD CONSTRAINT AvtivitiesOfMachines_Machines FOREIGN KEY AvtivitiesOfMachines_Machines (machine_id)
    REFERENCES machine (id);

-- Reference: MachineOfCompanies_Machines (table: MachineOfCompanies)
ALTER TABLE MachineOfCompanies ADD CONSTRAINT MachineOfCompanies_Machines FOREIGN KEY MachineOfCompanies_Machines (machine_id)
    REFERENCES machine (id);

-- Reference: MachinesOfCompanies (table: MachineOfCompanies)
ALTER TABLE MachineOfCompanies ADD CONSTRAINT MachinesOfCompanies FOREIGN KEY MachinesOfCompanies (company_nit)
    REFERENCES company (nit);

-- Reference: MaterialsOfActivities_Materials (table: MaterialsOfActivities)
ALTER TABLE MaterialsOfActivities ADD CONSTRAINT MaterialsOfActivities_Materials FOREIGN KEY MaterialsOfActivities_Materials (material_id)
    REFERENCES material (id);

-- Reference: MaterialsOfActivities_activity (table: MaterialsOfActivities)
ALTER TABLE MaterialsOfActivities ADD CONSTRAINT MaterialsOfActivities_activity FOREIGN KEY MaterialsOfActivities_activity (activity_id)
    REFERENCES activity (id);

-- Reference: SuppliersOfMaterial_material (table: SuppliersOfMaterial)
ALTER TABLE SuppliersOfMaterial ADD CONSTRAINT SuppliersOfMaterial_material FOREIGN KEY SuppliersOfMaterial_material (material_id)
    REFERENCES material (id);

-- Reference: SuppliersOfMaterial_supplier (table: SuppliersOfMaterial)
ALTER TABLE SuppliersOfMaterial ADD CONSTRAINT SuppliersOfMaterial_supplier FOREIGN KEY SuppliersOfMaterial_supplier (supplier_id)
    REFERENCES supplier (id);

-- Reference: inventoryTasks_company (table: inventoryTasks)
ALTER TABLE inventoryTasks ADD CONSTRAINT inventoryTasks_company FOREIGN KEY inventoryTasks_company (company_nit)
    REFERENCES company (nit);

-- Reference: inventoryTasks_material (table: inventoryTasks)
ALTER TABLE inventoryTasks ADD CONSTRAINT inventoryTasks_material FOREIGN KEY inventoryTasks_material (material_id)
    REFERENCES material (id);

-- Reference: inventoryTasks_materialControls (table: inventoryTasks)
ALTER TABLE inventoryTasks ADD CONSTRAINT inventoryTasks_materialControls FOREIGN KEY inventoryTasks_materialControls (materialControls_id)
    REFERENCES materialControls (id);

-- Reference: inventoryTasks_supplier (table: inventoryTasks)
ALTER TABLE inventoryTasks ADD CONSTRAINT inventoryTasks_supplier FOREIGN KEY inventoryTasks_supplier (supplier_id)
    REFERENCES supplier (id);

-- Reference: machineTasks_activity (table: machineTasks)
ALTER TABLE machineTasks ADD CONSTRAINT machineTasks_activity FOREIGN KEY machineTasks_activity (activity_id)
    REFERENCES activity (id);

-- Reference: machineTasks_company (table: machineTasks)
ALTER TABLE machineTasks ADD CONSTRAINT machineTasks_company FOREIGN KEY machineTasks_company (company_nit)
    REFERENCES company (nit);

-- Reference: machineTasks_machine (table: machineTasks)
ALTER TABLE machineTasks ADD CONSTRAINT machineTasks_machine FOREIGN KEY machineTasks_machine (machine_id)
    REFERENCES machine (id);

-- Reference: materialControls_company (table: materialControls)
ALTER TABLE materialControls ADD CONSTRAINT materialControls_company FOREIGN KEY materialControls_company (company_nit)
    REFERENCES company (nit);

-- End of file.

