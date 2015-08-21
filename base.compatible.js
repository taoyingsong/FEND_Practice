/*
实现浏览器兼容版的element.children
 */
function getChildElements(elementObj) {
    // if(elementObj.children) {
    //     return elementObj.children;
    // }
    // else {
    var childs = [];
    var childElement;
    for (var i = 0; i < elementObj.childNodes.length; i++) {
        childElement = elementObj.childNodes[i];
        if (childElement.nodeType == 1) {
            childs.push(childElement);
        }
    }
    return childs;
    // }
}


/*
实现浏览器兼容版的element.dataset
*/
function dataset(element) {

    //判断当前浏览器是否原生支持dataset属性
    if (element.dataset) {
        return element.dataset;
    }

    //data-*自定义属性以“-”拆分后得到的数组
    //返回的属性对象
    //得到的新的属性名
    var arr = [],
        result = {},
        attrName;

    //获取element元素的所有属性集合
    var attr = element.attributes;
    for (var i = 0; i < attr.length; i++) {

        //获取data-*的自定义属性                  
        if (attr[i].name.slice(0, 5) == "data-") {

            //data-*自定义属性以“-”拆分后得到的数组
            arr = attr[i].name.split("-");

            //从第二个单词开始
            for (var j = 1; j < arr.length; j++) {
                if (j > 1) {

                    //第二个单词开始首字母大写
                    attrName += arr[j].slice(0, 1).toUpperCase() + arr[j].slice(1);
                } else {

                    //第一个单词还是保持小写
                    attrName = arr[j];
                }
            }

            //将属性名和值存入返回对象中                 }
            result[attrName] = attr[i].value;
        }
    }
    return result;
}

/*
bind 的低版本兼容
 */

if (!Function.prototype.bind) {
    Function.prototype.bind = function(obj) {
        var self = this;
        var selfArg = Array.prototype.slice.call(arguments, 1);
        var bridge = function() {};
        bridge.prototype = self.prototype;
        var _self = function() {
            var newArg = selfArg.concat(Array.prototype.slice.call(arguments));
            return self.apply(this instanceof bridge ? this : obj || {}, newArg)
        };
        _self.prototype = new bridge();
        return _self;
    }
}




/*
实现浏览器兼容版的window.getComputedStyle
 */

function computedStyle(element) {
    return window.getComputedStyle ? window.getComputedStyle(element) : element.currentStyle;
}



/*
element.innerText兼容
 */
if (!('innerText' in document.body)) {
    HTMLElement.prototype._defineGetter_("innerText", function() {
        return this.textContent;
    });
    HTMLElement.prototype._defineSetter_("innerText", function(s) {
        return this.textContent = s;
    });
}


/*
getElementsByClass兼容
demo:
    <div id="example">
       <p id="p1" class="aaa bbb"/>
       <p id="p2" class="aaa ccc"/>
       <p id="p3" class="bbb ccc"/>
    </div>   
    console.log(getElementsByClassName(example, "aaa"));
    console.log(getElementsByClassName(example, "bbb ccc"));    
    console.log(getElementsByClassName(example, "ccc bbb"));
 */
function getElementsByClassName(element, names) {
    if (element.getElementsByClassName) {
        return element.getElementsByClassName(names);
    } else {
        var elements = element.getElementsByTagName('*');
        var result = [];
        var element,
            classNameStr,
            flag;
        names = names.split(' ');
        for (var i = 0; element = elements[i]; i++) {
            classNameStr = ' ' + element.className + ' ';
            flag = true;
            for (var j = 0, name; name = names[j]; j++) {
                if (classNameStr.indexOf(' ' + name + '') == -1) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result.push(element);
            }
        }
        return result;
    }
}



/*
addEvent delEvent 浏览器兼容
 */
var addEvent = document.addEventListener ?
    function(elem, type, listener, useCapture) {
        elem.addEventListener(type, listener, useCapture);
    } :
    function(elem, type, listener, useCapture) {
        elem.attachEvent('on' + type, listener);
    };
