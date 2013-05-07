<table border=1 class="table table-striped table-hover table-bordered">
    <tr>
        <th>Id</th>
        <th>Asset Tag</th>
        <th>Assigned Type</th>
        <th>Assigned To</th>
        <th>Assigned Date</th>
        <th></th>
    </tr>
    $ASSIGNED_ASSETS:{
    <tr>
        <td>$attr.id$</td>
        <td>$attr.assetTag$</td>
        <td>$attr.identifier1Type$</td>
        <td>$attr.identifier1$</td>
        <td>$attr.assignedDate1$</td>
        <td><a href="#myModal" role="button" class="btn" data-toggle="modal">Assign History</a></td>
        <!-- Modal -->
        <div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
             aria-hidden="true">
            <div class="modal-body">
                 HELLO APURVA
            </div>
            <div class="modal-footer">
                <button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
            </div>
        </div>
    </tr>
    }$
</table>