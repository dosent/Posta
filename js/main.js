//import ("/js/converter.js");


//import ("/js/utils.js");
function LOGGER(message) {
    if (LEVEL_LOG) {
        console.log(message);
    }
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
function loadData() {
    getAjax(URL_ARCHIVE, function (jsondata){
        let i = 0, len = jsondata.length;
        for (; i < len; i++) {
            let record = jsondata[i];
            let shipment = new Object();
            shipment["batchName"] = record["batch-name"];
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
        messages.forEach(function (itemMessage) {
            let receiver = itemMessage["str-index-to"] + ", "+ itemMessage["region-to"]+", " + itemMessage["place-to"]+","+ itemMessage["street-to"]+","
                + itemMessage["house-to"];
            let receiverName = itemMessage["recipient-name"];

            let sum = (itemMessage["total-rate-wo-vat"] + itemMessage["total-vat"]) / 100;
            let vat = itemMessage["total-vat"]/100;
            addRow(i++,"",itemMessage["barcode"],receiver,receiverName,sum, vat);
        });
    })
}

function addRow(key,typeMail, barcode,receiver,receiverName,sum,vat) {
    let markup = "<tr class='rowShipments'><td>"+key+"</td><td>"+typeMail+"</td><td>" + barcode + "</td><td>" + receiver + "</td><td>" + receiverName + "</td><td>" + sum + " ("+ vat +")" + "</td></tr>";
    let liteShipment = new Object();
    liteShipments["barcode"] = barcode;
    liteShipments["receiver"] = receiver;
    liteShipments["receiverName"] = receiverName;
    liteShipments["sum"] = sum;
    liteShipments["vat"] = vat;
    liteShipments.push(liteShipment);
    $("#tableReport tbody").append(markup);
}

$(document).ajaxComplete(function( event, request, settings ) {
    if ( settings.url === URL_ARCHIVE ) {
        LOGGER("URL_ARCHIVE Request Complete.");
        $(".rowShipments").remove();
        shipments.forEach(function(item, index, array) {
            getShipment(item["batchName"],item);
        });
    } else if (activeAjaxConnections == 0) {
        LOGGER("URL_BATCH Request Complete.");
        renderData();
    }
});

$(document).onload(function () {
    $("#dynamicTableReport").bootstrapTable("changeLocale", "zh_TW");
})