var delEvent = document.removeEventListener ?
    function(elem, type, listener, useCapture) {
        elem.removeEventListener(type, listener, useCapture);
    } :
    function(elem, type, listener, useCapture) {
        elem.detachEvent('on' + type, listener);
    }



/*
Object.create()兼容
参考：https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Object/create
 */
if (typeof Object.create != 'function') {
    // Production steps of ECMA-262, Edition 5, 15.2.3.5
    // Reference: http://es5.github.io/#x15.2.3.5
    Object.create = (function() {
        // To save on memory, use a shared constructor
        function Temp() {}

        // make a safe reference to Object.prototype.hasOwnProperty
        var hasOwn = Object.prototype.hasOwnProperty;

        return function(O) {
            // 1. If Type(O) is not Object or Null throw a TypeError exception.
            if (typeof O != 'object') {
                throw TypeError('Object prototype may only be an Object or null');
            }

            // 2. Let obj be the result of creating a new object as if by the
            //    expression new Object() where Object is the standard built-in
            //    constructor with that name
            // 3. Set the [[Prototype]] internal property of obj to O.
            Temp.prototype = O;
            var obj = new Temp();
            Temp.prototype = null; // Let's not keep a stray reference to O...

            // 4. If the argument Properties is present and not undefined, add
            //    own properties to obj as if by calling the standard built-in
            //    function Object.defineProperties with arguments obj and
            //    Properties.
            if (arguments.length > 1) {
                // Object.defineProperties does ToObject on its first argument.
                var Properties = Object(arguments[1]);
                for (var prop in Properties) {
                    if (hasOwn.call(Properties, prop)) {
                        obj[prop] = Properties[prop];
                    }
                }
            }

            // 5. Return obj
            return obj;
        };
    })();
}


//自己的Object.create兼容方案
if (typeof Object.create != 'function') {
    Object.create = (function() {
        function F() {};
        return function(proto) {
            if (typeof proto != 'object') {
                throw TypeError('原型只能是对象或者null');
            }
            F.prototype = proto;
            var obj = new F();
            F.prototype = null;
            return obj;
        };
    })();
}


/*
forEach的IE兼容方案
参考：
http://blog.csdn.net/oscar999/article/details/8671546
https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/forEach
 */
// Production steps of ECMA-262, Edition 5, 15.4.4.18
// Reference: http://es5.github.io/#x15.4.4.18
if (!Array.prototype.forEach) {

  Array.prototype.forEach = function(callback, thisArg) {

    var T, k;

    if (this == null) {
      throw new TypeError(' this is null or not defined');
    }

    // 1. Let O be the result of calling ToObject passing the |this| value as the argument.
    var O = Object(this);

    // 2. Let lenValue be the result of calling the Get internal method of O with the argument "length".
    // 3. Let len be ToUint32(lenValue).
    var len = O.length >>> 0;

    // 4. If IsCallable(callback) is false, throw a TypeError exception.
    // See: http://es5.github.com/#x9.11
    if (typeof callback !== "function") {
      throw new TypeError(callback + ' is not a function');
    }

    // 5. If thisArg was supplied, let T be thisArg; else let T be undefined.
    if (arguments.length > 1) {
      T = thisArg;
    }

    // 6. Let k be 0
    k = 0;

    // 7. Repeat, while k < len
    while (k < len) {

      var kValue;

      // a. Let Pk be ToString(k).
      //   This is implicit for LHS operands of the in operator
      // b. Let kPresent be the result of calling the HasProperty internal method of O with argument Pk.
      //   This step can be combined with c
      // c. If kPresent is true, then
      if (k in O) {

        // i. Let kValue be the result of calling the Get internal method of O with argument Pk.
        kValue = O[k];

        // ii. Call the Call internal method of callback with T as the this value and
        // argument list containing kValue, k, and O.
        callback.call(T, kValue, k, O);
      }
      // d. Increase k by 1.
      k++;
    }
    // 8. return undefined
  };
}