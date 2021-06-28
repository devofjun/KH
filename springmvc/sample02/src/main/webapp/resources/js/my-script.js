/**
 * my-script.js
 */

function changeDateString(timestamp){
	var d = new Date(timestamp);
	var year = d.getFullYear();
	var month = d.getMonth() + 1;
	var date = d.getDate();
	var hour = d.getHours();
	var minute = d.getMinutes();
	var second = d.getSeconds();
	return year + "-" + month + "-" + date  + "-" +  hour  + "-" +  minute  + "-" +  second; 
}