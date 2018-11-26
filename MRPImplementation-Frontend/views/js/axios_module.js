var axios_module=function(){
    var host="localhost:8080/"
    var addCompany=function(nit,name){
        axios.post('mrp/company',{"nit":nit,"name":name,"machines":[]})
            .then(function(resp){
                console.log(resp);
            })
            .catch(function(err){
                console.log(err);
            })
    };
    var getCompany=function(nit){
        axios.get('mrp/company/'+nit)
            .then(function(resp){
                console.log(resp);
            })
            .catch(function(err){
                console.log(err);
            })
    };

    return{
        "addCompany": addCompany,
        "getCompany":getCompany
    }
}