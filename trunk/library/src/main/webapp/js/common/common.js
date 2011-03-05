
/**
 * tab选项卡
 */
function tablmyc(tabnumber) { 
	var tabnum; 
	//var treePic; 
	for (i=1;i<=tabnumber;i++) { 
		tabnum = eval('tablm' + i); 
		var tabName='tabid'+ i; 
		document.getElementById(tabName).background="images/tab_titlebg.jpg";
		document.getElementById(tabName).className="menu";
		tabnum.style.display = 'none'; 
	} 
} 
function Showtab(i, tabnumber) { 
	var tabnum = eval('tablm' + i); 
	var tabName='tabid'+ i;
	if (tabnum.style.display == 'none') { 
		tablmyc(tabnumber); 
		document.getElementById(tabName).background="images/tab_title.jpg";
		document.getElementById(tabName).className="title0";
		tabnum.style.display = ''; 
	} 
} 

/**
 * 
 */
function fEvent(sType,oInput){
	switch (sType){
		case "focus" :
			oInput.isfocus = true;
		case "mouseover" :
			oInput.style.borderColor = '#7a95d2';
			oInput.style.background = '#ffffcc';
			break;
		case "blur" :
			oInput.isfocus = false;
		case "mouseout" :
			if(!oInput.isfocus){
				oInput.style.borderColor='#cddeeb';
				oInput.style.background = '#ffffff';
			}
			break;
	}
}

/**
 * 
 */
function test12(i){
	if(i==1){
		document.getElementById("div_yy").style.display="block";
		document.getElementById("ye").style.display="none";
		document.getElementById("yd").style.display="block";
		document.getElementById("yy").style.display="block";
		document.getElementById("yb").style.display="block";
	} else if(i==2){
		document.getElementById("div_yy").style.display="none";
		document.getElementById("ye").style.display="none";
		document.getElementById("yd").style.display="block";
		document.getElementById("yy").style.display="block";
		document.getElementById("yb").style.display="block";
	}else if(i==3){
		document.getElementById("ye").style.display="none";
		document.getElementById("yd").style.display="none";
		document.getElementById("yy").style.display="none";
		document.getElementById("yb").style.display="none";
		document.getElementById("div_yy").style.display="none";
	}
}

/**
 * 
 */
function oncli(){
 	var div1=document.getElementById("tab");
    div1.style.display="block";
   
    // var d=div1.style.display;
    //if(d=="block"){
      //div1.style.display="none";
    //}
    //else{
      // div1.style.display="block"
    //}
	var cols = window.event.srcElement.parentElement.cells;
	//document.getElementById("my").value=cols(0).innerText;
	id = cols(0).innerText;
}