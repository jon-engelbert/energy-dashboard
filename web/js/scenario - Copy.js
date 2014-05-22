var isLightDown = false;
var isHeatDown = false;
var isCoolDown = false;
var isHeatUODown = false;
var isCoolUODown = false;
//---------
var isLight_bDown = false;
var isHeat_bDown = false;
var isCool_bDown = false;
var isHeatUO_bDown = false;
var isCoolUO_bDown = false;

var light = new Slider(document.getElementById("light-slider"), document.getElementById("light-slider-input"));
light.setMinimum(25);
light.setMaximum(100);
var heat = new Slider(document.getElementById("heat-slider"), document.getElementById("heat-slider-input"));
heat.setMinimum(55);
heat.setMaximum(85);
var cool = new Slider(document.getElementById("cool-slider"), document.getElementById("cool-slider-input"));
cool.setMinimum(55);
cool.setMaximum(85);
var heatUO = new Slider(document.getElementById("heatUO-slider"), document.getElementById("heatUO-slider-input"));
heatUO.setMinimum(55);
heatUO.setMaximum(85);
var coolUO = new Slider(document.getElementById("coolUO-slider"), document.getElementById("coolUO-slider-input"));
coolUO.setMinimum(55);
coolUO.setMaximum(85);
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
//---------
//var light_z = new Slider(document.getElementById("light_z-slider"), document.getElementById("light_z-slider-input"));
//light_z.setMinimum(50);
//light_z.setMaximum(100);
//var heat_z = new Slider(document.getElementById("heat_z-slider"), document.getElementById("heat_z-slider-input"));
//heat_z.setMinimum(60);
//heat_z.setMaximum(80);
//var cool_z = new Slider(document.getElementById("cool_z-slider"), document.getElementById("cool_z-slider-input"));
//cool_z.setMinimum(60);
//cool_z.setMaximum(80);
//var heatUO_z = new Slider(document.getElementById("heatUO_z-slider"), document.getElementById("heatUO_z-slider-input"));
//heatUO_z.setMinimum(60);
//heatUO_z.setMaximum(80);
//var coolUO_z = new Slider(document.getElementById("coolUO_z-slider"), document.getElementById("coolUO_z-slider-input"));
//coolUO_z.setMinimum(60);
//coolUO_z.setMaximum(80);

//=====================

var lighti = document.getElementById("light-input");
lighti.onchange = function () {
	light.setValue(parseInt(this.value));
};

var heati = document.getElementById("heat-input");
heati.onchange = function () {
	heat.setValue(parseInt(this.value));
};

var cooli = document.getElementById("cool-input");
cooli.onchange = function () {
	cool.setValue(parseInt(this.value));
};

var heatUOi = document.getElementById("heatUO-input");
heatUOi.onchange = function () {
	heatUO.setValue(parseInt(this.value));
};

var coolUOi = document.getElementById("coolUO-input");
coolUOi.onchange = function () {
	coolUO.setValue(parseInt(this.value));
};
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
//---------
//var light_zi = document.getElementById("light_z-input");
//light_zi.onchange = function () {
//	light_z.setValue(parseInt(this.value));
//};
//
//var heat_zi = document.getElementById("heat_z-input");
//heat_zi.onchange = function () {
//	heat_z.setValue(parseInt(this.value));
//};
//
//var cool_zi = document.getElementById("cool_z-input");
//cool_zi.onchange = function () {
//	cool_z.setValue(parseInt(this.value));
//};
//
//var heatUO_zi = document.getElementById("heatUO_z-input");
//heatUO_zi.onchange = function () {
//	heatUO_z.setValue(parseInt(this.value));
//};
//
//var coolUO_zi = document.getElementById("coolUO_z-input");
//coolUO_zi.onchange = function () {
//	coolUO_z.setValue(parseInt(this.value));
//};

//=====================

light.onchange = heat.onchange = cool.onchange = heatUO.onchange = coolUO.onchange = function () {
	lighti.value = light.getValue();
	heati.value = heat.getValue();
	cooli.value = cool.getValue();
	heatUOi.value = heatUO.getValue();
	coolUOi.value = coolUO.getValue();
	
	if (typeof window.onchange == "function")
		window.onchange();
};

// fetching the setpoints from the hidden inputs on the page
light.setValue($('#lightlimit').val());
heat.setValue($('#heatlimit').val());
cool.setValue($('#coollimit').val());
heatUO.setValue($('#heatUOlimit').val());
coolUO.setValue($('#coolUOlimit').val());
$('#light-input-base').val($('#lightlimit').val());
$('#heat-input-base').val($('#heatlimit').val());
$('#cool-input-base').val($('#coollimit').val());
$('#heatUO-input-base').val($('#heatUOlimit').val());
$('#coolUO-input-base').val($('#coolUOlimit').val());

