$( function() {
    $( "#car" ).draggable();
    $( "#carPark" ).droppable({
        drop: function( event, ui ) {
            $( this )
            $('form').submit();
        }
    });
} );