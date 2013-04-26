<table border=1 class="table table-striped table-hover table-bordered">
    <tr>
        <th>Type</th>
    </tr>
    $TYPES:{
    <tr>
        <td>$attr$</td>
    </tr>
    }$
</table>
<form method="post" action="create_type" class="form-horizontal">
    <div class="control-group">
        <label class="control-label" for="type">Add Asset Type</label>

        <div class="controls">
            <input type=text id="type" name="type"/>
        </div>
        <div class="controls">
            <button type=submit>Add</button>
        </div>
    </div>
</form>