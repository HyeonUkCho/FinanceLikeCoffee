

$(function(){
	var pagesection6_OffSetTop = $('#pagesection6').offset().top;
	var detail_apply = document.getElementById("detail_apply");
					
					
	$(window).scroll(function(){
	var scroll = $(window).scrollTop();
	var window_Height = $(window).outerHeight();
	var top_distance = pagesection6_OffSetTop - window_Height;
						
	if( scroll >= top_distance )
	{							
		$(detail_apply).addClass('sticky');   
			document.getElementsByClassName('sticky')[0].style.bottom = "0px";
			detail_apply.style.display = "block";
	}
	else
	{
		$(detail_apply).removeClass('sticky');   
		detail_apply.style.display = "none";
	}

	});
});
