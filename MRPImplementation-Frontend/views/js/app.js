var company=null;


var appModule = {

    load:function(){
        document.getElementById("page-wrapper").innerHTML=loginView;
        this.getCompanies();
    },

    addCompany: function(){ 
        var name=document.getElementById("name").value;
        var nit=document.getElementById("nit").value;
        axios_module.addCompany(name,nit);
    },
    getCompanies: function(){
        axios_module.getCompanies(function(resp){
            for(let i in resp.data){
                document.getElementById("insert").innerHTML="<div><label><output  class='btn btn-lg btn-success btn-block'  onclick=\"appModule.initIndex('"+resp.data[i].nit+"','"+resp.data[i].name+"');\" >"+resp.data[i].name+"</label></div>"+document.getElementById("insert").innerHTML
            }     
        })
    },
    initIndex:function(nit,name){
        company={"nit":nit,"name":name};
        document.getElementById("company").innerHTML=company.name;
        document.getElementById("page-wrapper").innerHTML=dashboard;

    },    
    addMachine:function(){
        if(company==null){
            alert("Please login");
        }else{
            var name=document.getElementById("name").value;
            var id=document.getElementById("id").value;
            axios_module.addMachine(id,name,company)
        }
    },
    machinesView:function(){
        axios_module.getMachinesOfCompany(function(resp){
            document.getElementById("page-wrapper").innerHTML=machinesView;
            for(let i in resp.data){
                document.getElementById("machines").innerHTML="<div class='form-group'><label>ID: "+resp.data[i].id+"</label><label>NAME: "+resp.data[i].name+"</label><input  class='btn btn-lg btn-success btn-block'  onclick=\"appModule.deleteMachine('"+resp.data[i]+"');\" ></div>";
            }    
        },company)
        
    },
    deleteMachine:function(machine){
        axios_module.deleteMachine(company,machine);
    }


}