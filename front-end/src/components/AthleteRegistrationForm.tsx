import { useState } from "react";

function AthleteRegistrationForm() {
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [age, setAge] = useState<number | string>("");
  const [country, setCountry] = useState("");

  const registerAthlete = async () => {
    const formBody = {
      firstName,
      lastName,
      age,
      country,
    };
    await fetch("http://localhost:8080/athlete", {
      method: "POST",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
      body: JSON.stringify(formBody),
    });
  };

  const clearForm = () => {
    setFirstName("");
    setLastName("");
    setAge("");
    setCountry("");
  };

  return (
    <div className="form-container">
      <p>Register athlete</p>
      <form>
        <div className="form-input">
          <label>First name</label>
          <br />
          <input
            onChange={(e) => {
              setFirstName(e.currentTarget.value);
            }}
            type="text"
            value={firstName}
          />
          <br />
        </div>
        <div className="form-input">
          <label>Last name</label>
          <br />
          <input
            onChange={(e) => {
              setLastName(e.currentTarget.value);
            }}
            type="text"
            value={lastName}
          />
          <br />
        </div>
        <div className="form-input">
          <label>Age</label>
          <br />
          <input
            type="number"
            onChange={(e) => {
              setAge(e.currentTarget.valueAsNumber);
            }}
            value={age}
          />
          <br />
        </div>
        <div className="form-input">
          <label>Country</label>
          <br />
          <input
            type="text"
            onChange={(e) => {
              setCountry(e.currentTarget.value);
            }}
            value={country}
          />
          <br />
        </div>
        <br />
        <button
          onClick={async () => {
            await registerAthlete();
            clearForm();
          }}
          type="button"
        >
          Register
        </button>
      </form>
    </div>
  );
}

export default AthleteRegistrationForm;
