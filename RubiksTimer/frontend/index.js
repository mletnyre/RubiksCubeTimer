let startTime = 0; 
let timerInterval = null;

function updateTimer(){
    elapsed = Date.now() - startTime;
    console.log(elapsed)
    min = Math.floor( elapsed / 60000);
    elapsed = elapsed - min * 60000;
    sec = Math.floor( elapsed / 1000);
    elapsed = elapsed - sec * 1000;
    tenth = Math.floor( elapsed / 100); 
    elasped = elapsed - tenth * 100;
    hundreth = Math.floor(elapsed / 10);

    document.getElementById("timer").textContent = 
        `${String(min).padStart(2,'0')}:` +
        `${String(sec).padStart(2,'0')}:` +
        `${tenth}${hundreth}`;
}

function startTimer() { 
    console.log("starting timer")
    if(!timerInterval){
        startTime = Date.now();
        timerInterval = setInterval(updateTimer, 1); 
    }
}

function stopTime(){
    console.log("Stopping timer")
    if(timerInterval){
        const t = Date.now() - startTime;
        clearInterval(timerInterval);
        timerInterval = null;
        window.elapsed = Date.now() - startTime;

        //send a POST to the backend
        saveTime(t);
    }
}

function toggle(){
    console.log("toggling")
    if(timerInterval){
        console.log("stopping")
        stopTime();
    }
    else {
        console.log("starting")
        startTimer();
    }

}

document.addEventListener("keydown", function (event){
    if(event.code == "Space"){
        console.log("SPACE!")
        event.preventDefault(); //stops the default behavior of space
        toggle();
    }
})

function saveTime(t){
    const url =  `https://localhost:8080/${t}`
    fetch(url, {
    method: 'POST',
    headers: {
        'Content-Type': 'application/json',
    }
    })
}