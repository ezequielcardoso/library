function dateFormate(){

var date = new Date();


var year = date.getFullYear();
var month = date.getMonth()+1; //js��0��ʼȡ 
var date1 = date.getDate(); 
var hour = date.getHours(); 
var minutes = date.getMinutes(); 
var second = date.getSeconds();


return(year+"-"+month+"-"+date1+" "+hour+":"+minutes+":"+second);


}