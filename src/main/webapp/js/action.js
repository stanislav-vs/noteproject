/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function getList(result) {

    for (var k in result) {
        var item = result[k];
        $("#noteList tbody").append("<tr>"
                + "<td>" + item.id + "</td>"
                + "<td>" + item.title + "</td>"
                + "<td>" + item.description + "</td>"
                + "<td><img src=\"/uploads/" + item.picture + "\" alt=\"image\" height=\"42\" width=\"42\" /></td>"
                + "<td><button class='deleteNoteButton' type='button' data-itemid='" + item.id + "' >Remove</button></td>"
                + "<td><button class='editNoteButton' type='button' data-itemid='" + item.id + "' >Edit</button></td>"
                + "</tr>")
    }
}


