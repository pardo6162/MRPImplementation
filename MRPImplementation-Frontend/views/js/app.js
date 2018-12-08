var company=null;
var machine=null;


var appModule = {
    load:function(){
        document.getElementById("page-wrapper").innerHTML=loginView;
        this.getCompanies();
    },

    initIndex:function(nit,name){
        company={"nit":nit,"name":name};
        document.getElementById("company").innerHTML=company.name;
        document.getElementById("page-wrapper").innerHTML=dashboard;

    },
    
    // company CRUD
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
    
    // machine CRUD
    addMachine:function(){
        if(company==null){
            alert("Please login");
        }else{
            var name=document.getElementById("name").value;
            var id=document.getElementById("id").value;
            axios_module.addMachine(id,name,company)
            this.machinesView();
        }
    },
    deleteMachine:function(id,name){
        machine={"id":id,"name":name};
        axios_module.deleteMachine(company,machine);
        this.machinesView();
    },

    // activity CRUD
    addActivity:function(){
        if(machine==null){
            alert("Please select machine");    
        }else{
            var name=document.getElementById("name_activity").value;
            var id=document.getElementById("id_activity").value;
            activity={"id":id,"name":name};
            axios_module.addActivity(activity,machine);    
            this.activitiesView();   
        }
        
        
    },

    deleteActivity:function(id,name){
        if(machine==null){
            alert("Please select a machine");
        }else{
            activity={"id":id,"name":name};
            axios_module.deleteActivity(machine,activity);
        }
        this.activitiesView();
    },

    searchActivities:function(){
        var selector = document.getElementById('machines_list');
        machine = JSON.parse(selector[selector.selectedIndex].value);
        machine.company=company;
        document.getElementById("activities").innerHTML="";
        axios_module.getActivitiesOfMachine(function(resp){   
            for(let i in resp.data){
                document.getElementById("activities").innerHTML="<div><label> ID: "+resp.data[i].id+" NAME: "+resp.data[i].name+"   <button type='button' src='img/delete.png'   onclick=\"appModule.deleteActivity('"+resp.data[i].id+"','"+resp.data[i].name+"');\" ><img src='img/delete.png' /></button></label></div>"+document.getElementById("activities").innerHTML;
            }

        },machine);
        document.getElementById('form').innerHTML=addActivityForm;

    },

    // views 
    machinesView:function(){
        axios_module.getMachinesOfCompany(function(resp){
            document.getElementById("page-wrapper").innerHTML=machinesView;
            for(let i in resp.data){
                document.getElementById("machines").innerHTML="<div><label> ID: "+resp.data[i].id+" NAME: "+resp.data[i].name+"   <button type='button' src='img/delete.png'   onclick=\"appModule.deleteMachine('"+resp.data[i].id+"','"+resp.data[i].name+"');\" ><img src='img/delete.png' /></button></label></div>"+document.getElementById("machines").innerHTML;
            }    
        },company)
        
    },
    

    activitiesView:function(){
        axios_module.getMachinesOfCompany(function(resp){
            document.getElementById("page-wrapper").innerHTML=activitiesView;
            var list = document.getElementById("machines_list");
            for(let i in resp.data){
                document.getElementById("machines_list").innerHTML="<option value='{\"id\":\""+resp.data[i].id+"\",\"name\":\""+resp.data[i].name+"\"}'> "+resp.data[i].name+"</option>"+document.getElementById("machines_list").innerHTML;
            }  
        },company);
    },

    suppliersView:function(){
        axios_module.getSuppliers(function(resp){
            document.getElementById("page-wrapper").innerHTML=suppliersView;
            for(let i in resp.data){
                document.getElementById("suppliers").innerHTML="<div><label> ID: "+resp.data[i].id+" NAME: "+resp.data[i].name+"   <button type='button' src='img/delete.png'   onclick=\"appModule.deleteMachine('"+resp.data[i].id+"','"+resp.data[i].name+"');\" ><img src='img/delete.png' /></button></label></div>"+document.getElementById("machines").innerHTML;
            }  
        })
    }

}