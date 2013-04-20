function nextActivity(object) {
    $.ajax({
        url:"/activity",
        data: object
    }).done(function (result) {
            $('#content').html(result);
        });
    return false;
}