charset = "euc-kr";

var config = {
	type : 'pie',
	data : {
		datasets : [ {
			data : [ 1, 1 ],
			backgroundColor : [ window.chartColors.red,
					window.chartColors.orange, window.chartColors.yellow,
					window.chartColors.green, window.chartColors.blue, ],
			label : 'Alldataset 1'
		} ],
		labels : [ 'SQLinjection', '취약한인증', ]
	},
	options : {
		responsive : true
	}
};

window.onload = function() {
	var ctx = document.getElementById('chart-area').getContext('2d');
	window.myPie = new Chart(ctx, config);
	
	var ctx2 = document.getElementById('canvas').getContext('2d');
	window.myBar = new Chart(ctx2, {
		type : 'bar',
		data : barChartData,
		options : {
			responsive : true,
			legend : {
				position : 'top',
			},
			title : {
				display : true,
				text : '취약점 종합 통계'
			}
		}
	});
	
};
// 취약점 대응방안 팝업창
$(document).ready(function() {
	$('[data-toggle="popover"]').popover();
});


