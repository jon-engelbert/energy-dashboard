var chart1; // globally available
var chart2; // globally available
var chart3; // globally available

// === Initializing Charts ===//
var data1 = [8474, 26524, 3561];
var temp = [];

function tokwh(element, index, array) {
    var tempnum = element/.103;
    temp.push(Math.round(tempnum));
}

$(document).ready(function() {
    //--- Chart 1
    var options1 = {
        chart: {
            renderTo: 'container_graph1',
            animation: false,
            type: 'column'
        },
        legend: {
            enabled: false
        },
        title: {
            text: 'Energy Cost by Building'
        },
        subtitle: {
            text: 'Year to date'
        },
        xAxis: {
            categories: ['Office', 'Factory', 'Warehouse']
        },
        yAxis: {
            title: {
                text: '$ Dollars'
            }
        },
        series: [{
            data: data1
        }]
    };
    //--- Chart 2
    var options2 = {
        chart: {
            renderTo: 'container_graph2',
            animation: false,
            type: 'pie'
        },
        title: {
            text: 'Energy Cost by End Use'
        },
        subtitle: {
            text: 'Year to Date'  
        },
        tooltip: {
            formatter: function() {
                return '<b>'+ this.point.name +'</b>: $'+ this.y;
            }
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: true,
                    color: '#000000',
                    connectorColor: '#000000',
                    formatter: function() {
                        return '<b>' + this.point.name +'</b><br/>$'+ this.y;
                    }
                }
            }
        },
        series: [{
            type: 'pie',
            data: [
            ['Domestic Hot Water',    2987],
            ['Plug Loads',  8239],
            ['Heating',   45201],
            ['Cooling',       30405],
            ['Lighting',     15209],
            ]
        }]
    };
    //--- Chart 3
    var options3 = {
        chart: {
            renderTo: 'container_graph3',
            animation: false,
            type: 'line'
        },
        xAxis: {
            categories: []
        },
        yAxis: {
            title: {
                text: 'Cost ($)'
            }
        },
        series: []
    };
    
    chart1 = new Highcharts.Chart(options1);
    chart2 = new Highcharts.Chart(options2);
    chart3 = new Highcharts.Chart(options3);
});
   
// === Populating Charts with Data ===//

// --- Initial Data for Chart 3 ---//

$.ajax({  
    url: 'graphs_monthlyEnergyCosts',  
    //    data: 'id=' + meterNum,  
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
                    if (item == "1") {name = 'Lighting'};
                    if (item == "2") {name = 'Plug Load'};
                    if (item == "4") {name = 'Heating'};
                    if (item == "11") {name = 'Hot Water'};
                    if (item == "14") {name = 'Cooling'};
                    series.name = name;
                } else {
                    series.data.push(parseFloat(item));
                }
            });
            chart3.setTitle({
                text: 'Monthly Energy Costs'
            });
            chart3.addSeries(series);
        });
        chart3.xAxis[0].setCategories(['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 
            'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']);
    },
    error: function()
    {
//        alert("error");
    }
});

// --- Initial Data for Chart 2 ---//


// --- Initial Data for Chart 3 ---//


// === Updating series ===//

$('#kwh').click(function() {
    alert('here');
    data1.forEach(tokwh);
    alert(temp);
    chart1.series[0].setData(temp);
    alert("done");
    $('#kwh').attr('disabled', 'disabled');
});