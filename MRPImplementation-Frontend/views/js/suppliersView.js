var suppliersView="<div class='row'>" +
"<div class='col-lg-12'>" +
    "<h1 class='page-header'>Suppliers</h1>" +
"</div>" +
"</div>" +
"<div class='col-lg-12'>" +
"<div class='panel panel-default'>" +
    "<div class='panel-body'>" +
        "<div class='row'>" +
            "<div class='col-lg-6'>" +
                "<div id='suppliers'>" +
                "</div>" +
            "</div>" +
        "</div>" +
    "</div>" +
"</div>" +
"</div>" +
"</div>" +
"</div>"+
        "<div class='row'>" +
            "<div class='col-lg-12'>" +
                "<h1 class='page-header'>Add new Supplier</h1>" +
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
                        "<input id='id_supplier' class='form-control'>" +
                    "</div>" +
                    "       <div class='form-group'>" +
                        "<label>Company Name</label>" +
                        "<input id='name_supplier' class='form-control'>" +
                    "</div>" +
                    "<div class='form-group'>" +
                        "<label>Country</label>" +
                        "<input id='country' class='form-control'>" +
                    "</div>" +
                    "<div class='form-group'>" +
                        "<label>Address</label>" +
                        "<input id='address' class='form-control'>" +
                    "</div>" +
                    "<div class='form-group'>" +
                        "<label>Delivery Time</label>" +
                        "<input type='number' id='delivery_time' class='form-control'>" +
                    "</div>" +
                    "<div class='form-group'>" +
                        "<label>Phone</label>" +
                        "<input type='number' id='phone' class='form-control'>" +
                    "</div>" +
                    "<button  class='btn btn-default' onclick='appModule.addSupplier()'>Submit Button</button>" +
                    "<button type='reset' class='btn btn-default'>Reset Button</button>"+
                "</div>" +
            "</div>" +
        "</div>" +
    "</div>" +
"</div>" +
"</div>" +
"</div>";
