window.alert = function(txt) {
	var shield = document.createElement("DIV");
	shield.id = "shield";
	shield.style.position = "absolute";
	shield.style.left = "0px";
	shield.style.top = "0px";
	shield.style.width = "100%";
	shield.style.height = "100%";
	//shield.style.height = document.body.scrollHeight+"px";
	shield.style.background = "#000";
	shield.style.textAlign = "center";
	shield.style.zIndex = "10000";
	shield.style.filter = "alpha(opacity=0)";
	var alertFram = document.createElement("DIV");
	alertFram.id = "alertFram";
	alertFram.style.position = "absolute";
	//负边界居中法,相对于shield层的顶部时

	//alertFram.style.left = "50%";
	//alertFram.style.top = "50%";
	//alertFram.style.marginLeft = "-125px";
	//alertFram.style.marginTop = "-75px";

	//负边界居中法,相对于shield层的底部时
	alertFram.style.right = "50%";
	alertFram.style.bottom = "50%";
	alertFram.style.marginRight = "-125px";
	alertFram.style.marginBottom = "-75px";

	alertFram.style.width = "250px";
	alertFram.style.height = "150px";
	alertFram.style.background = "#000";
	alertFram.style.textAlign = "center";
	alertFram.style.lineHeight = "150px";
	alertFram.style.zIndex = "10002";
	strHtml = "<ul style=\"list-style:none;margin:0px;padding:0px;width:100%\">\n";
	strHtml += "<li onmousedown=\"oMove(parentNode.parentNode);\" title=\"移動\" style=\"cursor:move;background:#002F9C;text-align:left;padding-left:5px;font-size:14px;font-weight:bold;color: #FFFFFF;height:25px;line-height:25px;border-left:1px solid #FFFFFF;border-top:1px solid #FFFFFF;border-right:1px solid #FFFFFF;\">[提示窗口...]</li>\n";
	strHtml += "<li style=\"background:#5A7EDC;text-align:center;font-size:12px;color: #FFFFFF;height:120px;line-height:120px;border-left:1px solid #FFFFFF;border-right:1px solid #FFFFFF;\">"
			+ txt + "</li>\n";
	strHtml += "<li style=\"background:#002F9C;text-align:center;font-weight:bold;height:25px;line-height:25px; border-left:1px solid #FFFFFF;border-bottom:1px solid #FFFFFF;border-right:1px solid #FFFFFF;\"><input type=button value=' 确定 ' onclick=\"remove()\"></li>\n";
	strHtml += "</ul>\n";
	alertFram.innerHTML = strHtml;
	document.body.appendChild(alertFram);
	document.body.appendChild(shield);

	var c = 0;
	this.doAlpha = function() {
		if (c++ > 50) {
			clearInterval(ad);
			return 0;
		}
		shield.style.filter = "alpha(opacity=" + c + ");";
	}
	this.remove = function() {
		alertFram.innerHTML = "";
		shield.style.filter = "";
		shield.id = "";
		shield.style.position = "";
		shield.style.left = "";
		shield.style.top = "";
		shield.style.width = "";
		shield.style.height = "";
		shield.style.background = "";
		shield.style.textAlign = "";
		shield.style.zIndex = "";
		shield.style.filter = "";
		alertFram.id = "";
		alertFram.style.position = "";
		alertFram.style.left = "";
		alertFram.style.top = "";
		alertFram.style.marginLeft = "";
		alertFram.style.marginTop = "";
		alertFram.style.width = "";
		alertFram.style.height = "";
		alertFram.style.background = "";
		alertFram.style.textAlign = "";
		alertFram.style.lineHeight = "";
		alertFram.style.zIndex = "";
		
		//div.parentNode.removeChild(div)
		alertFram.style.display="none";//隐藏 而不删除
		alertFram.parentNode.removeChild(alertFram);	//移除
	}
	var ad = setInterval("doAlpha()", 10);
	alertFram.focus();
	document.body.onselectstart = function() {
		return false;
	};
}
function oMove(obj) {
	var otop, oleft;
	otop = event.y - obj.offsetTop;
	oleft = event.x - obj.offsetLeft;
	obj.setCapture();
	obj.onmousemove = function() {
		obj.style.left = event.x - oleft;
		obj.style.top = event.y - otop;
	}
	obj.onmouseup = function() {
		obj.onmousemove = null;
		obj.style.filter = null;
		obj.releaseCapture();
	}
}
