<form method="post" action="new" class="form-horizontal">
    <div>
        <h3>Add An Asset</h3>
    </div>
    <div class='row-fluid form-main'>
        <div class="control-group">
            <label class="control-label" for="type">Asset Type </label>

            <div class="controls">
                <select id="type" name="type" onchange="doAjaxPost()">
                    $TYPES:{
                    <option value=$attr$>$attr$</option>
                    }$
                </select>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="Brand">Brand </label>

            <div class="controls">
                <input type=text id="brand" name="brand" value="$ASSET.brand$" />
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="Model">Model </label>

            <div class="controls">
                <input type=text id="model" name="model" value="$ASSET.model$" />
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="serialNo">Serial_no </label>

            <div class="controls">
                <input type=text id="serialNo" name="serialNo" />
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="Warranty">Warranty </label>

            <div class="controls">
                <input type=text id="warranty" name="warranty" value="$ASSET.warranty$" />
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="assetTag">Asset Tag</label>

            <div class="controls">
                <input type=text id="assetTag" name="assetTag" value="$ASSET.assetTag$" />
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="Description">Description</label>

            <div class="controls">
                <textarea id="description" name="description">$ASSET.description$</textarea>
            </div>
        </div>
        <div class="control-group">
            <div class="controls">
                <button type=submit>send</button>
            </div>
        </div>
    </div>
</form>
</div>
</div>
<div class="span1"></div>
</div>