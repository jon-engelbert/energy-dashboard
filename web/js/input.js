function clearForm()
{
    $('#meterInfo').html( ' ' );
    $('#meterNum').html( '<option value="0">Select a Meter</option>' );
}
	
function getMeterNum()
{
    var meterType = $('#meterType').val();
    $('#meterInfo').html(" ");
		
    $.ajax(
    {  
        url: 'getMeters',  
        data: 'meterType=' + meterType,  
        dataType: 'html',  
        success: function( data )
        {
            $('#meterNum').html( data );
        },
        error: function()
        {
            alert("getMeterNum error");
        }
    }
    );
//    if (meterType == "Natural Gas") {
//        $('#gasDataForm').show();
//        $('#electricDataForm').hide();
//    }
//    if (meterType == "Electric") {
        $('#electricDataForm').show();
        $('#gasDataForm').hide();
//    }
}
	
function getMeterInfo()
{
    var meterNum = $('#meterNum').val();
    $('#meterNumber').val(meterNum);
    //    alert(meterNum);
    $.ajax(
    {  
        url: 'getMeterInfo',  
        data: 'meterNum=' + meterNum,  
        dataType: 'text',
        success: function( data )
        {
            //            alert('in success');
            $('#meterInfo').html( data );
            $('#meterNumber').val(meterNum);
            if (data.search("Electric") > 0) {
                $('#units').text(" kWh");
            } else if (data.search("Natural Gas") > 0) {
                $('#units').text(" CCF");
            } else if (data.search("Water") > 0) {
                $('#units').text(" Gal");
            } else if (data.search("Waste") > 0) {
                $('#units').text(" Bins");
            } else {
                $('#units').text(" ");
            }
        },
        error: function()
        {
            alert("getMeterInfo error");
        }
    }
    );  
}

$(function () {
    $("#startDate").mask("9999-99-99");
    $("#billDate").mask("9999-99-99");
    $("#billStart").mask("9999-99-99");
    $("#billEnd").mask("9999-99-99");
    $('#gasDataForm').hide();
    $('#electricDataForm').hide(); 
})
