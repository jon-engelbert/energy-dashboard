var isLightDown = false;
var isHeatDown = false;
var isCoolDown = false;
var isHeatUODown = false;
var isCoolUODown = false;

// init code
//$('#savedkWh').show();
//$('#savedemissions').hide();
    
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

var heatiUO = document.getElementById("heatUO-input");
heatiUO.onchange = function () {
	heatUO.setValue(parseInt(this.value));
};

var cooliUO = document.getElementById("coolUO-input");
cooliUO.onchange = function () {
	coolUO.setValue(parseInt(this.value));
};

light.onchange = heat.onchange = cool.onchange = heatUO.onchange = coolUO.onchange = function () {
//    alert('onchange');
	lighti.value = light.getValue();
	heati.value = heat.getValue();
	cooli.value = cool.getValue();
	heatiUO.value = heatUO.getValue();
	cooliUO.value = coolUO.getValue();
	
	if (typeof window.onchange == "function")
		window.onchange();
};

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

// initial values
var moneysavedInit = Number($('#scenario_moneysaved').val().replace(/[^-0-9\.]+/g,""));
var elecsavedInit = Number($('#scenario_elecsaved').val().replace(/[^-0-9\.]+/g,""));
var gassavedInit = Number($('#scenario_gassaved').val().replace(/[^-0-9\.]+/g,""));
//var elecsavedInit = parseFloat($('#scenario_elecsaved').val());
//var gassavedInit = parseFloat($('#scenario_gassaved').val());
var paybackdateInitString = $('#scenario_paybackdate').val();
var paybackdateInitArray = paybackdateInitString.split('/');
paybackdateInit = new Date(paybackdateInitArray[2], paybackdateInitArray[0]-1, paybackdateInitArray[1]);

var lightValInit = lighti.value;
var heatValInit = heati.value;
var coolValInit = cooli.value;
var heatUOValInit = heatiUO.value;
var coolUOValInit = cooliUO.value;

function fixSize() {
	light.recalculate();
	heat.recalculate();
	cool.recalculate();
	heatUO.recalculate();
	coolUO.recalculate();
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
}); 

$('#light-input, #heat-input, #cool-input, #heatUO-input, #coolUO-input').change( function() {
    recalculatePaybackProto();
});

function recalculatePaybackProto() {
//    alert("recalculatePayback");
    recalculatePayback($('#light-input').val(), $('#heat-input').val(), $('#cool-input').val(), $('#heatUO-input').val(), $('#coolUO-input').val());
}

//$('#toggleemissions').click( function() {
//    $('#savedkWh').hide();
//    $('#savedemissions').show();
//}); 
//$('#toggleWh').click( function() {
//    $('#savedkWh').show();
//    $('#savedemissions').hide();
//}); 

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
//                if (inputName == "scenario_moneysaved"){
//                    inputVal = parseFloat(inputVal) + moneysavedInit;
//                    inputVal = addCommas(inputVal);
//                    inputVal = "$" + inputVal;
//                }
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

// the commented out code below was mockup code to show the sliders working.
//    $('#lightVal').val(light.getValue());
//    $('#heatVal').val(heat.getValue());
//    $('#coolVal').val(cool.getValue());

//    var one_month = 1000*60*60*24*31;

    //the changes from inital values
//    var lightValDelta = lightValInit - light.getValue();
//    var heatValDelta = heatValInit - heat.getValue();
//    var coolValDelta = coolValInit - cool.getValue();

    // calculating the new payback and savings
//    var paybackdateNew_ms = paybackdateInit.getTime() - (one_month * lightValDelta) - (one_month * heatValDelta) + (one_month * coolValDelta);
//    var moneysavedNew = moneysavedInit + (moneysavedInit * (lightValDelta/100)) + (moneysavedInit * (heatValDelta/100)) - (moneysavedInit * (coolValDelta/100));
//    var energysavedNew = energysavedInit + (energysavedInit * (lightValDelta/100)) + (energysavedInit * (heatValDelta/100)) - (energysavedInit * (coolValDelta/100));
//    paybackdateNew = new Date(paybackdateNew_ms);

    // adding the new value to the HTML fields
//    $('#scenario_paybackdate').val((paybackdateNew.getMonth()+1) + '/' + paybackdateNew.getDate() + '/' + paybackdateNew.getFullYear());
//    $('#scenario_moneysaved').val("$" + moneysavedNew.toFixed(2));
//    $('#scenario_elecsaved').val(energysavedNew.toFixed(2) + " gWh");
//    $('#scenario_gassaved').val(energysavedNew.toFixed(2) + " gWh");
}

function setPolicy() {

    setPolicyProto($('#light-input').val(), $('#heat-input').val(), $('#cool-input').val(), $('#heatUO-input').val(), $('#coolUO-input').val());
}

