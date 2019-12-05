//import ("/js/converter.js");


//import ("/js/utils.js");
function LOGGER(message) {
    if (LEVEL_LOG) {
        console.log(message);
    }
}

function getDate(string) {
    let temp = string.split("-");
    return new Date(parseInt(temp[0]),parseInt(temp[1])-1,parseInt(temp[2]));
}

function getDateString(date) {
    return ("0" + date.getDate()).slice(-2) + "." +
        ("0" + (date.getMonth()+1)).slice(-2) + "." +
        date.getFullYear();
}

//import {config} from "/js/configuration.js";
const AUTHORIZATION = "AccessToken I_53pDoc8j_jtSpHBkYkCFMXBGFrdq6R";
const USER_AUTHORIZATION = "Basic Kzc5OTE0NjE0MDcxOnVzZXI3Mw==";
const URL_ARCHIVE = "http://localhost:8089/pochta/1.0/archive";
const URL_BATCH = "http://localhost:8089/pochta/1.0/batch/{key}/shipment";
const LEVEL_LOG = true;


let shipments = [];
let liteShipments = [];
let activeAjaxConnections = 0;


function getAjax (url,callback) {
    jQuery.ajax({
        type: 'GET',
        beforeSend: function (jqXHR) {
            /* Authorization header */
            jqXHR.setRequestHeader("Authorization",AUTHORIZATION);
            jqXHR.setRequestHeader("X-User-Authorization", USER_AUTHORIZATION);
            activeAjaxConnections ++;
        },
        url: url,
        error:function (data) {
            activeAjaxConnections --;
            $("#alert").text(data.statusText);
            utils.LOGGER(data.statusText);
        },
        success: function (data) {
            activeAjaxConnections --;
            callback(data);
        }
    });

}

function clearTables() {
    $(".rowShipments").remove();
    shipments.length = 0;
    liteShipments.length = 0;
}

function loadData() {
    clearTables();
    getAjax(URL_ARCHIVE, function (jsondata){
        let i = 0, len = jsondata.length;
        for (; i < len; i++) {
            let record = jsondata[i];
            let shipment = new Object();
            shipment["batchName"] = record["batch-name"];
            shipment["dateMail"] = getDate(record["list-number-date"]);
            shipment["typeMail"] = record["mail-category-text"] + " "+record["mail-type-text"];
            shipments.push(shipment);
        }
    });
}


function getShipment(batchId, shipment) {
    let url = URL_BATCH.replace("{key}",batchId);
    getAjax(url, function (data) {
        shipment["messages"] = [];
        let i = 0, len = data.length;
        for (; i < len; i++) {
            shipment["messages"].push(data[i]);
        }
    });
}

function renderData() {
    let i = 1;
    shipments.forEach(function(item, index, array) {
        let messages = item["messages"];
        let dateMail = item["dateMail"];
        let humanOperationName = item["humanOperationName"];
        messages.forEach(function (itemMessage) {
            let receiver = itemMessage["str-index-to"] + ", "+ itemMessage["region-to"]+", " + itemMessage["place-to"]+","+ itemMessage["street-to"]+","
                + itemMessage["house-to"];
            let receiverName = itemMessage["recipient-name"];

            let sum = 2.7 + (itemMessage["total-rate-wo-vat"] + itemMessage["total-vat"]) / 100;
            let humanOperationName = itemMessage["human-operation-name"];
            let vat = itemMessage["total-vat"]/100;
            if (parseInt(dateMail.getMonth()) === parseInt($("#selectMouth :selected").val())
                && parseInt(dateMail.getFullYear()) === parseInt($("#selectYear").val())) {
                addRow(i++, humanOperationName, itemMessage["barcode"], receiver, receiverName, sum, vat, dateMail);
            }
        });
    })
}
function updateTable() {
    $(".rowShipments").remove();
    renderData();
}

function addRow(key,typeMail, barcode,receiver,receiverName,sum,vat, dateMail) {
    let isRed = (typeMail.toLowerCase().indexOf("получен") === -1) ? "style='color: red'" : "";
    let markup = ("<tr class='rowShipments' "+isRed+"><td>"+key+"</td><td hidden='hidden'>"+typeMail+"</td><td><a target='_blank' href='https://www.pochta.ru/tracking#{barcode}'>" + barcode + "</a></td><td>" + receiverName +"<br>" +receiver + "</td><td>" + sum + "</td><td>" + getDateString(dateMail) + "</td></tr>")
        .replace("{barcode}",barcode);
    let liteShipment = new Object();
    liteShipments["barcode"] = barcode;
    liteShipments["receiver"] = receiver;
    liteShipments["receiverName"] = receiverName;
    liteShipments["sum"] = sum;
    liteShipments["vat"] = vat;
    liteShipments["dateMail"] = dateMail;
    liteShipments.push(liteShipment);
    $("#tableReport tbody").append(markup);
}

$(document).ajaxComplete(function( event, request, settings ) {
    if ( settings.url === URL_ARCHIVE ) {
        LOGGER("URL_ARCHIVE Request Complete.");
        shipments.forEach(function(item, index, array) {
            getShipment(item["batchName"],item);
        });
    } else if (activeAjaxConnections == 0) {
        LOGGER("URL_BATCH Request Complete.");
        renderData();
    }
})
$(document).ready(function () {
    let currentDate = new Date();
    let value = parseInt(currentDate.getMonth());
    $("#selectMouth option[value=" + value + "]").attr('selected', 'true');
    $("#selectYear").val(parseInt(currentDate.getFullYear()));
    loadData();
});