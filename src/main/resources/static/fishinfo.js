let current_fish = null
let overlay = document.getElementById("overlay")

for (let fish of document.getElementsByClassName("fish")) {
    fish.onclick = () => {
        let w = document.getElementById("window_" + fish.id).classList
        if (w.contains("opened")) {
            w.remove("opened")
            overlay.classList.remove("show")
        } else {
            w.add("opened")
            overlay.classList.add("show")
            current_fish = w
        }
    }
}

overlay.onclick = () => {
    overlay.classList.remove("show")
    if (current_fish != null) {
        current_fish.remove("opened")
        current_fish = null
    }
}