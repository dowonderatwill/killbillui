function changeBizDate(){

	var selectedDate = $("input[type='date']").val();
	
	var url = "/changeDate?date="+selectedDate;
	
	$('#spanBizDate').text('wip...');
	
	$.post(url,function(data,status){
		$('#spanBizDate').text(data);
	});
	
}