	window.bapdosa.util.parseQueryString = function(query){

		var urlParams = {};

		var e,
		a = /\+/g,
		// Regex for replacing addition symbol with a space
		r = /([^&=]+)=?([^&]*)/g,
		d = function (s) {
			return decodeURIComponent(s.replace(a, " "));
		},
		q = query;
		while (e = r.exec(q))
			urlParams[d(e[1])] = d(e[2]);


		return urlParams;
	};

	window.bapdosa.util.getQueryArray = function(query) {

	    queryString = []; // reset queryString
	    var q = query;

	    var arr = q.split("&");

	    var n = ""; // name
	    var v = ""; // value
	    var ind; // index of equal symbol

	    for (var i = 0; i < arr.length; i++) {
	        ind = parseInt(arr[i].indexOf("="));
	        v = arr[i].substring(ind+1, arr[i].length);
	        n = arr[i].substring(0, ind);

	        queryString[n] = decodeURI(v);
	    }

	    return queryString;
	};

	window.bapdosa.util.checkIP = function(strIP) {
		var expUrl = /^(1|2)?\d?\d([.](1|2)?\d?\d){3}$/;
		return expUrl.test(strIP);
	}	;

	window.bapdosa.util.checkMac = function(strMac){

		//strMac="0a:1b:3c:4d:5e:6f";
	    //regex= /^([0-9a-f]{2}([:-]|$)){6}$|([0-9a-f]{4}([.]|$)){3}$/i;
		regex= /^([0-9a-f]{2}([-]|$)){6}$|([0-9a-f]{4}([.]|$)){3}$/i;

	    return regex.test(strMac);
	};

	/*
	 * useragent에서 정보를 추출하여 webinfo객체에 deviceType, browser, ieVersion정보를 넣는다.
	 * deviceType : web, android, ipad
	 * browser : chrome, safari, ie
	 * ieVersion : 7,8,9
	 */
	window.bapdosa.util.setWebInfo = function(webinfo){
		var userAgent = navigator.userAgent.toLowerCase();

		//alert(userAgent);

		if(userAgent.match(/android/i) != null){
			webinfo.deviceType = "android";
			webinfo.androidVersion = (userAgent.match(/android [\d+\.]{3,5}/)||[''])[0].replace('android ','');

			//alert(webinfo.androidVersion);
		}
		else if(userAgent.match(/ipad/i) != null){
			webinfo.deviceType = "ipad";
			webinfo.iosVersion = (userAgent.match(/\b[0-9]+_[0-9]+(?:_[0-9]+)?\b/)||[''])[0].replace(/_/g,'.');
			//alert( webinfo.iosVersion);
		}
		else {
			webinfo.deviceType = "web";
		}

		if(userAgent.match(/chrome/i) != null)
			webinfo.browser = "chrome";
		else if(userAgent.match(/safari/i) != null)
			webinfo.browser = "safari";
		else if(userAgent.match(/msie/i) != null || userAgent.match(/Trident/i))
		{
			webinfo.browser = "ie";

			if (navigator.appVersion.indexOf("MSIE") != -1) {
				  var temp=navigator.appVersion.split("MSIE");
				  webinfo.ieVersion = parseFloat(temp[1]);
			}else if (navigator.appVersion.indexOf("Trident") != -1) {
				  var temp=navigator.appVersion.split("rv:");
				  webinfo.ieVersion = parseFloat(temp[1]);
			}
			
			//alert(navigator.appVersion + " : " + webinfo.browser + " : " + webinfo.ieVersion);
		}
		
		webinfo.domain = document.domain;
		
//		if(document.domain == "localhost"){
//			window.bapdosa.config.isLocal = true;
//			webinfo.accessType = "4"; // local
//		} else if(document.domain == "u-tong.sktelecom.com"){
//			webinfo.accessType = "1"; // 운영 내부망
//		} else if(document.domain == "utong.sktelecom.com"){
//			webinfo.accessType = "2"; // 운영 외부망
//		} else if(document.domain == "u-tongdev.sktelecom.com"){
//			if(location.port == "8030"){
//				webinfo.accessType = "0"; // 개발기(판매점)
//			} else {
//				webinfo.accessType = "3"; // 개발기
//			}
//		} else if(document.domain == "220.103.249.195"){
//			webinfo.accessType = "0"; //판매점망 
//		} else {
//			window.bapdosa.config.isLocal = true;
//			webinfo.accessType = "4"; // local
//		}
		
//		CONSOLE.log("location.href: " + location.href);
//		CONSOLE.log("document.domain: " + document.domain);
//		CONSOLE.log("location.host: " + location.host);
//		CONSOLE.log("location.protocol: " + location.protocol);
	};

	window.bapdosa.util.getArrayByLength = function(listStr, cropLength){

		CONSOLE.log(listStr);

		 var idListArr = [];
		 var flag = true;
		 while(flag){
			var idStr = listStr.substr(-cropLength);
			listStr = listStr.substr(0,listStr.length-cropLength);
			if(idStr){
				idListArr.push(idStr);
			} else {
				break;
			}
		 }

		 return idListArr;
	};
	
	//핸드폰 번호 체크
	window.bapdosa.util.isMobile = function(arg){

		 var regex = /^[01][1][016789]\d{4}\d{4}$/;
		 var chkFlg = regex.test(arg);
		 return chkFlg;

	};

	// 재외국인 번호 체크
	window.bapdosa.util.check_fgnno = function (fgnno) {
	 var sum=0;
	 var odd=0;
	 buf = new Array(13);
	 for(i=0; i<13; i++) { buf[i]=parseInt(fgnno.charAt(i)); }
	 odd = buf[7]*10 + buf[8];
	 if(odd%2 != 0) { return false; }
	 if( (buf[11]!=6) && (buf[11]!=7) && (buf[11]!=8) && (buf[11]!=9) ) {
	  return false;
	 }
	 multipliers = [2,3,4,5,6,7,8,9,2,3,4,5];
	 for(i=0, sum=0; i<12; i++) { sum += (buf[i] *= multipliers[i]); }
	 sum = 11 - (sum%11);
	 if(sum >= 10) { sum -= 10; }
	 sum += 2;
	 if(sum >= 10) { sum -= 10; }
	 if(sum != buf[12]) { return false; }
	 return true;
	}

	// 주민번호 체크
	window.bapdosa.util.check_juminno = function (juminno) {

	 var jumin1 = juminno.substr(0,6);
	 var jumin2 = juminno.substr(6,7);
	 var yy    = jumin1.substr(0,2); // 년도
	 var mm     = jumin1.substr(2,2); // 월
	 var dd     = jumin1.substr(4,2); // 일
	 var genda  = jumin2.substr(0,1); // 성별
	 var msg, ss, cc;

	 // 숫자가 아닌 것을 입력한 경우
	 if (!isNumeric(jumin1)) {
	  //alert("주민등록번호 앞자리를 숫자로 입력하세요.");
	  return false;
	 }
	 // 길이가 6이 아닌 경우
	 if (jumin1.length != 6) {
	  //alert("주민등록번호 앞자리를 다시 입력하세요.");
	  return false;
	 }
	 // 첫번째 자료에서 연월일(YYMMDD) 형식 중 기본 구성 검사
	 if (yy < "00" || yy > "99" ||
	  mm < "01" || mm > "12" ||
	  dd < "01" || dd > "31") {
	  //alert("주민등록번호 앞자리를 다시 입력하세요.");
	  return false;
	 }
	 // 숫자가 아닌 것을 입력한 경우
	 if (!isNumeric(jumin2)) {
	  //alert("주민등록번호 뒷자리를 숫자로 입력하세요.");
	  return false;
	 }
	 // 길이가 7이 아닌 경우
	 if (jumin2.length != 7) {
	  //alert("주민등록번호 뒷자리를 다시 입력하세요.");
	  return false;
	 }
	 // 성별부분이 1 ~ 4 가 아닌 경우
	 if (genda < "1" || genda > "4") {
	  //alert("주민등록번호 뒷자리를 다시 입력하세요.");
	  return false;
	 }
	 // 연도 계산 - 1 또는 2: 1900년대, 3 또는 4: 2000년대
	 cc = (genda == "1" || genda == "2") ? "19" : "20";
	 // 첫번째 자료에서 연월일(YYMMDD) 형식 중 날짜 형식 검사
	 if (isYYYYMMDD(parseInt(cc+yy), parseInt(mm), parseInt(dd)) == false) {
	  //alert("주민등록번호 앞자리를 다시 입력하세요.");
	  return false;
	 }
	 // Check Digit 검사
	 if (!isSSN(jumin1, jumin2)) {
	  //alert("입력한 주민등록번호를 검토한 후, 다시 입력하세요.");
	  return false;
	 }
	 return true;
	}

	// 사업자등록번호 체크
	window.bapdosa.util.check_busino = function (vencod) {
	 if(vencod.length == 0){
		 return false;	
	 }
	 var sum = 0;
	 var getlist =new Array(10);
	 var chkvalue =new Array("1","3","7","1","3","7","1","3","5");
	 for(var i=0; i<10; i++) { getlist[i] = vencod.substring(i, i+1); }
	 for(var i=0; i<9; i++) { sum += getlist[i]*chkvalue[i]; }
	 sum = sum + parseInt((getlist[8]*5)/10);
	 sidliy = sum % 10;
	 sidchk = 0;
	 if(sidliy != 0) { sidchk = 10 - sidliy; }
	 else { sidchk = 0; }
	 if(sidchk != getlist[9]) { return false; }
	 return true;
	}

	/*****
	 * 법인번호 체크
	 * return : boolean
	 * ex) 111111-1111111
	 *****/
	window.bapdosa.util.check_corpnum = function (resno){
	   fmt = /^\\d{6}-\\d{7}$/;
	   if(!fmt.test(resno)) return false;
	   // Check Sum 코드의 유효성 검사
	   buf = new Array(13);
	   for (i = 0; i < 6; i++) buf[i] = parseInt(resno.charAt(i));
	   for (i = 6; i < 13; i++) buf[i] = parseInt(resno.charAt(i + 1));

	   multipliers = [1,2,1,2,1,2,1,2,1,2,1,2];
	   for (i = 0, sum = 0; i < 12; i++) sum += (buf[i] *= multipliers[i]);
	   if(10 - sum.toString().substring(sum.toString().length*1 - 1,sum.toString().length*1)*1 != buf[12]) return false;

	   return true;
	}

	window.bapdosa.util.isYYYYMMDD = function (y, m, d) {
	 switch (m) {
	 case 2: // 2월의 경우
	  if (d > 29) return false;
	  if (d == 29) {
	   // 2월 29의 경우 당해가 윤년인지를 확인
	   if ((y % 4 != 0) || (y % 100 == 0) && (y % 400 != 0))
	    return false;
	  }
	  break;
	 case 4: // 작은 달의 경우
	 case 6:
	 case 9:
	 case 11:
	  if (d == 31) return false;
	 }
	 // 큰 달의 경우
	 return true;
	}
	
	window.bapdosa.util.isNumeric = function (s) {
	 for (i=0; i<s.length; i++) {
	  c = s.substr(i, 1);
	  if (c < "0" || c > "9") return false;
	 }
	 return true;
	}
	
	window.bapdosa.util.isLeapYear = function (y) {
	 if (y < 100)
	 y = y + 1900;
	 if ( (y % 4 == 0) && (y % 100 != 0) || (y % 400 == 0) ) {
	  return true;
	 } else {
	  return false;
	 }
	}
	
	window.bapdosa.util.getNumberOfDate = function (yy, mm) {
	 month = new Array(29,31,28,31,30,31,30,31,31,30,31,30,31);
	 if (mm == 2 && window.bapdosa.util.isLeapYear(yy)) mm = 0;
	 return month[mm];
	}
	
	//현재달의 총 날짜 개수
	window.bapdosa.util.getNumberOfCurrentDate = function () {		
		var d = new Date();
		var fullyear = d.getFullYear() + "";
		var yy = fullyear.substring(2,4);
		var mm = d.getMonth() + 1;
		
		return window.bapdosa.util.getNumberOfDate(yy,mm);
	}
	//현재달의 남은날짜 개수
	window.bapdosa.util.getRemainDayOfCurrentDate = function () {	
		var d = new Date();
		var day = d.getDate();
		var totalDay = window.bapdosa.util.getNumberOfCurrentDate();
		
		return totalDay - day + 1;
	}	
	
	window.bapdosa.util.isSSN = function (s1, s2) {
	 n = 2;
	 sum = 0;
	 for (i=0; i<s1.length; i++)
	  sum += parseInt(s1.substr(i, 1)) * n++;
	 for (i=0; i<s2.length-1; i++) {
	  sum += parseInt(s2.substr(i, 1)) * n++;
	  if (n == 10) n = 2;
	 }
	 c = 11 - sum % 11;
	 if (c == 11) c = 1;
	 if (c == 10) c = 0;
	 if (c != parseInt(s2.substr(6, 1))) return false;
	 else return true;
	}



	window.bapdosa.util.getNumber = function (obj){
	   //[] <--문자 범위 [^] <--부정 [0-9] <-- 숫자  
	   //[0-9] => \d , [^0-9] => \D
	   var rgx1 = /\D/g;  // /[^0-9]/g 와 같은 표현		
		
	   var num01;
	   var num02;
	   num01 = obj.value;
	   num02 = num01.replace(rgx1,"");
	   num01 = setComma(num02);
	   obj.value =  num01;

	}

	window.bapdosa.util.setComma = function (inNum){
	   
	   var rgx2 = /(\d+)(\d{3})/; 
	   var outNum;
	   outNum = inNum + ""; 
	   while (rgx2.test(outNum)) {
	        outNum = outNum.replace(rgx2, '$1' + ',' + '$2');
	    }
	   return outNum;
	}

	window.bapdosa.util.passChg = function (isVal, tagId){
		
		var count = isVal.length;
		var realvalue =  $("#"+tagId+"h").val();
		
		if(event.keyCode >= 48 && event.keyCode < 58 ) {  //숫자 영문 인 경우
			   $("#"+tagId+"h").val(realvalue.substring(0,count)+ String.fromCharCode(event.keyCode));
		} else {
		 	$("#"+tagId+"h").val(realvalue.substring(0,count));
		}
		
		var strText = '';
		for(var i =0; i < count; i++){
		  strText = strText + '*';
		}
		$("#"+tagId).val(strText);
		
	}
	
	window.bapdosa.util.masking = function (oriNum, length, mask){
		var returnVal = oriNum;
		
		if(oriNum.length < length){
			for(var i=oriNum.length; i<length; i++){
				returnVal += "" + mask;
			}			
		}
		return returnVal;
	}
	
	window.bapdosa.util.replaceMasking = function (oriStr, length, mask){
		var returnVal = "";
		
		if(oriStr.length >= length){
			for(var i=0; i<oriStr.length; i++){
				
				if(i>=length)
					returnVal += "" + mask;
				else
					returnVal += "" + oriStr[i]
			}			
		}
		return returnVal;
	}	
	
	window.bapdosa.util.onlyMasking = function (oriStr, length, mask){
		var returnVal = "";
		
		if(oriStr.length >= length){
			for(var i=0; i<oriStr.length; i++){
				
				if(i==length-1)
					returnVal += "" + mask;
				else
					returnVal += "" + oriStr[i]
			}			
		}
		return returnVal;
	}	
	
	window.bapdosa.util.mdnMasking = function (oriNum){
		var returnVal = oriNum;
		
		if(oriNum.length == 10){
			returnVal = oriNum.substring(0,3) + "0" + oriNum.substring(3)
		}
		return returnVal;
	}	
	
	//상담내역 자리수 체크
	window.bapdosa.util.CheckStrLen = function (val,maxlen){
	  var  temp; 
	  var  msglen;
	  
	  msglen  =  maxlen*2;
	  var  value=  val.value;
	  
	  l  =  val.value.length;  
	  tmpstr  =  ""  ;
	  if  (l  ==  0){
		  value  =  maxlen*2;
	  } else {
		  for(var k=0;k<l;k++){
			  temp  =value.charAt(k);
			  if  (escape(temp).length  >  4)
				  msglen  -=  2;
			  else
				  msglen--;
			  if(msglen  <  0)  {
				  alert("총 영문 "+(maxlen*2)+"자 한글 " + (maxlen) + "자 까지 저장 하실 수 있습니다.");
				  val.value=  tmpstr;
				  break;
			  } else{
				  tmpstr  +=  temp;
			  }
		   }
	  }
	}
	
	// 배열 합계 구하기 함수
	window.bapdosa.util.arrSum = function(array) {
		var result = 0;		
		for (var i = 0; i < array.length; i++){
			result += parseInt(parseInt(array[i]));
		}
		
		return result;
	}
	
	window.bapdosa.util.checkEmail = function(str){
	    var reg = /^((\w|[\-\.])+)@((\w|[\-\.])+)\.([A-Za-z]+)$/;
	   
	    if (str.search(reg) != -1) {
	           return false;
	    }
	    return true;
	}

	window.bapdosa.util.leadingZeros = function(n, digits) {
		  var zero = '';
		  n = n.toString();

		  if (n.length < digits) {
		    for (var i = 0; i < digits - n.length; i++)
		      zero += '0';
		  }
		  return zero + n;
	}

	window.bapdosa.util.getTimeToDate = function(time, separation){
		var d = new Date(time);
		
		if(!separation){
			separation = ".";
		}
		
		return d.getFullYear() + separation + leadingZeros(d.getMonth()+1, 2) + separation + leadingZeros(d.getDate(),2);
	}

	window.bapdosa.util.nl2br = function(str, is_xhtml) {   
	    var breakTag = (is_xhtml || typeof is_xhtml === 'undefined') ? '<br />' : '<br>';    
	    return (str + '').replace(/([^>\r\n]?)(\r\n|\n\r|\r|\n)/g, '$1'+ breakTag +'$2');
	}

	window.bapdosa.util.getNumberOnly = function(val)
	{
	    val = new String(val);
	    var regex = /[^0-9]/g;
	    val = val.replace(regex, '');
	    
	    return val;
	}	
	
	
	/*
	 * param YYYYMMDD HH:mm:ss 형식
	 * return 01:14  (1시14분)
	 */
	window.bapdosa.util.getUsedDateFromNow = function(YYYYMMDDHHmmss)
	{
		var returnVal = "";
		var msecPerMinute = 1000 * 60;
		var msecPerHour = msecPerMinute * 60;
		var msecPerDay = msecPerHour * 24;
		var nowTime = new Date().getTime();
		
		var thatTime = moment(YYYYMMDDHHmmss, "YYYYMMDD HH:mm:ss").valueOf();
		var interval = nowTime - thatTime;
		var days = Math.floor(interval / msecPerDay );
		interval = interval - (days * msecPerDay );

		// Calculate the hours, minutes, and seconds.
		var hours = Math.floor(interval / msecPerHour );
		interval = interval - (hours * msecPerHour );

		var minutes = Math.floor(interval / msecPerMinute );
		interval = interval - (minutes * msecPerMinute );
		var seconds = Math.floor(interval / 1000 );
		console.log(days + " days, " + hours + " hours, " + minutes + " minutes, " + seconds + " seconds.");
		
		if(days < 0){
			returnVal = 0;
		} else {
			if(days > 0){
				returnVal = days+" day " + window.bapdosa.util.leadingZeros(hours,2) + ":" + window.bapdosa.util.leadingZeros(minutes, 2);
			} else if(hours > 0){
				returnVal = window.bapdosa.util.leadingZeros(hours,2) + ":" + window.bapdosa.util.leadingZeros(minutes, 2);
			} else {
				returnVal = window.bapdosa.util.leadingZeros(minutes, 2);
			}
		}
	    
	    return returnVal;
	}
	
	/*
	 * param ㄱ
	 * return boolean
	 */
	window.bapdosa.util.isInitialLetter = function(str)
	{
		var pattern = /[^ㄱ-ㅎ]/i;
	    
	    return !pattern.test(str);
	}	
	
	/*
	 * 24시간 => 12시간 , 예) 00 -> 12, 12-> 12
	 * param HH (00~23)
	 * return 02
	 */
	window.bapdosa.util.hourTo12 = function(hour)
	{
		var hour = parseInt(hour);
		var hourTime = ['12','01','02','03','04','05','06','07','08','09','10','11','12','1','2','3','4','5','6','7','8','9','10','11'];	    
	    return hourTime[hour];
	}	
	
	/*
	 * 12시간 => 24시간 , 예) 오전, 12 -> 00; 오후, 12-> 12
	 * param 오전(오후),HH (1~12)
	 * return 02
	 */
	window.bapdosa.util.hourTo24 = function(diff, hour)
	{
		var hour = parseInt(hour);		
		var hourTime = {
			'오전': ['','01','02','03','04','05','06','07','08','09','10','11','00'],
			'오후': ['','13','14','15','16','17','18','19','20','21','22','23','12']
		};	    
	    return hourTime[diff][hour];
	}	
	
	/*
	 * HH -> 오전/오후
	 * param HH (00~23)
	 * return 오후
	 */
	window.bapdosa.util.hourToampm = function(hour)
	{
		var hour = parseInt(hour);   
	    return hour < 12 ? '오전' : '오후';
	}	