'use strict';

/** グループチャット新規作成でグループ名がNULLのときにはじく **/

let formObj = document.getElementById('groupchatcreate');
let errorMessageObj = document.getElementById('errormessage');
formObj.onsubmit = function(event){
	if(formObj.room_name.value === ""){
	errorMessageObj.textContent = 'グループ名を入力してください！';
	return false;
	}
	errorMessageObj.textContent = "";
}
