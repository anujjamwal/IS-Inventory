<table border=1 class="table table-striped table-hover table-bordered">
    <tr>
        <th>Id</th>
        <th>Type</th>
        <th>Brand</th>
        <th>Model</th>
        <th>Serial No.</th>
        <th>Warranty</th>
        <th>Asset Tag</th>
        <th>Description</th>
        <th></th>
    </tr>
    $ASSETS:{
    <tr>
        <td>$attr.id$</td>
        <td>$attr.type$</td>
        <td>$attr.brand$</td>
        <td>$attr.model$</td>
        <td>$attr.serialNo$</td>
        <td>$attr.warranty$</td>
        <td>$attr.assetTag$</td>
        <td>$attr.description$</td>
        <td><a href="#myModal" role="button" class="btn" data-toggle="modal">Assign</a></td>
        <!-- Modal -->
        <div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
             aria-hidden="true">
            <div class="modal-header">
                <h3 id="myModalLabel">Assign this $attr.type$</h3>
            </div>
            <div class="modal-body">
                <form method="post" action="show" class="form-horizontal">
                    <div class="row-fluid form-main">
                        <div class="control-group">
                            <label class="control-label" for="type">Assign To </label>

                            <div class="controls">
                                <select id="type" name="type">
                                    <option value=Office>Office</option>
                                    <option value=Individual>Individual</option>
                                    <option value=Project>Project</option>
                                </select>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="identifier">Identifier </label>

                            <div class="controls">
                                <input type=text id="identifier" name="identifier"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <div class="controls">
                                <button class="btn" type=submit>Send</button>
                                <button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </tr>
    }$
</table>