function setPolicyBuilding() {

    setPolicyProtoBuilding($('#light-input').val(), $('#heat-input').val(), $('#cool-input').val(), $('#heatUO-input').val(), $('#coolUO-input').val());
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

function setPolicyProtoBuilding(lightVal, heatVal, coolVal, heatUOVal, coolUOVal) {

    var answer = confirm("Send Message to Building Managers?")
    if (answer){
        $.ajax({  
            url: 'sendPolicyBuilding',  
            data: 'light-b-input=' + lightVal + '&heat-b-input=' + heatVal + '&cool-b-input=' + coolVal + '&heatUO-b-input=' + heatUOVal + '&coolUO-b-input=' + coolUOVal,  
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


var chart; // globally available
var fuelType = 'all';

$(document).ready(function() {
// alert('about to graph');
    drawChart(fuelType);
    
    $('#selectFuel').change( function () {
        var fuel = $('#selectFuel').val();
        drawChart(fuel);
    })
   });

function drawChart (fuelType, selectType, selectMonth, selectYear) {
     var options = {
        chart: {
            renderTo: 'container_graph',
            animation: false,
            type: 'bar'
        },
        tooltip: {
            formatter: function() {
                var commaNum = addCommas(this.y);
                return commaNum;
            }
        },
        xAxis: {
            categories: []
        },
        yAxis: {
            title: {
                text: 'Dollars'
            }
        },
        series: []
        };

        chart = new Highcharts.Chart(options);
        getDataByYear(fuelType, selectYear);
//        if (selectType == 0) {
//            //Month versus Last Month
//            getDataByMonth(mID, selectMonth, selectYear);
//        } else if (selectType == 1) {
//            //Month versus Last Year
//            getDataByMonthPrevYear(mID, selectMonth, selectYear);
//        } else if (selectType == 2) {
//            //Last Year
//            getDataByYear(mID, selectYear);
//        } 
        
}

function getDataByMonthPrevYear(mID, selectMonth, selectYear) {
    $.ajax({  
    url: 'graphs_addseriesbymonthyear',  
    data: 'id=' + mID + '&year='+ selectYear + '&month='+ selectMonth,  
    dataType: 'html',  
    success: function( json )
    {
        var seriesArrays = json.split(';');
        $.each(seriesArrays, function(itemNo, seriesArray ) {
            var items = seriesArray.split(',');
    //                alert("success " + items);
            var series = {
                data: []
            };
            $.each(items, function(itemNo, item) {
    //                            alert(itemNo + " " + item);
                if (itemNo == 0) {
                    series.name = item;
                } else {
                    series.data.push(parseFloat(item));
                }
            });
            chart.setTitle({text: 'Usage'});
            chart.addSeries(series);
        });
        chart.xAxis[0].setCategories(['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 
                'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']);

    },
    error: function()
    {
//        alert("error");
    }
    });
}

function getDataByMonth(mID, selectMonth, selectYear) {
    $.ajax({  
    url: 'graphs_addseriesbymonth',  
    data: 'id=' + mID + '&year='+ selectYear + '&month='+ selectMonth,  
    dataType: 'html',  
    success: function( json )
    {
        var seriesArrays = json.split(';');
        $.each(seriesArrays, function(itemNo, seriesArray ) {
            var items = seriesArray.split(',');
    //                alert("success " + items);
            var series = {
                data: []
            };
            $.each(items, function(itemNo, item) {
    //                            alert(itemNo + " " + item);
                if (itemNo == 0) {
                    series.name = item;
                } else {
                    series.data.push(parseFloat(item));
                }
            });
            chart.setTitle({text: 'Usage'});
            chart.addSeries(series);
        });
        chart.xAxis[0].setCategories(['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 
                'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']);

    },
    error: function()
    {
//        alert("error");
    }
    });
}


function getDataByYear(mID, selectYear) {
    $.ajax({  
    url: 'graphs_addseriesbyyear',  
    data: 'fuel=' + mID + '&year='+ selectYear,  
    dataType: 'html',  
    success: function( json )
    {
        var seriesArrays = json.split(';');
        $.each(seriesArrays, function(itemNo, seriesArray ) {
            var items = seriesArray.split(',');
    //                alert("success " + items);
            var series = {
                data: []
            };
            $.each(items, function(itemNo, item) {
    //                            alert(itemNo + " " + item);
                if (itemNo == 0) {
                    series.name = item;
                } else {
                    series.data.push(parseFloat(item));
                }
            });
            chart.setTitle({text: 'Usage'});
            chart.addSeries(series);
        });
        chart.xAxis[0].setCategories(['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 
                'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']);

    },
    error: function()
    {
//        alert("error");
    }
    });
}
$('#selectbuilding').change(function () {
    siteID = $('#selectbuilding').val();
    selectType = $('#selectType').val();
    selectMonth = $('#selectMonth').val();
    selectYear = $('#selectYear').val();
    drawChart(siteID, selectType, selectMonth, selectYear);
});
$('#selectType').change(function () {
    siteID = $('#selectbuilding').val();
    selectType = $('#selectType').val();
    selectMonth = $('#selectMonth').val();
    selectYear = $('#selectYear').val();
    drawChart(siteID, selectType, selectMonth, selectYear);
});
$('#selectMonth').change(function () {
    siteID = $('#selectbuilding').val();
    selectType = $('#selectType').val();
    selectMonth = $('#selectMonth').val();
    selectYear = $('#selectYear').val();
    drawChart(siteID, selectType, selectMonth, selectYear);
});
$('#selectYear').change(function () {
    siteID = $('#selectbuilding').val();
    selectType = $('#selectType').val();
    selectMonth = $('#selectMonth').val();
    selectYear = $('#selectYear').val();
    drawChart(siteID, selectType, selectMonth, selectYear);
});


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