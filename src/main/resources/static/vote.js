let url = document.URL
let domain = url.split('/')[2]
let ws = new WebSocket('ws://' + domain + '/ws')

let prop0 = document.getElementById("prop0")
let prop1 = document.getElementById("prop1")
let propp0 = document.getElementById("propp0")
let propp1 = document.getElementById("propp1")
let passr = document.getElementById("passr")
let passi = document.getElementById("passi")

prop0.onclick = function () {
    ws.send("0")
}

prop1.onclick = function () {
    ws.send("1")
}

passr.onclick = function () {
    ws.send("passr")
}

passi.onclick = function () {
    ws.send("passi")
}

ws.onmessage = function (event) {
    console.log(event.data)
    let data = JSON.parse(event.data)
    let txt0 = data.prop0
    let txt1 = data.prop1
    // remplace les espaces par des underscores, les accents par des lettres sans accents et le reste des caractères spéciaux par des w
    txt0 = txt0.replace(/ /g, "_").normalize("NFD").replace(/[^a-zA-Z0-9_]/g, "w")
    txt1 = txt1.replace(/ /g, "_").normalize("NFD").replace(/[^a-zA-Z0-9_]/g, "w")
    console.log(txt0)
    console.log(txt1)
    prop0.setAttribute("style", "background-image: url('/static/prop/" + txt0 + ".png'), url('/static/prop/" + txt0 + ".jpg'), url('/static/default0.jpg')")
    prop1.setAttribute("style", "background-image: url('/static/prop/" + txt1 + ".png'), url('/static/prop/" + txt1 + ".jpg'), url('/static/default1.jpg')")
    propp0.textContent = data.prop0
    propp1.textContent = data.prop1
}
