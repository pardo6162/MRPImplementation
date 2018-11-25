
var app = function(){
    
    return {
        addCompany:function(nit,name){
            axios_module.addCompany(name,nit);
            console.log("Company added");      
        }
    }
}