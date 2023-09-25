const progress = document.getElementById("progress")
const song = document.getElementById("song")
const play = document.getElementById("play")

song.onloadedmetadata = function() {
    progress.max = song.duration;
    progress.value = song.currentTime;
}

function playPause() {
    if (play.classList.contains("bx-pause")) {
        song.pause();
        play.classList.remove("bx-pause");
        play.classList.add("bx-play");
    } else {
        song.play();
        play.classList.add("bx-pause");
        play.classList.remove("bx-play");
    }

}

if(song.play()) {
    setInterval(()=>{
        progress.value = song.currentTime;
    },500);
}

progress.onchange = function () {
    song.play();
    song.currentTime = progress.value;
    play.classList.add("bx-pause");
    play.classList.remove("bx-play");
}

document.addEventListener('DOMContentLoaded', function() {
    const progressBar = document.querySelector('.progress-bar');
    const progressInput = document.getElementById('progress');

    // Update the progress bar width when the input value changes
    progressInput.addEventListener('input', function() {
        const value = this.value;
        progressBar.style.width = value + '%';
    });
});