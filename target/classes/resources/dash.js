var gcnm;
$(document).ready(() => {
  addResizeListeners();
  setSidenavListeners();
  setUserDropdownListener();
  
  setMenuClickListener();
  setSidenavCloseListener();
  document.getElementById("logout").addEventListener("click", logoutfn);
});
$(document).ready(function(){
	var email;
	var queryString = window.location.search;
	console.log(queryString);
	var urlParams = new URLSearchParams(queryString);
	var conm = urlParams.get('cnm');
	//conm = window.atob(conm);
	console.log("cookie name="+conm);
	gcnm=conm;
	var auth =getCookie(conm);
	//alert(auth);
	
	console.log("#######"+auth+"######"+gcnm);
	 $.ajax({
         url: '/dashboard',
         type: 'POST',
         headers:{'Auth-Code':auth},
         statusCode: {
         	200 : function(response,textstatus,xhr) {
                 
             	
					alert((xhr.responseText));
					var res = JSON.parse(xhr.responseText);
					
					document.getElementById("name").innerHTML=res.firstname;
					document.getElementById("fullname").innerHTML=res.firstname+res.lastname;
					email=res.email;
					
					for(var i=0;i<res.usertimeline.event.length;i++)
						{
						console.log(res.usertimeline.event[i].eventdate);
						var tm='<div class="card__row">\
							<div class="card__icon"><i class="fas fa-plane"></i></div>\
							<div class="card__time">\
							  <div>Tuesday</div>\
							</div>\
							<div class="card__detail">\
							  <div class="card__source text-bold">Matthew H</div>\
							  <div class="card__description">Flying to Bora Bora at 4:30pm</div>\
							  <div class="card__note">Delta, Gate 27B</div>\
							</div>\
							</div>';

							  
							  document.getElementById("dab").innerHTML+=tm;

						}
             
             }
         	
         }
                
 });
	
	
	
	
	
	
	
	
	});

function updatePage()
{
var auth =getCookie("Auth-Code");
//alert(auth);
document.getElementById("time").innerHTML='';

$.ajax({
 url: '/dashboard',
 type: 'POST',
 headers:{'Auth-Code':auth},
 statusCode: {
 	200 : function(response,textstatus,xhr) {
         
     	
			//alert((xhr.responseText));
			var res = JSON.parse(xhr.responseText);
			
			document.getElementById("name").innerHTML=res.firstname;
			email=res.email;
			console.log(email);
			
			for(var i=0;i<res.usertimeline.event.length;i++)
				
					{
					var tm='<div class="card__row">\
<div class="card__icon"><i class="fas fa-plane"></i></div>\
<div class="card__time">\
  <div>Tuesday</div>\
</div>\
<div class="card__detail">\
  <div class="card__source text-bold">Matthew H</div>\
  <div class="card__description">Flying to Bora Bora at 4:30pm</div>\
  <div class="card__note">Delta, Gate 27B</div>\
</div>\
</div>';

  
  document.getElementById("dab").innerHTML+=tm;
  


						
					//console.log(document.getElementById("dab").innerHTML);
					}
     }
 	
 }
        
});
}
function logoutfn()
{
	
	console.log("loggedout");
	$.ajax({
         url: '/logout',
         headers:{'cookiename':gcnm},
         type: 'POST',
         statusCode: {
         	200 : function(response,textstatus,xhr) {
                 console.log("loggedout");
                 window.location.href="log.html";
			}
	
         }
		 });
	
	
}
function setCookie(cname, cvalue, exdays) {
var d = new Date();
d.setTime(d.getTime() + (exdays*24*60*60*1000));
var expires = "expires="+ d.toUTCString();
document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
}
function getCookie(cname) {
var name = cname + "=";
var decodedCookie = decodeURIComponent(document.cookie);
console.log(decodedCookie);
var ca = decodedCookie.split(';');
for(var i = 0; i <ca.length; i++) {
var c = ca[i];
console.log(c);
console.log("Shivam");
while (c.charAt(0) == ' ') {
  c = c.substring(1);
}
if (c.indexOf(name) == 0) {
  return c.substring(name.length, c.length);
}
}
return "";
}



// Set constants and grab needed elements
const sidenavEl = $('.sidenav');
const gridEl = $('.grid');
const SIDENAV_ACTIVE_CLASS = 'sidenav--active';
const GRID_NO_SCROLL_CLASS = 'grid--noscroll';

function toggleClass(el, className) {
  if (el.hasClass(className)) {
    el.removeClass(className);
  } else {
    el.addClass(className);
  }
}

// User avatar dropdown functionality
function setUserDropdownListener() {
  const userAvatar = $('.header__avatar');

  userAvatar.on('click', function(e) {
    const dropdown = $(this).children('.dropdown');
    toggleClass(dropdown, 'dropdown--active');
  });
}

// Sidenav list sliding functionality
function setSidenavListeners() {
  const subHeadings = $('.navList__subheading'); console.log('subHeadings: ', subHeadings);
  const SUBHEADING_OPEN_CLASS = 'navList__subheading--open';
  const SUBLIST_HIDDEN_CLASS = 'subList--hidden';

  subHeadings.each((i, subHeadingEl) => {
    $(subHeadingEl).on('click', (e) => {
      const subListEl = $(subHeadingEl).siblings();

      // Add/remove selected styles to list category heading
      if (subHeadingEl) {
        toggleClass($(subHeadingEl), SUBHEADING_OPEN_CLASS);
      }

      // Reveal/hide the sublist
      if (subListEl && subListEl.length === 1) {
        toggleClass($(subListEl), SUBLIST_HIDDEN_CLASS);
      }
    });
  });
}

// Draw the chart

function toggleClass(el, className) {
  if (el.hasClass(className)) {
    el.removeClass(className);
  } else {
    el.addClass(className);
  }
}

// If user opens the menu and then expands the viewport from mobile size without closing the menu,
// make sure scrolling is enabled again and that sidenav active class is removed
function addResizeListeners() {
  $(window).resize(function(e) {
    const width = window.innerWidth; console.log('width: ', width);

    if (width > 750) {
      sidenavEl.removeClass(SIDENAV_ACTIVE_CLASS);
      gridEl.removeClass(GRID_NO_SCROLL_CLASS);
    }
  });
}

// Menu open sidenav icon, shown only on mobile
function setMenuClickListener() {
  $('.header__menu').on('click', function(e) { console.log('clicked menu icon');
    toggleClass(sidenavEl, SIDENAV_ACTIVE_CLASS);
    toggleClass(gridEl, GRID_NO_SCROLL_CLASS);
  });
}

// Sidenav close icon
function setSidenavCloseListener() {
  $('.sidenav__brand-close').on('click', function(e) {
    toggleClass(sidenavEl, SIDENAV_ACTIVE_CLASS);
    toggleClass(gridEl, GRID_NO_SCROLL_CLASS);
  });
}
