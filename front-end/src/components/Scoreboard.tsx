import { useEffect, useState } from "react";
import RegisterPoints from "./RegisterPoints";

export interface AthleteResponse {
  id: string;
  firstName: string;
  lastName: string;
  country: string;
  age: number;
}

interface Athlete extends AthleteResponse {
  points: number;
}

function Scoreboard() {
  const [athletes, setAthletes] = useState<Athlete[]>([]);

  const fetchAthletePoints = async (id: string) => {
    const pointResponse = await fetch(`http://localhost:8080/results/${id}`);
    const points = await pointResponse.json();
    return points;
  };

  useEffect(() => {
    const fetchData = async () => {
      const athletesResponse = await fetch("http://localhost:8080/athletes", {
        method: "GET",
        headers: {
          Accept: "application/json",
          "Content-Type": "application/json",
        },
      });

      const athletesJson = await athletesResponse.json();

      for (const athlete of athletesJson) {
        const points = await fetchAthletePoints(athlete.id);
        athlete.points = points;
      }
      setAthletes(athletesJson);
    };
    fetchData();
  }, []);

  return (
    <div>
      <table>
        <tr>
          <th>Athlete</th>
          <th>Country</th>
          <th>Score</th>
        </tr>

        {athletes.map((athlete) => {
          return (
            <tr>
              <td>{athlete.firstName + " " + athlete.lastName}</td>
              <td>{athlete.country}</td>
              <td>{athlete.points}</td>
            </tr>
          );
        })}
      </table>
      <RegisterPoints athletes={athletes} />
    </div>
  );
}

export default Scoreboard;
