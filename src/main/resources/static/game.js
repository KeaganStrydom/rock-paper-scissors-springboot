

Array.from(document.getElementsByClassName("game-move")).forEach(element => {
    element.addEventListener("click", () => move(element.id));
});

async function move(gameMove) {
    console.log(gameMove)
    const moveURL = `http://localhost:8080/game/${gameMove}`

    try {
        const response = await fetch(moveURL, {method: "POST"});
        const gameState = await response.json();

        document.getElementById("wins").innerHTML = gameState.wins;
        document.getElementById("losses").innerHTML = gameState.losses;
        document.getElementById("ties").innerHTML = gameState.ties;

        document.getElementById("computer-move").innerHTML = gameState.computerMove;
        document.getElementById("game-outcome").innerHTML = gameState.outcome;
        
    } catch (error) {
        console.log(error.message)
    }
}