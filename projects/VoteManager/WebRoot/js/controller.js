/**
 * 创建投票事项
 * @param {Object} $scope
 * @param {Object} $element
 * @param {Object} $http
 */
function createVoteCL($scope,$element,$http){
	// 获取文字投票页中的图片的名字（方法）
	function getTitle(id){
		var title = $(id).parents(".file-input").find(".file-caption-name").attr("title");
		return title;
	}
	// 获取文字投票页中的图片的描述信息（方法）
	function getDesc(id){
		var desc = $(id).parents(".file-input").next().next().val();
		return desc;
	}
	
	/*
	 * 选项卡
	 */
	$http.get("json/page.json").success(function(data){
		$scope.urlObj = data;
		$scope.url = $scope.urlObj[0].url; // 初始化
	})
	/*  以事件作为参数，调用函数时的参数为$event（v1.4.0），ng-change事件不可传参为$event
		$scope.changeUrl = function(event){
			$scope.url = $(event.target).attr("data-url");
		}
	*/
	// 改变url，与上面效果相同
	$scope.urlType = "textVote";
	$scope.changeUrl = function(msg){
		$scope.url = msg;
		if(msg == "page/textVote.html"){
			$scope.urlType = "textVote";
		} else if(msg == "page/imgVote.html"){
			$scope.urlType = "imgVote";
		}
	}	
	
	/*
	 * 单选与多选
	 */
	$scope.chooseFlag = true; // 默认单选
	$scope.limitFlag = true; // 默认不限人数
	$scope.chooseFunc = function(event){
		var target_id = $(event.target).attr("id");
		if(target_id == "singChoose"){
			$scope.chooseFlag = true;
			$(event.target).parent().next().find(".multiInput").find("input").prop("disabled","true");
		} else if(target_id == "multiChoose") {
			$scope.chooseFlag = false;
			$(event.target).parent().next().find("input").removeAttr("disabled");
		} else if(target_id == "unlimited"){
			$scope.limitFlag = true;
			$(event.target).parent().next().next().find("input").prop("disabled","true");
		} else if(target_id == "custom"){
			$scope.limitFlag = false;
			$(event.target).parent().next().find("input").removeAttr("disabled");
		}
	}
	
	// 上限与下限
	$scope.lowLimit = 1;
	$scope.upLimit = 1;
	$scope.llFunc = function(){
		if($scope.lowLimit < 0 || typeof $scope.lowLimit != "number"){
			$scope.lowLimit = 0;
		}
		if($scope.lowLimit > $scope.upLimit){
			$scope.upLimit = $scope.lowLimit;
		}
	}
	$scope.ulFunc = function(){
		if($scope.upLimit < $scope.lowLimit || typeof $scope.upLimit != "number"){
			$scope.upLimit = $scope.lowLimit;
		}
	}
	
	// 人数限制
	$scope.peoLimit = 1;
	$scope.plFunc = function(){
		if($scope.peoLimit < 0 || typeof $scope.peoLimit != "number"){
			$scope.peoLimit = 0;
		}
	}

	// 设置日期
	$scope.pubDate = new Date(); // 发布日期默认显示当前日期
	$scope.edFunc = function(){
		if($scope.expireDate < $scope.pubDate){
			$scope.expireDate = $scope.pubDate;
		}
	}
	
	/*
	 * 提交表单
	 */
	$scope.subForm = function(){
			// 获取投票类型
			var urlType = $scope.urlType;
			
			// 文字投票
			if(urlType == "textVote"){
				// 获取图片名
				var img = getTitle("#input-id");
				if(img == null || img == '' || img == undefined){
					img = "noImg";
				}
				// 获取所有问题内容及选项 
				var quesBoxArr = []; // 用来装载所有问题盒子的容器（包括所有问题和选项）
				var quesBox = $("#acconding").children(); // 获取总共多少个问题盒子
				for(var i = 0; i < quesBox.length; i++){
					var quesText = quesBox.eq(i).find(".question").val(); // 获得问题内容
					var optionInput = quesBox.eq(i).find(".optionBox").find("input"); // 获得总共多少个选项
					var optionArr = []; // 一个用来装载选项内容的容器，每次循环清空
					for(var j = 0; j < optionInput.length; j++){
						var optionInputText = optionInput.eq(j).val();
						optionArr[optionArr.length] = optionInputText; // 将选项装入容器
					}
					// 一个问题盒子的内容
					var obj = {
						"quesText": quesText,
						"optionArr": optionArr
					}
					// 将盒子加入容器
					quesBoxArr[quesBoxArr.length] = obj; 
				}
			// 图片投票
		 	} else if(urlType == "imgVote"){
		 		var img = "noImg"; // 没有介绍图片
		 		var quesBoxArr = []; // 用来装载所有图片盒子的容器（包括所有图片和描述）
				var imgInput = $("#imgBox").children().find("input");
				for(var x = 0; x < imgInput.length; x++){
					var imgInputId = imgInput.eq(x).attr("id");
					var imgName = getTitle("#"+imgInputId); // 获取图片名
					var imgDesc = getDesc("#"+imgInputId); // 获取描述信息
					var obj = new Object();
					obj.img = imgName;
					obj.desc = imgDesc;
					quesBoxArr.push(obj);
				}
			}
			
			// 获取投票模式
			if($scope.chooseFlag){
				var chooseFlagObj = {
					"chooseFlag": "singChoose" // 单选
				}
			} else {
				var chooseFlagObj = {
					"chooseFlag": "multiChoose", // 多选
					"lowLimit": $scope.lowLimit, // 下限
					"upLimit": $scope.upLimit // 上限
				}
			}
			
			// 获取投票人数限制
			if($scope.limitFlag){
				var limitFlagObj = {
					"limitFlag": "unlimited" // 不限
				}
			} else {
				var limitFlagObj = {
					"limitFlag": "custom", // 自定义
					"peoLimit": $scope.peoLimit // 人数
				}
			}
			
			// 日期处理
			var pubDate = $scope.pubDate;
			var expireDate = $scope.expireDate;
			pubDate = DateUtils.dateFormat(pubDate,'yyyy/MM/dd');
			expireDate = DateUtils.dateFormat(expireDate,'yyyy/MM/dd');
			//pubDate = new Date(pubDate).toJSON().toString().substr(0,10).replace(/-/g,"/");
			//expireDate = new Date(expireDate).toJSON().toString().substr(0,10).replace(/-/g,"/");
			
			// 所有提交数据
			var subData = {
				"type": urlType,
				"title": $("#voteTitle").val(),
				"desc": $("#desc").val(),
				"img": img,
				"choose": quesBoxArr,
				"pattern": chooseFlagObj,
				"peopleNum": limitFlagObj,
				"pubDate": pubDate,
				"expireDate": expireDate
			}
			
			$.ajax({
				url: 'CenterCL',
				type: 'post',
				dataType: 'json', // 预期返回类型
				data: {'op':'create','data':JSON.stringify(subData)},
				success: function(data){
					$(".kv-file-upload").click(); // 上传图片..
					if(data == true){
						$("#divModal").find(".modal-body").find("span").html("创建成功！");
						$("#modalBtn").click();
						$(".confirm").click(function(){ // 重置表单
							location.reload();
						}) 
						//$("#form")[0].reset(); // 重置表单，jquery获取的对象是一个数组
					} else {
						$("#divModal").find(".modal-body").find("span").html("创建失败！");
						$("#modalBtn").click();
					}
				}
			});
			
			console.log(subData);
			return false;
	}
}

