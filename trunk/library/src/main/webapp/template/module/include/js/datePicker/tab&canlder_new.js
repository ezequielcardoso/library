


/************ TAB 选项卡效果  *************/

	var textPadding = 3; // Padding at the left of tab text - bigger value gives you wider tabs
	var strictDocType = true;
	var MSIE = navigator.userAgent.indexOf('MSIE')>=0?true:false;
	var navigatorVersion = navigator.appVersion.replace(/.*?MSIE (\d\.\d).*/g,'$1')/1;
	var TabsLengthMax = 100;


function getLeft(div)
{
    var left = 0;
    while(div!= null)
    {
        left += div.offsetLeft;
        div= div.offsetParent; 
    }      
    return left; 
}
function getTop(div)
{
    var top = 0;
    while(div!= null)
    {
        top += div.offsetTop;
        div= div.offsetParent; 
    }      
    return top; 
}
function frameLoaded()
{
	if(tabGroup)	tabGroup.Loaded();
	//alert(event.srcElement.name);
}



  Object.prototype.setTimeout=function(m,interval)
  {
	var c=this;
	return window.setTimeout(function(){m.apply(c)},interval)
  };

  Object.prototype.eventHandler=function(handler)
  {
		var b=this;
		b=b;
		return function(c)
		       {
					if(!c)
					{
					   c=window.event;
					}
					if(c&&!c.target)
					{
					  c.target=c.srcElement;
					}
					b[handler](c);
		       }
  };

	function rolloverTab()
	{
		event.srcElement.style.color = "#0000aa";
		/*
        return;
        if(this.className.indexOf('tabInactive')>=0){
			this.className='inactiveTabOver';
			var img = this.getElementsByTagName('IMG')[0];
			img.src = 'images/tab_right_over.gif';
		}
        */
	}
	function rolloutTab()
	{
		event.srcElement.style.color = "#000000";
		/*
        return;
		if(this.className ==  'inactiveTabOver'){
			this.className='tabInactive';
			var img = this.getElementsByTagName('IMG')[0];
			img.src = 'images/tab_right_inactive.gif';
		}
        */
	}

		/*

	function tabClick()
	{
		tabGroup.showTab(this.id.replace(/[^\d]/g,''));
	}

	function tabDblClick()
	{
		tabGroup.Delete(this.id.replace(/[^\d]/g,''));
	}
        */

	function setPadding(obj,padding){
		var span = obj.getElementsByTagName('SPAN')[0];
		span.style.paddingLeft = padding + 'px';
		span.style.paddingRight = padding + 'px';
	}
	
function OpenTab(tabname, url, canscroll)
{
	if(parent.mainFrame.tabGroup == null)  return;
	parent.mainFrame.tabGroup.OpenWindow(false, tabname, tabname, url, true, canscroll);
}

function LoadPageStop()
{
    //alert(top.tabGroup);
    if(top.tabGroup != null)	top.tabGroup.Loaded();;
}


