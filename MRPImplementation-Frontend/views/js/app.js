var appModule = function(){
    var addCompany= function(){
        var name=document.getElementById("name");
        var nit=document.getElementById("nit");
        axios_module.addCompany(name,nit);
        console.log("Company added");      
    }
    return {
        addCompany:addCompany
    }
}