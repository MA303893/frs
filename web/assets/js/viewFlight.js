$(function () {
    var deleteFlight = $("#deleteFlight")
    deleteFlight.click(function () {
        $('#exampleModal').modal('show');
    });
    var deleteFlightBtn = $("#deleteFlightBtn");
    deleteFlightBtn.click(function () {
        var url = this.dataset.id;
        $.get(url,function () {
            
        });
    });
});