// Select all table cells to bind a click event
$('table #delrow').click(function(){
    alert('removing');
    $(this).parent().remove();
});

function addTableRow(selectName, tableId) {

    var itemId = $('#' + selectName).val();
    //alert(itemId);
    var itemName = $('#' + selectName + ' option:selected').text();
    //alert (itemName);
    var trString = '<tr><td><input type="hidden" value="' + itemId + '" />' + itemName + '</td><td id="delrow"><a href=#>remove</a></td></tr>';
    
    $('.' + tableId + ' > tbody:last').append(trString);
}

function filterBySite(id)
{

    $.ajax({  
        url: 'updateCircuitBySite',  
        data: 'siteId=' + id,  
        dataType: 'html',  
        success: function( json )
        {
            var seriesArrays = json.split(';');
            $.each(seriesArrays, function(itemNo, seriesArray ) {
                var items = seriesArray.split(',');
                var selectName;
                var selectText;

                $.each(items, function(itemNo, item) {
                    //                            alert(itemNo + " " + item);
                    if (itemNo == 0) {
                        selectName = item;
                    } else {
                        selectText = item
                    }

                });
                $('#' + selectName).html( selectText );              
            });
        },
        error: function()
        {
            alert("error");
        }
    });
}

$('#cbuilding').change(function () {
    var buildingId = $(this).val();
//    alert(buildingId);
//    filterBySite(buildingId);
    var newURL = "setup_circuits?siteId=" + buildingId;
    window.location.href = newURL;

});

//$(document).ready(function() {
//    var buildingId = $('#cbuilding').val();
//    alert(buildingId);
//});
//