/**
 * 展示所有的投票
 * @param {Object} $scope
 * @param {Object} $element
 * @param {Object} $http
 */
function voteListCL($scope,$element,$http,service){
	$scope.nowDate = new Date();
	// 将时间转化为标准时间（方法）
	$scope.getExpireDate = function(date){
		return new Date(date);
	}
	// 获取人数限制
	$scope.getPeopleNum = function(obj){
		return service.getPeopleNum(obj);
	}
	$(function(){
		$.ajax({
			url: 'CenterCL',
			type: 'post',
			dataType: 'text',
			data: {"op":"getAllVote"},
			success: function(data){
				console.log("返回数据：" + data);
				var result = JSON.parse(data);
				$scope.$apply(function(){
					$scope.result = result;
					for(var item in result){
						console.log(result[item]['expireDate']);
					}
				})
			}
		})
	})
	
	// AngularAjax
	/*var url = "CenterCL";
    var ajax = new ajaxClass($http,url,"POST");
    ajax.headers = { 'Content-Type': 'application/x-www-form-urlencoded' }; // post传递表单数据的时候设置请求头
    ajax.responseType = "json";
    ajax.data = $.param({"op":"getAllVote"}); // 传递表单数据的时候要使用$.param不然服务器没法正常捕获到发送的数据
    ajax.successCallback = function(res){
    	console.log(res);
    	$scope.result = res.data;
    };
    ajax.failureCallback = function(res){
    	
    };
    ajax.requestData();*/
}