var lightValInit = lighti.value;
var heatValInit = heati.value;
var coolValInit = cooli.value;
var heatUOValInit = heatUOi.value;
var coolUOValInit = coolUOi.value;
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
//light_z.onchange = heat_z.onchange = cool_z.onchange = heatUO_z.onchange = coolUO_z.onchange = function () {
//	light_zi.value = light_z.getValue();
//	heat_zi.value = heat_z.getValue();
//	cool_zi.value = cool_z.getValue();
//	heatUO_zi.value = heatUO_z.getValue();
//	coolUO_zi.value = coolUO_z.getValue();
//	
//	if (typeof window.onchange == "function")
//		window.onchange();
//};
//
//light_z.setValue(75);
//heat_z.setValue(70);
//cool_z.setValue(74);
//heatUO_z.setValue(64);
//coolUO_z.setValue(78);
//
//var light_zValInit = light_zi.value;
//var heat_zValInit = heat_zi.value;
//var cool_zValInit = cool_zi.value;
//var heatUO_zValInit = heatUO_zi.value;
//var coolUO_zValInit = coolUO_zi.value;

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
	light.recalculate();
	heat.recalculate();
	cool.recalculate();
	heatUO.recalculate();
	coolUO.recalculate();
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

$('#light-slider').mousedown( function() {
    isLightDown = true;
});

$('#heat-slider').mousedown( function() {
    isHeatDown = true;
});

$('#cool-slider').mousedown( function() {
    isCoolDown = true;
});

$('#heatUO-slider').mousedown( function() {
    isHeatUODown = true;
});

$('#coolUO-slider').mousedown( function() {
    isCoolUODown = true;
});

$(document).mouseup(function(){
    if(isLightDown){
        isLightDown = false;
        recalculatePaybackProto();
    }
    if(isHeatDown){
        isHeatDown = false;
        recalculatePaybackProto();
    }
    if(isCoolDown){
        isCoolDown = false;
        recalculatePaybackProto();
    }
    if(isHeatUODown){
        isHeatUODown = false;
        recalculatePaybackProto();
    }
    if(isCoolUODown){
        isCoolUODown = false;
        recalculatePaybackProto();
    }
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

$('#light-input, #heat-input, #cool-input, #heatUO-input, #coolUO-input').change( function() {
    recalculatePaybackProto();
});

function recalculatePaybackProto() {
//    alert("recalculatePayback");
    recalculatePayback($('#light-input').val(), $('#heat-input').val(), $('#cool-input').val(), $('#heatUO-input').val(), $('#coolUO-input').val());
};

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

function recalculatePayback(lightVal, heatVal, coolVal, heatUOVal, coolUOVal) {
    $.ajax({  
        url: 'dashboard_recalc',  
        data: 'light-input=' + lightVal + '&heat-input=' + heatVal + '&cool-input=' + coolVal + '&heatUO-input=' + heatUOVal + '&coolUO-input=' + coolUOVal,  
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

function toggleBuildingDiv() {
	var ele = document.getElementById("buildingscenariodiv");
	var text = document.getElementById("displayBuildingDiv");
	if(ele.style.display == "block") {
            ele.style.display = "none";
//            $('#buildingscenariodiv').slideUp('fast');
            text.innerHTML = "Show Building Details";
  	}
	else {
            ele.style.display = "block";
//            $('#buildingscenariodiv').slideDown('fast');
            text.innerHTML = "Hide Building Details";
	}
        fixSize();
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

function resetValues () {
    $('#scenario_paybackdate').val(paybackdateInitString);
    $('#scenario_moneysaved').val("$" + moneysavedInit);
    $('#scenario_elecsaved').val(elecsavedInit + " gWh");
    $('#scenario_gassaved').val(gassavedInit + " BTU");
    light.setValue(lightValInit);
    heat.setValue(heatValInit);
    cool.setValue(coolValInit);
    heatUO.setValue(heatUOValInit);
    coolUO.setValue(coolUOValInit);
}

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

function setPolicy() {

    setPolicyProto($('#light-input').val(), $('#heat-input').val(), $('#cool-input').val(), $('#heatUO-input').val(), $('#coolUO-input').val());
}

function setPolicyBuilding() {

    setPolicyProtoBuilding($('#buildingscenario').val(), $('#light_b-input').val(), $('#heat_b-input').val(), $('#cool_b-input').val(), $('#heatUO_b-input').val(), $('#coolUO_b-input').val(), $('#isOverride').is(':checked'));
}

function setPolicyProto(lightVal, heatVal, coolVal, heatUOVal, coolUOVal) {

    var answer = confirm("Send Message to Building Managers?")
    if (answer){
        $.ajax({  
            url: 'sendPolicy',  
            data: 'light-input=' + lightVal + '&heat-input=' + heatVal + '&cool-input=' + coolVal + '&heatUO-input=' + heatUOVal + '&coolUO-input=' + coolUOVal,  
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
    else{
            alert("Message Cancelled")
    }
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
