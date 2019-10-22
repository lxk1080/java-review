var rotX = 40;
var rotY = -30;
var currX = 0;
var currY = 0;
var flag=0;
tracking = false;

$(document).ready(function() {
  
  diff = $('.container').width() - $('.container').height();
  $('.container .inner').css({marginTop: '-'+diff/2+'px'})

  setBindings();
  
  setRotation(0,0);
});

function unsetBindings() {
  $('body, li').off();
}

function setBindings() {
  $('body').on('mousedown touchstart', function(e) {
    if (e.type == "touchstart") {
     interactionStart(e.originalEvent.touches[0].clientX, e.originalEvent.touches[0].clientY);
    } else {
      interactionStart(e.clientX, e.clientY);
    }
    e.preventDefault();
  });

  $('body').on('mousemove touchmove', function(e) {
    if (e.type == "touchmove") {
      interactionMove(e.originalEvent.touches[0].clientX, e.originalEvent.touches[0].clientY);
    } else {
      interactionMove(e.clientX, e.clientY);
    }
    e.preventDefault();
  });

  $('body').on('mouseup touchend', function(e) {
    interactionEnd();
    e.preventDefault();
  });
  
  $('.front').on('click', function() {
      $('.container').addClass('anim');
      rotX = 0;
      rotY = 0;
      setRotation(0,0);
    $("span.res").html("魔兽世界").css("color","#FC4A3D");
	$(".m").next().remove();
	
	  $(".m").after("<audio id='audio' autoplay='true' loop='true'><source src='music/Russell Brower - Why Do we Fight.mp3' type='audio/mp3'></audio>");
	    
	flag=1;
  })
  $('.right').on('click', function() {
      $('.container').addClass('anim');
      rotX = -90;
      rotY = 0;
      setRotation(0,0);
	  $("span.res").html("DOTA2").css("color","#FC4A3D");
      $(".m").next().remove();

	$(".m").after("<audio id='audio' autoplay='true' loop='true'><source src='music/Dota2.mp3' type='audio/mp3'></audio>");
	    
	flag=4;
  })
  $('.back').on('click', function() {
      $('.container').addClass('anim');
      rotX = -180;
      rotY = 0;
      setRotation(0,0);
	  $("span.res").html("守望先锋").css("color","#FC4A3D");
      $(".m").next().remove();

	$(".m").after("<audio id='audio' autoplay='true' loop='true'><source src='music/Derek Duke - Rally the Heroes.mp3' type='audio/mp3'></audio>");
	    
	flag=5;
  })
  $('.left').on('click', function() {
      $('.container').addClass('anim');
      rotX = 90;
      rotY = 0;
      setRotation(0,0);
    $("span.res").html("地下城与勇士").css("color","#FC4A3D");
	$(".m").next().remove();
	
	$(".m").after("<audio id='audio' autoplay='true' loop='true'><source src='music/DNF.mp3' type='audio/mp3'></audio>");
	
	flag=2;
  })
  $('.top').on('click', function() {
      $('.container').addClass('anim');
      rotX = 0;
      rotY = -90;
      setRotation(0,0);  
	  $("span.res").html("英雄联盟").css("color","#FC4A3D");
	  $(".m").next().remove();
	  
	  $(".m").after("<audio id='audio' autoplay='true' loop='true'><source src='music/League of Legends - Welcome To Planet Urf.mp3' type='audio/mp3'></audio>");
	  
	  flag=3;
  })
  $('.bottom').on('click', function() {
      $('.container').addClass('anim');
      rotX = 0;
      rotY = 90;
      setRotation(0,0);
	  $("span.res").html("穿越火线").css("color","#FC4A3D");
	  $(".m").next().remove();

	$(".m").after("<audio id='audio' autoplay='true' loop='true'><source src='music/CF.mp3' type='audio/mp3'></audio>");
	    
	flag=6;
  })
}

function interactionStart(x, y) {
  currX = x;
  currY = y;
  tracking = true;
  $('.container').addClass('tracking');
}

function interactionMove(x, y) {
  if (tracking == false) {
    return;
  }
  var deltaX = x - currX;
  var deltaY = y - currY;
  setRotation(deltaX, deltaY);
  currX = x;
  currY = y;
}

function setRotation(x, y) {
  if (tracking == false) {
    unsetBindings();
    setTimeout(function() {
    setBindings();
      $('.container').removeClass('anim');
    }, 1000);
  }
  rotX+=x;
  rotY+=y;
  if (rotX >= 180) {
    rotX-=360;
  } else if (rotX <= (-179)) {
    rotX+=360;
  }
  
  if (rotY >= 90) {
    rotY = 90;
  } else if (rotY <= (-90)) {
    rotY = -90;
  }
  
  var radX = 0;
  var radZ = 0; // start front-facing?
  var radY = 0;
  
  $('.container .inner').css({transform:'rotateX('+rotY+'deg) rotateY('+rotX+'deg) translate3d('+radX+'px,'+radY+'px,'+radZ+'px)'});
}

function interactionEnd() {
  tracking = false;
  $('.container').removeClass('tracking');
}