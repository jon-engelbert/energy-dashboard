var chart; // globally available

// === Initializing Charts ===//

// --- Initial Data ---//

var data = [50, 175, 118, 145, 97, 99, 40];

$(document).ready(function() {

    var options = {
        chart: {
            renderTo: 'container_graph',
            animation: false,
            type: 'column'
        },
        legend: {
            enabled: false
        },
        title: {
            text: 'Energy Use by Building, Today'
        },
        xAxis: {
            categories: ['Engineering', 'Finance', 'R & D', 'Support', 'Shipping', 'Executive', 'Facilities']
        },
        yAxis: {
            title: {
                text: 'Wh (x 1000)'
            }
        },
        series: [{
            data: data
        }]
    };
    
    chart = new Highcharts.Chart(options);
    
    $('#graphoptions').hide();

});
// === Populating Charts with Data ===//

function toggleGraphOptions() {
	var ele = document.getElementById("graphoptions");
	var text = document.getElementById("graphoptionstext");
	if(ele.style.display == "block") {
    		ele.style.display = "none";
		text.innerHTML = "Show Graph Options";
  	}
	else {
		ele.style.display = "block";
		text.innerHTML = "Hide Graph Options";
	}
}