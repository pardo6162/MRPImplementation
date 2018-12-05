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

    return{
        "addCompany": addCompany,
        "getCompany":getCompany,
        "getCompanies":getCompanies,
        "addMachine":addMachine,
        "getMachinesOfCompany":getMachinesOfCompany,
        "deleteMachine":deleteMachine,
        "addActivity":addActivity,
        "getActivitiesOfMachine":getActivitiesOfMachine,
        "deleteActivity":deleteActivity
    }
}());