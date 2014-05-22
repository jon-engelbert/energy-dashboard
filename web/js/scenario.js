
//---------
var isLight_bDown = false;
var isHeat_bDown = false;
var isCool_bDown = false;
var isHeatUO_bDown = false;
var isCoolUO_bDown = false;

//---------
var light_b = new Slider(document.getElementById("light_b-slider"), document.getElementById("light_b-slider-input"));
light_b.setMinimum(25);
light_b.setMaximum(100);
var heat_b = new Slider(document.getElementById("heat_b-slider"), document.getElementById("heat_b-slider-input"));
heat_b.setMinimum(55);
heat_b.setMaximum(85);
var cool_b = new Slider(document.getElementById("cool_b-slider"), document.getElementById("cool_b-slider-input"));
cool_b.setMinimum(55);
cool_b.setMaximum(85);
var heatUO_b = new Slider(document.getElementById("heatUO_b-slider"), document.getElementById("heatUO_b-slider-input"));
heatUO_b.setMinimum(55);
heatUO_b.setMaximum(85);
var coolUO_b = new Slider(document.getElementById("coolUO_b-slider"), document.getElementById("coolUO_b-slider-input"));
coolUO_b.setMinimum(55);
coolUO_b.setMaximum(85);


//=====================


//---------
var light_bi = document.getElementById("light_b-input");
light_bi.onchange = function () {
	light_b.setValue(parseInt(this.value));
};

var heat_bi = document.getElementById("heat_b-input");
heat_bi.onchange = function () {
	heat_b.setValue(parseInt(this.value));
};

var cool_bi = document.getElementById("cool_b-input");
cool_bi.onchange = function () {
	cool_b.setValue(parseInt(this.value));
};


var heatUO_bi = document.getElementById("heatUO_b-input");
heatUO_bi.onchange = function () {
	heatUO_b.setValue(parseInt(this.value));
};

var coolUO_bi = document.getElementById("coolUO_b-input");
coolUO_bi.onchange = function () {
	coolUO_b.setValue(parseInt(this.value));
};


//=====================


// fetching the setpoints from the hidden inputs on the page


//----------
light_b.onchange = heat_b.onchange = cool_b.onchange = heatUO_b.onchange = coolUO_b.onchange = function () {
	light_bi.value = light_b.getValue();
	heat_bi.value = heat_b.getValue();
	cool_bi.value = cool_b.getValue();
	heatUO_bi.value = heatUO_b.getValue();
	coolUO_bi.value = coolUO_b.getValue();
	
	if (typeof window.onchange == "function")
		window.onchange();
};

// fetching the setpoints from the hidden inputs on the page
light_b.setValue($('#light_blimit').val());
heat_b.setValue($('#heat_blimit').val());
cool_b.setValue($('#cool_blimit').val());
heatUO_b.setValue($('#heatUO_blimit').val());
coolUO_b.setValue($('#coolUO_blimit').val());
$('#light_b-input-base').val($('#light_blimit').val());
$('#heat_b-input-base').val($('#heat_blimit').val());
$('#cool_b-input-base').val($('#cool_blimit').val());
$('#heatUO_b-input-base').val($('#heatUO_blimit').val());
$('#coolUO_b-input-base').val($('#coolUO_blimit').val());

var light_bValInit = light_bi.value;
var heat_bValInit = heat_bi.value;
var cool_bValInit = cool_bi.value;
var heatUO_bValInit = heatUO_bi.value;
var coolUO_bValInit = coolUO_bi.value;
//----------

//=====================
// initial values
var moneysavedInit = Number($('#scenario_moneysaved').val().replace(/[^-0-9\.]+/g,""));
var elecsavedInit = Number($('#scenario_elecsaved').val().replace(/[^-0-9\.]+/g,""));
var gassavedInit = Number($('#scenario_gassaved').val().replace(/[^-0-9\.]+/g,""));
//var elecsavedInit = parseFloat($('#scenario_elecsaved').val());
//var gassavedInit = parseFloat($('#scenario_gassaved').val());
var paybackdateInitString = $('#scenario_paybackdate').val();
var paybackdateInitArray = paybackdateInitString.split('/');
paybackdateInit = new Date(paybackdateInitArray[2], paybackdateInitArray[0]-1, paybackdateInitArray[1]);


//=====================

