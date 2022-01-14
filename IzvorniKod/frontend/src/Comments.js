import React from "react";
import "./styles/App.css";
import "./styles/Comments.css";

function Comments() {
  const [previousComments, setPreviousComments] = React.useState([]);
  const [user, setUser] = React.useState([]);
  const [form, setForm] = React.useState({ text: "" });
  const [location, setLocation] = React.useState([]);
  const [current, setCurrent] = React.useState(null);

  React.useEffect(() => {
    fetch("spasioci/current")
      .then((spasioc) => spasioc.json())
      .then((spasioc) => {
        fetch("/akcije/" + spasioc.currentAction_id)
          .then((data) => data.json())
          .then((previousComments) => {
            setPreviousComments(previousComments.comments);
            console.log(previousComments);
          });
        //}, 1000);

        setLocation(spasioc.location_id);
        setCurrent(spasioc.currentAction_id);
      });
    fetch("/akcije/komentari/" + current)
      .then((data) => data.json())
      .then((previousComments) => {
        //setPreviousComments(previousComments);
        console.log(previousComments);
      });
  }, []);

  React.useEffect(() => {
    fetch("/user")
      .then((data) => data.json())
      .then((user) => setUser(user));
  }, []);

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

    fetch("/akcije/comments/" + current, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(data),
    });
  }

  return (
    <div className="Comments">
      <h2>Comments</h2>
      <form className="UserForm" onSubmit={onSubmit}>
        <div className="FormRow">
          <label>Vaš komentar: </label>
          <input
            className="form-field"
            name="text"
            onChange={onChange}
            value={form.text}
          />
        </div>
        <button className="submit-button" type="submit">
          Send
        </button>
      </form>
      {previousComments.map((comment) => (
        <div key={comment.id}>
          {comment.userName}:{comment.text}
        </div>
      ))}
    </div>
  );
}

export default Comments;
