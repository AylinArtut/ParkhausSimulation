// For the little game before entering the car park:
$( function() {
    // You can drag & drop the car:
    $( "#car" ).draggable();
    // And when you drop the car on carPark, the submitting is activated:
    $( "#carPark" ).droppable({
        drop: function( event, ui ) {
            $( this )
            $("form").submit();
        }
    });
} );