const musicContainer = document.getElementById("music-player");
const playButton = document.getElementById("playButton");
const prevButton = document.getElementById("prev");
const nextButton = document.getElementById("next");
const audio = document.getElementById("audio");
const progress = document.getElementById("progress");
const progressContainer = document.getElementById("progress-container");
const title = document.getElementById("title");
const cover = document.getElementById("cover");

const songs = ["hey", "summer", "ukulele"];
let songIndex = 1;

function getSongTitle(song) {
    return song.charAt(0).toUpperCase() + song.slice(1);
}

function loadSong(song) {
    title.innerText = getSongTitle(song);
    audio.src = `https://github.com/bradtraversy/vanillawebprojects/blob/master/music-player/music/${song}.mp3?raw=true`;
    cover.src = `https://github.com/bradtraversy/vanillawebprojects/blob/master/music-player/images/${song}.jpg?raw=true`;
}

function playSong() {
    musicContainer.classList.add("playButton");
    playButton.querySelector("i.bx").classList.remove("bx-play");
    playButton.querySelector("i.bx").classList.add("bx-pause");
    audio.play();
}

function pauseSong() {
    musicContainer.classList.remove("playButton");
    playButton.querySelector("i.bx").classList.remove("bx-pause");
    playButton.querySelector("i.bx").classList.add("bx-play");
    audio.pause();
}

function prevSong() {
    songIndex--;
    if (songIndex < 0) songIndex = songs.length - 1;
    loadSong(songs[songIndex]);
    playSong();
}

function nextSong() {
    songIndex++;
    if (songIndex > songs.length - 1) songIndex = 0;
    loadSong(songs[songIndex]);
    playSong();
}

function updateProgress(e) {
    const { duration, currentTime } = e.target;
    const progressPercent = (currentTime / duration) * 100;
    progress.style.width = `${progressPercent}%`;
}

function setProgress(e) {
    const width = this.clientWidth;
    const clickX = e.offsetX;
    const duration = audio.duration;
    audio.currentTime = (clickX / width) * duration;
}

// Event Listeners
playButton.addEventListener("click", () => {
    const isPlaying = musicContainer.classList.contains("playButton");
    isPlaying ? pauseSong() : playSong();
});

prevButton.addEventListener("click", prevSong);
nextButton.addEventListener("click", nextSong);

audio.addEventListener("timeupdate", updateProgress);
progressContainer.addEventListener("click", setProgress);

audio.addEventListener("ended", nextSong);

// Init
loadSong(songs[songIndex]);