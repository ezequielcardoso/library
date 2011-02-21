var openURLRequestMap = new Array();

function isIE(){
	//return (navigator.appName.indexOf("Netscape") >= 0 )
	return ( navigator.appName.indexOf("Microsoft") >= 0 );
}

function OpenURLRequest_addParam(key, value){
	var list = this.paramMap[key];
	if (list == null){
		this.paramMap[key] = list = new Array();
		var keys = this.paramMap.keys;
		keys[keys.length]= key;
	}
	list[list.length]=value;
}

function OpenURLRequest_renderURL()
{
	var rt = this.baseURL+"?";
	for (var i = 0; i < this.paramMap.keys.length; i++){
		var key = this.paramMap.keys[i];
		var list = this.paramMap[key];
		for (var j = 0; j < list.length; j++){
			//rt += key +"=" + encodeURIComponent(list[j])+"&";
			rt += key +"=" + (list[j])+"&";
		}
	}
	return rt;
}

function OpenURLRequest_send_1(isNewWindow){
	var cf = document.getElementById("form_openurl_" + this.id);
	var ah = document.getElementById("a_openurl_" + this.id);
	if (cf == null && this.baseURL.indexOf("?") < 0 && this.paramMap.keys.length > 0){
		cf = document.createElement("form");
		cf.action= this.baseURL;
		cf.method = this.httpMethod;
		if (isNewWindow){
			cf.target = this.id;
		}
		cf.setAttribute("accept-charset", this.charset);
		cf.setAttribute("id", "form_openurl_" + this.id);
		cf['accept-charset'] = this.charset;
		cf.style.visibility = "hidden";
		for (var i = 0; i < this.paramMap.keys.length; i++){
			var key = this.paramMap.keys[i];
			var list = this.paramMap[key];
			
			for (var j = 0; j < list.length; j++){
				var input = document.createElement("input");
				input.name = key;
				input.value = list[j];
				cf.appendChild(input);
			}
		}
		document.body.appendChild(cf);
	}else{
		ah = document.createElement("a");
		if (isNewWindow){
			ah.target=this.id;
		}
		if (this.paramMap.keys.length == 0){
			ah.href = this.baseURL;
		}else{
			ah.href=this.renderURL();
		}
		ah.setAttribute("id", "a_openurl_" + this.id);
		document.body.appendChild(ah);
	}
	var iecharset;
	if (isIE()){
			iecharset = document.charset;
			document.charset=this.charset;//tmp
	}
	if (cf != null){
		cf.submit();
	}else{
		ah.click();
	}
	if (isIE()){
		document.charset=iecharset;//restore to it
	}
}


function OpenURLRequest_send(){
	this.send_1(true);
}

function OpenURLRequest_IE_send(){
	var ifm = document.getElementById("frame_openurl_" + this.id);
	var cf;
	if (ifm == null){
		ifm = document.createElement("iframe");
		ifm.style.visibility = "hidden";
		ifm.document.write("<html><head>");
		ifm.document.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=" + this.charset +"\" />");
		ifm.document.write("</head><body></body></html>");
		cf = ifm.document.createElement("form");
		cf.action= this.baseURL;
		cf.method = this.httpMethod;
		cf.target = this.id;
		cf.setAttribute("accept-charset", this.charset);
		cf.setAttribute("id", "form_openurl_" + this.id);
		cf['accept-charset'] = this.charset;
		cf.style.visibility = "hidden";
		for (var i = 0; i < this.paramMap.keys.length; i++){
			var key = this.paramMap.keys[i];
			var list = this.paramMap[key];
			
			for (var j = 0; j < list.length; j++){
				var input = ifm.document.createElement("input");
				input.name = key;
				input.value = list[j];
				cf.appendChild(input);
			}
		}
		ifm.document.body.appendChild(cf);
		alert(ifm.document.body.innerHTML);
		document.body.appendChild(ifm);
	}else{
		cf = ifm.document.forms[0];
	}
	cf.submit();
}