function _TABGROUP(width,height)
{
	this.Tabs = new Array();
	this.splitTabs = new Array();
	this.baseDiv = null;
	this.divLoad = null;
	this.Tabs.length = 0;
	this.activeTabIndex = -1;

    this.tabDiv = document.createElement('DIV');
    this.tabDiv.className = 'macrolong_tabPane';

	this.baseDiv = document.getElementById('macrolong_tabView');
	width = width + '';
	if(width.indexOf('%')<0)width= width + 'px';
	this.baseDiv.style.width = width;
	this.width = width;

    height = height + '';
	if(height.length>0){
		if(height.indexOf('%')<0)height= height + 'px';
		this.baseDiv.style.height = height;
	}
	this.height = height;

	this.baseDiv.appendChild(this.tabDiv);

	this.divLoad = document.createElement("DIV");
	//this.divLoad.innerHTML = "<table border=0 width=100% style=\"filter:alpha(opacity=60);\" height=100% bgcolor=white><tr><td align=center><img src=images/loadnew.gif width=120></td></tr></table>";
	this.divLoad.style.position="absolute";
	this.divLoad.style.left = 0 ;
	this.divLoad.style.width = this.width ;
	this.divLoad.style.height = this.height;
	this.divLoad.style.zIndex=100000;
	
	this.baseDiv.appendChild(this.divLoad);


	this.resize = function(w,h)
	{
		if(w>0)
		{
		this.width = w;
		this.height = h;		
		}
		else
		{
			this.width  = document.body.clientWidth  - 210;
			this.height = document.body.clientHeight - 175;
			if(this.width<810)	this.width = 810;
			if(this.height<600)	this.height = 600;
		}
//		alert("" + h + " " + this.height);
		this.baseDiv.style.height = this.height;
		this.baseDiv.style.width = this.width;
		for(var i=0; i<this.Tabs.length; i++)
			{
			this.Tabs[i].win.style.width = this.width;
			this.Tabs[i].win.style.height = this.height;
			}
		if(this.divLoad)
		{
		this.divLoad.style.width = this.width ;
		this.divLoad.style.height = this.height;
		}
	}


	this.Add = function (f)		//	f   as    _TAB
		{
			this.Tabs[this.Tabs.length] = f;
            this.tabDiv.appendChild(this.Tabs[this.Tabs.length-1].menuDiv);
			this.Tabs[(this.Tabs.length-1)].menuDiv.id = 'tabTab' + (this.Tabs.length-1);
            this.Tabs[(this.Tabs.length-1)].bodyDiv.id = 'tabView' + (this.Tabs.length-1);
            this.Tabs[(this.Tabs.length-1)].img.id = 'tabImage' + (this.Tabs.length-1);
            this.baseDiv.appendChild(this.Tabs[(this.Tabs.length-1)].bodyDiv);
//			this.Tabs.length ++;
		}

	this.OpenWindow = function (isnew, n, cn, u, cclose, cscroll)		//	f   as    _TAB
		{
			if(!isnew)
			{
					for(var i=0; i<this.Tabs.length; i++)
					{
					if(this.Tabs[i].ownName==n)
							{	
								this.Tabs[i].setTitle(cn);
								this.Tabs[i].load(u);	
								if(this.activeTabIndex != i)	this.showTab(i);
            						if(i>TabsLengthMax)   break;
									return;	}
					}
			}

			var tab = new _TAB(this, n, cn, u, cclose, cscroll);
			
			this.Add(tab);
			this.showTab(this.Count() - 1);
			return;
		}
		
	this.switchTab = function (index)	
	{
			if(isNaN(index))
			{
				for(var i=0; i<this.Tabs.length; i++)
					if( this.Tabs[i].ownName == index )
								if(this.activeTabIndex != i)	this.showTab(i);
			}
			else
			{
				if(parseInt(index) < this.Tabs.length)
								if(this.activeTabIndex != parseInt(index))	this.showTab(parseInt(index));
			}
			return;
	}
	
		
	this.Item = function (index)
		{
			if(isNaN(index))
			{
				for(var i=0; i<this.Tabs.length; i++)
					if( this.Tabs[i].ownName == index )
						return this.Tabs[i];
			}
			else
			{
				if(parseInt(index) < this.Tabs.length)
						return this.Tabs[parseInt(index)];
			}
			return null;
		}
		
	this.Count = function ()
		{
			return(this.Tabs.length);
		}

	this.Delete	= function (index)
		{
			if(isNaN(index))
			{
				for(var i=0; i<this.Tabs.length; i++)
					if(this.Tabs[i].ownName == index)
						this.Delete(i);
			}
			else
			{
				if(parseInt(index) < this.Tabs.length)	{
				    this.close(parseInt(index));
					for(var j = parseInt(index); j<this.Tabs.length - 1; j++)
					    {
						this.Tabs[j] = this.Tabs[j+1];
			            this.Tabs[j].menuDiv.id = 'tabTab' + j;
                        this.Tabs[j].bodyDiv.id = 'tabView' + j;
                        this.Tabs[j].img.id = 'tabImage' + j;
                        if(j>TabsLengthMax)   break;
						}

					this.Tabs.length --;
					}

				if(parseInt(index) < this.activeTabIndex)
				    this.showTab(this.activeTabIndex - 1);
				else
				if(parseInt(index) == this.activeTabIndex)
				{
				    if(this.activeTabIndex == 0)
				    {
				       this.activeTabIndex = -1;
                       this.showTab(0);
                    }
				    else
                       this.showTab(this.activeTabIndex - 1);
                }
			}
		}


	this.Clear	= function ()
		{
			for(var i=0; i<this.Tabs.length; i++)
			    {
                this.baseDiv.removeChild(this.Tabs[i].bodyDiv)
                this.tabDiv.removeChild(this.Tabs[i].menuDiv)
                if(i>TabsLengthMax)   break;
			    }
            this.Tabs = new Array();
			this.Tabs.length = 0;
		}


	this.close	= function (index)
		{
            if (this.baseDiv.childNodes)
            {
                this.baseDiv.removeChild(this.Item(index).bodyDiv)
                this.tabDiv.removeChild(this.Item(index).menuDiv)
            }
		}

	this.closeAll	= function ()
	{

        if (this.baseDiv.childNodes)
        {
           for (var i = 0; i < this.baseDiv.childNodes.length; i++)
           {
            if(this.baseDiv.childNodes[i].className == "macrolong_aTab")
                  this.baseDiv.removeChild(this.baseDiv.childNodes[i]);
            if(i>TabsLengthMax)   break;
           }
        }
        if (this.tabDiv.childNodes)
        {
           for (var i = 0; i < this.tabDiv.childNodes.length; i++)
           {
            this.tabDiv.removeChild(this.tabDiv.childNodes[i]);
            if(i>TabsLengthMax)   break;
           }
        }
	}


	this.init = function(activeTab)
	{

		this.closeAll();

		for(var i=0; i<this.Tabs.length; i++)
		{
            this.tabDiv.appendChild(this.Tabs[i].menuDiv);
			this.Tabs[i].menuDiv.id = 'tabTab' + i;
            this.Tabs[i].bodyDiv.id = 'tabView' + i;
            this.Tabs[i].img.id = 'tabImage' + i;
            this.baseDiv.appendChild(this.Tabs[i].bodyDiv);
            if(i>TabsLengthMax)   break;
        }

        this.showTab(activeTab);
	}


    this.showTab = function(tabIndex)
    {
        if(this.activeTabIndex == tabIndex)  return;
//        window.status = "tabIndex=" + tabIndex + "; this.Tabs.length=" + this.Tabs.length;
//        alert(tabIndex);
//        alert(this.Tabs.length);

        if(this.activeTabIndex >= 0 && this.activeTabIndex < this.Tabs.length)  this.Tabs[this.activeTabIndex].hide();
        this.Tabs[tabIndex].show();
        this.activeTabIndex = tabIndex;

        if(this.activeTabIndex == 0)
			if(top.FGroup != null)	top.FGroup.resize();

/*
        var ww = 0;var spNum = 0;
        for(var i=0; i<this.Count(); i++)
        {
        			ww += this.Item(i).menuDiv.offsetWidth + 2;
        			if(ww - 2 > this.tabDiv.offsetWidth)
        			{
        				spNum++;
        				}
        }
*/        
        
    }

    this.ActiveTab = function(evt)
    {
        var obj = evt.srcElement;
        var i = 0;
        while(obj.id == "" && i++ < 10)	{	obj = obj.parentNode;	}
        if(obj.id != "")
        		{	this.showTab(obj.id.replace(/[^\d]/g,''));return true;}
        else
        		return fasle;
    }

    this.CloseTab = function(evt)
    {
        var obj = evt.srcElement;
        var i = 0;
        while(obj.id == "" && i++ < 10)	{	obj = obj.parentNode;	}
        if(obj.id != "")
        		{	this.Delete(obj.id.replace(/[^\d]/g,''));		return true;}
        else
        		return fasle;
    }
    
    this.LoadPageComplete = function(evt)
    {
    	if(this.divLoad)this.divLoad.style.display = "none";
    	this.Tabs[this.activeTabIndex].bodyDiv.style.filter = "alpha(opacity=100)";
    }
    
    this.Loaded = function()
    {
    	if(this.divLoad)this.divLoad.style.display = "none";
    	this.Tabs[this.activeTabIndex].bodyDiv.style.filter = "alpha(opacity=100)";
    }
    
    this.Loading = function()
    {
    	if(this.divLoad)this.divLoad.style.display = "";
    	this.Tabs[this.activeTabIndex].bodyDiv.style.filter = "alpha(opacity=80)";
    	window.setTimeout("javascript:LoadPageStop();",8000);
    }

}



