function doAjaxPost() {
var type = $('#type').find('option:selected').val();

$.ajax({
type: "POST",
url: "/",
data: "type=" + type,
success: function(response){
// we have the response
$('#brand').val(response.brand);
$('#model').val(response.model);
$('#serialNo').val(response.serialNo);
$('#warranty').val(response.warranty);
$('#assetTag').val(response.assetTag);
$('#description').val(response.description);
},
error: function(e){
alert('Error: ' + e);
}
});
}