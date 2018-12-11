var axios_module=(function(){
    var host="http://localhost:8080/"
    var addCompany=function(name,nit){
        axios.post(host+'mrp/company',{"nit":nit,"name":name,"machines":[]})
            .then(function(resp){
                alert("Company created");
                
            })
            .catch(function(err){
                console.log(err);
            })
    };
    var getCompany=function(nit){
        axios.get(host+'mrp/company/'+nit)
            .then(function(resp){
                
            })
            .catch(function(err){
                console.log(err);
            })
    };
    var getCompanies=function(callback){
        axios.get(host+'mrp/company')
            .then(function(resp){
                callback(resp);
            })
            .catch(function(err){
                console.log(err);
            })
    };
    var addMachine=function(id,name,company){
        console.log(id);
        console.log(name);
        axios.post(host+'mrp/company/'+company.nit+'/machine',{"id":id,"name":name,"company":{},"activities":[]})
        .then(function(resp){
            alert("Machine created")
        })
        .catch(function(err){
            console.log(err);
        })
    };
    var getMachinesOfCompany=function(callback,company){
        axios.get(host+'mrp/company/'+company.nit+'/machine')
        .then(function(resp){
            callback(resp);
        })
        .catch(function(err){
            console.log(err);
        })
    };
    var deleteMachine=function(company,machine){
        axios.delete(host+'mrp/company/'+company.nit+'/machine/'+machine.id)
        .then(function(resp){
            alert("Machine deleted");
        })
        .catch(function(err){
            console.log(err);
        })
    };
    var addActivity=function(activity,machine){
        var activity={"id":activity.id,"name":activity.name,"machine":machine,"materials":[]}
        console.log(activity);
        axios.post(host+'mrp/company/'+machine.company.nit+'/machine/'+machine.id+'/activity',{"id":activity.id,"name":activity.name,"machine":machine,"materials":[]})
        .then(function(resp){
            alert("Activity created");
        })
        .catch(function(err){
            console.log(err);
        })
    };
    var getActivitiesOfMachine=function(callback,machine){
        axios.get(host+'mrp/company/'+machine.company.nit+'/machine/'+machine.id+'/activity')
        .then(function(resp){
            callback(resp);
        })
        .catch(function(err){
            console.log(err);
        })
    };
    var deleteActivity=function(machine,activity){

        axios.delete(host+'mrp/company/'+machine.company.nit+'/machine/'+machine.id+'/activity/'+activity.id)
        .then(function(resp){
            alert("Activity deleted")
        })
        .catch(function(err){
            console.log(err);
        })
    };

    var addMaterialToActivity=function(activity,material){
        var material={"id":material.id,"name":material.name,"orderingCost":material.orderingCost,"maintainCost":material.maintainCost,"activities":[],"suppliers":[]};
        axios.put(host+'mrp/company/'+activity.machine.company.nit+'/machine/'+activity.machine.id+'/activity/'+activity.id+'/material/'+material.id)
        .then(function(resp){
            alert("Material added to activity")
        })
        .catch(function(err){
            console.log(err);
        })
    };

    var getMaterialsOfActivity=function(callback,activity){
        axios.get(host+'mrp/company/'+activity.machine.company.nit+'/machine/'+activity.machine.id+'/activity/'+activity.id+'/material')
        .then(function(resp){
            callback(resp);
        })
        .catch(function(err){
            console.log(err);
        })

    };

    var deleteMaterial=function(activity,id){
        axios.delete(host+'mrp/company/'+activity.machine.company.nit+'/machine/'+activity.machine.id+'/activity/'+activity.id+'/material/'+id)
        .then(function(resp){
            alert("Material deleted")
        })
        .catch(function(err){
            console.log(err);
        })
    };

    var addMaterial=function(supplier,id,name,ordering_cost,maintain_cost){
        material={"id":id,"name":name,"name":name,"orderingCost":ordering_cost,"maintainCost":maintain_cost,"activities":[],"suppliers":[]}
        axios.post(host+"mrp/supplier/"+supplier.id+"/material",material)
        .then(function(resp){
            alert("Material added");
        })
        .catch(function(err){
            console.log(err);
        })
    };

    var addSupplier=function(id,name,country,address,delivery_time,phone){
        var supplier={"id":id,"businessName":name,"country":country,"address":address,"deliveryTime":delivery_time,"phone":phone,"materials":[]};
        console.log(supplier);
        axios.post(host+"/mrp/supplier",supplier)
        .then(function(resp){
            alert("Supplier added");
        })
        .catch(function(err){
            console.log(err);
        })
    };

    var deleteSupplier=function(id){
        axios.delete(host+"/mrp/supplier/"+id)
        .then(function(resp){
            alert("Supplier deleted");
        })
        .catch(function(err){
            console.log(err);
        })
    };

    var getSuppliers=function(callback){
        axios.get(host+"/mrp/supplier")
        .then(function(resp){
            callback(resp);
        })
        .catch(function(err){
            console.log(err);
        })
    }

    return{
        "addCompany": addCompany,
        "getCompany":getCompany,
        "getCompanies":getCompanies,
        "addMachine":addMachine,
        "getMachinesOfCompany":getMachinesOfCompany,
        "deleteMachine":deleteMachine,
        "addActivity":addActivity,
        "getActivitiesOfMachine":getActivitiesOfMachine,
        "deleteActivity":deleteActivity,
        "addMaterialToActivity":addMaterialToActivity,
        "getMaterialsOfActivity":getMaterialsOfActivity,
        "deleteMaterial":deleteMaterial,
        "addMaterial":addMaterial,
        "addSupplier":addSupplier,
        "deleteSupplier":deleteSupplier,
        "getSuppliers":getSuppliers
    }
}());