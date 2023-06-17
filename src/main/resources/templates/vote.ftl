<html lang="fr">
<head>
    <title>Page de vote</title>
    <link rel="stylesheet" href="/static/vote.css" type="text/css">
    <link rel="stylesheet" href="/static/iceberg.css" type="text/css">
</head>
<body>
<div class="upmenu">
    <img class="icebergmini" alt="icebergmini" src="/static/iceberg.png"/>
    <div class="uptext">
        <h1>Lequel des deux connaissez-vous le mieux ?</h1>
        <h2>Son origine, ses secrets, ... et aujourd'hui ?</h2>
    </div>
</div>
<div id="props">
    <div class="prop" id="prop0" style="background-image: url('/static/prop/${prop0}.png'), url('/static/default0.jpg')">
        <p id="propp0">${prop0}</p>
    </div>
    <div class="prop" id="prop1" style="background-image: url('/static/prop/${prop1}.png'), url('/static/default1.jpg')">
        <p id="propp1">${prop1}</p>
    </div>
</div>
<div class="passer">
    <div class="downmenu">
        <div class="passer_but" id="passr">
            <p>Passer sans répondre</p>
        </div>
        <div class="passer_but" id="passi">
            <p>Les deux sont inconus</p>
        </div>
    </div>
</div>
<script type="text/javascript" src="/static/vote.js"></script>
</body>
</html>