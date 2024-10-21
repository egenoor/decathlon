import { useEffect, useState } from "react";
import RegisterPoints from "./RegisterPoints";

export interface AthleteResponse {
  id: string;
  firstName: string;
  lastName: string;
  country: string;
  points: number;
}

function Scoreboard() {
  const [athletes, setAthletes] = useState<AthleteResponse[]>([]);
  const [registerPoints, setRegisterPoints] = useState(false);
  const [athleteDetails, setAthleteDetails] = useState<AthleteResponse | null>(
    null
  );

  useEffect(() => {
    const fetchData = async () => {
      const athletesResponse = await fetch("http://localhost:8080/results", {
        method: "GET",
        headers: {
          Accept: "application/json",
          "Content-Type": "application/json",
        },
      });

      const athletesJson = await athletesResponse.json();
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
              <td>
                <a
                  href={"/#"}
                  onClick={() => {
                    setAthleteDetails(athlete);
                  }}
                >
                  {athlete.firstName + " " + athlete.lastName}
                </a>
              </td>
              <td>{athlete.country}</td>
              <td>{athlete.points}</td>
            </tr>
          );
        })}
      </table>
      <br></br>
      {athleteDetails !== null && (
        <table>
          <tr>
            <td>{athleteDetails.firstName + " " + athleteDetails.lastName}</td>
            <td>{athleteDetails.country}</td>
            <td>{athleteDetails.points}</td>
          </tr>
        </table>
      )}
      <br></br>
      <button
        type="button"
        onClick={() => {
          setRegisterPoints(true);
        }}
      >
        Register points
      </button>
      {registerPoints && <RegisterPoints athletes={athletes} />}
    </div>
  );
}

export default Scoreboard;
