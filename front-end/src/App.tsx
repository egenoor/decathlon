import { useState } from "react";
import "./App.css";
import AthleteRegistrationForm from "./components/AthleteRegistrationForm";
import Scoreboard from "./components/Scoreboard";

function App() {
  const [registerAthlete, setRegisterAthlete] = useState(false);
  const [scoreboard, setScoreboard] = useState(false);
  return (
    <div className="App">
      <div>
        <h1>Decathlon</h1>
      </div>
      <button
        type="button"
        onClick={() => {
          setScoreboard(true);
          setRegisterAthlete(false);
        }}
      >
        Scoreboard
      </button>
      <br></br>
      <button
        type="button"
        onClick={() => {
          setRegisterAthlete(true);
          setScoreboard(false);
        }}
      >
        Register athlete
      </button>
      <br></br>
      {scoreboard && <Scoreboard />}
      {registerAthlete && <AthleteRegistrationForm />}
    </div>
  );
}

export default App;
