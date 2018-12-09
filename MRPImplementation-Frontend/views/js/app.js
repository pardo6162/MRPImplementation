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

    //Supplier CRUD
    addSupplier:function(){
        var id=document.getElementById("id_material").value;
        var name=document.getElementById("name_material").value;
        var country=document.getElementById("country").value;
        var address=document.getElementById("address").value;
        var delivery_time=document.getElementById("delivery_time").value;
        var phone=document.getElementById("phone").value;
        axios_module.addSupplier(id,name,country,address,delivery_time,phone);
        this.suppliersView();
    },


    deleteSupplier:function(id){
        axios_module.deleteSupplier(id);
        this.suppliersView();
    },

    addMaterial:function(){
        var id=document.getElementById("id").value;
        var name=document.getElementById("name").value;
        var country=document.getElementById("country").value;
        var address=document.getElementById("address").value;
    }



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

    suppliersView:function(){
        axios_module.getSuppliers(function(resp){
            document.getElementById("page-wrapper").innerHTML=suppliersView;
            for(let i in resp.data){
                document.getElementById("suppliers").innerHTML="<div><label> ID: "+resp.data[i].id+" COMPANY NAME: "+resp.data[i].businessName+"   <button type='button' src='img/delete.png'   onclick=\"appModule.deleteSupplier('"+resp.data[i].id+"');\" ><img src='img/delete.png' /></button></label></div>"+document.getElementById("suppliers").innerHTML;
            }  
        })
    },

    materialsView:function(){
        let loadSuppliers=function(){
            axios_module.getSuppliers(function(resp){
                for(let i in resp.data){
                    document.getElementById("supplier_list").innerHTML="<option value='{\"id\":\""+resp.data[i].id+"\",\"businessName\":\""+resp.data[i].businessName+"\"}'> "+resp.data[i].businessName+"</option>"+document.getElementById("supplier_list").innerHTML;
                }  
            });
        };

        axios_module.getMachinesOfCompany(function(resp){
            document.getElementById("page-wrapper").innerHTML=materialsView;
            for(let i in resp.data){
                document.getElementById("machines_list").innerHTML="<option value='{\"id\":\""+resp.data[i].id+"\",\"name\":\""+resp.data[i].name+"\"}'> "+resp.data[i].name+"</option>"+document.getElementById("machines_list").innerHTML;
            }  
            loadSuppliers();
        },company);
        
    },

    searchActivitiesMaterialsView:function(){
        var selector = document.getElementById('machines_list');
        machine = JSON.parse(selector[selector.selectedIndex].value);
        machine.company=company;
        axios_module.getActivitiesOfMachine(function(resp){   
            console.log(resp);
            for(let i in resp.data){
                document.getElementById("activities_list").innerHTML="<option value='{\"id\":\""+resp.data[i].id+"\",\"name\":\""+resp.data[i].name+"\"}'> "+resp.data[i].name+"</option>"+document.getElementById("activities_list").innerHTML;
            }

        },machine);

    }

}