function _TAB(p,ownn,cname,url,canclose,canscroll)
{
    this.parent = p;
    this.canclose = false;
    if(canclose!=null)  this.canclose = canclose;
    this.canscroll = false;
    if(canscroll!=null)  this.canscroll = canscroll;
    this.ownName = ownn;
	this.ownCName = cname;
	if(url=="")   url = "blank.htm";
	this.url = url;
	this.visible = false;
	this.bodyDiv = document.createElement("DIV");
    this.bodyDiv.className = "macrolong_aTab";
    this.bodyDiv.style.display = "none";
    this.bodyDiv.style.filter = "alpha(opacity=100)";

//	if(this.ownName.indexOf("地图")>=0)
//		this.bodyDiv.style.position="absolute";


	this.menuDiv = document.createElement("DIV");
	this.menuDiv.className = "macrolong_tabPane";


			this.menuDiv = document.createElement('DIV');
			this.menuDiv.onmouseover = rolloverTab;
			this.menuDiv.onmouseout = rolloutTab;
			this.menuDiv.onclick = this.parent.eventHandler("ActiveTab");//tabClick;
			if(this.canclose)  {
			    this.menuDiv.title = "双击关闭本窗口";
			    this.menuDiv.ondblclick = this.parent.eventHandler("CloseTab");//tabDblClick;
			    }
			this.menuDiv.className='tabInactive';
//			tabDiv.appendChild(this.menuDiv);
			this.tabtitle = document.createElement('SPAN');
			this.tabtitle.innerHTML = cname;
			this.menuDiv.appendChild(this.tabtitle);

			this.img = document.createElement('img');
			this.img.valign = 'bottom';
			this.img.className = "rimage";
			this.img.src = this.canclose?'images/tab_right_inactive_close.gif':'images/tab_right_inactive.gif';
			if(this.canclose)  {
				this.img.style.cursor = 'hand';
			    this.img.onclick = this.parent.eventHandler("CloseTab");//tabDblClick;
			    }
			// IE5.X FIX
			if((navigatorVersion && navigatorVersion<6) || (MSIE && !strictDocType)){
				this.img.style.styleFloat = 'none';
				this.img.style.position = 'relative';
				this.img.style.top = '0px'
				this.tabtitle.style.paddingTop = '0px';
			}	// End IE5.x FIX
			this.menuDiv.appendChild(this.img);



	this.win = document.createElement("IFRAME");
	this.win.style.borderWidth = "0px";
	this.win.name = "F_WINDOW";
	if(!this.canscroll)    	this.win.scrolling = "no";
	else					this.win.scrolling = "auto";
	this.win.style.width = this.parent.width;
	this.win.style.height = this.parent.height;
	this.win.src = "blank.htm";
	
	//this.win.onload = frameLoaded;
	//alert(this.win.onload);
	

	this.bodyDiv.appendChild(this.win);
//	alert(this.win.contentWindow);
//	this.win.contentWindow.onload = this.parent.eventHandler("LoadPageComplete");//LoadPageComplete;

	this.load = function(newurl)
	{
        if(newurl!=null)
            this.url = newurl;
        //alert(this.url + "\n\n" + this.win.src);
        if(this.win.src != this.url)
            {
	        if(this.parent.divLoad)		this.parent.divLoad.style.display = "";
	        this.bodyDiv.style.filter = "alpha(opacity=60)";
	        window.setTimeout("javascript:LoadPageStop();",8000);
	        //alert("");
            this.win.src = this.url;
            }
            
        if(!this.canscroll &&  this.win.scrolling != "no")    this.win.scrolling = "no";
    };
    
    this.setTitle = function(cn)
    {
		this.ownCName = cn;
		this.tabtitle.innerHTML = cn;
    };


    this.hide = function()
    {
		this.menuDiv.className='tabInactive';
		this.img.src = this.canclose?'images/tab_right_inactive_close.gif':'images/tab_right_inactive.gif';
//        if(this.ownName.indexOf("地图")<0)   
		this.bodyDiv.style.display='none';
    }    ;

    this.show = function()
    {
		this.menuDiv.className='tabActive';
		this.img.src = this.canclose?'images/tab_right_active_close.gif':'images/tab_right_active.gif';
		this.bodyDiv.style.display='block';
        this.load();

		var parentObj = this.menuDiv.parentNode;
		var aTab = parentObj.getElementsByTagName('DIV')[0];
		var countObjects = 0;
		var startPos = 0;
		var previousObjectActive = false;
		var i = 0;
		while(aTab){
			if(aTab.tagName=='DIV'){
				if(previousObjectActive){
					previousObjectActive = false;
					startPos-=2;
				}
				if(aTab==this){
					startPos-=2;
					previousObjectActive=true;
					setPadding(aTab,textPadding+1);
				}else{
					setPadding(aTab,textPadding);
				}

				aTab.style.left = startPos + 'px';
				countObjects++;
				startPos+=2;
			}
			aTab = aTab.nextSibling;
			i++;
            if(i>TabsLengthMax*10)   break;
			
		}

    }    ;


//alert(this.menuDiv.offsetWidth);
}



/************ TAB 选项卡效果   *************/