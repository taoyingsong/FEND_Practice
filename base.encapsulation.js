/*
getStyle函数获取元素的实际样式  
语法：var cssPropertyValue = getStyle(element, cssPropertyName);
demo:getStyle(element, "line-height") //返回："30px"
 */
function getStyle(element, cssPropertyName) {
    return window.getComputedStyle ? window.getComputedStyle(element).cssPropertyName : element.currentStyle.cssPropertyName;
}



/*
Ajax请求GET封装
详情回头补上
 */
function serialize(data) {
    if (!data) return '';
    var pairs = [];
    for (var name in data) {
        if (!data.hasOwnProperty(name)) continue;
        if (typeof data[name] == 'function') continue;
        var value = data[name].toString();
        name = encodeURIComponent(name);
        value = encodeURIComponent(value);
        pairs.push(name + '=' + value);
    }
    return pairs.join('&');
}

function get(url, options, callback) {
    var xhr;
    if (window.XMLHttpRequest) {
        xhr = new XMLHttpRequest();
    } else {
        xhr = window.ActiveXObject("Microsoft.XMLHTTP");
    }
    xhr.onreadystatechange = function(callback) {
        if (xhr.readyState == 4) {
            if ((xhr.status >= 200 && xhr.status < 300) || xhr.status == 304) {
                callback(xhr.responseText);
            } else {
                alert('Request was unsuccessful:' + xhr.stauts);
            }
        }
    }
    xhr.open('get', url + '?' + serialize(options), true);
    xhr.send(null);
}



/*
Ajax请求POST封装
详情回头补上
 */
function serialize(data) {
    if (!data) return '';
    var pairs = [];
    for (var name in data) {
        if (!data.hasOwnProperty(name)) continue;
        if (typeof data[name] == 'function') continue;
        var value = data[name].toString();
        name = encodeURIComponent(name);
        value = encodeURIComponent(value);
        pairs.push(name + '=' + value);
    }
    return pairs.join('&');
}

function post(url, options, callback) {
    var xhr;
    if (window.XMLHttpRequest) {
        xhr = new XMLHttpRequest();
    } else {
        xhr = window.ActiveXObject("Microsoft.XMLHTTP");
    }
    xhr.onreadystatechange = function(callback) {
        if (xhr.readyState == 4) {
            if ((xhr.status >= 200 && xhr.status < 300) || xhr.status == 304) {
                callback(xhr.responseText);
            } else {
                alert('Request was unsuccessful:' + xhr.stauts);
            }
        }
    }
    xhr.open('post', url, true);
    xhr.send(serialize(options));
}



/*
读取cookie：getCookie
 */
function getCookie() {
	var cookie = {};
	var all = document.cookie;
	if(all === '') {
		return cookie;
	}
	var list = all.split('; ');
	for(var i = 0; i < list.length; i++) {
		var item = list[i];
		var p = item.indexOf('=');
		var name = item.substring(0, p);
		name = docodeURIComponent(name);
		var value = item.substring(p + 1);
		value = decodeURIComponent(value);
		cookie[name] = value;
	}
	return cookie;
}



/*
设置/修改cookie：setCookie
 */
function setCookie(name, value, expires, path, domain, secure) {
	var cookie = encodeURIComponent(name) + '=' + encodeURIComponent(value);
	if(expires) {
		cookie += '; expires=' + expires.toGMTString();
	}
	if(path) {
		cookie += '; path=' + path;
	}
	if(domain) {
		cookie += '; domain=' + domain;
	}
	if(secure) {
		cookie += '; secure=' + secure;
	}
	document.cookie = cookie;
}



/*
删除cookie
 */
 function removeCookie(name, path, domain) {
 	document.cookie = name + '='	
 	+ '; path=' + path
 	+ '; domain=' + domain
 	+ '; max-age=0';
 }

 /*动画函数
 下边代码是以px为基本单位的所以透明度和旋转还要在这个基础上做一定的改造
  */
 var animation = function(ele, attr, from, to) {
    var distance = Math.abs(to - from);
    var stepLength = distance /100;
    var sign = (to - from) / distance;
    var offset = 0;
    var step = function() {
        var tmpOffset = offset + stepLength;
        if(tmpOffset < distance) {
            ele.style[attr] = from + tmpOffset * sign + 'px';
            offset = tmpOffset;
        } else {
            ele.style[attr] = to + 'px';
            clearInterval(intervalID);
        }
    }
    ele.style[attr] = from + 'px';
    var intervalID = setInterval(step, 10);
 }
