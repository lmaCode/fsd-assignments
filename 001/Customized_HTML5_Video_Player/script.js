var myVideo = document.getElementById("video1");
myVideo.volume = 0.5;
var progressFlag;

var likecount = localStorage.getItem('likecount');
var unlikecount = localStorage.getItem('unlikecount');
if (typeof likecount == 'undefined' || likecount == null) {
    localStorage.likecount = 0;
}

if (typeof unlikecount == 'undefined' || unlikecount == null) {
    localStorage.unlikecount = 0;
}

document.getElementById("thumbsUp").innerHTML = " " + localStorage.likecount;
document.getElementById("thumbsDown").innerHTML = " " + localStorage.unlikecount;
var prograssBar = document.getElementById("prograssBar");

function afterEnd() {
    document.getElementById("pause").setAttribute("disabled", true);
    document.getElementById("play").removeAttribute("disabled");
}

function playAndPause() {
    if (myVideo.paused) {
        document.getElementById("play").setAttribute("disabled", true);
        document.getElementById("pause").removeAttribute("disabled");
        myVideo.play();
        getProgress();
        progressFlag = setInterval(getProgress, 60);

    } else {
        document.getElementById("pause").setAttribute("disabled", true);
        document.getElementById("play").removeAttribute("disabled");
        myVideo.pause();
        clearInterval(progressFlag);
    }
}

function select(movie) {
    myVideo.setAttribute("src", movie);
    myVideo.setAttribute('autoplay', 'autoplay');
    document.getElementById("play").setAttribute("disabled", true);
    document.getElementById("pause").removeAttribute("disabled");
    getProgress();
    progressFlag = setInterval(getProgress, 60);
}

function getProgress() {
    var percent = myVideo.currentTime / myVideo.duration;
    prograssBar.style = "width: " + Number(percent * 100) + "%;";
    prograssBar.innerHTML = (percent * 100).toFixed(1) + "%";
}

function volumeUp() {
    if (myVideo.volume <= 1) {
        myVideo.volume = myVideo.volume + 0.1;
    }
}

function volumeDown() {
    if (myVideo.volume >= 0) {
        myVideo.volume = myVideo.volume - 0.1;
    }
}

function volumeOff() {
    if (myVideo.muted) {
        myVideo.muted = false;
    } else {
        myVideo.muted = true;
    }
}

function rePlay() {
    myVideo.load();
    myVideo.setAttribute("autoplay", "autoplay");
    document.getElementById("play").setAttribute("disabled", true);
    document.getElementById("pause").removeAttribute("disabled");
    getProgress();
    progressFlag = setInterval(getProgress, 60);

}

function like() { //IP地址，cookie 本地存储，一增一减少？；
    if (localStorage.likecount) {
        localStorage.likecount = Number(localStorage.likecount) + 1;
    } else {
        localStorage.likecount = 1;
    }
    document.getElementById("thumbsUp").innerHTML = " " + localStorage.likecount;
}

function unlike() {
    if (localStorage.unlikecount) {
        localStorage.unlikecount = Number(localStorage.unlikecount) + 1;
    } else {
        localStorage.unlikecount = 1;
    }
    document.getElementById("thumbsDown").innerHTML = " " + localStorage.unlikecount;
}

function fullScreen() {
    myVideo.requestFullscreen();
}