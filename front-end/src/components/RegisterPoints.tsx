import { useEffect, useState } from "react";
import { AthleteResponse } from "./Scoreboard";

interface RegisterPointsProps {
  athletes: AthleteResponse[];
}

function RegisterPoints({ athletes }: RegisterPointsProps) {
  const [events, setEvents] = useState([]);
  const [athlete, setAthlete] = useState("");
  const [eventName, setEventName] = useState("");
  const [points, setPoints] = useState("");

  useEffect(() => {
    const fetchData = async () => {
      const eventsResponse = await fetch("http://localhost:8080/events", {
        method: "GET",
        headers: {
          Accept: "application/json",
          "Content-Type": "application/json",
        },
      });
      const eventsJson = await eventsResponse.json();
      setEvents(eventsJson);
    };
    fetchData();
  }, []);

  const submitAthletePoints = async () => {
    const formBody = {
      athleteId: athlete,
      event: eventName,
      points: Number(points),
    };
    await fetch("http://localhost:8080/result", {
      method: "POST",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
      body: JSON.stringify(formBody),
    });
    await fetch("http://localhost:8080/athletes", {
      method: "GET",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
    });
  };

  return (
    <div>
      <br></br>
      <select
        onChange={(e) => {
          setAthlete(e.currentTarget.value);
        }}
      >
        <option>Athlete</option>
        {athletes.map((athlete, _index) => {
          return (
            <option value={athlete.id}>
              {athlete.firstName + " " + athlete.lastName}
            </option>
          );
        })}
      </select>
      <br></br>
      <br></br>
      <select
        onChange={(e) => {
          setEventName(e.currentTarget.value);
        }}
      >
        <option>Event name</option>
        {events.map((sport, _index) => {
          return <option value={sport}>{sport}</option>;
        })}
      </select>
      <br></br>
      <br></br>
      <select
        onChange={(e) => {
          setPoints(e.currentTarget.value);
        }}
      >
        <option value={700}>700</option>
        <option value={800}>800</option>
        <option value={900}>900</option>
        <option value={1000}>1000</option>
      </select>
      <br></br>
      <br></br>
      <button
        type="button"
        onClick={() => {
          submitAthletePoints();
        }}
      >
        Submit
      </button>
    </div>
  );
}

export default RegisterPoints;
