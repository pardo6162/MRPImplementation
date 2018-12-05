var dashboard="";
var loginView="<div class='container'>"+
                "<div class='row'>"+
                    "<div class='col-md-4 col-md-offset-4'>"+
                        "<div class='login-panel panel panel-default'>"+
                            "<div class='panel-heading'>"+
                                "<h3 class='panel-title'>Please Sign In</h3>"+
                            "</div>"+
                            "<div class='panel-body'>"+
                                "<form role='form'>"+
                                    "<fieldset id='insert'>"+
                                        "<!-- Change this to a button or input when using this as a form -->"+
                                        "<br>"+
                                        "<br>"+
                                    "</fieldset>"+
                                "</form>"+
                            "</div>"+
                        "</div>"+
                    "</div>"+
                "</div>"+
            "</div>";

var machinesView="<div class='row'>" +
"    <div class='col-lg-12'>" +
"        <h1 class='page-header'>Machines</h1>" +
"    </div>" +
"    <!-- /.col-lg-12 -->" +
"            </div>" +
"    <!-- /.row -->" +
"            <div class='col-lg-12'>" +
"                <div class='panel panel-default'>" +
"                    <div class='panel-body'>" +
"                        <div class='row'>" +
"                            <div class='col-lg-6'>" +
"                                <div id='machines'>" +
"                                </div>" +
"                                    </div>" +
"                                    <!-- /.col-lg-6 (nested) -->" +
"                            </div>" +
"                                <!-- /.row (nested) -->" +
"                        </div>" +
"                            <!-- /.panel-body -->" +
"                    </div>" +
"                        <!-- /.panel -->" +
"                </div>" +
"                    <!-- /.col-lg-12 -->" +
"            </div>" +
"                <!-- /.row -->" +
"        </div>"+
"<div class='row'>" +
"    <div class='col-lg-12'>" +
"        <h1 class='page-header'>Add new Machine</h1>" +
"    </div>" +
"    <!-- /.col-lg-12 -->" +
"            </div>" +
"    <!-- /.row -->" +
"            <div class='col-lg-12'>" +
"                <div class='panel panel-default'>" +
"                    <div class='panel-heading'>" +
"                        Fill the form" +
"                        </div>" +
"                    <div class='panel-body'>" +
"                        <div class='row'>" +
"                            <div class='col-lg-6'>" +
"                                    <div class='form-group'>" +
"                                        <label>Identifier</label>" +
"                                        <input id='id' class='form-control'>" +
"                                            " +
"                                        </div>" +
"                                        <div class='form-group'>" +
"                                            <label>Name</label>" +
"                                            <input id='name' class='form-control'>" +
"                                             " +
"                                        </div>" +
"                                            <button  class='btn btn-default' onclick='appModule.addMachine()'>Submit Button</button>" +
"                                            <button type='reset' class='btn btn-default'>Reset Button</button>"+
"                                    </div>" +
"                                    <!-- /.col-lg-6 (nested) -->" +
"                            </div>" +
"                                <!-- /.row (nested) -->" +
"                        </div>" +
"                            <!-- /.panel-body -->" +
"                    </div>" +
"                        <!-- /.panel -->" +
"                </div>" +
"                    <!-- /.col-lg-12 -->" +
"            </div>" +
"                <!-- /.row -->" +
"        </div>"


var activitiesView="<div class='row'>" +
"    <div class='col-lg-12'>" +
"        <h1 class='page-header'>Activity</h1>" +
"    </div>" +
"    <!-- /.col-lg-12 -->" +
"            </div>" +
"    <!-- /.row -->" +
"            <div class='col-lg-12'>" +
"                <div class='panel panel-default'>" +
"                    <div class='panel-body'>" +
"                        <div class='row'>" +
"                            <div class='col-lg-6'>" +
"                                <div id='activities'>" +
"                                </div>" +
"                                    </div>" +
"                                    <!-- /.col-lg-6 (nested) -->" +
"                            </div>" +
"                                <!-- /.row (nested) -->" +
"                        </div>" +
"                            <!-- /.panel-body -->" +
"                    </div>" +
"                        <!-- /.panel -->" +
"                </div>" +
"                    <!-- /.col-lg-12 -->" +
"            </div>" +
"                <!-- /.row -->" +
"        </div>"+
"<div class='row'>" +
"    <div class='col-lg-12'>" +
"        <h1 class='page-header'>Add new Activity</h1>" +
"    </div>" +
"    <!-- /.col-lg-12 -->" +
"            </div>" +
"    <!-- /.row -->" +
"            <div class='col-lg-12'>" +
"                <div class='panel panel-default'>" +
"                    <div class='panel-heading'>" +
"                        Fill the form" +
"                        </div>" +
"                    <div class='panel-body'>" +
"                        <div class='row'>" +
"                            <div class='col-lg-6'>" +
"                                    <div class='form-group'>" +
"                                        <label>Identifier</label>" +
"                                        <input id='id' class='form-control'>" +
"                                            " +
"                                        </div>" +
"                                        <div class='form-group'>" +
"                                            <label>Name</label>" +
"                                            <select id='machines_list'>" +
"                                            </select>"
"                                             " +
"                                        </div>" +
"                                        <div class='form-group'>" +
"                                            <label>Name</label>" +
"                                            <input id='name' class='form-control'>" +
"                                             " +
"                                        </div>" +
"                                            <button  class='btn btn-default' onclick='appModule.addActivity()'>Submit Button</button>" +
"                                            <button type='reset' class='btn btn-default'>Reset Button</button>"+
"                                    </div>" +
"                                    <!-- /.col-lg-6 (nested) -->" +
"                            </div>" +
"                                <!-- /.row (nested) -->" +
"                        </div>" +
"                            <!-- /.panel-body -->" +
"                    </div>" +
"                        <!-- /.panel -->" +
"                </div>" +
"                    <!-- /.col-lg-12 -->" +
"            </div>" +
"                <!-- /.row -->" +
"        </div>"