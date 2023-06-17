let url = document.URL
let domain = url.split('/')[2]
let ws = new WebSocket('ws://' + domain + '/ws')

let prop0 = document.getElementById("prop0")
let prop1 = document.getElementById("prop1")

prop0.onclick = function () {
    ws.send(JSON.stringify({
        type: 'vote',
        vote: 0
    }))
}

prop1.onclick = function () {
    ws.send(JSON.stringify({
        type: 'vote',
        vote: 1
    }))
}

ws.onmessage = function (event) {
    console.log(event.data)
}