function fixSize() {
//----------
	light_b.recalculate();
	heat_b.recalculate();
	cool_b.recalculate();
	heatUO_b.recalculate();
	coolUO_b.recalculate();
//----------
//	light_z.recalculate();
//	heat_z.recalculate();
//	cool_z.recalculate();
//	heatUO_z.recalculate();
//	coolUO_z.recalculate();
}

window.onresize = fixSize;

fixSize();
// -- other functions



$(document).mouseup(function(){

    if(isLight_bDown){
        isLight_bDown = false;
        recalculatePaybackProto_b();
    }
    if(isHeat_bDown){
        isHeat_bDown = false;
        recalculatePaybackProto_b();
    }
    if(isCool_bDown){
        isCool_bDown = false;
        recalculatePaybackProto_b();
    }
    if(isHeatUO_bDown){
        isHeatUO_bDown = false;
        recalculatePaybackProto_b();
    }
    if(isCoolUO_bDown){
        isCoolUO_bDown = false;
        recalculatePaybackProto_b();
    }
}); 


//-----------

$('#light_b-slider').mousedown( function() {
    isLight_bDown = true;
});

$('#heat_b-slider').mousedown( function() {
    isHeat_bDown = true;
});

$('#cool_b-slider').mousedown( function() {
    isCool_bDown = true;
});

$('#heatUO_b-slider').mousedown( function() {
    isHeatUO_bDown = true;
});

$('#coolUO_b-slider').mousedown( function() {
    isCoolUO_bDown = true;
});


$('#light_b-input, #heat_b-input, #cool_b-input, #heatUO_b-input, #coolUO_b-input').change( function() {
    recalculatePaybackProto_b();
});


function recalculatePaybackProto_b() {
    var siteId = $('#buildingscenario').val();
//    alert(siteId);
    recalculatePaybackByBuilding(siteId, $('#light-input').val(), $('#heat-input').val(), $('#cool-input').val(), $('#heatUO-input').val(), $('#coolUO-input').val(), $('#light_b-input').val(), $('#heat_b-input').val(), $('#cool_b-input').val(), $('#heatUO_b-input').val(), $('#coolUO_b-input').val(), $('#isOverride').is(':checked'));
//    alert("exit recalc by building");
}

// Recalculations based on slider/input changes


function recalculatePaybackByBuilding(siteId, lightVal, heatVal, coolVal, heatUOVal, coolUOVal, lightValb, heatValb, coolValb, heatUOValb, coolUOValb, isOverride) {
//    alert("recalculatePaybackProto_b");
    $.ajax({  
        url: 'dashboard_recalcByBuilding',  
        data: 'siteId=' + siteId + '&light-inputb=' + lightValb + '&heat-inputb=' + heatValb + '&cool-inputb=' + coolValb + '&heatUO-inputb=' + heatUOValb + '&coolUO-inputb=' + coolUOValb + '&IsOverride=' + isOverride + '&light-input=' + lightVal + '&heat-input=' + heatVal + '&cool-input=' + coolVal + '&heatUO-input=' + heatUOVal + '&coolUO-input=' + coolUOVal,  
        dataType: 'html',
        success: function( json )
        {
//            alert('success');
            var seriesArrays = json.split(';');
            $.each(seriesArrays, function(itemNo, seriesArray ) {
                var items = seriesArray.split(':');
                var inputName;
                var inputVal;

                $.each(items, function(itemNo, item) {
                    if (itemNo == 0) {
                        inputName = item;
                    } else {
                        inputVal = item
                    }

                });
                if (inputName == "scenario_elecsaved"){
                    inputVal = parseInt(inputVal) + elecsavedInit;
                    inputVal = addCommas(inputVal);
                    inputVal = inputVal + " kWh";
                }
                if (inputName == "scenario_gassaved"){
                    inputVal = parseInt(inputVal) + gassavedInit;
                    inputVal = addCommas(inputVal);
                    inputVal = inputVal + " BTU";
                }
                $('#' + inputName).val( inputVal );              
            });
        },
        error: function()
        {
//            alert("error");
        }
    });
}


//function toggleZoneDiv() {
//	var ele = document.getElementById("zonescenariodiv");
//	var text = document.getElementById("displayZoneDiv");
//	if(ele.style.display == "block") {
//    		ele.style.display = "none";
//		text.innerHTML = "Show Zone Details";
//  	}
//	else {
//		ele.style.display = "block";
//		text.innerHTML = "Hide Zone Details";
//	}
//}

