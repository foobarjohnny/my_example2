<%@page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Just Scratch It</title>
	<script type="text/javascript">
    	$('.carousel').carousel({
        	interval: 2000
        })
	
	</script>
</head>
<body>
	<section>
		<div id="myCarousel" class="carousel">
		    <div class="carousel-inner">
			    <div class="active item"><img src="http://twitter.github.com/bootstrap/assets/img/bootstrap-mdo-sfmoma-01.jpg"></img></div>
			    <div class="item"><img src="http://twitter.github.com/bootstrap/assets/img/bootstrap-mdo-sfmoma-02.jpg"></img></div>
			    <div class="item"><img src="http://twitter.github.com/bootstrap/assets/img/bootstrap-mdo-sfmoma-03.jpg"></img></div>
		    </div>
		    <a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
		    <a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
    	</div>
	</section>
</body>
</html>