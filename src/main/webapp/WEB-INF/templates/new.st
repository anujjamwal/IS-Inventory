<html>
    <head>
        <title> Create an asset </title>
        <link rel="stylesheet" type="text/css" href="resources/css/bootstrap.css" media="screen"/>
    </head>
    <body>
        <form method="post" action="new" class="form-horizontal">
             <div class="control-group">
                <label class="control-label" for="Asset type">Asset Type </label>
                <select id="type" name="type">
                    <option value="Laptop">Laptop</option>
                    <option value="Keyboard">Keyboard</option>
                    <option value="Mouse">Mouse</option>
                </select>
             </div>
            <div class="control-group">
                <label class="control-label" for="Brand">Brand </label>
                <div class="controls">
                    <input type=text id="brand" name="brand"></input>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="Model">Model </label>
                <div class="controls">
                    <input type=text id="model" name="model"></input>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="Serial_no">Serial_no </label>
                <div class="controls">
                    <input type=text id="serialNo" name="serialNo"></input>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="Warranty">Warranty </label>
                <div class="controls">
                    <input type=text id="warranty" name="warranty"></input>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="Asset Tag">Asset Tag</label>
                <div class="controls">
                    <input type=text id="assetTag" name="assetTag"></input>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="Description">Description</label>
                <div class="controls">
                    <input type=text id="description" name="description"></input>
                </div>
            </div>
            <div class="control-group">
                <div class="controls">
                    <button type=submit>send</button>
                </div>
            </div>
        </form>
    </body>
</html>
