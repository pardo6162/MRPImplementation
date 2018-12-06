var suppliersView="<div class='row'>" +
                            "<div class='col-lg-12'>" +
                                "<h1 class='page-header'>Activity</h1>" +
                            "</div>" +
                        "</div>" +
                        "<div class='col-lg-12'>" +
                            "<div class='panel panel-default'>" +
                                "<div class='panel-heading'>" +
                                    "Select a machine" +
                                "</div>" +
                                "<div class='panel-body'>" +
                                    "<div class='row'>" +
                                        "<div class='col-lg-6'>" +                         
                                            "<div class='form-group'>" +
                                                "<label>Machine</label>" +
                                                    "<select id='machines_list' class='form-control'>" +
                                                    "</select>"+
                                            "</div>" +
                                            "<button  class='btn btn-default' onclick='appModule.searchActivities()'>Search</button>" +
                                        "</div>"+
                                    "</div>" +
                                "</div>" +
                            "</div>" +
                        "<div class='col-lg-12'>" +
                            "<div class='panel panel-default'>" +
                                "<div class='panel-body'>" +
                                    "<div class='row'>" +
                                        "<div class='col-lg-6'>" +
                                            "<div id='activities'>" +
                                            "</div>" +
                                        "</div>" +
                                    "</div>" +
                                "</div>" +
                            "</div>" +
                        "</div>" +
                    "</div>" +
                    "<div id='form' class='row'>" +
                    "</div>" +
                "</div>"+
            "</div>" +
        "</div>" +
    "</div>" +
"</div>";

var addActivityForm="<div class='col-lg-12'>" +
                                "<h1 class='page-header'>Add new Activity</h1>" +
                            "</div>" +
                        "</div>" +
                        "<div class='col-lg-12'>" +
                            "<div class='panel panel-default'>" +
                                "<div class='panel-heading'>" +
                                    "Fill the form" +
                                "</div>" +
                            "<div class='panel-body'>" +
                                "<div class='row'>" +
                                    "<div class='col-lg-6'>" +
                                        "<div class='form-group'>" +
                                            "<label>Identifier</label>" +
                                            "<input id='id_activity' class='form-control'>" +
                                        "</div>" +
                                    "<div class='form-group'>" +
                                        "<label>Name</label>" +
                                        "<input id='name_activity' class='form-control'>" +
                                    "</div>" +
                                    "<button  class='btn btn-default' onclick='appModule.addActivity()'>Submit Button</button>" +
                                    "<button type='reset' class='btn btn-default'>Reset Button</button>"+
                                "</div>"+
                            "</div>" +
                        "</div>" +
                    "</div>" +
                "</div>" +
            "</div>" +
        "</div>" +
    "</div>";