var axios_module=(function(){
    var host="http://localhost:8080/"
    var addCompany=function(name,nit){
        axios.post(host+'mrp/company',{"nit":nit,"name":name,"machines":[]})
            .then(function(resp){
                console.log(resp);
            })
            .catch(function(err){
                console.log(err);
            })
    };
    var getCompany=function(nit){
        axios.get(host+'mrp/company/'+nit)
            .then(function(resp){
                console.log(resp);
            })
            .catch(function(err){
                console.log(err);
            })
    };
    var getCompanies=function(response){
        axios.get(host+'mrp/company')
            .then(function(resp){
                response(resp);
                console.log(resp);
            })
            .catch(function(err){
                console.log(err);
            })
    };
    var addMachine=function(id,name,company){
        axios.post(host+'mrp/company/'+company.nit+'/machine',{"id":id,"name":name,"activities":[],"companies":[]})
        .then(function(resp){
            console.log(resp);
        })
        .catch(function(err){
            console.log(err);
        })
    }

    return{
        "addCompany": addCompany,
        "getCompany":getCompany,
        "getCompanies":getCompanies
    }
}());