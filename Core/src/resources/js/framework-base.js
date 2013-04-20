function performActivity(object) {
    $.ajax({
        dataType: "json",
        url: "/activity",
        data: object,
        success: function (result) {
            if (result.type == "html") {
                $('#content').html(result.html);
            } else if (result.type == "media") {
                $('#content').html();
            }

        }
    });
    return false;
}

function createVideoPlayer() {

}