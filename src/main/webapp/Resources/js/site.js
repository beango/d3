// only run when the substr() function is broken
if ('ab'.substr(-1) != 'b') {
  /**
	 * Get the substring of a string
	 * 
	 * @param {integer}
	 *            start where to start the substring
	 * @param {integer}
	 *            length how many characters to return
	 * @return {string}
	 */
  String.prototype.substr = function(substr) {
	  console.log(123);
    return function(start, length) {
      // call the original method
      return substr.call(this,
      	// did we get a negative start, calculate how much it is from the
		// beginning of the string
        // adjust the start parameter for negative value
        start < 0 ? this.length + start : start,
        length)
    }
  }(String.prototype.substr);
}


var Common = {

    // EasyUI用DataGrid用日期格式化
    TimeFormatter: function (value, rec, index) {
        if (value == undefined) {
            return "";
        }
        /* json格式时间转js时间格式 */
        value = value.substr(1, value.length - 2);
        var obj = eval('(' + "{Date: new " + value + "}" + ')');
        var dateValue = obj["Date"];
        if (dateValue.getFullYear() < 1900) {
            return "";
        }
        var val = dateValue.format("yyyy-mm-dd HH:MM");
        return val.substr(11, 5);
    },
    DateTimeFormatter: function (value, rec, index) {
        if (value == undefined) {
            return "";
        }
        /* json格式时间转js时间格式 */
        value = value.substr(1, value.length - 2);
        var obj = eval('(' + "{Date: new " + value + "}" + ')');
        var dateValue = obj["Date"];
        if (dateValue.getFullYear() < 1900) {
            return "";
        }

        return dateValue.format("yyyy-mm-dd HH:MM");
    },
    ToLocal: function(value)
    {
    	if (value == undefined) {
            return "";
        }
        return new Date(value.time).format("yyyy-MM-dd hh:mm:ss");
    },
    // EasyUI用DataGrid用日期格式化
    DateFormatter: function (value, rec, index) {
        if (value == undefined) {
            return "";
        }
        /* json格式时间转js时间格式 */
        value = value.substr(1, value.length - 2);
        var obj = eval('(' + "{Date: new " + value + "}" + ')');
        console.log(obj)
        var dateValue = obj["Date"];
        if (dateValue.getFullYear() < 1900) {
            return "";
        }

        return dateValue.format("yyyy-mm-dd");
    },
    TitleFormatter : function (value, rec, index) {
        if (value.length > 10) value = value.substr(0, 8) + "...";
        return value;
    },
    LongTitleFormatter: function (value, rec, index) {
        if (value.length > 15) value = value.substr(0, 12) + "...";
        return value;
    }
};

Date.prototype.format = function (format) { 
	var o = { 
	"M+": this.getMonth() + 1, // month
	"d+": this.getDate(), // day
	"h+": this.getHours(), // hour
	"m+": this.getMinutes(), // minute
	"s+": this.getSeconds(), // second
	"q+": Math.floor((this.getMonth() + 3) / 3), // quarter
	"S": this.getMilliseconds() // millisecond
	} 
	if (/(y+)/.test(format)) format = format.replace(RegExp.$1, 
	(this.getFullYear() + "").substr(4 - RegExp.$1.length)); 
	for (var k in o) if (new RegExp("(" + k + ")").test(format)) 
	format = format.replace(RegExp.$1, 
	RegExp.$1.length == 1 ? o[k] : 
	("00" + o[k]).substr(("" + o[k]).length)); 
	return format; 
	} 
