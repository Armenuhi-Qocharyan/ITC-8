$('.toggle').on('click', function() {
  $('.log-container').stop().addClass('active');
});

$('.close').on('click', function() {
  $('.log-container').stop().removeClass('active');
});
