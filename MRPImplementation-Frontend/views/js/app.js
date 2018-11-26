var appModule = {
     addCompany: function(){ 
        var name=document.getElementById("name").value;
        var nit=document.getElementById("nit").value;
        axios_module.addCompany(name,nit);
    },
    getCompanies: function(){
    var companies =axios_module.getCompanies(function(resp){
        var table =document.getElementById("insert").innerHTML="<div><label><button name='name' value='dfsfsdf'>dfgdg</label></div>"
        console.log(table)
        for(let i in companies){
            for(let j in i){
                table.innerHTML="<div><label><output name='name' value='"+j.name+"'></label></div>"
            }
        }     
    });    
    
    
    }
}