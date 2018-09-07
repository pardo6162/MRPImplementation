-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2018-09-07 12:02:13.801

-- tables
-- Table: Activities
CREATE TABLE Activities (
    id varchar(5) NOT NULL,
    name varchar  NULL,
    CONSTRAINT Activities_pk PRIMARY KEY (id)
);

-- Table: AvtivitiesOfMachines
CREATE TABLE AvtivitiesOfMachines (
    Activities_id varchar(5) NOT NULL,
    Machines_id varchar(5) NOT NULL,
    CONSTRAINT AvtivitiesOfMachines_pk PRIMARY KEY (Activities_id,Machines_id)
);

-- Table: CalendarOfActivity
CREATE TABLE CalendarOfActivity (
    timelndex int NOT NULL,
    Activities_id varchar(5) NOT NULL,
    CONSTRAINT CalendarOfActivity_pk PRIMARY KEY (timelndex,Activities_id)
);

-- Table: MRPPlanning
CREATE TABLE MRPPlanning (
    Materials_id varchar(5) NOT NULL,
    type varchar(5) NOT NULL,
    timelndex int NOT NULL,
    planningReception int NOT NULL,
    Materials_id_Material varchar(5) NOT NULL,
    CONSTRAINT MRPPlanning_pk PRIMARY KEY (Materials_id,type)
);

-- Table: Machines
CREATE TABLE Machines (
    id varchar(5) NOT NULL,
    name  varchar NULL,
    CONSTRAINT Machines_pk PRIMARY KEY (id)
);

-- Table: Materials
CREATE TABLE Materials (
    id_Material varchar(5) NOT NULL,
    name varchar(30) NOT NULL,
    initialInventoryOnHand int NOT NULL,
    orderingCost int NOT NULL,
    maintainCost int NOT NULL,
    sizeOfLot int NOT NULL,
    Suppliers_id varchar(5) NOT NULL,
    CONSTRAINT Materials_pk PRIMARY KEY (id_Material)
);

-- Table: MaterialsOfActivities
CREATE TABLE MaterialsOfActivities (
    Activities_id varchar(5) NOT NULL,
    Materials_id varchar(5) NOT NULL,
    CONSTRAINT MaterialsOfActivities_pk PRIMARY KEY (Activities_id,Materials_id)
);

-- Table: ProgramedReceptions
CREATE TABLE ProgramedReceptions (
    timelnd int NOT NULL,
    quantity int NOT NULL,
    Materials_id varchar(5) NOT NULL,
    CONSTRAINT ProgramedReceptions_pk PRIMARY KEY (timelnd,quantity,Materials_id)
);

-- Table: Suppliers
CREATE TABLE Suppliers (
    id_Supplier varchar(5) NOT NULL,
    bussiness_name varchar(30) NULL,
    country varchar(4) NULL,
    address varchar(30) NULL,
    deliveryTime int NOT NULL,
    phone int NOT NULL,
    CONSTRAINT Suppliers_pk PRIMARY KEY (id_Supplier)
);

-- foreign keys
-- Reference: AvtivitiesOfMachines_Activities (table: AvtivitiesOfMachines)
ALTER TABLE AvtivitiesOfMachines ADD CONSTRAINT AvtivitiesOfMachines_Activities FOREIGN KEY AvtivitiesOfMachines_Activities (Activities_id)
    REFERENCES Activities (id);

-- Reference: AvtivitiesOfMachines_Machines (table: AvtivitiesOfMachines)
ALTER TABLE AvtivitiesOfMachines ADD CONSTRAINT AvtivitiesOfMachines_Machines FOREIGN KEY AvtivitiesOfMachines_Machines (Machines_id)
    REFERENCES Machines (id);

-- Reference: CalendarOfActivity_Activities (table: CalendarOfActivity)
ALTER TABLE CalendarOfActivity ADD CONSTRAINT CalendarOfActivity_Activities FOREIGN KEY CalendarOfActivity_Activities (Activities_id)
    REFERENCES Activities (id);

-- Reference: MRPPlanning_Materials (table: MRPPlanning)
ALTER TABLE MRPPlanning ADD CONSTRAINT MRPPlanning_Materials FOREIGN KEY MRPPlanning_Materials (Materials_id_Material)
    REFERENCES Materials (id_Material);

-- Reference: MaterialsOfActivities_Activities (table: MaterialsOfActivities)
ALTER TABLE MaterialsOfActivities ADD CONSTRAINT MaterialsOfActivities_Activities FOREIGN KEY MaterialsOfActivities_Activities (Activities_id)
    REFERENCES Activities (id);

-- Reference: MaterialsOfActivities_Materials (table: MaterialsOfActivities)
ALTER TABLE MaterialsOfActivities ADD CONSTRAINT MaterialsOfActivities_Materials FOREIGN KEY MaterialsOfActivities_Materials (Materials_id)
    REFERENCES Materials (id_Material);

-- Reference: Materials_Suppliers (table: Materials)
ALTER TABLE Materials ADD CONSTRAINT Materials_Suppliers FOREIGN KEY Materials_Suppliers (Suppliers_id)
    REFERENCES Suppliers (id_Supplier);

-- Reference: ProgramedReceptions_Materials (table: ProgramedReceptions)
ALTER TABLE ProgramedReceptions ADD CONSTRAINT ProgramedReceptions_Materials FOREIGN KEY ProgramedReceptions_Materials (Materials_id)
    REFERENCES Materials (id_Material);

-- End of file.

