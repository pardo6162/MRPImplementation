var materialsView="<div class='row'>" +
                        "<div class='col-lg-12'>" +
                            "<h1 class='page-header'>Material</h1>" +
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
                                        "<button  class='btn btn-default' onclick='appModule.searchActivitiesMaterialsView()'>Search</button>" +
                                        "<div class='form-group'>" +
                                        "<label>Activity</label>" +
                                            "<select id='activities_list' class='form-control'>" +
                                            "</select>"+
                                        "</div>" +
                                        "<button  class='btn btn-default' onclick='appModule.searchMaterialsOfActivity()'>Search</button>" +
                                    "</div>"+
                                "</div>" +
                                "<div class='row' id='materials_search'>" +
                                "</div>" +
                                "<div class='row' id='materials_form'>" +
                                "</div>" ;



var addMaterialForm="<div class='col-lg-6'>" +                         
                                        "<div class='form-group'>" +
                                            "<label>Supplier</label>" +
                                            "<select id='supplier_list' class='form-control'>" +
                                            "</select>"+
                                        "</div>" +
                                        "<div class='form-group'>" +
                                            "<label>Identifier</label>" +
                                            "<input id='id_material' class='form-control'>" +
                                        "</div>" +
                                        "<div class='form-group'>" +
                                            "<label>Name</label>" +
                                            "<input id='name_material' class='form-control'>" +
                                        "</div>" +
                                        "<div class='form-group'>" +
                                            "<label>Ordering Cost</label>" +
                                            "<input type='number' id='ordering_cost' class='form-control'>" +
                                        "</div>" +
                                        "<div class='form-group'>" +
                                            "<label>Maintain Cost</label>" +
                                            "<input type='number' id='maintain_cost' class='form-control'>" +
                                        "</div>" +
                                        "<button  class='btn btn-default' onclick='appModule.addMaterial()'>Submit Button</button>" +
                                    "</div>";
                        
