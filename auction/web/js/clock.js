/**
 * 定义显示时间类
 * 
 * @param id
 * @param time
 * @return
 */
function ShowTime(id, time) {
	this.id = id;
	this.time = time;
}

/**
 * 显示时间
 * 
 * @return
 */
function displayTime(id, time) {
	var nowDate = new Date();
	//剩余时间
	var hour = time.getHours() - nowDate.getHours();
	var minute = time.getMinutes() - nowDate.getMinutes();
	var seconds = time.getSeconds() - nowDate.getSeconds();
	if (seconds < 0) {
		seconds = 60 + seconds;
		minute = minute - 1;
	}
	if (minute < 0) {
		minute = 60 + minute;
		hour = hour - 1;
	}
	if (hour < 0) {
		hour = 0;
	}
	var msg = hour + ":" + minute + ":" + seconds;
	document.all[id].innerHTML = msg;
}