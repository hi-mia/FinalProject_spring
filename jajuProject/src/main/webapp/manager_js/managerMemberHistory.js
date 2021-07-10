$(function(){
	

	//이름 
	$.ajax({
		type:'post',
		url:'/jaju/mypage/getMyProfileInfo',
		data: //{'id':$('#id').val()},//id값 가져가야 해당 로그인 한 사람의 관심정보 가져올 수 있음.
		 {'id':$('#id').val()},
		 
		dataType:'json',
		success:function(data){
			var text
			if(data.memberDTO.member_name==""){
				text = "no name"; 
			}else{
				text=data.memberDTO.member_name;
			}
			
			//alert("name? " +data);
			
			//console.log("getMyProfileInfo"+data);
			if(data.memberDTO.member_image==null){
				$('.profile_image').attr('src','/jaju/storage/unnamed.png');
			}
			else{
				$('.profile_image').attr('src','/jaju/storage/'+data.memberDTO.member_image);
			}
			
			$('#name').append($('<p/>',{
				class: 'info',
				text: text+'님',
				style:'font-weight:bold; font-weight: 700; font-size: 20px;color: #47597e; height: 20px; flex-grow: 3; margin-top: 30px;  position: relative;'
			}).append($('<span/>',{
				class: 'expire'
			})));
			
		},error:function(err){
			consoloe.log("err발생"+err);
		}
	});//getMemberName
	
	
	$.ajax({
		type:'post',
		url:'/jaju/mypage/mysaleStateCount',
		
		data: {'id':$('#id').val()},//id값 가져가야 해당 로그인 한 사람의 관심정보 가져올 수 있음.
		dataType:'json',
		
		success: function(data){
			
			//console.log(JSON.stringify(data));
			
			$.each(data.list, function(index, items){
				//console.log(items.dealCount),console.log(items.saleCount),console.log(items.buyCount)
				var sale_text;
				var buy_text;
				var deal_text;
				
				if(items.saleCount=="0"){
					sale_text = '판매완료 '+"\u00a0"+items.saleCount+'건';//판매를 시작해보세요!; 
				}else if(items.saleCount!=""){
					sale_text='판매완료 '+"\u00a0"+items.saleCount+'건';
				}
				
				if(items.buyCountAll=="0"){
					buy_text = '구매완료 '+"\u00a0"+items.buyCountAll+'건';//구매를 시작해보세요!
				}else if(items.buyCount!=""){
					buy_text ='구매완료 '+"\u00a0"+items.buyCountAll+'건';
				}
				if(items.buyCount=="0"){
					deal_text = '판매중'+"\u00a0\u00a0\u00a0\u00a0\u00a0"+items.dealCount+'건';//"판매중
				}else if(items.buyCount!=""){
					deal_text ='판매중'+"\u00a0\u00a0\u00a0\u00a0\u00a0"+items.dealCount+'건';
				}
				if(items.reviewCount=="0"){
					review_text = items.reviewCount+'건';//"후기내역
				}else if(items.reviewCount!=""){
					review_text = items.reviewCount+'건';
				}
				
				
				
				$('#sale').append($('<span/>',{
					class: 'info',
					id: 'saleBtn',
					text: sale_text, 
					style:'font-weight:bold; font-weight: 700; font-size:17px;color: #47597e; margin-top: 30px;'   //style="margin-top: 0px;"
				}));
				$('#buy').append($('<span/>',{
					class: 'info',
					id: 'buyBtn',
					text: buy_text,
					style:'font-weight:bold; font-weight: 700; font-size: 17px; color: #47597e; '
				}));
				
				$('#deal').append($('<span/>',{
					class: 'info',
					id: 'dealBtn',
					text: deal_text,
					style:'font-weight:bold; font-weight: 700; font-size: 17px; color: #47597e; '
				}));
				
				$('#scrap_count').append($('<p/>',{
					class: 'info',
					style:"margin-bottom: margin-top: 0px;border-top-width: 0px;border-bottom-width: 25px;bottom: 32px;",
					//id:'review',
					text: review_text
				}).append($('<span/>',{
					class: 'expire'
				})));
			}); //each	
		},
		error:function(err){
			console.log("saleStateCount에러"+err);
		}	
	});//mysaleStateCount ajax
	

	
		//console.log("이2"+$('#id').val() );
  
});	


