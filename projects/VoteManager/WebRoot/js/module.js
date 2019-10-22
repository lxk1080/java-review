angular.module("appVote",[])
	.service('service',function(){
		return {
			'getPeopleNum': function(obj){
								var limitFlag = obj['limitFlag'];
								if(limitFlag == "unlimited"){
									return "不限";
								} else if(limitFlag == "custom"){
									var peoLimit = obj['peoLimit'];
									return peoLimit;
								}
							}
		}
	})
	.controller("createVote",createVoteCL)
	.controller("showVote",showVoteCL)
	.controller("voteList",voteListCL);
