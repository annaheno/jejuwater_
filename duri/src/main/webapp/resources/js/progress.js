$(function() {
  var progressbar = $( "#progressbar" ),
    progressLabel = $( ".progress-label" );
    progressLabel2 = $( ".progress-label2" );

  progressbar.progressbar({
    change: function() {
      progressLabel.text( progressbar.progressbar( "value" ) + "%" );
      progressLabel2.text( "2,199,502원" );
    },
    complete: function() {
    }
  });

  function progress() {
    var val = progressbar.progressbar( "value" ) || 0;
    progressbar.progressbar( "value", val + 2 );

    if ( val < 42 ) {
      setTimeout( progress, 20 );
    }
  }

  setTimeout( progress, 0 );
});