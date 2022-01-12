import React from "react";
import "./styles/App.css";

function Comments() {
  const [previousComments, setPreviousComments] = React.useState([]);
  const [user, setUser] = React.useState([]);
  const [form, setForm] = React.useState({ text: "" });
  const [location, setLocation] = React.useState([]);

  React.useEffect(() => {
    //setInterval(() => {
    fetch("/komentari")
      .then((data) => data.json())
      .then((previousComments) => setPreviousComments(previousComments));
    //}, 1000);
  }, []);

  React.useEffect(() => {
    fetch("/user")
      .then((data) => data.json())
      .then((user) => setUser(user));
  }, []);

  React.useEffect(() => {
    fetch("spasioci/current")
      .then((spasioc) => spasioc.json())
      .then((spasioc) => setLocation(spasioc.location_id));
  });

  function onChange(event) {
    const { name, value } = event.target;
    setForm((oldForm) => ({ ...oldForm, [name]: value }));
  }

  function onSubmit(event) {
    event.preventDefault();
    //console.log(user.id);

    //timestamp
    const data = {
      owner: user.id,
      text: form.text,
      location_id: location,
    };

    const options = {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(data),
    };

    fetch("/komentari", options).then((data) => console.log(data));
  }

  return (
    <div className="Comments">
      <h2>Comments</h2>
      <form onSubmit={onSubmit}>
        <div className="FormRow">
          <label>yourComment</label>
          <input name="text" onChange={onChange} value={form.text} />
        </div>
        <button type="submit">Send</button>
      </form>
    </div>
  );
}

export default Comments;
