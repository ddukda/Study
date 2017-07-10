<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
<title>Jquery Test</title>
<style type="text/css">
body {
	background: url(http://img263.imageshack.us/img263/343/darkwoodsx7.jpg);
	font-family: "Georgia", "Times New Roman", serif;
	font-size: .8em;
	color: #fff;
	text-align: center;
	text-shadow: 0 -1px 0 #000;
}

h1 {
	font-size: 1.7em;
	line-height: 150%;
}

#wrapper {
	position: relative;
	height: 320px;
	width: 280px;
	margin: 15px auto;
}

img {
	position: relative;
	float: left;
	padding: 0;
	margin: 5px;
	-webkit-box-shadow: 0 0 5px #000;
	-moz-box-shadow: 0 0 5px #000;
	border: solid 2px #FFFAF2;
	border-bottom: solid 15px #FFFAF2;
	-webkit-transition: -webkit-transform 0.20s ease-in-out;
	-moz-transition: -moz-transform 0.20s ease-in-out;
}
</style>

<script type="text/javascript">
	/*
	 ---
	 script: ElementStacks.js
	 decription: ElementStacks stacks elements/images on top of each other with a funky transition
	 license: MIT-style license.
	 authors:
	 - Oskar Krawczyk (http://nouincolor.com/)
	 requires: 
	 core:1.2.4: 
	 - Class.Extras
	 - Array
	 - Function
	 - Event
	 - Element.Style
	 - Element.Dimensions
	 - Fx.Morph
	 - Fx.Transitions
	 provides: [ElementStacks]
	 ...
	 */

	// bigger demo: http://nouincolor.com/ElementStack/
	var ElementStacks = new Class(
			{
				Implements : [ Options ],

				options : {
					rotationDeg : 20,
					delay : 40,
					duration : 900,
					transition : 'back:out'
				},

				initialize : function(selector, wrapper, options) {
					this.setOptions(options);
					this.pos, this.collapsed, this.wrapper = wrapper,
							this.stackItems = selector

					this.setDefaults();
				},

				setDefaults : function() {
					this.stackItems.each(function(stackItem) {
						this.pos = stackItem.getPosition(this.wrapper);

						stackItem.store('default:coords', this.pos);

						stackItem.set('styles', {
							top : this.pos.y,
							left : this.pos.x
						});

						stackItem.set('morph', {
							transition : this.options.transition,
							duration : this.options.duration
						});

						// MooTools bug (?)
						(function() {
							this.setStyle('position', 'absolute');
						}).delay(1, stackItem);
					}, this);

					this.attachActions();
				},

				reStack : function(els, mode, altEl) {
					var that = this;
					els
							.each(function(stackItem, i) {
								(function() {
									var el = $pick(altEl, this);
									var rand = (mode === 'in' ? $random(
											-that.options.rotationDeg,
											that.options.rotationDeg) : 0);

									this.set('styles', {
										'-webkit-transform' : 'rotate(' + rand
												+ 'deg)',
										'-moz-transform' : 'rotate(' + rand
												+ 'deg)'
									});

									this.morph({
										top : el.retrieve('default:coords').y
												+ rand,
										left : el.retrieve('default:coords').x
												+ rand
									});

									if (mode === 'in') {
										el.setStyle('z-index', 100);
									} else {
										(function() {
											els.setStyle('z-index', 10);
										}).delay(that.options.delay
												* (els.length * 2));
									}
								}).delay(that.options.delay * i, stackItem);
							});
				},

				attachActions : function() {

					this.stackItems
							.addEvents({
								click : function(e) {

									if (this.collapsed) {
										this.reStack(this.stackItems);
										this.collapsed = false;
									} else {
										var target = $(e.target);

										if (target.retrieve('default:coords')) {
											this.reStack(this.stackItems, 'in',
													target);
											this.collapsed = true;
										}
									}
								}.bind(this)
							});
				}
			});

	new ElementStacks($$('img'), $('wrapper'));
</script>
<script src="../common/googleAnalytics.js"></script></head>
<body>
	<h1>ElementStack.js</h1>
	<p>Click on one of the images to toggle stacks</p>

	<div id="wrapper">
		<img width="75" height="75"
			src="http://farm3.static.flickr.com/2697/4106711273_969cc50546_s.jpg" />
		<img width="75" height="75"
			src="http://farm3.static.flickr.com/2639/4142476380_7b928bdd6d_s.jpg" />
		<img width="75" height="75"
			src="http://farm3.static.flickr.com/2607/4194526085_a129ff3485_s.jpg" />
		<img width="75" height="75"
			src="http://farm4.static.flickr.com/3298/3502874366_d73cb0f6fe_s.jpg" />
		<img width="75" height="75"
			src="http://farm3.static.flickr.com/2630/3795161224_1012daa415_s.jpg" />
		<img width="75" height="75"
			src="http://farm3.static.flickr.com/2736/4158101064_89f08e4bff_s.jpg" />
		<img width="75" height="75"
			src="http://farm4.static.flickr.com/3524/3880365897_682521f7b9_s.jpg" />
		<img width="75" height="75"
			src="http://farm5.static.flickr.com/4072/4208775604_8d1e65578d_s.jpg" />
		<img width="75" height="75"
			src="http://farm5.static.flickr.com/4005/4247684077_6848f141ff_s.jpg" />
	</div>
</body>
</html>