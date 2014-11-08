$(function () {
    $("#createNoteButton").click(function () {
        $.ajax({
            url: "/note/create",
        }).done(function (response, status, xhr) {
            console.log(response);
            $("#addNewNote").html(response);
        });
    })
})

