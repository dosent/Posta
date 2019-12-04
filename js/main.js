var authorization = "AccessToken I_53pDoc8j_jtSpHBkYkCFMXBGFrdq6R";
var userAuthorization = "Basic Kzc5OTE0NjE0MDcxOnVzZXI3Mw=="

function getAjax (url,callback) {
    jQuery.ajax({
        type: 'GET',
        beforeSend: function (jqXHR) {
            /* Authorization header */
            jqXHR.setRequestHeader("Authorization",authorization);
            jqXHR.setRequestHeader("X-User-Authorization", userAuthorization);
        },
        url: url,
        error:function (data) {
            $("#alert").text(data.statusText);
            console.log(data.statusText);
        },
        success: callback
    });

}
function loadData() {
    var url = "http://localhost:8089/pochta/1.0/archive";
    getAjax(url,renderData);
}

function renderData(jsondata){
    for (var i = 0, len = jsondata.length; i < len; i++) {
        var record = jsondata[i];
        var batchName = record["batch-name"];
        var rowShipment = new Object();
        rowShipment["batch-name"] = batchName;
        rowShipment["typeMail"] = record["mail-category-text"] + " "+record["mail-type-text"];
        getShipment(batchName, rowShipment);
        console.log(batchName);
    }
}
function addRow(key,typeMail, barcode) {
    var markup = "<tr><td>"+key+"</td><td>"+typeMail+"</td><td>" + barcode + "</td></tr>";
    $("#tableReport tbody").append(markup);
}
function getShipment(key, rowShipment) {
    var url = "http://localhost:8089/pochta/1.0/batch/"+ key +"/shipment";
    rowShipment = getAjax(url, function (data) {
        for (var i = 0, len = data.length; i < len; i++) {
            rowShipment["barcode"] = data[i]["barcode"];
            break;
        }

        addRow(key,rowShipment["typeMail"],rowShipment["barcode"]);
        return rowShipment;
    });

}
var shipmentObject = function (data) {
    return data;

};