function OpenURLRequest(id, baseURL, httpMethod, charset) {
	this.id = id;
	this.baseURL = baseURL;
	this.httpMethod = httpMethod;
	this.paramMap = new Array();
	this.paramMap.pro = 0;
	this.paramMap.keys = new Array();
	this.addParam = OpenURLRequest_addParam;
	this.renderURL = OpenURLRequest_renderURL;
	//this.send = isIE() ? OpenURLRequest_IE_send : OpenURLRequest_send;
	this.send = OpenURLRequest_send;
	this.send_1 = OpenURLRequest_send_1;
	if (charset == null)
		this.charset = "UTF-8";
	else
		this.charset = charset;
}

function createOpenURLRequest(id, baseURL, httpMethod, charset) {
	return (openURLRequestMap[id] =  new OpenURLRequest(id, baseURL, httpMethod, charset));
}

function getOpenURLRequest(id){
	return openURLRequestMap[id];
}

function rlsc_addParam(req, key, value){
	if (key == null || key.length == 0)
		return;
	req.addParam(key, value);
}

function rlsc_sendJArticleRequest(isNewWindow, rlsBaseURL, issn, eissn, journalTitle, articleTitle, volume,issue, startPage){
	var req = new OpenURLRequest(new Date().getTime(), rlsBaseURL, "get", "UTF-8");
	rlsc_addParam(req, "ver","OPENURL01CX");
	rlsc_addParam(req, "fmt", "journal");
	rlsc_addParam(req, "genre", "article");
	rlsc_addParam(req, "issn", issn);
	rlsc_addParam(req, "eissn", eissn);
	rlsc_addParam(req, "jtitle", journalTitle);
	rlsc_addParam(req, "atitle", articleTitle);
	rlsc_addParam(req, "volume", volume);
	rlsc_addParam(req, "issue", issue);
	rlsc_addParam(req, "spage", startPage);	
	req.send_1(isNewWindow);
}

function rlsc_sendJournalRequest(isNewWindow, rlsBaseURL, issn, eissn, journalTitle, volume,issue){
	var req = new OpenURLRequest(new Date().getTime(), rlsBaseURL, "get", "UTF-8");
	rlsc_addParam(req, "ver","OPENURL01CX");
	rlsc_addParam(req, "fmt", "journal");
	rlsc_addParam(req, "genre", "journal");
	rlsc_addParam(req, "issn", issn);
	rlsc_addParam(req, "eissn", eissn);
	rlsc_addParam(req, "jtitle", journalTitle);
	rlsc_addParam(req, "volume", volume);
	rlsc_addParam(req, "issue", issue);
	req.send_1(isNewWindow);
}

function rlsc_sendBookRequest(isNewWindow, rlsBaseURL, isbn, bookTitle){
	var req = new OpenURLRequest(new Date().getTime(), rlsBaseURL, "get", "UTF-8");
	rlsc_addParam(req, "ver","OPENURL01CX");
	rlsc_addParam(req, "fmt", "book");
	rlsc_addParam(req, "genre", "book");
	rlsc_addParam(req, "isbn", isbn);
	rlsc_addParam(req, "btitle", bookTitle);
	req.send_1(isNewWindow);
}



function rlsc_sendDCRequest(isNewWindow, rlsBaseURL, type, title, creator, date, contributor){
	var req = new OpenURLRequest(new Date().getTime(), rlsBaseURL, "get", "UTF-8");
	rlsc_addParam(req, "ver","OPENURL01CX");
	rlsc_addParam(req, "fmt", "dc");
	rlsc_addParam(req, "title", title);
	rlsc_addParam(req, "creator", creator);
	rlsc_addParam(req, "type", type);
	rlsc_addParam(req, "date", date);
	rlsc_addParam(req, "contributor", contributor);
	req.send_1(isNewWindow);
}
