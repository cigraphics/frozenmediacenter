function performActivity(object) {
    object.type = "current";
    getJson("/activity", object, handleResponse);
    return false;
}

function handleResponse(result) {
    if (result.type == "html") {
        $('#content').html(result.html);
    } else if (result.type == "media") {
        $('#content').html();
    }
}

function getJson(url, data, successHandler) {
    $.ajax({
        dataType: "json",
        url: url,
        data: data,
        success: successHandler
    });
}

function restoreDefaultActivity() {
    getJson("/activity", {'type': 'default'}, handleResponse);
}

function restorePreviousActivity(object) {
    getJson("/activity", {'type': 'previous'}, handleResponse);
}

function createVideoPlayer() {

}