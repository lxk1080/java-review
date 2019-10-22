/*
 * _http:angularJs中的$http对象
 * _url:ajax请求的URL
 * _method:请求方式：POST或GET
 * _params:GET方式请求时传递的参数
 * _data:POST方式请求时传递的参数
 * _responseType:在请求中设置XMLHttpRequestResponseType属性,""（字符串，默认）,
 * "arraybuffer"(ArrayBuffer);"blob"（blob对象）；"document"（HTTP文档）"json"(从JSON对象解析而来的JSON字符串)；
 * "text"（字符串）；"moz-blob"（Firefox的接收进度事件）；"moz-chunked-text"(文本流);"moz-chunked-arraybuffer"（ArrayBuffer流）。
 * 这个参数表示的含义就是服务器给页面返回的数据格式
 * _successCallback:请求成功的回调函数
 * _failureCallback:请求失败的回调函数
 *
 */
function ajaxClass(_http, _url, _method, _headers, _responseType, _data, _params, _successCallback, _failureCallback) {
	this.http = _http; // Angular的$http
	this.url = _url || ""; 
	this.method = _method || "GET";
	this.headers = _headers || ""; // post方式必须设置请求头
	this.responseType = _responseType || "json"; // 响应类型
	this.data = _data || ""; // post方式传递参数
	this.params = _params || ""; // get方式传递参数
	this.successCallback = _successCallback || function(res) {};
	this.failureCallback = _failureCallback || function(res) {};
	this.requestData = function() {
		this.http({
			url: this.url,
			method: this.method,
			headers: this.headers,
			responseType: this.responseType,
			data: this.data,
			params: this.params,
		}).then(this.successCallback, this.failureCallback);
	}
}

/*POST方式请求数据， 并且传递表单数据的例子
var ajaxApp = angular.module('ajaxApp', []);

ajaxApp.controller('addCtrl', function($scope, $http, $filter) {
	var url = "a.json";
	var ajax = new ajaxClass($http, url, "POST");
	// 千万记住要传递表单数据的时候设置请求头
	ajax.headers = {
		'Content-Type': 'application/x-www-form-urlencoded'
	}; 
	// 传递表单数据的时候要使用$.param不然服务器没法正常捕获到发送的数据
	ajax.data = $.param({
		"username": "qqq",
		"pwd": "bbb",
		"code": "111"
	}); 
	ajax.successCallback = function(res) {
		var status = res.data.status;
		if(status == 0) {
			$scope.gridOptions = res.data;
		} else {

		}
	};
	ajax.failureCallback = function(res) {};
	ajax.requestData();

});*/

/*GET方式请求数据， 并且传递参数的例子
var myApp = angular.module('myApp', []);
myApp.controller('myCtrl', function($scope, $http) {
	var url = "a.php";
	//var url = "a.php?limit=10";
	var ajax = new ajaxClass($http, url, "get");
	// 表单方式传递数据或者可以使用在url后面加？limit=11这样的形式传递
	ajax.params = {
		"limit": 11
	}; 
	// get方式请求数据不需要设置表头header
	ajax.successCallback = function(res) {
		var status = res.data.status;
		$scope.gridOptions = res.data;
		console.log("status = " + status);
		if(status == 0) {
			$scope.gridOptions = res.data;
		} else {

		}
	};
	ajax.failureCallback = function(res) {};
	ajax.requestData();

});*/

/*GET方式请求数据， 不传递参数的例子
var myApp = angular.module('myApp', []);
myApp.controller('myCtrl', function($scope, $http) {
	var url = "a.json";
	var ajax = new ajaxClass($http, url, "get");
	// get方式请求数据不需要设置表头header
	ajax.successCallback = function(res) {
		var status = res.data.status;
		$scope.gridOptions = res.data;
		console.log("status = " + status);
		if(status == 0) {
			$scope.gridOptions = res.data;
		} else {

		}
	};
	ajax.failureCallback = function(res) {};
	ajax.requestData();

});*/