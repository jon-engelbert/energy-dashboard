	
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
}
	
function getMeterInfo()
{
    var meterType = $('#meterType').val();
    var meterID = $('#meterNum').val();
//    alert("meterID: " + meterID);
    $.ajax(
    {  
        url: 'getMeterInfo',  
        data: 'meterNum=' + meterID,  
        dataType: 'text',
        success: function( data )
        {
//            alert('in getMeterInfo success');
            $('#meterInfo').html( data );
//            $('#meterNumber').val(meterID);
            $.ajax
            ({  
                    url: 'getBills',  
                    data: 'meterNum=' + meterID + '&meterType=' + meterType,  
                    dataType: 'html',  
                    success: function( tableData )
                    {
//                       alert('in getBills success');
                       $('#billTable').html( tableData );
                    },
                    error: function()
                    {
                        alert("getBills error");
                    }
            });  

        },
        error: function()
        {
                alert("getMeterInfo error");
        }
    }
    );  
}

function getPCBillsInfo()
{
    var buildingID = $('#building').val();
        $.ajax
        ({  
                url: 'getPCBills',  
                data: 'siteID=' + buildingID,  
                dataType: 'html',  
                success: function( tableData )
                {
//                       alert('in getBills success');
                    $('#billTable').html( tableData );
                },
                error: function()
                {
                    alert("getPCBills error");
                }
        });
}