/**
 * 投票页面
 * @param {Object} $scope
 * @param {Object} $element
 * @param {Object} $http
 */
function showVoteCL($scope,$element,$http,$filter,$timeout,service){
	// 关于提交
	$scope.alertInfo = false;
	$scope.alertInfo2 = false;
	$scope.errorInfo = false;
	$scope.errorInfo2 =false;
	$scope.dateInfo = false;
	$scope.limitInfo = false;
	// 显示错误（方法）
	function showError(args){
		$scope[args] = true;
		$timeout(function(){
			$scope[args] = false;
		},3000)
	}
	// 默认是单选模式的页面
	$scope.isRadio = true;
	// 获取url上的参数（方法）
	function getQueryString(name){
	     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
	     var r = window.location.search.substr(1).match(reg);
	     if(r!=null)
	     	return unescape(r[2]); 
	     return null;
	}
	var vote_id = getQueryString("vote_id");
	var vote_type = getQueryString("vote_type");
	// 判断是哪种投票
	$scope.url = "page/textVoteShow.html";
	if(vote_type == "imgVote"){
		$scope.url = "page/imgVoteShow.html";
	}
	// 通过id获取投票事项
	$.ajax({
		url: 'CenterCL',
		type: 'post',
		dataType: 'text',
		data: {"op":"getVoteById","vote_id": vote_id},
		success: function(data){
			console.log("返回数据：" + data);
			var result = JSON.parse(data);
			$scope.$apply(function(){
				// 将result传递页面
				$scope.result = result;
				// 判断是否过期
				if(new Date() > new Date(result.expireDate)){
					$scope.dateInfo = true;
				}
				// 判断是否是单选模式
				if(result.pattern.chooseFlag != 'singChoose'){
					$scope.isRadio = false;
				}
				// 如果是自定义的人数，判断人数是否已满
				if(result.peopleNum.limitFlag == 'custom'){
					if(result.votedNum == result.peopleNum.peoLimit){
						$scope.limitInfo = true;
					}
				}
				
				// 文字投票页面处理
				if(result.type == "textVote"){
					// 判断是否存在描述图片
					$scope.imgFlag = true;
					if(result.img == "noImg"){
						$scope.imgFlag = false;
					}
					// 用来承装用户的选择信息
					$scope.choose = [];
					// 每ng-repeat循环一次，创建一个元素（方法）
					$scope.addItem = function(index,quesText){
						var obj = $scope['ques'+index] = {};
						obj.quesText = quesText;
						obj.answer = [];
						$scope.choose.push(obj);
						console.log('ques'+index +","+ $filter("json")(obj));
					}
					// 选择一个选项
					$scope.changeAns = function(event){
						var $e = $(event.target);
						var name = $e.attr("name");
						var answerArr = $scope[name]['answer'];
						// 单选
						if(result.pattern.chooseFlag == 'singChoose'){
							answerArr.length = 0;
							answerArr[0] = $e.val();
							console.log(name +": "+ answerArr);
							
						// 多选
						} else {
							// 判断是否存在
							var valIndex = answerArr.indexOf($e.val());
							if(valIndex != -1){
								answerArr.splice(valIndex,1); // 删除元素
							} else {
								// 判断是否到达选项上限
								if(answerArr.length == result.pattern.upLimit){
									$e.removeAttr("checked");  // 去勾（checkbox默认给勾）
								} else {
									answerArr.push($e.val());
								}
							}
							console.log(name +": "+ answerArr);
						}
					}
					
				// 图片投票页面处理
				} else {
					$scope.choose = [];
					$scope.changeImg = function(event){
						// 通过共同父元素找到指定的元素（由于冒泡，单击子元素时的单击效果冒泡到了父元素，导致父元素触发单击事件，但是触发事件的对象却依然是子元素）
						var btnObj = $(event.target).parents(".caption").find("button");
						var title = $(event.target).parents(".caption").prev().attr("title");
						// 单选
						if(result.pattern.chooseFlag == 'singChoose'){
							if(title == $scope.choose[0]){
								$scope.choose = []; // 清空
								btnObj.attr("class","btn btn-info").html("<i class='glyphicon glyphicon-flag'></i> 投票");
								console.log($scope.choose);
							} else {
								$scope.choose = []; // 重新选择
								$scope.choose[0] = title;
								btnObj.attr("class","btn btn-primary").html("<i class='glyphicon glyphicon-ok'></i>");
								btnObj.parents(".imgBox").siblings().find("button").attr("class","btn btn-info").html("<i class='glyphicon glyphicon-flag'></i> 投票");
								console.log($scope.choose);
							}
							
						// 多选
						} else {
							var titleIndex = $scope.choose.indexOf(title); // 判断是否存在
							if(titleIndex != -1){
								$scope.choose.splice(titleIndex,1); // 删除元素
								btnObj.attr("class","btn btn-info").html("<i class='glyphicon glyphicon-flag'></i> 投票");
							} else {
								if($scope.choose.length < result.pattern.upLimit){
									$scope.choose.push(title);
									btnObj.attr("class","btn btn-primary").html("<i class='glyphicon glyphicon-ok'></i>");
								}
							}
							console.log($scope.choose);
						}
					}
				}
				
				// 提交到后台（方法）
				function subFunc(){
					// 提交的数据
					var subData = {
						"vote_id": result.id,
						"vote_title": result.title,
						"choose": $scope.choose,
						"vote_date": new Date().toJSON().toString().substr(0,10).replace(/-/g,"/")
					};
					$.ajax({
						url: 'CenterCL',
						type: 'post',
						dataType: 'json', // 预期返回类型
						data: {'op':'vote','data':JSON.stringify(subData)},
						success: function(data){
							$("#divModal").find(".modal-body").find("span").html(data.info);
							$("#modalBtn").click();
						}
					});
				}
				
				// 提交控制
				$scope.subReply = function(){
					// 文字投票提交
					if(result.type == "textVote"){
						// 单选
						if(result.pattern.chooseFlag == 'singChoose'){
							// 判断是否每个问题都已选择答案
							var ret = $scope.choose.every(function(item,index,array){
								return (item['answer'].length != 0)
							});
							if(!ret){
								showError('alertInfo');
							} else {
								subFunc();
							}
						// 多选
						} else {
							var ret = $scope.choose.every(function(item,index,array){
								return (item['answer'].length >= result.pattern.lowLimit);
							});
							if(!ret){
								showError('alertInfo2');
							} else {
								subFunc();
							}
						}
						
					// 图片投票提交
					} else {
						// 单选
						if(result.pattern.chooseFlag == 'singChoose'){
							if($scope.choose.length == 0){
								showError('errorInfo');
							} else {
								subFunc();
							}
						
						// 多选
						} else {
							if($scope.choose.length < result.pattern.lowLimit){
								showError('errorInfo2');
							} else {
								subFunc();
							}
						}
					}
				}
			})
		}
	})
	
}