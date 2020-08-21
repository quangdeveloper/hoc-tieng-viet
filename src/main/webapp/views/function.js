function addFtp(data, url, urlback) {
    $.ajax({
        url: url,
        type: 'POST',
        contentType: 'application/json; charset=UTF-8',
        data: JSON.stringify(data),
        dataType: 'json',
        success: function (result) {
            alert("Create successful!");
            window.location.href = urlback;
        },
        error: function (error) {
            alert("Create fail!\n");
        }
    });
}

function update(data, url, urlback){
    $.ajax({
        url: url,
        type: 'PUT',
        contentType: 'application/json;charset=UTF-8',
        data: JSON.stringify(data),
        dataType: 'json',
        success: function (result) {

            alert("Update successful!");
            window.location.href = urlback;
        },
        error: function (error) {

            console.log(error.toString());
            alert("Update fail!");
        }
    });
}

function deleteMany(data, url, urlback) {
    $.ajax({
            url: url,
            type: 'DELETE',
            contentType: 'application/json',    //chi dinh loai data de gui ve server
            data: JSON.stringify(data),      //chuyển đổi sang định dạng json
            dataType: 'json',       //chi dinh loai data khi server tra ve
            success: function (result) {

                window.location.href = urlback;
                alert("Delete successful !!!");
            },
            error: function (error) {

                window.location.href = urlback;
                alert("Delete faild !!!");
            }
        }
    );
}