$('#buildingscenario').change(function() {
    var buildingId = $(this).val();
//    alert(buildingId);
    $.ajax({  
        url: 'getBuildingSetPoints',  
        data: 'siteId=' + buildingId,  
        dataType: 'html',
        success: function( json )
        {
//            alert('success');
            var seriesArrays = json.split(';');
            $.each(seriesArrays, function(itemNo, seriesArray ) {
                var items = seriesArray.split(':');
                var inputName;
                var inputVal;

                $.each(items, function(itemNo, item) {
                    if (itemNo == 0) {
                        inputName = item;
                    } else {
                        inputVal = item
                    }

                });
                if (inputName != "isOverride") {
                    $('#' + inputName).val( inputVal );
                    $('#' + inputName + '-base').val( inputVal );
                } else {
                    var checked = inputVal == "true" ? true:false;
                    $('#' + inputName).attr("checked", checked );
                }
                switch (inputName) {
                    case "light_b-input" : light_b.setValue(inputVal); break;
                    case "heat_b-input" : heat_b.setValue(inputVal); break;
                    case "cool_b-input" : cool_b.setValue(inputVal); break;
                    case "heatUO_b-input" : heatUO_b.setValue(inputVal); break;
                    case "coolUO_b-input" : coolUO_b.setValue(inputVal); break;
                }
            });
        },
        error: function()
        {
//            alert("error");
        }
    });
});

$(document).ready(function() {
    $('#isOverride').change(function () {
        var isOverride = $('#isOverride').is(':checked');
    });
    
});


function resetValues_b () {
//    $('#scenario_paybackdate').val(paybackdateInitString);
//    $('#scenario_moneysaved').val("$" + moneysavedInit);
//    $('#scenario_elecsaved').val(elecsavedInit + " gWh");
//    $('#scenario_gassaved').val(gassavedInit + " BTU");
    light_b.setValue($('#light_b-input-base').val());
    heat_b.setValue($('#heat_b-input-base').val());
    cool_b.setValue($('#cool_b-input-base').val());
    heatUO_b.setValue($('#heatUO_b-input-base').val());
    coolUO_b.setValue($('#coolUO_b-input-base').val());
    var checked = $('#isOverride').val() == "true" ? true:false;
    $('#isOverride').attr("checked", checked);
}

function addCommas(nStr)
{
    nStr += '';
    x = nStr.split('.');
    x1 = x[0];
    x2 = x.length > 1 ? '.' + x[1] : '';
    var rgx = /(\d+)(\d{3})/;
    while (rgx.test(x1)) {
        x1 = x1.replace(rgx, '$1' + ',' + '$2');
    }
    return x1 + x2;
}


function setPolicyBuilding() {

    setPolicyProtoBuilding($('#buildingscenario').val(), $('#light_b-input').val(), $('#heat_b-input').val(), $('#cool_b-input').val(), $('#heatUO_b-input').val(), $('#coolUO_b-input').val(), $('#isOverride').is(':checked'));
}


function setPolicyProtoBuilding(buildingId, lightVal, heatVal, coolVal, heatUOVal, coolUOVal, isOverride) {

    var answer = confirm("Send Message to Building Managers?");
    var checked = $('#isOverride').is(':checked');
    var answer_override = true;
    if (!checked) {
        var answer_override = confirm("This building is not set to override the enterprise.  Check the Is Override checkbox if you wish to override the enterprise settings.");
    }
    if (answer && answer_override){
        $.ajax({  
            url: 'sendPolicyBuilding',  
            data: 'buildingId=' + buildingId + '&light-b-input=' + lightVal + '&heat-b-input=' + heatVal + '&cool-b-input=' + coolVal + '&heatUO-b-input=' + heatUOVal + '&coolUO-b-input=' + coolUOVal + '&isOverride=' + isOverride,  
            dataType: 'html',
            success: function( json )
            {
                if (json.indexOf("success") > -1 ) {
                    alert("Message sent");
                } else {
//                    alert("There was an error sending the message");
                }
            },
            error: function()
            {
                alert("There was an error sending the message");
            }
        });
    }
}
