cliente = (function () {

    function dameDatos(ciudad,callback){
        var data = $.ajax({
            url:"https://hidden-oasis-46090.herokuapp.com/weater/?lugar="+ciudad,
            type: "GET",
            success : function (data){
                console.log(data);
                callback(data);
            }});
        return data;
    }

    return {
        dameDatos:dameDatos
    }
})();