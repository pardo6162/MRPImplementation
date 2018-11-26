var appModule = {
    company:null,
    addCompany: function(){ 
        var name=document.getElementById("name").value;
        var nit=document.getElementById("nit").value;
        axios_module.addCompany(name,nit);
    },
    getCompanies: function(){
        axios_module.getCompanies(function(resp){
            for(let i in resp.data){
                document.getElementById("insert").innerHTML="<div><label align='center'><a href='index.html'><input  value='"+resp.data[i].name+"' class='btn btn-lg btn-success btn-block' onclick='appModule.initIndex("+resp.data[i]+")'></a></label></div>"+document.getElementById("insert").innerHTML
            }     
        })
    },
    initIndex:function(companyJSON){
        appModule.company=companyJSON;
    },    
    addMachine:function(){
        if(this.company==null){
            alert("Please login");
        }else{
            var name=document.getElementById("name").value;
            var name=document.getElementById("id").value;
            axios_module.addMachine(name,id,appModule.company)
        }
    }
    
    
}