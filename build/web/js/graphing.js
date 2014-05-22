var chart; // globally available

$(document).ready(function() {
    var options = {
    chart: {
        renderTo: 'container_graph',
        type: 'bar'
    },
    xAxis: {
        categories: []
    },
    yAxis: {
        title: {
            text: 'kWh'
        }
    },
    series: []
    };
    
    chart = new Highcharts.Chart(options);
   });
   
function addtograph () {
//    if ($('#exists').val() != "true" ) {
$('#exists').val("true");
var fuel = $('#fuel').val();
var fuelType2 = $('#fuel option:selected').text();
//        alert (meterNum);
 $.ajax({  
    url: 'graphs_addseries',  
    data: 'fuel=' + fuel,  
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
//                var items = json.split(',');
//                var series = {
//                    data: []
//                };
//                $.each(items, function(itemNo, item) {
//                    if (itemNo == 0) {
//                        series.name = meterName;
//                    } else {
//                        series.data.push(parseFloat(item));
//                    }
//                });
//                chart.setTitle({ text: 'Electricity Used'});
//                chart.addSeries(series);
    },
    error: function()
    {
//        alert("error");
    }
});
//   } 
//   else {
//        $.ajax({  
//            url: 'graphs_addseries',  
//            data: 'id=2010',  
//            dataType: 'html',  
//            success: function( json )
//            {
//                var items = json.split(',');
//                alert("success " + items);
//                var series = {
//                    data: []
//                };
//                $.each(items, function(itemNo, item) {
////                            alert(itemNo + " " + item);
//                    if (itemNo == 0) {
//                        series.name = item;
//                    } else {
//                        series.data.push(parseFloat(item));
//                    }
//                });
//                chart.addSeries(series);
//            },
//            error: function()
//            {
//                alert("error");
//            }
//        });
//    }
}

$('#cleargraph').click(function() {
    alert("ouch");
    chart.destroy();
});